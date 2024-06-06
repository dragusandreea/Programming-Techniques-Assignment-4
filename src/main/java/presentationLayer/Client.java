package presentationLayer;

public class Client extends User{
    private static int index;
    private int idClient;
    private int orderingTimes;
    public Client(String username, String password) {
        super(username, password);
        index++;
        this.idClient = index;
        this.setRole("CLIENT");
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getOrderingTimes() {
        return orderingTimes;
    }

    public void setOrderingTimes(int orderingTimes) {
        this.orderingTimes = orderingTimes;
    }
}
