package businessLayer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public interface IDeliveryServiceProcessing {

    //admin
    List<MenuItem> importProducts();
    void addBaseProduct(JTextArea ta, JTextField title, JTextField rating, JTextField calories, JTextField protein, JTextField fat, JTextField sodium, JTextField price,ArrayList<MenuItem>products);
    void deleteProduct(JTextArea ta, JTextField title, ArrayList<MenuItem> products);
    void modifyProduct(JTextArea ta, JTextField title, JTextField rating, JTextField calories, JTextField protein, JTextField fat, JTextField sodium, JTextField price, ArrayList<MenuItem> products);
    void createComposedProduct(JTextArea ta, JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4, JTextField tf5, JTextField tf6, ArrayList<MenuItem> products, ArrayList<MenuItem> composed);


}
