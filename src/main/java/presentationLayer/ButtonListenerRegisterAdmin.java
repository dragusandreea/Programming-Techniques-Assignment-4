package presentationLayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonListenerRegisterAdmin implements ActionListener {
    private ArrayList<Admin> reg;
    private JTextField tf2;
    private JTextField tf3;

    public ButtonListenerRegisterAdmin(ArrayList<Admin> reg,  JTextField tf2,  JTextField tf3) {
        this.reg = reg;
        this.tf2 = tf2;
        this.tf3 = tf3;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
         Admin admin = new Admin(tf2.getText(), tf3.getText());
         reg.add(admin);
    }
}
