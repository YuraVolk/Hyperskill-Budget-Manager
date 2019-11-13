package budget;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BudgetManager {
    Scanner scanner = new Scanner(System.in);
    Map<String, Double> expenses = new LinkedHashMap();
    double expensesTotal;

    private void printMap() {
        expenses.forEach((name, sum) ->
                System.out.printf("%s $%.2f\n", name, sum)
        );
    }

    void start() {
        new InputPurchasesCommand(this).execute();
        printMap();
        System.out.println();
        System.out.printf("Total: $%.2f", expensesTotal);
    }
}
