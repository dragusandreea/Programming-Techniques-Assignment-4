package businessLayer;

import presentationLayer.User;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class Employee extends User implements Observer {
    JTextArea ta;
    private DeliveryService ds;
    public Employee(String username, String password) {
        super(username, password);
        this.setRole("EMPLOYEE");
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
    @SuppressWarnings("deprecation")
    @Override
    public void update(Observable o, Object arg) {
        ta.append("\nThe employee prepared the products for the placed order\n");
        //System.out.println("\nThe employee prepared the products for the placed order\n");
    }
}
