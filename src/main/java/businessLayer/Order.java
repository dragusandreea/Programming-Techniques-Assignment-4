package businessLayer;

import presentationLayer.Client;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@SuppressWarnings("deprecation")
public class Order  {

    private int idClient;
    private int idOrder;
    private static int index;


    private Date data;
    private Time timp;


    private float price;

    private int clientNumberOfOrders;

    int day;

    private Employee e;
    public Order(int idClient,Date data, Time timp)
    {
        this.idClient = idClient;

        index++;
        this.idOrder = index;


        this.data = data;
        this.timp = timp;


    }


    public float computeOrderPrice(ArrayList<MenuItem> orderedProducts)
    {
        for(MenuItem product: orderedProducts)
            price += product.getPrice();

        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return idClient == order.idClient && idOrder == order.idOrder && data.equals(order.data) && timp.equals(order.timp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, idOrder, data, timp, price);
    }

    @Override
    public String toString() {
        return "Order{" +
                "idClient=" + idClient +
                ", idOrder=" + idOrder +
                ", data=" + data +
                ", price=" + price +
                '}';
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getClientNumberOfOrders() {
        return clientNumberOfOrders;
    }

    public void setClientNumberOfOrders(int clientNumberOfOrders) {
        this.clientNumberOfOrders = clientNumberOfOrders;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
