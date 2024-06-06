package presentationLayer;

import businessLayer.CompositeProduct;
import businessLayer.DeliveryService;
import businessLayer.MenuItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonListenerCreateB implements ActionListener {
    private JTextArea ta;
    private JTextField tf1;
    private JTextField tf2;
    private JTextField tf3;
    private JTextField tf4;
    private JTextField tf5;
    private JTextField tf6;
    private ArrayList<MenuItem> products;
    private ArrayList<MenuItem> composed;
    private DeliveryService ds;

    public ButtonListenerCreateB(JTextArea ta, JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4, JTextField tf5, JTextField tf6, ArrayList<MenuItem> products, ArrayList<MenuItem> composed) {
        this.ta = ta;
        this.tf1 = tf1;
        this.tf2 = tf2;
        this.tf3 = tf3;
        this.tf4 = tf4;
        this.tf5 = tf5;
        this.tf6 = tf6;
        this.products = products;
        this.composed = composed;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
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
            for(MenuItem item: products)
            {
                if(item.getTitle().equals(tf6.getText()))
                {
                    ta.setText("Exista deja un produs cu acest nume!");
                    break;
                }
            }


        }
        else
        {
            ta.setText("Nu a fost introdus un nume pentru produsul compus!");
            ok = 0;
        }

        if(count >= 2 && ok == 1 && ok_found == 1)
        {
            CompositeProduct compositeProduct = new CompositeProduct(composed,tf6.getText());
            products.add(compositeProduct);
            ta.append("\nA fost creat produsul compus:\n");
            ta.append(compositeProduct.toString());
        }
        else
        {   if(count < 2)
            ta.setText("Nu au fost introduse suficiente produse");
        }

         */
        ds.createComposedProduct(ta,tf1,tf2,tf3,tf4,tf5,tf6,products,composed);

    }

    public DeliveryService getDs() {
        return ds;
    }

    public void setDs(DeliveryService ds) {
        this.ds = ds;
    }
}
