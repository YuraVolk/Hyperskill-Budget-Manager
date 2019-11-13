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

        if (type == 5) {
            System.out.println("All: ");
        } else {
            System.out.printf("%s: ", typeStr);
        }
        for (Purchase purchase : history) {
            if (type == 5) {
                purchase.print();
                total += purchase.cost;
            } else {
                if (purchase.type.equals(typeStr)) {
                    purchase.print();
                    total += purchase.cost;
                }
            }
        }

        System.out.printf("Total sum: $%.2f", total);
    }
}
