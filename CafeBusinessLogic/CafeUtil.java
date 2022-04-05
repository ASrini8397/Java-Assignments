import java.util.ArrayList;

public class CafeUtil{
    public int StreakGoal(int numWeeks){
        int[] drinksArray = new int[numWeeks];
        int sum=0;
        for(int i=0; i< drinksArray.length; i++){
            drinksArray[i]=i;
            sum = sum + i;
            System.out.println(sum);
        }
        return sum;
    }

    public double getOrderTotal (double[] prices){
        double total=0.0;
        for( int a=0; a< prices.length; a++){
            total+=prices[a];
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menuItems){
        for (int i=0; i<menuItems.size(); i++){
            String item = menuItems.get(i);
            System.out.println(i+": " + item);
        }
        
    }
    public void addCustomer(ArrayList<String> customers){
        int totalCustomers=customers.size();
        System.out.println("Please enter your name: ");
        String userName = System.console().readLine();
        String Response= String.format("Hello " +userName+ ", there are " + totalCustomers+ " people in front of you");
        System.out.println(Response);
        customers.add(userName);
        System.out.println(customers);
    }

    
}
