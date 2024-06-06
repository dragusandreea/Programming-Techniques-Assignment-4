package presentationLayer;

import businessLayer.DeliveryService;
import businessLayer.MenuItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonListenerCreateComposedProduct implements ActionListener {
    private ArrayList<MenuItem> products;
    private ArrayList<MenuItem> composed = new ArrayList<MenuItem>();
    JFrame frameCreate = new JFrame("ADMIN CREATE");
    private DeliveryService ds;

    public ButtonListenerCreateComposedProduct(ArrayList<MenuItem> products) {
        this.products = products;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frameCreate.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameCreate.setSize(900, 650);

        JPanel finalPanelCreate = new JPanel();

        JPanel panel1 = new JPanel();

        JLabel jLabel1 = new JLabel("ADMIN CREATE");
        jLabel1.setFont(new java.awt.Font("sansserif", 1, 28)); // NOI18N
        panel1.add(jLabel1);

        JPanel panel11 = new JPanel();
        JLabel jLabel11 = new JLabel("Please list below 2-5 items");
        panel11.add(jLabel11);

        JPanel panel2 = new JPanel();
        JLabel jLabel2 = new JLabel("Title 1");
        JTextField tf2 = new JTextField(20);
        panel2.add(jLabel2);
        panel2.add(tf2);

        JPanel panel3 = new JPanel();
        JLabel jLabel3 = new JLabel("Title 2");
        JTextField tf3 = new JTextField(20);
        panel3.add(jLabel3);
        panel3.add(tf3);

        JPanel panel4 = new JPanel();
        JLabel jLabel4 = new JLabel("Title 3");
        JTextField tf4 = new JTextField(20);
        panel4.add(jLabel4);
        panel4.add(tf4);

        JPanel panel5 = new JPanel();
        JLabel jLabel5 = new JLabel("Title 4");
        JTextField tf5 = new JTextField(20);
        panel5.add(jLabel5);
        panel5.add(tf5);

        JPanel panel6 = new JPanel();
        JLabel jLabel6 = new JLabel("Title 5");
        JTextField tf6 = new JTextField(20);
        panel6.add(jLabel6);
        panel6.add(tf6);

        JPanel panel66 = new JPanel();
        JLabel jLabel66 = new JLabel("Title Composed Product");
        JTextField tf66 = new JTextField(20);
        panel66.add(jLabel66);
        panel66.add(tf66);

        JPanel panel7 = new JPanel();
        JButton buttonCreate = new JButton("Create");
        panel7.add(buttonCreate);

        JPanel panel8 = new JPanel();
        JTextArea textArea = new JTextArea(30,70);
        panel8.add(textArea);
        JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel8.add(scroll);

        ButtonListenerCreateB buttonListenerCreateB = new ButtonListenerCreateB(textArea,tf2,tf3,tf4,tf5,tf6,tf66,products,composed);
        buttonCreate.addActionListener(buttonListenerCreateB);
        buttonListenerCreateB.setDs(ds);


        finalPanelCreate.add(panel1);
        finalPanelCreate.add(panel11);
        finalPanelCreate.add(panel2);
        finalPanelCreate.add(panel3);
        finalPanelCreate.add(panel4);
        finalPanelCreate.add(panel5);
        finalPanelCreate.add(panel6);
        finalPanelCreate.add(panel66);
        finalPanelCreate.add(panel7);
        finalPanelCreate.add(panel8);



        finalPanelCreate.setLayout(new BoxLayout(finalPanelCreate, BoxLayout.Y_AXIS));
        frameCreate.setContentPane(finalPanelCreate);
        frameCreate.setVisible(true);
        frameCreate.show();

    }

    public DeliveryService getDs() {
        return ds;
    }

    public void setDs(DeliveryService ds) {
        this.ds = ds;
    }
}
