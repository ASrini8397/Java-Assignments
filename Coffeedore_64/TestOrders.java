import java.util.ArrayList;
public class TestOrders{

    public static void main (String [] args){

        // Menu items

  
   
    //   Item item1 = new Item("mocha", 4.0);
  

    // Item item2 = new Item("latte", 3.50);
   

    // Item item3 = new Item("drip coffee", 2.75);
   

    // Item item4 = new Item("cappuccino", 4.50);
    
    CoffeeKiosk coffeeKios= new CoffeeKiosk();
    coffeeKios.addMenuItem("mocha", 4.0);
    coffeeKios.addMenuItem("latte", 3.50);
    coffeeKios.addMenuItem("drip coffee", 2.75);
    coffeeKios.addMenuItem("cappuccino", 4.50);
     coffeeKios.displayMenu();
     coffeeKios.newOrder();
   
   
       // Order variables -- order1, order2 etc.
    // Order order1= new Order();
    // order1.setItems(item2);
    // order1.setItems(item3); 
    // order1.display();
    

    // Order order2 = new Order("Jimmy");
    // Order order3 = new Order("Noah");
    // Order order4 = new Order("Sam");

    // order1.addItem(item1);
    // order2.addItem(item1);
    // order2.addItem(item2);

    // order3.addItem(item1);
    // order3.addItem(item3);

    // order4.addItem(item1);
    // order4.addItem(item4);

    // order1.setReady(true);
    // order2.setReady(true);

    // System.out.println(order1.getStatusMessage());
    // System.out.println(order2.getStatusMessage());
    // System.out.println(order3.getStatusMessage());
    // System.out.println(order4.getStatusMessage());


    // System.out.println(order1.getOrderTotal());
    // System.out.println(order2.getOrderTotal());
    // System.out.println(order3.getOrderTotal());
    // System.out.println(order4.getOrderTotal());

    // order1.display();
    // order2.display();
    // order3.display();
    // order4.display();
    
    
    
       
        
   

    }
}