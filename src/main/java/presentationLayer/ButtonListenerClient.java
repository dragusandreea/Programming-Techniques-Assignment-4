package presentationLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import businessLayer.MenuItem;
import businessLayer.Order;


public class ButtonListenerClient implements ActionListener {
    JFrame frameClient = new JFrame("CLIENT");
    private ArrayList<MenuItem> products;
    private ButtonListenerImport buttonListenerImport;
    private ButtonListenerAdmin buttonListenerAdmin;
    private JTextField tfUsername;
    private JTextField tfPassword;
    private Client client;
    private Map<Order,ArrayList<MenuItem>> orderData;
    private Employee employee;
    private ArrayList<Client> reg;


    public ButtonListenerClient(ArrayList<MenuItem> products,ButtonListenerAdmin buttonListenerAdmin, JTextField tf1, JTextField tf2,Map<Order,ArrayList<MenuItem>> orderData, Employee employee) {
        this.products = products;
        this.buttonListenerAdmin = buttonListenerAdmin;
        this.tfUsername = tf1;
        this.tfPassword = tf2;
        this.orderData = orderData;
        this.employee = employee;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent e) {
        client = new Client(tfUsername.getText(),tfPassword.getText());

        int ok = 1;
        int found = 0;
        for(Client r: reg)
        {
            if(r.getUsername().equals(tfUsername.getText()) && !(r.getPassword().equals(tfPassword.getText())) )
            {
                JOptionPane.showMessageDialog(null,"Wrong Password for this Client","Wrong Password",1);
                ok = 0;
            }
        }
        if(ok == 1) {
            frameClient.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            frameClient.setSize(900, 750);


            buttonListenerImport = buttonListenerAdmin.getButtonListenerImport();

            JPanel finalPanelClient = new JPanel();

            JPanel panel1 = new JPanel();

            JLabel jLabel1 = new JLabel("CLIENT");
            jLabel1.setFont(new java.awt.Font("sansserif", 1, 28)); // NOI18N
            panel1.add(jLabel1);

            JPanel panel2 = new JPanel();
            JLabel label2 = new JLabel("Keyword");
            JTextField tf2 = new JTextField(20);
            panel2.add(label2);
            panel2.add(tf2);

            JPanel panel3 = new JPanel();
            JLabel label3 = new JLabel("Rating");
            JTextField tf3 = new JTextField(20);
            panel3.add(label3);
            panel3.add(tf3);

            JPanel panel4 = new JPanel();
            JLabel label4 = new JLabel("Calories");
            JTextField tf4 = new JTextField(20);
            panel4.add(label4);
            panel4.add(tf4);

            JPanel panel5 = new JPanel();
            JLabel label5 = new JLabel("Proteins");
            JTextField tf5 = new JTextField(20);
            panel5.add(label5);
            panel5.add(tf5);

            JPanel panel6 = new JPanel();
            JLabel label6 = new JLabel("Fats");
            JTextField tf6 = new JTextField(20);
            panel6.add(label6);
            panel6.add(tf6);

            JPanel panel7 = new JPanel();
            JLabel label7 = new JLabel("Sodium");
            JTextField tf7 = new JTextField(20);
            panel7.add(label7);
            panel7.add(tf7);

            JPanel panel8 = new JPanel();
            JLabel label8 = new JLabel("Price");
            JTextField tf8 = new JTextField(20);
            panel8.add(label8);
            panel8.add(tf8);

            JPanel panel20 = new JPanel();
            panel20.add(panel2);
            panel20.add(panel3);
            panel20.add(panel4);
            panel20.add(panel5);
            panel20.add(panel6);
            panel20.add(panel7);
            panel20.add(panel8);

            JPanel panel21 = new JPanel();
            JPanel panel22 = new JPanel();
            JLabel jLabel22 = new JLabel("Title 1");
            JTextField tf22 = new JTextField(20);
            panel22.add(jLabel22);
            panel22.add(tf22);

            JPanel panel23 = new JPanel();
            JLabel jLabel23 = new JLabel("Title 2");
            JTextField tf23 = new JTextField(20);
            panel23.add(jLabel23);
            panel23.add(tf23);

            JPanel panel24 = new JPanel();
            JLabel jLabel24 = new JLabel("Title 3");
            JTextField tf24 = new JTextField(20);
            panel24.add(jLabel24);
            panel24.add(tf24);

            JPanel panel25 = new JPanel();
            JLabel jLabel25 = new JLabel("Title 4");
            JTextField tf25 = new JTextField(20);
            panel25.add(jLabel25);
            panel25.add(tf25);

            JPanel panel26 = new JPanel();
            JLabel jLabel26 = new JLabel("Title 5");
            JTextField tf26 = new JTextField(20);
            panel26.add(jLabel26);
            panel26.add(tf26);

            JPanel panel27 = new JPanel();
            JLabel jLabel27 = new JLabel("Day");
            JTextField tf27 = new JTextField(2);
            JLabel jLabel28 = new JLabel("Month");
            JTextField tf28 = new JTextField(2);
            JLabel jLabel29 = new JLabel("Year");
            JTextField tf29 = new JTextField(4);
            JLabel jLabel30 = new JLabel("Hour");
            JTextField tf30 = new JTextField(2);
            panel27.add(jLabel27);
            panel27.add(tf27);
            panel27.add(jLabel28);
            panel27.add(tf28);
            panel27.add(jLabel29);
            panel27.add(tf29);
            panel27.add(jLabel30);
            panel27.add(tf30);

            panel21.add(panel22);
            panel21.add(panel23);
            panel21.add(panel24);
            panel21.add(panel25);
            panel21.add(panel26);
            panel21.add(panel27);

            JPanel panel100 = new JPanel();
            panel100.add(panel20);
            panel100.add(panel21);


            JPanel panel9 = new JPanel();
            JButton buttonMenu = new JButton("Menu");
            JButton buttonSearch = new JButton("Search");
            JButton buttonOrder = new JButton("Order");
            panel9.add(buttonMenu);
            panel9.add(buttonSearch);
            panel9.add(buttonOrder);

            JPanel panel10 = new JPanel();
            JTextArea textArea = new JTextArea(20, 70);
            panel10.add(textArea);
            JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            panel10.add(scroll);

            ButtonListenerMeniu buttonListenerMeniu = new ButtonListenerMeniu(textArea, products, buttonListenerImport);
            buttonMenu.addActionListener(buttonListenerMeniu);

            ButtonListenerSearch buttonListenerSearch = new ButtonListenerSearch(textArea, tf2, tf3, tf4, tf5, tf6, tf7, tf8, products, buttonListenerImport);
            buttonSearch.addActionListener(buttonListenerSearch);

            ButtonListenerOrder buttonListenerOrder = new ButtonListenerOrder(textArea, tf22, tf23, tf24, tf25, tf26, tf27, tf28, tf29, tf30, products, orderData, client, employee);
            buttonOrder.addActionListener(buttonListenerOrder);
            buttonListenerOrder.addObserver(employee);

            finalPanelClient.add(panel1);
       /* finalPanelClient.add(panel2);
        finalPanelClient.add(panel3);
        finalPanelClient.add(panel4);
        finalPanelClient.add(panel5);
        finalPanelClient.add(panel6);
        finalPanelClient.add(panel7);
        finalPanelClient.add(panel8);
        finalPanelClient.add(panel9);
        finalPanelClient.add(panel10);
        */
            finalPanelClient.add(panel100);
            finalPanelClient.add(panel9);
            finalPanelClient.add(panel10);

            panel20.setLayout(new BoxLayout(panel20, BoxLayout.Y_AXIS));
            panel21.setLayout(new BoxLayout(panel21, BoxLayout.Y_AXIS));
            finalPanelClient.setLayout(new BoxLayout(finalPanelClient, BoxLayout.Y_AXIS));

            frameClient.setContentPane(finalPanelClient);
            frameClient.setVisible(true);
            frameClient.show();
        }
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ArrayList<Client> getReg() {
        return reg;
    }

    public void setReg(ArrayList<Client> reg) {
        this.reg = reg;
    }
}
