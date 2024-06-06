package presentationLayer;

import businessLayer.CompositeProduct;
import businessLayer.DeliveryService;
import businessLayer.MenuItem;
import businessLayer.Order;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.util.*;

@SuppressWarnings("deprecation")
public class ButtonListenerOrder extends Observable  implements ActionListener {
    private JTextArea ta;
    private JTextField tf1;
    private JTextField tf2;
    private JTextField tf3;
    private JTextField tf4;
    private JTextField tf5;
    private JTextField tf6; //day
    private JTextField tf7; //month
    private JTextField tf8; //year
    private JTextField tf9; //hour
    private ArrayList<MenuItem> products;
    private ArrayList<MenuItem> composed = new ArrayList<>(); //articolele comandate
    private ArrayList<Order> orders = new ArrayList<>();
    private Map<Order,ArrayList<MenuItem>> orderData;
    private Client client;
    private Employee employee;
    private DeliveryService ds;

    private List<Observer> observers = new ArrayList<>();
    private int state;
    Order order;


    int day;
    int month;
    int year;
    int hour;

    public ButtonListenerOrder(JTextArea ta, JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4, JTextField tf5, JTextField tf6, JTextField tf7, JTextField tf8, JTextField tf9, ArrayList<MenuItem> products,  Map<Order,ArrayList<MenuItem>> orderData, Client client, Employee employee) {
        this.ta = ta;
        this.tf1 = tf1;
        this.tf2 = tf2;
        this.tf3 = tf3;
        this.tf4 = tf4;
        this.tf5 = tf5;
        this.tf6 = tf6;
        this.tf7 = tf7;
        this.tf8 = tf8;
        this.tf9 = tf9;
        this.products = products;
        //this.composed = composed;
        //this.orders = orders;
        this.orderData = orderData;
        this.client = client;
        this.employee = employee;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent e) {

        employee.setTa(ta);
        composed = new ArrayList<>();
        int count = 0;
        int ok_found = 1;

        int found1 = 0;
        if(!(tf1.getText().equals("")))
        {   count++;
            found1 = -1;
            for(MenuItem item: products)
            {
                if(item.getTitle().equals(tf1.getText()))
                {
                    item.setTimesOrdered(item.getTimesOrdered()+1);
                    composed.add(item);
                    found1 = 1;
                    break;
                }
            }

            if(found1 == -1)
            {
                ta.setText("Produsul 1 nu se afla in meniu!");
                ok_found = 0;
            }
        }

        int found2 = 0;
        if(!(tf2.getText().equals("")))
        {   count++;
            found2 = -1;
            for(MenuItem item: products)
            {
                if(item.getTitle().equals(tf2.getText()))
                {
                    item.setTimesOrdered(item.getTimesOrdered()+1);
                    composed.add(item);
                    found2 = 1;
                    break;
                }
            }
            if(found2 == -1)
            {
                ta.setText("Produsul 2 nu se afla in meniu!");
                ok_found = 0;
            }
        }

        int found3 = 0;
        if(!(tf3.getText().equals("")))
        {   count++;
            found3 = -1;
            for(MenuItem item: products)
            {
                if(item.getTitle().equals(tf3.getText()))
                {
                    item.setTimesOrdered(item.getTimesOrdered()+1);
                    composed.add(item);
                    found3 = 1;
                    break;
                }
            }
            if(found3 == -1)
            {
                ta.setText("Produsul 3 nu se afla in meniu!");
                ok_found = 0;
            }
        }

        int found4 = 0;
        if(!(tf4.getText().equals("")))
        {   count++;
            found4 = -1;
            for(MenuItem item: products)
            {
                if(item.getTitle().equals(tf4.getText()))
                {
                    item.setTimesOrdered(item.getTimesOrdered()+1);
                    composed.add(item);
                    found4 = 1;
                    break;
                }
            }

            if(found4 == -1)
            {
                ta.setText("Produsul 4 nu se afla in meniu!");
                ok_found = 0;
            }
        }
        int found5 = 0;
        if(!(tf5.getText().equals("")))
        {   count++;
            found5 = -1;
            for(MenuItem item: products)
            {
                if(item.getTitle().equals(tf5.getText()))
                {
                    item.setTimesOrdered(item.getTimesOrdered()+1);
                    composed.add(item);
                    found5 = 1;
                    break;
                }
            }

            if(found5 == -1)
            {
                ta.setText("Produsul 5 nu se afla in meniu!");
                ok_found = 0;
            }
        }

        int ok = 1;
        if(!(tf6.getText().equals("")))
        {
            day = Integer.parseInt(tf6.getText());
        }
        else
        {
            ta.setText("Nu a fost introdusa ziua!");
            ok = 0;
        }

        if(!(tf7.getText().equals("")))
        {
            month = Integer.parseInt(tf7.getText());
        }
        else
        {
            ta.setText("Nu a fost introdusa luna!");
            ok = 0;
        }

        if(!(tf8.getText().equals("")))
        {
            year = Integer.parseInt(tf8.getText());
        }
        else
        {
            ta.setText("Nu a fost introdus anul!");
            ok = 0;
        }

        if(!(tf9.getText().equals("")))
        {
            hour = Integer.parseInt(tf9.getText());
        }
        else
        {
            ta.setText("Nu a fost introdusa ora!");
            ok = 0;
        }

        if( ok == 1 && ok_found == 1)
        {
            //CompositeProduct compositeProduct = new CompositeProduct(composed,tf6.getText());
            //Date data = new Date(year, month,day);
            Date data = new Date(year-1900,month-1,day, hour,0,0);
            Time time = new Time(hour,0,0);

            client.setOrderingTimes(client.getOrderingTimes() + 1);
            order = new Order(client.getIdClient(), data,time);

            order.setDay(day);
            order.setClientNumberOfOrders(client.getOrderingTimes());

            order.setPrice(order.computeOrderPrice(composed));

            setChanged();
            notifyObservers(order);
            clearChanged();

            orders.add(order);

            orderData.put(order,composed);

            ta.append("\nA fost creata comanda:\n");
            ta.append(order.toString() + " " );
            ta.append(orderData.get(order).toString());
            ta.append("\nOrder data:\n");
            ta.append(orderData.toString());

            String fileBill = "billClient"+client.getIdClient()+"Order"+order.getIdOrder()+".txt";
            try {
                FileWriter writer = new FileWriter(fileBill);
                writer.write("ORDER " +order.getIdOrder()+"\n");
                writer.write("Client "+ client.getIdClient()+"\n");
                writer.write("Client username: "+ client.getUsername()+"\n");
                writer.write("Date: "+ order.getData()+"\n");
                writer.write("Products: "+ orderData.get(order).toString()+"\n" );
                writer.write("Price: "+ order.getPrice()+"\n");

                writer.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


    }

    public DeliveryService getDs() {
        return ds;
    }

    public void setDs(DeliveryService ds) {
        this.ds = ds;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    public void attach(Observer observer)
    {
        observers.add(observer);
    }


}

