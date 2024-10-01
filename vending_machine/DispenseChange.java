package vending_machine;

public class DispenseChange implements MachineState{
    private final VendingMachine vendingMachine;

    public DispenseChange(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void dispenseChange(){
        String itemCode = vendingMachine.getSelectedItem();
        int itemPrice =  vendingMachine.getInventory().getItemByName(itemCode).getPrice();
        System.out.println("Please collect your changes " + (vendingMachine.getInsertedCache()-itemPrice));
        vendingMachine.changeState(new DispenseItem(vendingMachine));
    }
}
