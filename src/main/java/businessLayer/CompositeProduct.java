package businessLayer;

import java.util.ArrayList;

public class CompositeProduct extends MenuItem{
    private ArrayList<MenuItem> composition;
    private String title;

    public CompositeProduct(ArrayList<MenuItem> composition, String title)
    {
        this.composition = composition;
        this.setPrice(computePrice());
        this.setSodium(computeSodium());
        this.setFat(computeFat());
        this.setProtein(computeProtein());
        this.setCalories(computeCalories());
        this.setRating(computeRating());
        this.setTitle(title);
    }

    public int computeSodium()
    {   int sodium = 0;
        for(MenuItem item: composition)
        {
            sodium += item.getSodium();
        }

        return sodium;
    }

    public int computeFat()
    {   int fat = 0;
        for(MenuItem item: composition)
        {
            fat += item.getFat();
        }

        return fat;
    }

    public int computeProtein()
    {
        int protein = 0;
        for(MenuItem item: composition)
        {
            protein += item.getProtein();
        }

        return protein;
    }

    public int computeCalories()
    {
        int calories = 0;
        for(MenuItem item: composition)
        {
            calories += item.getCalories();
        }

        return calories;
    }

    public float computeRating()
    {
        float rating = 0;
        for(MenuItem item: composition)
        {
            rating += item.getRating();
        }

        return rating/ composition.size();
    }

    public String computeTitle()
    {
        String title = "";

        for(MenuItem item: composition)
        {
            title += item.getTitle();
            title += " ";
        }

        return title;
    }


    @Override
    public float computePrice() {
        float price = 0;
        for(MenuItem item: composition)
        {
            price += item.computePrice();
        }
        return price;
    }



    @Override
    public String toString() {
        return super.toString();
    }
}
