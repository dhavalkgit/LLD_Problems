package vending_machine;

public class VendingMachine {
    private int insertedcache;
    private MachineState state;
    private static VendingMachine instance;
    private InventoryManager inventory;
    private String selectedItem;

    private  VendingMachine(){
        this.insertedcache=0;
        this.state= new SelectItem(this);
        this.inventory = InventoryManager.getInstance();
        this.selectedItem=null;
    }

    public synchronized static VendingMachine getInstance(){
        if(instance==null) instance = new VendingMachine();
        return instance;
    }

    public void changeState(MachineState state){
        this.state=state;
    }

    public MachineState getCurrentState(){
        return state;
    }

    public void setInsertedCache(int cache){
        this.insertedcache=cache;
    }

    public void displayAllItem(){
        inventory.getItems().forEach((name, item) ->{
            System.out.println("item name: "+ item.getName() + ", price: "+item.getPrice());
        } );
    }

    public InventoryManager getInventory() {
        return inventory;
    }

    public int getInsertedCache() {
        return insertedcache;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }
}
