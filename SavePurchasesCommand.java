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
                toSave = String.format("income~%s", income);
                writer.println(toSave);
            }

            for (Purchase purchase : manager.history.history) {
                toSave = String.format("expense~%s~%s~%s",
                            purchase.getInternalType(), purchase.name, purchase.cost);
                writer.println(toSave);
            }
            writer.close();
            System.out.println("Purchases were saved!");
        } catch (IOException e) {
            System.out.println("Failed to save file.");
        }

    }
}
