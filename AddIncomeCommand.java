package budget;

public class AddIncomeCommand extends Command {
    AddIncomeCommand(BudgetManager manager) {
        super(manager);
    }

    @Override
    void execute() {
        System.out.println("Enter income: ");
        double income = manager.scanner.nextDouble();
        manager.incomes.add(income);
        System.out.println("Income was added!");
    }
}
