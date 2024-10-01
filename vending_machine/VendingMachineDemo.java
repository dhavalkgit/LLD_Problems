package vending_machine;

public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getInstance();
        vendingMachine.getInventory().addItem(new Item("cock",10, 20));
        vendingMachine.getInventory().addItem(new Item("pepsi",10, 20));
        vendingMachine.getInventory().addItem(new Item("sprite",10, 20));

        vendingMachine.getCurrentState().acceptCache();
        vendingMachine.getCurrentState().selectItem();
        vendingMachine.getCurrentState().dispenseChange();
        vendingMachine.getCurrentState().dispenseItem();
    }
}
