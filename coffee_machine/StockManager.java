package coffee_machine;

import java.util.HashMap;
import java.util.Map;

public class StockManager {
    private Map<String,Ingredient> stocks;
    private static StockManager stockManager=null;

    private StockManager(){
        stocks=new HashMap<>();
        initializeStock();
    }

    public static StockManager getStockManager(){
        if(stockManager==null) stockManager=new StockManager();
        return stockManager;
    }
    private void initializeStock() {
        stocks.put("hotWater", new Ingredient(500, "hotWater"));
        stocks.put("hotMilk", new Ingredient(500, "hotMilk"));
        stocks.put("coffeeDecoration", new Ingredient(100, "coffeeDecoration"));
        stocks.put("sugarSyrup", new Ingredient(100, "sugarSyrup"));
        stocks.put("teaLeavesSyrup", new Ingredient(100, "teaLeavesSyrup"));
        stocks.put("greenTeaSyrup", new Ingredient(100, "greenTeaSyrup"));
    }
    public void addNewIngredient(String name, int quantity){
        if(!(stocks.containsKey(name) && quantity<=0)){
            stocks.put(name, new Ingredient(quantity, name));
        }
        else{
            System.out.println("Ingredient is already present or quantity is less then zero");
        }
    }

    public boolean refill(int quantity, String name){
        if(stocks.containsKey(name)) {
            stocks.get(name).addQuantity(quantity);
            return true;
        }
        else{
            System.out.println("Ingredient is not present");
            return false;
        }
    }
    public boolean hasStock(int requiredQuantity, String name){
        return stocks.containsKey(name) && stocks.get(name).getQuantity() >= requiredQuantity;
    }

    public void consumeStock(String name, int quantity){
        stocks.get(name).consumeQuantity(quantity);
    }

    public void getStock(){
        System.out.println("Current stock status:");
        for (Map.Entry<String, Ingredient> entry : stocks.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getQuantity());
        }
    }
}
