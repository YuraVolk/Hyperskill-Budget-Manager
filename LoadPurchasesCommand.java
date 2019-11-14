package budget;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LoadPurchasesCommand extends Command {
    LoadPurchasesCommand(BudgetManager manager) {
        super(manager);
    }

    @Override
    void execute() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("purchases.txt"));

            String[] entryInfo;
            for (String entry : lines) {
                entryInfo = entry.split("~");
                if (entryInfo[0].equals("income")) {
                    manager.incomes.add(Double.parseDouble(entryInfo[1]));
                } else {
                    manager.history.add(Integer.parseInt(entryInfo[1]),
                            entryInfo[2], Double.parseDouble(entryInfo[3]));
                }
            }

            System.out.println("Purchases were loaded!");
        } catch (IOException e) {
            System.out.println("No purchases found.");
        }
    }
}
