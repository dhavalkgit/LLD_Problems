package coffee_machine;

public class Demo {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.addStocks("hotWater",100);
        coffeeMachine.addStocks("sugarSyrup",200);
        coffeeMachine.getStocks();
        System.out.println("---------------------------------");
        coffeeMachine.makeBeverage("black_tea");
        System.out.println("---------------------------------");
        coffeeMachine.getStocks();
    }
}
