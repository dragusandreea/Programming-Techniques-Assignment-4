package presentationLayer;

import businessLayer.BaseProduct;
import businessLayer.DeliveryService;
import businessLayer.MenuItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonListenerAddBaseProduct implements ActionListener {
    private JTextArea ta;
    private JTextField title;
    private JTextField rating;
    private JTextField calories;
    private JTextField protein;
    private JTextField fat;
    private JTextField sodium;
    private JTextField price;
    private ArrayList<MenuItem>products;
    DeliveryService ds = GUI.ds;

    public ButtonListenerAddBaseProduct(JTextArea ta, JTextField title, JTextField rating, JTextField calories, JTextField protein, JTextField fat, JTextField sodium, JTextField price,ArrayList<MenuItem>products) {
        this.ta = ta;
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
        this.products = products;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         /*
        String titleVal = title.getText();
        float ratingVal = Float.parseFloat(rating.getText());
        int caloriesVal = Integer.parseInt(calories.getText());
        int proteinVal = Integer.parseInt(protein.getText());
        int fatVal = Integer.parseInt(fat.getText());
        int sodiumVal = Integer.parseInt(sodium.getText());
        float priceVal = Float.parseFloat(price.getText());

        BaseProduct addProduct = new BaseProduct(titleVal,ratingVal,caloriesVal,proteinVal,fatVal,sodiumVal,priceVal);

        int ok = 1;
        for(MenuItem item: products)
        {
            if(item.getTitle().equals(addProduct.getTitle()))
            {
                ok = 0;
            }
        }
        if(ok == 1)
        {
            products.add(addProduct);

            ta.append("\nAm adaugat produsul:\n");
            ta.append(addProduct.toString());
        }
        else
        {
            ta.append("\nAcest produs exista deja in meniu!");
        }


        //ds.addBaseProduct(addProduct);
        */
        ds.addBaseProduct(ta,title,rating,calories,protein,fat,sodium,price,products);


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
