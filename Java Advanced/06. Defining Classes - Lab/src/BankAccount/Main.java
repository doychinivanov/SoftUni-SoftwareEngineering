package BankAccount;

import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashMap<Integer, BankAccount> accountsMap = new HashMap<>();
        String input = scan.nextLine();

        while(!input.equals("End")){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            String output = null;

            if(command.equals("Create")){
                BankAccount account = new BankAccount();
                accountsMap.put(account.getId(), account);

                output = String.format("Account ID%d created", account.getId());
            } else if(command.equals("Deposit")){
                int id = Integer.parseInt(tokens[1]);
                int amount = Integer.parseInt(tokens[2]);

                BankAccount account = accountsMap.get(id);

                output = executeIfNotNull(account, b -> {
                    b.deposit(amount);
                    return String.format("Deposited %d to ID%d", amount, id);
                });
            } else if(command.equals("SetInterest")){
                BankAccount.setInterestRate(Double.parseDouble(tokens[1]));
            } else {
                int id = Integer.parseInt(tokens[1]);
                int years = Integer.parseInt(tokens[2]);
                BankAccount account = accountsMap.get(id);

                output = executeIfNotNull(account , b -> {
                    double interest = account.getInterestRate(years);
                    return String.format("%.2f", interest);
                });
            }

            if(output != null){
                System.out.println(output);
            }

            input = scan.nextLine();
        }
    }

    public static String executeIfNotNull(BankAccount account, Function<BankAccount, String> function){
        if(account == null){
            return "Account does not exist";
        }

        return function.apply(account);
    }
}
