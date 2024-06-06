package presentationLayer;

import businessLayer.Order;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class Employee extends User implements Observer {
    private static int index;
    private int idEmployee;
    private JTextArea ta;
    private Order order;

    public Employee(String username, String password) {
        super(username, password);
        this.setRole("EMPLOYEE");

        index++;
        this.idEmployee = index;
    }

    public void setTa(JTextArea ta) {
        this.ta = ta;
    }

    @Override
    public void update(Observable o, Object arg) {
     ta.append("\n\nThe employee is preparing the order "+( (Order)arg).toString() + "\n\n");
     //System.out.println("\nThe employee is preparing the order "+( (Order)arg).toString() + "\n\n");
    }
     /*
    @Override
    public void update(Observable o, Object arg) {
        this.order.setOrderProcessed(true);
    }

      */

    @Override
    public String toString() {
        return "Employee{" +
                "idEmployee=" + idEmployee +
                ", ta=" + ta +
                ", order=" + order +
                '}';
    }
}
