package vending_machine;

public class DispenseItem implements MachineState{
    private final VendingMachine vendingMachine;

    public DispenseItem(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void dispenseItem(){
        vendingMachine.setInsertedCache(0);
        vendingMachine.getInventory().consumeQuantity(1,vendingMachine.getSelectedItem());
        System.out.println("Your item is dispense collect it...");
        vendingMachine.setSelectedItem(null);
        vendingMachine.changeState(new AcceptCache(vendingMachine));
    }
}
