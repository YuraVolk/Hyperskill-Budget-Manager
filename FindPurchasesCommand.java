package budget;

public class FindPurchasesCommand extends Command {
    FindPurchasesCommand(BudgetManager manager) {
        super(manager);
    }

    @Override
    void execute() {
        int type;

        while (true) {
            if (manager.history.history.size() == 0) {
                System.out.print("Purchase list is empty!");
                break;
            }

            System.out.println("Choose the type of purchases\n" +
                    "1) Food\n" +
                    "2) Clothes\n" +
                    "3) Entertainment\n" +
                    "4) Other\n" +
                    "5) All\n" +
                    "6) Back");
            type = manager.scanner.nextInt();
            if (type == 6) {
                break;
            }

            manager.history.printByType(type);
        }
    }
}
