package presentationLayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListenerEmployee implements ActionListener {
    private JTextField tfUsername;
    private JTextField tfPassword;
    private Employee employee;
    private JTextArea ta;

    public ButtonListenerEmployee(JTextField tfUsername, JTextField tfPassword) {
        this.tfUsername = tfUsername;
        this.tfPassword = tfPassword;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        employee = new Employee(tfUsername.getText(), tfPassword.getText());
        employee.setTa(ta);

    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
