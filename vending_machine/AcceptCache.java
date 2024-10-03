package vending_machine;

import java.util.Scanner;

public class AcceptCache implements MachineState{
    private final VendingMachine vendingMachine;

    public AcceptCache(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void acceptCache(){
        int cache=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("please Enter Your cache...");
        cache = sc.nextInt();
        if(vendingMachine.getInventory().getItemByName(vendingMachine.getSelectedItem()).getPrice()>cache){
            vendingMachine.setSelectedItem(null);
            vendingMachine.changeState(new SelectItem(vendingMachine));
            throw new RuntimeException("entered cache is lees");
        }
        vendingMachine.setInsertedCache(cache);
        vendingMachine.changeState(new DispenseChange(vendingMachine));
    }
}
