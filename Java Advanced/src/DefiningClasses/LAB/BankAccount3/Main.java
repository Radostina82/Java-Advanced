package DefiningClasses.LAB.BankAccount3;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        HashMap<Integer, BankAccount> list = new HashMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String output = null;

            if (command.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                list.put(bankAccount.getId(), bankAccount);
                output = String.format("Account ID%d created", bankAccount.getId());

            } else if (command.equals("Deposit")) {
                int id = Integer.parseInt(tokens[1]);
                int amount = Integer.parseInt(tokens[2]);
                if(list.containsKey(id)) {
                    list.get(id).deposit(amount);
                    output = String.format("Deposited %d to ID%d", amount, id);
                }else {
                    output = "Account does not exist";
                }
            } else if (command.equals("SetInterest")) {
                BankAccount.setInterestRate(Double.parseDouble(tokens[1]));

            } else if (command.equals("GetInterest")) {
                int id = Integer.parseInt(tokens[1]);
                int year = Integer.parseInt(tokens[2]);
                if (list.containsKey(id)) {
                    double interest = list.get(id).getInterestYears(year);
                    output = String.format("%.2f", interest);
                }else {
                    output = "Account does not exist";
                }
            }
            if (output != null) {
                System.out.println(output);
            }

            input = scanner.nextLine();
        }
    }
}
