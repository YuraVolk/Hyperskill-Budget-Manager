package budget;

public class Entry {
    private double transactionCost;
    private String source;
    private String type; // "expense" or "income"

    void printEntry() {
        System.out.printf("%s $%.2f\n", source, transactionCost);
    }

    Entry(double transactionCost) {
        this.type = "income";
        this.transactionCost = transactionCost;
    }

    Entry(double transactionCost, String source) {
        this.type = "expense";
        this.transactionCost = transactionCost;
        this.source = source;
    }

    double getTransactionCost() {
        return type.equals("expense") ? transactionCost * -1.00 : transactionCost;
    }

    String getType() {
        return type;
    }
}
