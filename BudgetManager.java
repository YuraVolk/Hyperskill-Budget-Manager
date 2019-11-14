package budget;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BudgetManager {
    Scanner scanner = new Scanner(System.in);
    List<Double> incomes = new ArrayList<>();
    PurchaseHistory history = new PurchaseHistory();

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
                    "5) Save\n" +
                    "6) Load\n" +
                    "0) Exit");
            choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    command = new AddIncomeCommand(this);
                    command.execute();
                    break;
                case 2:
                    command = new AddPurchaseCommand(this);
                    command.execute();
                    break;
                case 3:
                    command = new FindPurchasesCommand(this);
                    command.execute();
                    break;
                case 4:
                    command = new CalculateBudgetCommand(this);
                    command.execute();
                    break;
                case 5:
                    command = new SavePurchasesCommand(this);
                    command.execute();
                    break;
                case 6:
                    command = new LoadPurchasesCommand(this);
                    command.execute();
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
