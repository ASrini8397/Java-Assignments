import java.util.ArrayList;
public class TestCafe{
    public static void main (String[] args){
        CafeUtil cafeutil= new CafeUtil();
        int test= cafeutil.StreakGoal(5);
        System.out.println(test);

        double[] prices = {5.5, 4.6, 8.5, 9.9, 2.3};
        cafeutil.getOrderTotal(prices);
        

        ArrayList<String> menu= new ArrayList<String>();
        menu.add("pizza");
        menu.add("ice-cream");
        menu.add("popcorn");
        menu.add("milkshakes");
        menu.add("pasta");
        menu.add("diabetes");
        cafeutil.displayMenu(menu);

        ArrayList<String> customers= new ArrayList<String>();
        customers.add("Bob");
        customers.add("Billy");
        customers.add("Joe");
        customers.add("Jane");
        customers.add("John");
        cafeutil.addCustomer(customers);
    }
}