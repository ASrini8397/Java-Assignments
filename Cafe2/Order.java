import java.util.ArrayList;

class Order{
    private String name;
    // private double total;
    private boolean ready;
    private ArrayList<Item> items= new ArrayList<Item>();

    public Order(){
        this("Guest" );
    }

    public Order(String name){
        this.name=name;
        this.ready=false;
    }

    //Getters

    public String getName(){
        return this.name;
    }

    public boolean isOrderReady(){
        return this.ready;
    }

    public ArrayList<Item> getItems(){
        return this.items;
    }

    //Setters
    public void setReady(boolean isReady){
        this.ready=isReady;
    } 

    public void setItems(Item purchases){
        this.items.add(purchases);
        
    }

    public void setName(String guestName){
        this.name=guestName;
    }

    
    //Order Class Methods

    public void addItem(Item newitem){
        items.add(newitem);
        
    }

    public String getStatusMessage(){
        if (this.ready== true){
            return " Your order is ready!";
        }
        else{
            return "Thank your for waiting, your order will be ready shortly";
        }
    }

    public double getOrderTotal(){
        double ototal=0;

    for(Item x: this.items) {
      ototal = ototal+ x.getPrice();
    }
    return ototal;
    }

    public void display(){
        System.out.format("Customer Name: %s", this.name+ "\n");
        
    for(Item x: this.items) {
      System.out.println( x.getName() + ": " + x.getPrice());
    }
    System.out.println("Total" + this.getOrderTotal());
  }
    

}