package budget;

public class Purchase {
    double cost;
    String name;
    String type;
    private int internalType;

    Purchase(double cost, String name, int type) {
        switch (type) {
            case 1:
                this.type = "Food";
                break;
            case 2:
                this.type = "Clothes";
                break;
            case 3:
                this.type = "Entertainment";
                break;
            default:
            case 4:
                this.type = "Other";
                break;
        }
        this.internalType = type;
        this.cost = cost;
        this.name = name;
    }

    void print() {
        System.out.printf("%s $%.2f\n", name, cost);
    }

    int getInternalType() {
        return internalType;
    }
}
