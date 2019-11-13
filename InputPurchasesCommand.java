package budget;

import java.util.Map;

public class InputPurchasesCommand extends Command {
    InputPurchasesCommand(BudgetManager manager) {
        super(manager);
    }

    @Override
    void execute() {
        String[] expense;

        while (manager.scanner.hasNext()) {
            expense = manager.scanner.nextLine().split(" \\$");
            manager.expenses.put(expense[0], Double.parseDouble(expense[1]));
        }

        manager.expensesTotal = manager.expenses.values()
                .stream().mapToDouble(v -> v).sum();
    }
}
