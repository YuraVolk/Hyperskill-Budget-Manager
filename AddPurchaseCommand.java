package budget;

public class AddPurchaseCommand extends Command {
    private String type;

    AddPurchaseCommand(BudgetManager manager) {
        super(manager);
    }

    @Override
    void execute() {
        final double cost;

        if (type.equals("income")) {
            System.out.println("\nEnter income: ");
            cost = manager.scanner.nextDouble();

            manager.entries.add(new Entry(cost));
            System.out.println("Income was added!");
        } else {
            System.out.println("\nEnter purchase name: ");
            manager.scanner.nextLine();
            final String name = manager.scanner.nextLine();
            System.out.println("Enter its price: ");
            cost = manager.scanner.nextDouble();

            manager.entries.add(new Entry(cost, name));
            System.out.println("Purchase was added!");
        }
    }

    Command setType(String type) {
        this.type = type;
        return this;
    }
}
