package budget;

import java.util.*;

public class BudgetManager {
    Scanner scanner = new Scanner(System.in);
    List<Entry> entries = new ArrayList<>();
    double balance;
    double totalExpenses;

    private void printPurchases() {
        int found = 0;

        for (Entry entry : entries) {
            if (entry.getType() == "expense") {
                entry.printEntry();
                found++;
            }
        }

        if (found == 0) {
            System.out.println("Purchase list is empty");
        } else {
            System.out.printf("Total sum: $%s\n",
                    totalExpenses);
        }

    }

    void start() {
        Command command;
        int choice;

        main:
        while (true) {
            System.out.println("Choose your action:\n" +
                    "1) Add income\n" +
                    "2) Add purchase\n" +
                    "3) Show list of purchases\n" +
                    "4) Balance\n" +
                    "0) Exit");
            choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    command = new AddPurchaseCommand(this)
                            .setType("income");
                    command.execute();
                    break;
                case 2:
                    command = new AddPurchaseCommand(this)
                            .setType("expense");
                    command.execute();
                    break;
                case 3:
                    command = new CalculateBalanceCommand(this);
                    command.execute();
                    printPurchases();
                    break;
                case 4:
                    command = new CalculateBalanceCommand(this);
                    command.execute();
                    System.out.printf("\nBalance: $%.2f\n", balance);
                    break;
                case 0:
                    System.out.println();
                    break main;
            }

            System.out.println();
        }

        System.out.print("Bye!");
    }
}
