package businessLayer;

public class BaseProduct extends MenuItem{
    public BaseProduct(String title, float rating, int calories, int protein, int fat, int sodium, float price) {
        super(title, rating, calories, protein, fat, sodium, price);
    }

    @Override
    public float computePrice() {
       return this.getPrice();
    }


}
