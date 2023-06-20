import java.util.ArrayList;

public class Order {
    private String name;
    private ArrayList<Double> customerOrders;
    private double balance;
    private double[] menuPrices;

    public Order(String name, ArrayList<Double> customerOrders, double balance){
        this.name = name;
        this.customerOrders = customerOrders; //dont initialize already populated
        this.balance = balance;
    }

    public double totalPrice(){
        double totalPrice = 0;
        for(int i = 0; i<customerOrders.size(); i++ ){
            totalPrice += customerOrders.get(i);
        }
        return totalPrice;
    }

    public boolean validOrder(){
    if(balance - totalPrice() < 0 ) return false;
    else return true;
    }

    public double remainingBalance(){
        return balance-totalPrice();
    }

}
