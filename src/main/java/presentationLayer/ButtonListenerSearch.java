package presentationLayer;

import businessLayer.MenuItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;
import static presentationLayer.ButtonListenerImport.distinctByKey;

public class ButtonListenerSearch implements ActionListener {
    private JTextArea ta;
    private JTextField keyword;
    private JTextField rating;
    private JTextField calories;
    private JTextField protein;
    private JTextField fat;
    private JTextField sodium;
    private JTextField price;
    private ArrayList<MenuItem> products;

    private List<MenuItem> filteredProducts;

    ButtonListenerImport buttonListenerImport;


    public ButtonListenerSearch(JTextArea ta, JTextField keyword, JTextField rating, JTextField calories, JTextField protein, JTextField fat, JTextField sodium, JTextField price, ArrayList<MenuItem> products, ButtonListenerImport buttonListenerImport) {
        this.ta = ta;
        this.keyword = keyword;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
        this.products = products;
        this.buttonListenerImport = buttonListenerImport;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        ta.setText("");
        filteredProducts = new ArrayList<MenuItem>(products);

        if (!(keyword.getText().equals(""))) {
            filteredProducts = filteredProducts.stream().filter(product -> product.getTitle().contains(keyword.getText())).collect(toList());
        }

        if (!(rating.getText().equals(""))) {
            float ratingValue = Float.parseFloat(rating.getText());
            filteredProducts = filteredProducts.stream().filter(product -> product.getRating() == ratingValue).collect(toList());
        }

        if (!(calories.getText().equals(""))) {
            int caloriesValue = Integer.parseInt(calories.getText());
            filteredProducts = filteredProducts.stream().filter(product -> product.getCalories() == caloriesValue).collect(toList());
        }

        if (!(protein.getText().equals(""))) {
            int proteinValue = Integer.parseInt(protein.getText());
            filteredProducts = filteredProducts.stream().filter(product -> product.getProtein() == proteinValue).collect(toList());
        }

        if (!(fat.getText().equals(""))) {
            int fatValue = Integer.parseInt(fat.getText());
            filteredProducts = filteredProducts.stream().filter(product -> product.getFat() == fatValue).collect(toList());
        }

        if (!(sodium.getText().equals(""))) {
            int sodiumValue = Integer.parseInt(sodium.getText());
            filteredProducts = filteredProducts.stream().filter(product -> product.getSodium() == sodiumValue).collect(toList());
        }

        if (!(price.getText().equals(""))) {
            float priceValue = Float.parseFloat(price.getText());
            filteredProducts = filteredProducts.stream().filter(product -> product.getPrice() == priceValue).collect(toList());
        }

        filteredProducts.stream().filter(distinctByKey(MenuItem::getTitle)).forEach(product -> { ta.append(product.toString() + "\n");});


    }

}
