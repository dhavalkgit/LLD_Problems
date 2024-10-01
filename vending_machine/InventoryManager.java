package vending_machine;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private final Map<String,Item> items = new HashMap<>();
    private static InventoryManager instance=null;

    private InventoryManager(){}

    public synchronized static InventoryManager getInstance(){
        if(instance==null){
            instance = new InventoryManager();
        }
        return instance;
    }

    public void addItem(Item item){
        if(items.containsKey(item.getName())){
            throw new RuntimeException("Item is already present in inventory");
        }
        else{
            items.put(item.getName(), item);
        }
    }
    public void removeItem(String name){
        items.remove(name);
    }

    public void refill(String name, int quantity){
        if(items.containsKey(name)){
            items.get(name).addQuantity(quantity);
        }
        else{
            throw new RuntimeException("Item is not present");
        }
    }

    public boolean isAvailable(String name, int quantity){
        if(items.containsKey(name)){
            return items.get(name).getQuantity()>=quantity;
        }
        else{
            throw new RuntimeException("Item quantity is not sufficient");
        }
    }

    public void consumeQuantity(int quantity, String name){
        items.get(name).consumeItem(quantity);
    }

    public Map<String, Item> getItems() {
        return items;
    }

    public Item getItemByName(String name){
        if(items.containsKey(name)) return items.get(name);
        else throw new RuntimeException("Item does not exist");
    }
}
