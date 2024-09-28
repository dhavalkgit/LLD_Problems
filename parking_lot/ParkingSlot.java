package parking_lot;

public class ParkingSlot {
    private boolean isOccupied;
    private VehicleType slotType;
    private Vehicle parkedVehicle;
    private int slotNumber;

    public ParkingSlot(VehicleType slotType, int slotNumber) {
        this.slotType = slotType;
        this.slotNumber = slotNumber;
        this.isOccupied=false;
        this.parkedVehicle=null;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public VehicleType getSlotType() {
        return slotType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void parkVehicle(Vehicle vehicle){
        if(!isOccupied && this.slotType==vehicle.getVehicleType()){
            this.parkedVehicle=vehicle;
            this.isOccupied=true;
        }
    }

    public Vehicle unParkVehicle(){
        if(isOccupied){
            Vehicle vehicle = parkedVehicle;
            isOccupied=false;
            parkedVehicle=null;
            return vehicle;
        }
        return null;
    }
}
