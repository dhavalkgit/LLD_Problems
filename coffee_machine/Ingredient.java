package coffee_machine;

public class Ingredient {
    private int quantity;
    private final String name;

    public Ingredient(int quantity, String name) {
        this.quantity = quantity;
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public void addQuantity(int quantity){
        this.quantity += quantity;
    }

    public void consumeQuantity(int quantity){
        this.quantity-=quantity;
    }
}
