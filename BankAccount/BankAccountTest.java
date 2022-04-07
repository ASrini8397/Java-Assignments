public class BankAccountTest{
    public static void main (String [] args){

 BankAccount bank= new BankAccount();
 bank.depositToChecking(1000.00);
 bank.depositToSaving(2000.00);
 bank.getCheckingBalance();
 bank.getSavingsBalance();
 bank.withdrawFromChecking(500000.0);


BankAccount bank2= new BankAccount();
bank2.depositToChecking(134234.07);
 bank2.depositToSaving(4365646.65);
 bank2.getCheckingBalance();
 bank2.getSavingsBalance();
 bank2.withdrawFromChecking(5.6);

 bank2.totalAccounts();
 bank2.totalMoney();
    }
}