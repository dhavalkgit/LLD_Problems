package observer_design_pattern;

public interface StockObservable {
    public void notifyMe();
    public void subscribe(Notification notification);
    public void unSubscribe(Notification notification);
    public void setStockCount(int newCount);
    public void display();
}
