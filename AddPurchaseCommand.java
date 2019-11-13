package budget;

public class AddPurchaseCommand extends Command {
    AddPurchaseCommand(BudgetManager manager) {
        super(manager);
    }

    @Override
    void execute() {
        int type;
        String name;
        double cost;

        while (true) {
            System.out.println("Choose the type of purchase\n" +
                    "1) Food\n" +
                    "2) Clothes\n" +
                    "3) Entertainment\n" +
                    "4) Other\n" +
                    "5) Back");
            type = manager.scanner.nextInt();
            if (type == 5) {
                break;
            }
            System.out.println("Enter purchase name:");
            manager.scanner.nextLine();
            name = manager.scanner.nextLine();
            System.out.println("Enter its price:");
            cost = manager.scanner.nextDouble();

            manager.history.add(type, name, cost);
            System.out.println("Purchase was added!\n");
        }
    }
}
