package observer_design_pattern;

import java.util.ArrayList;
import java.util.List;

public class Iphone implements StockObservable{
    private List<Notification> observers = new ArrayList<>();
    private int quantity;

    public Iphone(){
        this.quantity=0;
    }

    @Override
    public void notifyMe() {
        for(var observer : observers){
            observer.send();
        }
    }

    @Override
    public void subscribe(Notification notification) {
        observers.add(notification);
    }

    @Override
    public void unSubscribe(Notification notification) {
        if (observers.contains(notification)) {
            observers.remove(notification);
            System.out.println("Observer successfully unsubscribed.");
        } else {
            System.out.println("Observer not found in the subscription list.");
        }
    }

    @Override
    public void setStockCount(int newCount) {
        if(newCount<=0) throw new RuntimeException("please enter valid value ");
        if(this.quantity==0){
            this.quantity+=newCount;
            notifyMe();
        }
        else{
            this.quantity+=newCount;
        }
    }

    @Override
    public void display(){
        observers.forEach( observer ->{
            System.out.println(observer.toString());
        });
    }
}
