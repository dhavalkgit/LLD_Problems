package observer_design_pattern;

public class Demo {
    public static void main(String[] args) {
        StockObservable stockObservable = new Iphone();
        stockObservable.subscribe(new EmailNotification("abc@gmail.com"));
        stockObservable.subscribe(new SmsNotification("13049393"));
        stockObservable.setStockCount(3);
        stockObservable.display();
        stockObservable.unSubscribe(new SmsNotification("13049393"));
        stockObservable.display();
        stockObservable.setStockCount(4);
    }
}
