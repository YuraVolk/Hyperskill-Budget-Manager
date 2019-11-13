package budget;

public class CalculateBalanceCommand extends Command {
    CalculateBalanceCommand(BudgetManager manager) {
        super(manager);
    }

    @Override
    void execute() {
        double balance = 0.00;
        double expenses = 0.00;

        for (Entry entry : manager.entries) {
            balance += entry.getTransactionCost();
            if (entry.getType().equals("expense")) {
                expenses += Math.abs(entry.getTransactionCost());
            }
        }

        if (balance < 0.00) {
            balance = 0.00;
        }


        manager.balance = balance;
        manager.totalExpenses = expenses;
    }
}
