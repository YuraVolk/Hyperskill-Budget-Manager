package budget;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

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
        double[] types = new double[4];
        Arrays.fill(types, 0.00);

        int type;
        for (Purchase purchase : manager.history.history) {
            type = purchase.getInternalType();
            types[type - 1] += purchase.cost;
            total += purchase.cost;
        }

        TreeMap<String, Double> typesMap = new TreeMap<>(
                Collections.reverseOrder()){{
            put("Food", types[0]);
            put("Entertainment", types[1]);
            put("Clothes", types[2]);
            put("Other", types[3]);
        }};

        typesMap.entrySet().forEach(entry -> {
            System.out.printf("%s - $%.2f\n", entry.getKey(),
                    entry.getValue());
        });

        System.out.printf("Total sum: $%.2f\n\n", total);
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
                case 2:
                    sortTypes();
                    break;
                case 4:
                default:
                    break analyzer;
            }
        }
    }
}
