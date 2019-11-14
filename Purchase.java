package budget;

public class Purchase {
    double cost;
    String name;
    String type;

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
        this.cost = cost;
        this.name = name;
    }

    void print() {
        System.out.printf("%s: $%.2f\n", name, cost);
    }
}
