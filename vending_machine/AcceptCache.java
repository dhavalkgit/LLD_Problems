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
        vendingMachine.setInsertedCache(cache);
        vendingMachine.changeState(new SelectItem(vendingMachine));
    }
}
