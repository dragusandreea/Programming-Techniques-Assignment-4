package presentationLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import businessLayer.MenuItem;


public class ButtonListenerImportShow implements ActionListener {
    JFrame frameAdmin = new JFrame("ADMIN IMPORT");
    private ArrayList<MenuItem> products;

    public ButtonListenerImportShow(ArrayList<MenuItem> products) {
        this.products = products;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent e) {
        frameAdmin.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameAdmin.setSize(900, 650);

        JPanel finalPanelAdmin = new JPanel();

        JPanel panel1 = new JPanel();

        JLabel jLabel1 = new JLabel("ADMIN IMPORT");
        jLabel1.setFont(new java.awt.Font("sansserif", 1, 28)); // NOI18N
        panel1.add(jLabel1);

        JPanel panel3 = new JPanel();
        JTextArea textArea = new JTextArea(30,70);
        panel3.add(textArea);
        JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel3.add(scroll);

        JPanel panel2 = new JPanel();
        JButton importButton = new JButton("Import");
        ButtonListenerImport listenerImport = new ButtonListenerImport(textArea, products);
        importButton.addActionListener(listenerImport);
        panel2.add(importButton);


        finalPanelAdmin.add(panel1);
        finalPanelAdmin.add(panel2);
        finalPanelAdmin.add(panel3);
        finalPanelAdmin.setLayout(new BoxLayout(finalPanelAdmin, BoxLayout.Y_AXIS));

        frameAdmin.setContentPane(finalPanelAdmin);
        frameAdmin.setVisible(true);
        frameAdmin.show();

    }
}
