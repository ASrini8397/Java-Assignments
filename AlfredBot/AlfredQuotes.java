import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        String guestResponse= String.format("Hello %s , Master Bruce was expecting you!", name);
        return guestResponse;
    }
    
    public String dateAnnouncement() {
        Date date= new Date();
        return "Excuse me Master Bruce, the time is "+ date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        String response;
        String changed= conversation.toLowerCase();
       int a= changed.indexOf("alexis");
       int b = changed.indexOf("alfred");
       if (a!= -1 && b == -1){
         return "No need to waste your time sir, I can take care of it, unlike alexis";
       }
       else if(a== -1 && b != -1){
           return "Right away sir, I'm on it!";
       }
       else {
           return "I guess I'll be of more service to the Justice League then sir!";
       }
       
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}