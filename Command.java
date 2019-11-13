package budget;

public abstract class Command {
    public BudgetManager manager;
    Command(BudgetManager manager) {
        this.manager = manager;
    }

    abstract void execute();
}
