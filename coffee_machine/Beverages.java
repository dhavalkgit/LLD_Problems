package coffee_machine;

import java.util.HashMap;
import java.util.Map;

public class Beverages {
    private Map<String,Integer> ingredients;
    private Beverages(Builder builder){
        ingredients = new HashMap<>(builder.ingredients);
    }

    public void prepare(StockManager stockManager){
        boolean flag = true;
        for(Map.Entry<String,Integer> entry: ingredients.entrySet()){
             flag &= stockManager.hasStock(entry.getValue(), entry.getKey());
        }

        if(flag){
            for(Map.Entry<String,Integer> entry: ingredients.entrySet()){
                stockManager.consumeStock(entry.getKey(), entry.getValue());
            }
            System.out.println("your beverage is ready please take it!");
        }
        else{
            System.out.println("Sorry, for this beverage ingredient is out of stock");
        }
    }

    static final class Builder{
        private final Map<String,Integer> ingredients=new HashMap<>();
        public Builder(){}

        public Builder hotWater(int quantity){
            ingredients.put("hotWater",quantity);
            return this;
        }
        public Builder hotMilk(int quantity){
            ingredients.put("hotMilk",quantity);
            return this;
        }
        public Builder coffeeDecoration(int quantity){
            ingredients.put("coffeeDecoration",quantity);
            return this;
        }

        public Builder sugarSyrup(int quantity){
            ingredients.put("sugarSyrup",quantity);
            return this;
        }

        public Builder teaLeavesSyrup(int quantity){
            ingredients.put("teaLeavesSyrup",quantity);
            return this;
        }
        public Builder greenTeaSyrup(int quantity){
            ingredients.put("greenTeaSyrup",quantity);
            return this;
        }

        public Beverages build(){
            return new Beverages(this);
        }
    }
}
