package vending_machine;

public class Item {
    private final String name;
    private int quantity;
    private int price;

    public Item(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public void changePrice(int price){
        if(price>0)
            this.price=price;
    }

    public void addQuantity(int quantity){
        this.quantity+=quantity;
    }

    public void consumeItem(int quantity){
        this.quantity-=quantity;
    }
}
