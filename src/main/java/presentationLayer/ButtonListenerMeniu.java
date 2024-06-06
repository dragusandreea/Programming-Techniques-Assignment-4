package presentationLayer;

import businessLayer.MenuItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static presentationLayer.ButtonListenerImport.distinctByKey;

public class ButtonListenerMeniu implements ActionListener {
    private JTextArea ta;
    private ArrayList<MenuItem> products;
    private ButtonListenerImport buttonListenerImport;


    public ButtonListenerMeniu(JTextArea ta, ArrayList<MenuItem> products,ButtonListenerImport buttonListenerImport) {
        this.ta = ta;
        this.products = products;
        this.buttonListenerImport = buttonListenerImport;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //ArrayList<MenuItem> products2 = buttonListenerImport.getProducts();

        ta.setText("");
        products.stream().filter(distinctByKey(MenuItem::getTitle)).forEach(product -> { ta.append(product.toString() + "\n");});

    }
}
