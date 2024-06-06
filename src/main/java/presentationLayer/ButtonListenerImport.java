package presentationLayer;

import businessLayer.BaseProduct;
import businessLayer.DeliveryService;
import businessLayer.MenuItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ButtonListenerImport implements ActionListener  {
    public List<MenuItem> products;
    private JTextArea ta;
    public List<MenuItem> products2 = new ArrayList<MenuItem>();
    public static boolean solveDone = false;
    DeliveryService ds = GUI.ds;

    public ButtonListenerImport(JTextArea ta,ArrayList<MenuItem> products  )
    {
        this.ta = ta;
        this.products = products;
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("products.csv"));

            String currentLine;

            while((currentLine = br.readLine() )!= null)
            {
                String[] detalied = currentLine.split(",");
                if(detalied[0] == "Title")
                    continue;
                else {
                    String title = detalied[0];
                    float rating = Float.parseFloat(detalied[1]);
                    int calories = Integer.parseInt(detalied[2]);
                    int protein = Integer.parseInt(detalied[3]);
                    int fat = Integer.parseInt(detalied[4]);
                    int sodium = Integer.parseInt(detalied[5]);
                    float price = Float.parseFloat(detalied[6]);

                    BaseProduct product = new BaseProduct(title, rating, calories, protein, fat, sodium, price);
                    int ok = 1;
                    for (MenuItem m : products) {
                        if (m.getTitle().equals(title)) {
                            ok = 0;
                        }
                    }
                    if (ok == 1) {
                        products.add(product);
                        ta.append(product.toString()+" ");
                        ta.append("\n");
                    }
                }
            }


        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        */
        /*
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
           products.stream().filter(distinctByKey(MenuItem::getTitle)).forEach(product -> { ta.append(product.toString() + "\n");});

           for(MenuItem p: products)
           {
               products2.add(p);
               //System.out.println(p.toString());
           }
           solveDone = true;

        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }

         */

        products = ds.importProducts();
        products.stream().filter(distinctByKey(MenuItem::getTitle)).forEach(product -> { ta.append(product.toString() + "\n");});

    }



    public ArrayList<MenuItem> getProducts() {
        ArrayList<MenuItem> copy = new ArrayList<>(products2);
        return copy;
    }

    public void setProducts(ArrayList<MenuItem> products) {
        this.products = products;
    }
}
