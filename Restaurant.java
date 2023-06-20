import java.util.Scanner;
import java.util.ArrayList;

public class Restaurant{
    public static void main(String[] args){

        ArrayList<Double> customerOrders = new ArrayList<Double>();
        double[] menuPrices = { 9.5, 6, 2.5 };
        
        //scan stuff to put into order ctor. creates order obj
        System.out.println("Hi, enter your name: ");
        Scanner n = new Scanner(System.in);
        String name = n.next();

        System.out.println("What would you like to order?"
         +" enter the number 1. Burger $9.5 2. Milkshake $6 3. Fries $3 4. done ordering");
        Scanner in = new Scanner(System.in);
        Scanner del = new Scanner(System.in);
        Scanner c = new Scanner(System.in);
        int input = in.nextInt(); //item number they want
       if(input == 4){
        System.out.println("done ordering"); return;
       } 
       else if( input >= 1 && input <= 3){
        customerOrders.add( menuPrices[input-1] ); //add the price of item to order
        System.out.println("Item "+input+" ordered");
       }
    //keep ordering if so
       while(input != 4){
        System.out.println("What would you like to order? enter the number 1. Burger $9 2. Milkshake $6 3. Fries $3 4. done ordering 5. print & change order");
        input = in.nextInt();
        if(input==4) System.out.println("done ordering");
        else if( input >= 1 && input <= 3 ){
        customerOrders.add( menuPrices[input-1] );
        System.out.println("Item "+input+" ordered");
       }
       else if( input==5 ){ //repeats until customer is done ordering.
        int itemNum = 1;
        for(int i=0; i < customerOrders.size(); i++){
            System.out.println("ordered item #" + itemNum + "  $"+customerOrders.get(i));
            itemNum++;
        }
            System.out.println("enter 0. delete an item. enter 4. done ordering.");
            int delete = del.nextInt();
            if(delete==4) break;
            System.out.println("Enter item number to delete: ");
            int choice = c.nextInt();
            customerOrders.remove(choice-1); //
            System.out.println("Item "+choice+" deleted");
        }
    }//end while inpht!=4
             
       Scanner in2 = new Scanner(System.in);
       System.out.println("Enter your wallet balance");
       double balance = in2.nextDouble(); //change range later
       System.out.println("Wallet balance = $"+balance);

       Order o1 = new Order(name, customerOrders, balance);
       
       if( o1.validOrder() ) System.out.println("Order success for "+name+". Your remaining balance is $" + o1.remainingBalance() );
       else System.out.println("Order failed, not enough $ ");

}//end main
        
}
