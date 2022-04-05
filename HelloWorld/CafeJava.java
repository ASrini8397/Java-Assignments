public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffeePrice= 6.5;
        double lattePrice = 4.5;
        double cappuccinoPrice =2.75; 
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = false;
        boolean isReadyOrder5 = false;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        if (isReadyOrder1== true){
            System.out.println(customer1+ readyMessage);
        }
        else{
            System.out.println(customer1 + pendingMessage);
        }

        System.out.println(generalGreeting + customer4);
        System.out.println(displayTotalMessage+ cappuccinoPrice);
        if(isReadyOrder4==true){
        System.out.println(customer4+ readyMessage);
        }
        else{
            System.out.println(customer4 + pendingMessage);
        }

        System.out.println(generalGreeting+ customer2);
        System.out.println(displayTotalMessage+ lattePrice*2 );
        if (isReadyOrder2== true){
            System.out.println(customer2+ readyMessage);

        }
        else{
            System.out.println(customer2 + pendingMessage);
        }

        System.out.println(customer3 + displayTotalMessage + (dripCoffeePrice-lattePrice));
        cappuccinoPrice=7.5;
        System.out.println("Due to inflation your cappuccino now costs "+ cappuccinoPrice); 

    }
}