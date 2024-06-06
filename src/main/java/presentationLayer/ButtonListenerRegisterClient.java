package presentationLayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonListenerRegisterClient implements ActionListener {
    private ArrayList<Client> reg;
    private JTextField tf2;
    private JTextField tf3;

    public ButtonListenerRegisterClient(ArrayList<Client> reg, JTextField tf2, JTextField tf3) {
        this.reg = reg;
        this.tf2 = tf2;
        this.tf3 = tf3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Client client = new Client(tf2.getText(),tf3.getText());
        reg.add(client);
    }
}
