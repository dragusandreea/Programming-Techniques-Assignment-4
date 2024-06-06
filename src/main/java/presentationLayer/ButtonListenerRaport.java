package presentationLayer;

import businessLayer.MenuItem;
import businessLayer.Order;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ButtonListenerRaport implements ActionListener {
    private JTextArea ta;
    private JTextField tf1;
    private JTextField tf2;
    private JTextField tf3;
    private JTextField tf4;
    private JTextField tf5;
    private JTextField tf6;
    private JTextField tf7;
    private JTextField tf8;
    private JTextField tf9;

    private ArrayList<MenuItem> products;
    private Map<Order,ArrayList<MenuItem>> orderData;

    int hour1;
    int hour2;

    int numberOfTimes;

    int numberOfTimes3;
    int price;

    int day;
    int month;
    int year;
    int numberOfTimes4;

    public ButtonListenerRaport(JTextArea ta, JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4, JTextField tf5, JTextField tf6, JTextField tf7,JTextField tf8,  ArrayList<MenuItem> products, Map<Order, ArrayList<MenuItem>> orderData) {
        this.ta = ta;
        this.tf1 = tf1;
        this.tf2 = tf2;
        this.tf3 = tf3;
        this.tf4 = tf4;
        this.tf5 = tf5;
        this.tf6 = tf6;
        this.tf7 = tf7;
        this.tf8 = tf8;
        //this.tf9 = tf9;
        this.products = products;
        this.orderData = orderData;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!(tf1.getText().equals("")) && !(tf2.getText().equals(""))) {
            hour1 = Integer.parseInt(tf1.getText());
            hour2 = Integer.parseInt(tf2.getText());


            String resultRaport1 = "Orders placed between " + hour1 + " and "+ hour2+"\n\n";
            resultRaport1 += orderData.entrySet().stream()
                    .filter(x -> x.getKey().getData().getHours() >= hour1 && x.getKey().getData().getHours() <= hour2)
                    .map(x ->x.getKey().toString()+"\n"+ x.getValue().toString()+"\n\n")
                    .collect(Collectors.joining());

            String fileBill = "Raport1"+ ".txt";
            try {
                FileWriter writer = new FileWriter(fileBill);
                writer.write(resultRaport1);
                writer.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

        if(!(tf3.getText().equals("")))
        {
            numberOfTimes = Integer.parseInt(tf3.getText());

            String resultRaport2 ="Orders with products ordered more than "+ numberOfTimes+" times:"+"\n\n";
            resultRaport2 += orderData.entrySet().stream()
                    .filter(x -> x.getValue().stream().anyMatch( y -> y.getTimesOrdered() >= numberOfTimes))
                    .map(x ->x.getKey().toString()+"\n"+ x.getValue().toString()+"\n\n")
                    .collect(Collectors.joining());

            String fileBill = "Raport2"+ ".txt";
            try {
                FileWriter writer = new FileWriter(fileBill);
                writer.write(resultRaport2);
                writer.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

        if(!(tf4.getText().equals("")) && !(tf5.getText().equals("")))
        {
            numberOfTimes3 = Integer.parseInt(tf4.getText());
            price = Integer.parseInt(tf5.getText());

            String resultRaport3 = "Orders from clients who ordered more than "+ numberOfTimes3+" times and also have a final price greater than "+price+":\n\n";

            resultRaport3 += orderData.entrySet().stream()
                    .filter(x -> x.getKey().getClientNumberOfOrders() >= numberOfTimes3 && x.getKey().getPrice() >= price)
                    .map(x ->x.getKey().toString()+"\n"+ x.getValue().toString()+"\n\n")
                    .collect(Collectors.joining());

            String fileBill = "Raport3"+ ".txt";
            try {
                FileWriter writer = new FileWriter(fileBill);
                writer.write(resultRaport3);
                writer.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }


        }

        if(!(tf6.getText().equals("")) && !(tf7.getText().equals("")) && !(tf8.getText().equals("")) )
        {
            day = Integer.parseInt(tf6.getText());
            month = Integer.parseInt(tf7.getText());
            year = Integer.parseInt(tf8.getText());

            Date dataa = new Date(year-1900, month-1,day);
            //numberOfTimes4 = Integer.parseInt(tf9.getText());

            String resultRaport4 = "Products ordered in "+day+"/"+month+"/"+year+":\n\n";

            resultRaport4 += orderData.entrySet().stream()
                    .filter(x -> x.getKey().getDay() == day && x.getKey().getData().getMonth() + 1 == month && x.getKey().getData().getYear() + 1900 == year)
                    .map(x-> x.getValue().toString()+"\n\n")
                    .distinct()
                    .collect(Collectors.joining());

            /*
            for(Map.Entry<Order,ArrayList<MenuItem>> entry: orderData.entrySet())
            {
                int day1 = entry.getKey().getDay();
                int month = entry.getKey().getData().getMonth()+1;
                int year = entry.getKey().getData().getYear()+1900;
                System.out.println(day1+" "+month+" "+ year);

            }
            */


            String fileBill = "Raport4"+ ".txt";
            try {
                FileWriter writer = new FileWriter(fileBill);
                writer.write(resultRaport4);
                writer.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }


    }
}
