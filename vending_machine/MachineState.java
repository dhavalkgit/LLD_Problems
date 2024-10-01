package vending_machine;

public interface MachineState {
    default void dispenseChange(){
        throw new RuntimeException("Invalid operation in this state");
    }
    default void dispenseItem(){
        throw new RuntimeException("Invalid operation in this state");
    }
    default void acceptCache(){
        throw new RuntimeException("Invalid operation in this state");
    }
    default void selectItem(){
        throw new RuntimeException("Invalid operation in this state");
    }
    default void cancelTransaction(){
        throw new RuntimeException("Invalid operation in this state");
    }
}
