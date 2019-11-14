package budget;

import java.io.IOException;
import java.io.PrintWriter;

public class SavePurchasesCommand extends Command {
    SavePurchasesCommand(BudgetManager manager) {
        super(manager);
    }

    @Override
    void execute() {
        try {
            PrintWriter writer = new PrintWriter("purchases.txt");

            String toSave;
            for (Double income : manager.incomes) {
                toSave = String.format("income_%s", income);
                System.out.println(toSave);
                writer.println(toSave);
            }

            for (Purchase purchase : manager.history.history) {
                toSave = String.format("expense_%s_%s_%s",
                            purchase.type, purchase.name, purchase.cost);
                System.out.println(toSave);
                writer.println(toSave);
            }
            writer.close();
            System.out.println("Purchases were saved!");
        } catch (IOException e) {
            System.out.println("Failed to save file.");
        }

    }
}
