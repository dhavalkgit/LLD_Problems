package vending_machine;

import java.util.Scanner;

public class SelectItem implements MachineState {
    private final VendingMachine vendingMachine;

    public SelectItem(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectItem(){
        vendingMachine.displayAllItem();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please select Item..");
        String name = sc.nextLine();

        if(vendingMachine.getInventory().isAvailable(name,1) ){
            vendingMachine.setSelectedItem(name);
            vendingMachine.changeState(new AcceptCache(vendingMachine));
        }
        else{
            throw new RuntimeException("Item is not available");
        }
    }
}
