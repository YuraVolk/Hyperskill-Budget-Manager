package budget;

import java.util.ArrayList;
import java.util.List;

public class PurchaseHistory {
    List<Purchase> history = new ArrayList<>();

    void add(int type, String name, double cost) {
        history.add(new Purchase(cost, name, type));
    }

    private String getType(int type) {
        switch (type) {
            case 1:
                return "Food";
            case 2:
                return "Clothes";
            case 3:
                return "Entertainment";
            default:
            case 4:
                return "Other";
        }
    }

    void printByType(int type) {
        double total = 0.00;
        final String typeStr = getType(type);
        int found = 0;

        if (type == 5) {
            System.out.println("All: \n");
        } else {
            System.out.printf("%s: \n", typeStr);
        }
        for (Purchase purchase : history) {
            if (type == 5) {
                purchase.print();
                total += purchase.cost;
                found++;
            } else {
                if (purchase.type.equals(typeStr)) {
                    purchase.print();
                    total += purchase.cost;
                    found++;
                }
            }
        }

        if (found == 0) {
            System.out.println("Purchase list is empty!\n");
        } else {
            System.out.printf("Total sum: $%.2f\n\n", total);
        }
    }
}
