package budget;

import java.util.*;
import java.util.stream.Collectors;

public class AnalyzeCommand extends Command {
    private PurchaseComparator comparator = new PurchaseComparator();
    AnalyzeCommand(BudgetManager manager) {
        super(manager);
    }

    private void sortAll() {
        if (manager.history.history.size() == 0) {
            System.out.println("\nPurchase list is empty!\n");
            return;
        }

        List<Purchase> list = manager.history.history;
        list.sort(comparator);
        double total = 0.00;

        System.out.println("\nAll:");
        for (Purchase purchase : list) {
            total += purchase.cost;
            purchase.print();
        }
        System.out.printf("Total sum: $%.2f\n\n", total);
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


        System.out.println("\nTypes:");
        Map<String, Double> typesMap = new LinkedHashMap<>(){{
            put("Food", types[0]);
            put("Entertainment", types[2]);
            put("Clothes", types[1]);
            put("Other", types[3]);
        }};

        Map<String, Double> result = typesMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        result.forEach((key, value) ->
            System.out.printf("%s - $%.2f\n", key,
                    value)
        );

        System.out.printf("Total sum: $%.2f\n\n", total);
    }

    private void sortByType() {
        System.out.println("\nChoose the type of purchase\n" +
                "1) Food\n" +
                "2) Clothes\n" +
                "3) Entertainment\n" +
                "4) Other\n");

        int choice = manager.scanner.nextInt();
        System.out.println();
        if (choice > 4 || choice < 1) {
            return;
        }

        if (manager.history.history.size() == 0) {
            System.out.println("Purchase list is empty!\n");
            return;
        }

        List<Purchase> purchases = new ArrayList<>();
        double total = 0.00;
        String type = "";

        for (Purchase purchase : manager.history.history) {
            if (purchase.getInternalType() == choice) {
                purchases.add(purchase);
                total += purchase.cost;
                type = purchase.type;
            }
        }
        purchases.sort(comparator);

        if (type == null) {
            System.out.println("Purchase list is empty!\n\n");
        } else {
            System.out.printf("\n%s: \n", type);
            for (Purchase purchase : purchases) {
                purchase.print();
            }
            System.out.printf("Total sum: $%.2f\n\n", total);
        }
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
                case 3:
                    sortByType();
                    break;
                case 4:
                default:
                    break analyzer;
            }
        }
    }
}
