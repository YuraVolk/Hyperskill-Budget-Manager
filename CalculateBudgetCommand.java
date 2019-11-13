package budget;

public class CalculateBudgetCommand extends Command {
    CalculateBudgetCommand(BudgetManager manager) {
        super(manager);
    }

    @Override
    void execute() {
        double balance = manager.incomes.stream()
                .mapToDouble(Double::doubleValue).sum();
        for (Purchase purchase : manager.history.history) {
            balance -= purchase.cost;
        }

        if (balance < 0.00) {
            balance = 0.00;
        }

        System.out.printf("Balance: $%.2f\n\n", balance);
    }
}
