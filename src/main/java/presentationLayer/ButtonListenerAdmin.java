package presentationLayer;

import businessLayer.DeliveryService;
import businessLayer.MenuItem;
import businessLayer.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

public class ButtonListenerAdmin implements ActionListener {
    private JFrame frameAdmin =  new JFrame("ADMIN");
    private ArrayList<MenuItem> products;
    private ButtonListenerImport buttonListenerImport;
    private ButtonListenerAddBaseProduct buttonListenerAddBaseProduct;
    private ButtonListenerDeleteProduct buttonListenerDeleteProduct;
    private Map<Order,ArrayList<MenuItem>> orderData;
    private ArrayList<Admin> reg;
    private JTextField tf2;
    private JTextField tf3;
    private DeliveryService ds;

    public ButtonListenerAdmin(ArrayList<MenuItem> products,Map<Order,ArrayList<MenuItem>> orderData ) {
        this.products = products;
        this.orderData = orderData;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent e) {
        Admin a = new Admin(tf2.getText(),tf3.getText());
        int ok = 1;
        int found = 0;
        for(Admin r: reg)
        {
            if(r.getUsername().equals(tf2.getText()) && !(r.getPassword().equals(tf3.getText())) )
            {
                JOptionPane.showMessageDialog(null,"Wrong Password for this user","Wrong Password",1);
                ok = 0;
            }
        }
        if( ok ==1 ) {
            frameAdmin.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            frameAdmin.setSize(1100, 700);

            JPanel finalPanelAdmin = new JPanel();
            JPanel panel1 = new JPanel();

            JLabel jLabel1 = new JLabel("ADMIN");
            jLabel1.setFont(new java.awt.Font("sansserif", 1, 28)); // NOI18N
            panel1.add(jLabel1);

            JPanel panel2 = new JPanel();
            JLabel jLabel2 = new JLabel("Title");
            panel2.add(jLabel2);
            JTextField tf2 = new JTextField(20);
            panel2.add(tf2);

            JPanel panel3 = new JPanel();
            JLabel jLabel3 = new JLabel("Rating");
            panel3.add(jLabel3);
            JTextField tf3 = new JTextField(20);
            panel3.add(tf3);

            JPanel panel4 = new JPanel();
            JLabel jLabel4 = new JLabel("Calories");
            panel4.add(jLabel4);
            JTextField tf4 = new JTextField(20);
            panel4.add(tf4);

            JPanel panel5 = new JPanel();
            JLabel jLabel5 = new JLabel("Protein");
            panel5.add(jLabel5);
            JTextField tf5 = new JTextField(20);
            panel5.add(tf5);

            JPanel panel6 = new JPanel();
            JLabel jLabel6 = new JLabel("Fat");
            panel6.add(jLabel6);
            JTextField tf6 = new JTextField(20);
            panel6.add(tf6);

            JPanel panel7 = new JPanel();
            JLabel jLabel7 = new JLabel("Sodium");
            panel7.add(jLabel7);
            JTextField tf7 = new JTextField(20);
            panel7.add(tf7);

            JPanel panel8 = new JPanel();
            JLabel jLabel8 = new JLabel("Price");
            panel8.add(jLabel8);
            JTextField tf8 = new JTextField(20);
            panel8.add(tf8);

            JPanel panel20 = new JPanel();
            panel20.add(panel2);
            panel20.add(panel3);
            panel20.add(panel4);
            panel20.add(panel5);
            panel20.add(panel6);
            panel20.add(panel7);
            panel20.add(panel8);
            panel20.setLayout(new BoxLayout(panel20, BoxLayout.Y_AXIS));

            JPanel panel30 = new JPanel();
            JPanel panel31FINAL = new JPanel();

            JPanel panel31 = new JPanel();
            JPanel panel310 = new JPanel();
            JLabel label310 = new JLabel("Raport Type 1");
            panel310.add(label310);

            JLabel label31 = new JLabel("Hour 1");
            JTextField tf31 = new JTextField(2);
            panel31.add(label31);
            panel31.add(tf31);
            JLabel label311 = new JLabel("Hour 2");
            JTextField tf311 = new JTextField(2);
            panel31.add(label311);
            panel31.add(tf311);

            panel31FINAL.add(panel310);
            panel31FINAL.add(panel31);
            panel31FINAL.setLayout(new BoxLayout(panel31FINAL, BoxLayout.Y_AXIS));


            JPanel panel32FINAL = new JPanel();
            JPanel panel32 = new JPanel();
            JLabel label320 = new JLabel("Raport Type 2");
            JPanel panel320 = new JPanel();
            panel320.add(label320);

            JLabel label321 = new JLabel("Number of times ordered");
            JTextField tf321 = new JTextField(2);
            panel32.add(label321);
            panel32.add(tf321);

            panel32FINAL.add(panel320);
            panel32FINAL.add(panel32);
            panel32FINAL.setLayout(new BoxLayout(panel32FINAL, BoxLayout.Y_AXIS));


            JPanel panel33FINAL = new JPanel();
            JPanel panel33 = new JPanel();
            JLabel label330 = new JLabel("Raport Type 3");
            JPanel panel330 = new JPanel();
            panel330.add(label330);

            JLabel label331 = new JLabel("Number of times ordered");
            JTextField tf331 = new JTextField(2);

            JLabel label332 = new JLabel("Minimum Price");
            JTextField tf332 = new JTextField(2);

            panel33.add(label331);
            panel33.add(tf331);

            panel33.add(label332);
            panel33.add(tf332);

            panel33FINAL.add(panel330);
            panel33FINAL.add(panel33);
            panel33FINAL.setLayout(new BoxLayout(panel33FINAL, BoxLayout.Y_AXIS));


            JPanel panel34FINAL = new JPanel();
            JPanel panel34 = new JPanel();
            JLabel label340 = new JLabel("Raport Type 4");
            JPanel panel340 = new JPanel();
            panel340.add(label340);

            JLabel label341 = new JLabel("Day");
            JTextField tf341 = new JTextField(2);

            JLabel label3411 = new JLabel("Month");
            JTextField tf3411 = new JTextField(2);

            JLabel label3412 = new JLabel("Year");
            JTextField tf3412 = new JTextField(4);

            //JLabel label342 = new JLabel("Number of times ordered");
            //JTextField tf342 = new JTextField(2);

            panel34.add(label341);
            panel34.add(tf341);

            panel34.add(label3411);
            panel34.add(tf3411);

            panel34.add(label3412);
            panel34.add(tf3412);

            // panel34.add(label342);
            // panel34.add(tf342);

            panel34FINAL.add(panel340);
            panel34FINAL.add(panel34);
            panel34FINAL.setLayout(new BoxLayout(panel34FINAL, BoxLayout.Y_AXIS));

            panel31FINAL.setBorder(BorderFactory.createLineBorder(Color.black));
            panel32FINAL.setBorder(BorderFactory.createLineBorder(Color.black));
            panel33FINAL.setBorder(BorderFactory.createLineBorder(Color.black));
            panel34FINAL.setBorder(BorderFactory.createLineBorder(Color.black));


            panel30.add(panel31FINAL);
            panel30.add(panel32FINAL);
            panel30.add(panel33FINAL);
            panel30.add(panel34FINAL);

            JPanel panel40 = new JPanel();
            panel40.add(panel20);
            panel40.add(panel30);

            JPanel panel9 = new JPanel();
            JButton buttonAddBaseProduct = new JButton("Add");
            panel9.add(buttonAddBaseProduct);

            JButton buttonDeleteProduct = new JButton("Delete");
            panel9.add(buttonDeleteProduct);

            JButton buttonModifyProduct = new JButton("Modify");
            panel9.add(buttonModifyProduct);

            JButton buttonImport = new JButton("Import");
            panel9.add(buttonImport);

            JButton buttonMenu = new JButton("Menu");
            panel9.add(buttonMenu);

            JButton buttonCreateCompositieProduct = new JButton("Create Composed Product");
            panel9.add(buttonCreateCompositieProduct);

            JButton buttonRaport = new JButton("Raport");
            panel9.add(buttonRaport);

            JTextArea ta = new JTextArea(10, 70);
            panel9.add(ta);


            buttonListenerImport = new ButtonListenerImport(ta, products);
            buttonImport.addActionListener(buttonListenerImport);



         /*
        //Create a new thread to handle processes while the JFrame is frozen
        SwingUtilities.invokeLater(new Thread(){
            public void run(){
                products = buttonListenerImport.getProducts();
                buttonListenerImport.solveDone = true;
            }
        });

        //Sleep the program until the process is done.
        try{
            while(!buttonListenerImport.solveDone) {
                Thread.sleep(10); //Interval in milliseconds to check if the puzzle is done goes here.
            }
            buttonListenerImport.solveDone = false;
        }catch(InterruptedException exception){
            exception.printStackTrace();
            System.exit(-1);
        }
        */


            buttonListenerAddBaseProduct = new ButtonListenerAddBaseProduct(ta, tf2, tf3, tf4, tf5, tf6, tf7, tf8, products);
            buttonAddBaseProduct.addActionListener(buttonListenerAddBaseProduct);

            ButtonListenerModifyBaseProduct buttonListenerModifyProduct = new ButtonListenerModifyBaseProduct(ta, tf2, tf3, tf4, tf5, tf6, tf7, tf8, products);
            buttonModifyProduct.addActionListener(buttonListenerModifyProduct);

            buttonListenerDeleteProduct = new ButtonListenerDeleteProduct(ta, tf2, products);
            buttonDeleteProduct.addActionListener(buttonListenerDeleteProduct);


            ButtonListenerMeniu buttonListenerMeniu = new ButtonListenerMeniu(ta, products, buttonListenerImport);
            buttonMenu.addActionListener(buttonListenerMeniu);

            ButtonListenerCreateComposedProduct buttonListenerCreateComposedProduct = new ButtonListenerCreateComposedProduct(products);
            buttonCreateCompositieProduct.addActionListener(buttonListenerCreateComposedProduct);
            buttonListenerCreateComposedProduct.setDs(ds);

            ButtonListenerRaport buttonListenerRaport = new ButtonListenerRaport(ta, tf31, tf311, tf321, tf331, tf332, tf341, tf3411, tf3412, products, orderData);
            buttonRaport.addActionListener(buttonListenerRaport);

            buttonListenerModifyProduct.setDs(ds);
            buttonListenerDeleteProduct.setDs(ds);
            buttonListenerAddBaseProduct.setDs(ds);

            JScrollPane scroll = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            panel9.add(scroll);

            finalPanelAdmin.add(panel1);
            //finalPanelAdmin.add(panel2);
            //finalPanelAdmin.add(panel3);
            //finalPanelAdmin.add(panel4);
            //finalPanelAdmin.add(panel5);
            //finalPanelAdmin.add(panel6);
            //finalPanelAdmin.add(panel7);
            //finalPanelAdmin.add(panel8);
            finalPanelAdmin.add(panel40);
            finalPanelAdmin.add(panel9);

            finalPanelAdmin.setLayout(new BoxLayout(finalPanelAdmin, BoxLayout.Y_AXIS));

            frameAdmin.setContentPane(finalPanelAdmin);
            frameAdmin.setVisible(true);
            frameAdmin.show();

        }



    }

    public ArrayList<MenuItem> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<MenuItem> products) {
        this.products = products;
    }

    public ButtonListenerImport getButtonListenerImport() {
        return buttonListenerImport;
    }

    public void setButtonListenerImport(ButtonListenerImport buttonListenerImport) {
        this.buttonListenerImport = buttonListenerImport;
    }

    public ButtonListenerAddBaseProduct getButtonListenerAddBaseProduct() {
        return buttonListenerAddBaseProduct;
    }

    public void setButtonListenerAddBaseProduct(ButtonListenerAddBaseProduct buttonListenerAddBaseProduct) {
        this.buttonListenerAddBaseProduct = buttonListenerAddBaseProduct;
    }

    public ButtonListenerDeleteProduct getButtonListenerDeleteProduct() {
        return buttonListenerDeleteProduct;
    }

    public void setButtonListenerDeleteProduct(ButtonListenerDeleteProduct buttonListenerDeleteProduct) {
        this.buttonListenerDeleteProduct = buttonListenerDeleteProduct;
    }

    public ArrayList<Admin> getReg() {
        return reg;
    }

    public void setReg(ArrayList<Admin> reg) {
        this.reg = reg;
    }

    public JTextField getTf2() {
        return tf2;
    }

    public void setTf2(JTextField tf2) {
        this.tf2 = tf2;
    }

    public JTextField getTf3() {
        return tf3;
    }

    public void setTf3(JTextField tf3) {
        this.tf3 = tf3;
    }

    public DeliveryService getDs() {
        return ds;
    }

    public void setDs(DeliveryService ds) {
        this.ds = ds;
    }
}
