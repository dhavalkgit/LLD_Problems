package coffee_machine;

public class CoffeeMachine {
    private StockManager stockManager;
    private BaveragesFactory baveragesFactory;

    public CoffeeMachine() {
        this.stockManager = StockManager.getStockManager();
        this.baveragesFactory = new BaveragesFactory();
    }

    public void addStocks(String name, int quantity){
        stockManager.refill(quantity,name);
    }

    public void getStocks(){
        stockManager.getStock();
    }

    public void makeBeverage(String beverageType){
        baveragesFactory.produce(beverageType).prepare(stockManager);
    }
}
