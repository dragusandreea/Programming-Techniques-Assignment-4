package presentationLayer;

import businessLayer.BaseProduct;
import businessLayer.DeliveryService;
import businessLayer.MenuItem;

import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static presentationLayer.ButtonListenerImport.distinctByKey;

public class GUI {
    public static DeliveryService ds = new DeliveryService();
    public static ButtonListenerAdmin buttonListenerAdmin;
    static List<MenuItem> products = new ArrayList<MenuItem>();
    public static void start()
    {   //List<MenuItem> products = new ArrayList<MenuItem>();

        Pattern pattern = Pattern.compile(",");

        try (Stream<String> lines = Files.lines(Path.of("products.csv"))) {

            products = lines.skip(1).map(line -> {
                String[] arr = pattern.split(line);
                return new BaseProduct(
                        arr[0],
                        Float.parseFloat(arr[1]),
                        Integer.parseInt(arr[2]),
                        Integer.parseInt(arr[3]),
                        Integer.parseInt(arr[4]),
                        Integer.parseInt(arr[5]),
                        Float.parseFloat(arr[6]));
            }).collect(Collectors.toList());
            //System.out.println(products.toString());
            products.stream().filter(distinctByKey(MenuItem::getTitle));
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        JFrame frameLogIn = new JFrame("Catering Company");
        frameLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogIn.setSize(400, 300);

        JPanel finalPanel = new JPanel();

        JPanel panel1 = new JPanel();
        panel1.setBackground(new java.awt.Color(172, 214, 218, 255));
        JLabel jLabel1 = new JLabel("Login");
        jLabel1.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(229, 162, 162, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel1.add(jLabel1);


        JPanel panel2 = new JPanel();
        panel2.setBackground(new java.awt.Color(172, 214, 218, 255));
        JLabel jLabel2 = new JLabel("User Name");
        jLabel2.setForeground(new java.awt.Color(245, 245, 245, 255));
        panel2.add(jLabel2);

        JTextField tf2 = new JTextField(20);
        tf2.setCaretColor(new java.awt.Color(69, 68, 68));
        panel2.add(tf2);


        JPanel panel3 = new JPanel();
        panel3.setBackground(new java.awt.Color(172, 214, 218, 255));
        JLabel jLabel3 = new JLabel("Password");
        jLabel3.setForeground(new java.awt.Color(239, 239, 239));
        panel3.add(jLabel3);

        JTextField tf3 = new JTextField(20);
        tf3.setCaretColor(new java.awt.Color(69, 68, 68));
        panel3.add(tf3);


        JPanel panel4 = new JPanel();
        panel4.setBackground(new java.awt.Color(172, 214, 218, 255));

        JButton logAdmin = new JButton("Login ADMIN");
        ArrayList<MenuItem> products2 = new ArrayList<>(products);
        buttonListenerAdmin = new ButtonListenerAdmin(products2,ds.getOrderData());
        logAdmin.addActionListener(buttonListenerAdmin);
        logAdmin.setBackground(new java.awt.Color(229, 162, 162, 255));
        logAdmin.setForeground(new java.awt.Color(16, 15, 15));

        panel4.add(logAdmin);


        JPanel panel5 = new JPanel();
        panel5.setBackground(new java.awt.Color(172, 214, 218, 255));

        JButton logEmployee = new JButton ("Login EMPLOYEE");
        logEmployee.setBackground(new java.awt.Color(229, 162, 162, 255));
        logEmployee.setForeground(new java.awt.Color(16, 15, 15));

        ButtonListenerEmployee buttonListenerEmployee = new ButtonListenerEmployee(tf2,tf3);
        logEmployee.addActionListener(buttonListenerEmployee);
        Employee e = new Employee("BasicEmployee", "BasicPassword");
        buttonListenerEmployee.setEmployee(e);
        //System.out.println(buttonListenerEmployee.getEmployee().toString());

        panel4.add(logEmployee);


        JPanel panel6 = new JPanel();
        panel6.setBackground(new java.awt.Color(172, 214, 218, 255));

        JButton logClient = new JButton ("Login CLIENT");
        logClient.setBackground(new java.awt.Color(229, 162, 162, 255));
        logClient.setForeground(new java.awt.Color(16, 15, 15));

        JPanel panel10 = new JPanel();
        panel10.setBackground(new java.awt.Color(172, 214, 218, 255));

        ArrayList<Admin> registeredAdmins = new ArrayList<>();
        ArrayList<Client> registeredClients = new ArrayList<>();

        JButton RegisterAdmin = new JButton ("Register Admin");
        ButtonListenerRegisterAdmin buttonListenerRegisterAdmin = new ButtonListenerRegisterAdmin(registeredAdmins, tf2, tf3);
        RegisterAdmin.addActionListener(buttonListenerRegisterAdmin);

        RegisterAdmin.setBackground(new java.awt.Color(229, 162, 162, 255));
        RegisterAdmin.setForeground(new java.awt.Color(16, 15, 15));
        panel10.add(RegisterAdmin);

        JButton RegisterClient = new JButton ("Register Client");
        ButtonListenerRegisterClient buttonListenerRegisterClient = new ButtonListenerRegisterClient(registeredClients,tf2,tf3);
        RegisterClient.addActionListener(buttonListenerRegisterClient);

        buttonListenerAdmin.setTf2(tf2);
        buttonListenerAdmin.setTf3(tf3);
        buttonListenerAdmin.setReg(registeredAdmins);
        buttonListenerAdmin.setDs(ds);



        RegisterClient.setBackground(new java.awt.Color(229, 162, 162, 255));
        RegisterClient.setForeground(new java.awt.Color(16, 15, 15));
        panel10.add(RegisterClient);


        ArrayList<MenuItem> products3 = buttonListenerAdmin.getProducts();

        ButtonListenerClient buttonListenerClient = new ButtonListenerClient(products3,buttonListenerAdmin,tf2,tf3, ds.getOrderData(), buttonListenerEmployee.getEmployee());
        logClient.addActionListener(buttonListenerClient);
        buttonListenerClient.setReg(registeredClients);

        panel4.add(logClient);
        //panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));


        finalPanel.add(panel1);
        finalPanel.add(panel2);
        finalPanel.add(panel3);
        finalPanel.add(panel10);
        finalPanel.add(panel4);
        finalPanel.add(panel5);
        finalPanel.add(panel6);

        finalPanel.setLayout(new BoxLayout(finalPanel, BoxLayout.Y_AXIS));
        frameLogIn.setContentPane(finalPanel);
        frameLogIn.setVisible(true);

    }

    public DeliveryService getDs() {
        return ds;
    }

    public void setDs(DeliveryService ds) {
        this.ds = ds;
    }

    public static ButtonListenerAdmin getButtonListenerAdmin() {
        return buttonListenerAdmin;
    }

    public static void setButtonListenerAdmin(ButtonListenerAdmin buttonListenerAdmin) {
        GUI.buttonListenerAdmin = buttonListenerAdmin;
    }

    public static List<MenuItem> getProducts() {
        return products;
    }

    public static void setProducts(List<MenuItem> products) {
        GUI.products = products;
    }
}
