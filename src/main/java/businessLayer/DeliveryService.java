package businessLayer;

import org.jetbrains.annotations.NotNull;
import presentationLayer.ButtonListenerAddBaseProduct;
import presentationLayer.ButtonListenerDeleteProduct;
import presentationLayer.GUI;

import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static presentationLayer.ButtonListenerImport.distinctByKey;

@SuppressWarnings("deprecation")
public class DeliveryService extends Observable implements IDeliveryServiceProcessing{
    List<MenuItem> products = GUI.getProducts();
    private Map<Order,ArrayList<MenuItem>> orderData = new HashMap<>();
    private DeliveryService ds;

    @Override
    public List<MenuItem> importProducts() {
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
            return products;
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return null;

    }

    /**
     * @pre title != "" && rating != "" && calories != "" && protein != "" && fat != "" && sodium != "" && price !=""
     *
     */
    @Override
    public void addBaseProduct(JTextArea ta, JTextField title, JTextField rating, JTextField calories, JTextField protein, JTextField fat, JTextField sodium, JTextField price,ArrayList<MenuItem>products) {
        String titleVal = title.getText();
        float ratingVal = Float.parseFloat(rating.getText());
        int caloriesVal = Integer.parseInt(calories.getText());
        int proteinVal = Integer.parseInt(protein.getText());
        int fatVal = Integer.parseInt(fat.getText());
        int sodiumVal = Integer.parseInt(sodium.getText());
        float priceVal = Float.parseFloat(price.getText());

        assert titleVal != "" && ratingVal >=0 && caloriesVal >=0 && proteinVal >= 0 && fatVal >= 0 && sodiumVal >= 0 && priceVal >= 0;

        BaseProduct addProduct = new BaseProduct(titleVal,ratingVal,caloriesVal,proteinVal,fatVal,sodiumVal,priceVal);
        int sizeInitial = products.size();

        int ok = 1;
        for(MenuItem item: products)
        {
            if(item.getTitle().equals(addProduct.getTitle()))
            {
                ok = 0;
            }
        }
        if(ok == 1)
        {
            products.add(addProduct);

            ta.append("\nAm adaugat produsul:\n");
            ta.append(addProduct.toString());
            int sizeFinal = products.size();
            assert sizeFinal == sizeInitial + 1 && addProduct != null;
        }
        else
        {
            ta.append("\nAcest produs exista deja in meniu!");
        }


    }
    /**
     * @pre title != "" && products!= null
     *
     */
    @Override
    public void deleteProduct(JTextArea ta, JTextField title, ArrayList<MenuItem> products) {
        assert !title.equals("") && products.size() > 0;

        int sizeInitial = products.size();

        int index = 0;
        if(!(title.getText().equals("")))
        {
            for(MenuItem item: products)
            {
                if(item.getTitle().equals(title.getText()))
                {
                    ta.append("\nAm sters produsul:\n");
                    ta.append(item.toString());
                    index = products.indexOf(item);
                }
            }
            products.remove(index);
            int sizeFinal = products.size();
            assert sizeFinal == sizeInitial - 1;

            // ds.deleteProduct(title.getText());
        }
        else
        {
            ta.setText("Campul title nu a fost completat!");
        }



    }
    /**
     * @pre title != "" && products!= null
     *
     */
    @Override
    public void modifyProduct(JTextArea ta, JTextField title, JTextField rating, JTextField calories, JTextField protein, JTextField fat, JTextField sodium, JTextField price, ArrayList<MenuItem> products) {
        String titleVal = title.getText();

        assert !title.equals("") && products.size() > 0;
        int sizeInitial = products.size();

        float ratingVal = -1;
        int caloriesVal = 0;
        int proteinVal = 0;
        int fatVal = 0;
        int sodiumVal = 0;
        float priceVal = 0;

        if(!title.getText().equals("")) {
            if (!(rating.getText().equals(""))) {
                ratingVal = Float.parseFloat(rating.getText());
            }
            if (!(calories.getText().equals(""))) {
                caloriesVal = Integer.parseInt(calories.getText());
            }
            if (!(protein.getText().equals(""))) {
                proteinVal = Integer.parseInt(protein.getText());
            }
            if (!(fat.getText().equals(""))) {
                fatVal = Integer.parseInt(fat.getText());
            }
            if (!(sodium.getText().equals(""))) {
                sodiumVal = Integer.parseInt(sodium.getText());
            }
            if (!(price.getText().equals(""))) {
                priceVal = Float.parseFloat(price.getText());
            }
        }
        else
        {
            ta.setText("Nu a fost completat campul title!");
        }

        int itemFound = 0;
        for(MenuItem item: products)
        {
            if(item.getTitle().equals(titleVal))
            {
                if(ratingVal != -1)
                    item.setRating(ratingVal);

                if(caloriesVal != 0)
                    item.setCalories(caloriesVal);

                if(proteinVal != 0)
                    item.setProtein(proteinVal);

                if(fatVal != 0)
                    item.setFat(fatVal);

                if(sodiumVal != 0)
                    item.setSodium(sodiumVal);

                if(priceVal != 0)
                    item.setPrice(priceVal);

                itemFound = 1;
                ta.append("\nAm modificat produsul:\n");
                ta.append(item.toString());
                int sizeFinal = products.size();
                assert sizeInitial == sizeFinal && itemFound == 1;
            }
        }

        if(!(title.getText().equals("")) && itemFound == 0)
        {
            ta.setText("Produsul "+title.getText()+" nu poate fi actualizat deoarece nu exista in meniu!");
        }


    }
    /**
     * @pre tf1 != "" && tf2 != ""
     *
     */
    @Override
    public void createComposedProduct(JTextArea ta, JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4, JTextField tf5, JTextField tf6, ArrayList<MenuItem> products, ArrayList<MenuItem> composed) {

        assert(!tf1.equals("") && !tf2.equals(""));
        int count = 0;
        int ok_found = 1;

        int found1 = 0;
        if(!(tf1.getText().equals("")))
        {   count++;
            found1 = -1;
            for(MenuItem item: products)
            {
                if(item.getTitle().equals(tf1.getText()))
                {
                    composed.add(item);
                    found1 = 1;
                    break;
                }
            }

            if(found1 == -1)
            {
                ta.setText("Produsul 1 nu se afla in meniu!");
                ok_found = 0;
            }
        }

        int found2 = 0;
        if(!(tf2.getText().equals("")))
        {   count++;
            found2 = -1;
            for(MenuItem item: products)
            {
                if(item.getTitle().equals(tf2.getText()))
                {
                    composed.add(item);
                    found2 = 1;
                    break;
                }
            }
            if(found2 == -1)
            {
                ta.setText("Produsul 2 nu se afla in meniu!");
                ok_found = 0;
            }
        }

        int found3 = 0;
        if(!(tf3.getText().equals("")))
        {   count++;
            found3 = -1;
            for(MenuItem item: products)
            {
                if(item.getTitle().equals(tf3.getText()))
                {
                    composed.add(item);
                    found3 = 1;
                    break;
                }
            }
            if(found3 == -1)
            {
                ta.setText("Produsul 3 nu se afla in meniu!");
                ok_found = 0;
            }
        }

        int found4 = 0;
        if(!(tf4.getText().equals("")))
        {   count++;
            found4 = -1;
            for(MenuItem item: products)
            {
                if(item.getTitle().equals(tf4.getText()))
                {
                    composed.add(item);
                    found4 = 1;
                    break;
                }
            }

            if(found4 == -1)
            {
                ta.setText("Produsul 4 nu se afla in meniu!");
                ok_found = 0;
            }
        }
        int found5 = 0;
        if(!(tf5.getText().equals("")))
        {   count++;
            found5 = -1;
            for(MenuItem item: products)
            {
                if(item.getTitle().equals(tf5.getText()))
                {
                    composed.add(item);
                    found5 = 1;
                    break;
                }
            }

            if(found5 == -1)
            {
                ta.setText("Produsul 5 nu se afla in meniu!");
                ok_found = 0;
            }
        }

        int ok = 1;
        if(!(tf6.getText().equals("")))
        {
            for(MenuItem item: products)
            {
                if(item.getTitle().equals(tf6.getText()))
                {
                    ta.setText("Exista deja un produs cu acest nume!");
                    break;
                }
            }


        }
        else
        {
            ta.setText("Nu a fost introdus un nume pentru produsul compus!");
            ok = 0;
        }

        if(count >= 2 && ok == 1 && ok_found == 1)
        {
            CompositeProduct compositeProduct = new CompositeProduct(composed,tf6.getText());
            products.add(compositeProduct);
            ta.append("\nA fost creat produsul compus:\n");
            ta.append(compositeProduct.toString());
            assert compositeProduct != null;
        }
        else
        {   if(count < 2)
            ta.setText("Nu au fost introduse suficiente produse");
        }
    }


    public Map<Order, ArrayList<MenuItem>> getOrderData() {
        return orderData;
    }

    public void setOrderData(Map<Order, ArrayList<MenuItem>> orderData) {
        this.orderData = orderData;
    }

    public DeliveryService getDs() {
        return ds;
    }

    public void setDs(DeliveryService ds) {
        this.ds = ds;
    }
}
