package presentationLayer;

import businessLayer.DeliveryService;
import businessLayer.MenuItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonListenerDeleteProduct implements ActionListener {
    private JTextArea ta;
    private JTextField title;
    private ArrayList<MenuItem> products;
    DeliveryService ds = GUI.ds;

    public ButtonListenerDeleteProduct(JTextArea ta, JTextField title, ArrayList<MenuItem> products) {
        this.ta = ta;
        this.title = title;
        this.products = products;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       /*
        int index = 0;
        if(!(title.getText().equals("")))
        {
            for(MenuItem item: products)
            {
                if(item.getTitle().equals(title.getText()))
                {
                    ta.append("\nAm sters produsul:\n");
                    ta.append(item.toString());
                    index = products.indexOf(item);
                }
            }
            products.remove(index);

           // ds.deleteProduct(title.getText());
        }
        else
        {
            ta.setText("Campul title nu a fost completat!");
        }
        */
        ds.deleteProduct(ta,title,products);



    }

    public JTextArea getTa() {
        return ta;
    }

    public void setTa(JTextArea ta) {
        this.ta = ta;
    }

    public DeliveryService getDs() {
        return ds;
    }

    public void setDs(DeliveryService ds) {
        this.ds = ds;
    }
}
