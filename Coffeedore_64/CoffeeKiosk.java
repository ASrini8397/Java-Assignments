import java.util.ArrayList;
public class CoffeeKiosk{
    ArrayList<Item> menu= new ArrayList<Item>();
    ArrayList<Object> orders= new ArrayList<Object>();

    public CoffeeKiosk(){

    }

    //Methods

    public void addMenuItem(String name, Double price){
        Item menuItem= new Item(name, price);
        menu.add(menuItem);
       int count= menu.indexOf(menuItem);
       menuItem.setIndex(count);

    }

    public void displayMenu(){
        for(Item x: this.menu) {
      System.out.println(x.getIndex() + "--"+ x.getName()+ " : "+ x.getPrice());
    }
    }
    public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
    	// Your code:
    Order order= new Order(name);
        // Create a new order with the given input string
        // Show the user the menu, so they can choose items to add.
        order.display();
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            int orderNumber= Integer.parseInt(itemNumber);
             if(orderNumber>=this.menu.size()){
                System.out.println("Not available");
                 System.out.println("Please enter a menu item index or q to quit:");
                itemNumber = System.console().readLine();
                orderNumber= Integer.parseInt(itemNumber);
                 if(itemNumber.equals("q")){
                order.display();
            }
            }
            Item ord= menu.get(orderNumber);
            order.addItem(ord);
           

    System.out.println("Please enter a menu item index or q to quit:");
        itemNumber = System.console().readLine();
        
            if(itemNumber.equals("q")){
                order.display();
            }


            
            // Get the item object from the menu, and add the item to the order
            // Ask them to enter a new item index or q again, and take their input
        }
        // After you have collected their order, print the order details 
    	// as the example below. You may use the order's display method.


}




}