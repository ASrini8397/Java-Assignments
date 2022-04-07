public class BankAccount{
    private double checkingBalance;
    private double savingBalance;
    private static int numberOfAccounts=0;
    private static int moneyInAccounts=0;

    public BankAccount(){
        numberOfAccounts++;

    }
    //Methods
    public void depositToChecking(double checkingDeposit){
        this.checkingBalance += checkingDeposit;
        moneyInAccounts+= checkingDeposit;
        System.out.println("Amount Deposited:" + checkingDeposit);
    }

     public void depositToSaving(double savingsDeposit){
         this.savingBalance+= savingsDeposit;
        moneyInAccounts+= savingsDeposit;
        System.out.println("Amount Deposited:" + savingsDeposit);
    }
    public void withdrawFromSavings(double withdrawal){
        if(withdrawal> this.savingBalance){
            System.out.println("Insufficient Funds!");
        }
        else{
        this.savingBalance-= withdrawal;
        moneyInAccounts-=withdrawal;
        }

    }
    public void withdrawFromChecking(double withdrawal){
         if(withdrawal> this.checkingBalance){
            System.out.println("Insufficient Funds!");
        }
        else{
        this.checkingBalance-= withdrawal;
        moneyInAccounts-=withdrawal;
        }

    }

   public double totalMoney(){
       System.out.println("Total Money:" + moneyInAccounts);
       return moneyInAccounts;
   }

   public double totalAccounts(){
       System.out.println("Total accounts:"+ numberOfAccounts);
       return numberOfAccounts;
   }

    //Getters & Setters

    public double getCheckingBalance(){
        System.out.println("Balance:" + this.checkingBalance);
        return this.checkingBalance;
    }
     public void setCheckingBalance(double money){
        this.checkingBalance=money;
    }


      public double getSavingsBalance(){
           System.out.println("Balance:" + this.savingBalance);
        return this.savingBalance;
    }
       public void setSavingsBalance(double money){
        this.savingBalance=money;

    }

}