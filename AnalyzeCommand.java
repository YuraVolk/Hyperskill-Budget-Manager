package budget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnalyzeCommand extends Command {
    private PurchaseComparator comparator = new PurchaseComparator();
    AnalyzeCommand(BudgetManager manager) {
        super(manager);
    }

    private void sortAll() {
        List<Purchase> list = manager.history.history;
        Collections.sort(list, comparator);
        System.out.println("\nAll:");
        for (Purchase purchase : list) {
            purchase.print();
        }
    }

    private void sortTypes() {
        double total = 0.00;
        List<Double> types = new ArrayList<>() {{
            for (int i = 0; i < 4; i++) {
                add(0.00);
            }
        }};

        
    }

    @Override
    void execute() {
        System.out.println();
        int choice;

        analyzer:
        while (true) {
            System.out.println("How do you want to sort?\n" +
                    "1) Sort all purchases\n" +
                    "2) Sort by type\n" +
                    "3) Sort certain type\n" +
                    "4) Back");
            choice = manager.scanner.nextInt();
            switch (choice) {
                case 1:
                    sortAll();
                    break;
                case 4:
                default:
                    break analyzer;
            }
        }
    }
}
