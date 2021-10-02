package BankAccount;

public class BankAccount {
    private static int accountNextId = 1;
    private static double interestRate = 0.02;

    private int id;
    private double balance;

    public BankAccount(){
        this.id = accountNextId;
        accountNextId++;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterestRate(int years) {
        return interestRate * years * this.balance;
    }

    public void deposit(int amount){
        this.balance += amount;
    }

    public int getId() {
        return this.id;
    }
}
