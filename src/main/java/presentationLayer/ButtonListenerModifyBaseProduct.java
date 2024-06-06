package presentationLayer;

import businessLayer.DeliveryService;
import businessLayer.MenuItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonListenerModifyBaseProduct implements ActionListener {
    private JTextArea ta;
    private JTextField title;
    private JTextField rating;
    private JTextField calories;
    private JTextField protein;
    private JTextField fat;
    private JTextField sodium;
    private JTextField price;
    private ArrayList<MenuItem> products;
    private DeliveryService ds;

    public ButtonListenerModifyBaseProduct(JTextArea ta, JTextField title, JTextField rating, JTextField calories, JTextField protein, JTextField fat, JTextField sodium, JTextField price, ArrayList<MenuItem> products) {
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

        float ratingVal = -1;
        int caloriesVal = 0;
        int proteinVal = 0;
        int fatVal = 0;
        int sodiumVal = 0;
        float priceVal = 0;

        if(!title.getText().equals("")) {
            if (!(rating.getText().equals(""))) {
                 ratingVal = Float.parseFloat(rating.getText());
            }
            if (!(calories.getText().equals(""))) {
                 caloriesVal = Integer.parseInt(calories.getText());
            }
            if (!(protein.getText().equals(""))) {
                 proteinVal = Integer.parseInt(protein.getText());
            }
            if (!(fat.getText().equals(""))) {
                 fatVal = Integer.parseInt(fat.getText());
            }
            if (!(sodium.getText().equals(""))) {
                 sodiumVal = Integer.parseInt(sodium.getText());
            }
            if (!(price.getText().equals(""))) {
                 priceVal = Float.parseFloat(price.getText());
            }
        }
        else
        {
            ta.setText("Nu a fost completat campul title!");
        }

        int itemFound = 0;
        for(MenuItem item: products)
        {
            if(item.getTitle().equals(titleVal))
            {
                if(ratingVal != -1)
                    item.setRating(ratingVal);

                if(caloriesVal != 0)
                    item.setCalories(caloriesVal);

                if(proteinVal != 0)
                    item.setProtein(proteinVal);

                if(fatVal != 0)
                    item.setFat(fatVal);

                if(sodiumVal != 0)
                    item.setSodium(sodiumVal);

                if(priceVal != 0)
                    item.setPrice(priceVal);

                itemFound = 1;
                ta.append("\nAm modificat produsul:\n");
                ta.append(item.toString());
            }
        }

        if(!(title.getText().equals("")) && itemFound == 0)
        {
            ta.setText("Produsul "+title.getText()+" nu poate fi actualizat deoarece nu exista in meniu!");
        }

         */
        ds.modifyProduct(ta,title,rating,calories,protein,fat,sodium,price,products);

    }

    public DeliveryService getDs() {
        return ds;
    }

    public void setDs(DeliveryService ds) {
        this.ds = ds;
    }
}
