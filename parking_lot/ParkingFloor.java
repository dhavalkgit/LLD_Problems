package parking_lot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingFloor {
    private final int floorNumber;
    private final Map<VehicleType, List<ParkingSlot>> slots;

    private ParkingFloor(Builder builder){
        this.floorNumber=builder.floorNumber;
        this.slots=new HashMap<>(builder.slots);
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public ParkingSlot getFreeSlot(VehicleType vehicleType){
        for(var slot :slots.get(vehicleType)){
            if(!slot.isOccupied()){
                return slot;
            }
        }
        return null;
    }
    public ParkingSlot getSlotById(int id, VehicleType vehicleType){
        for(var slot : slots.get(vehicleType)){
            if(slot.getSlotNumber()==id) return slot;
        }
        return null;
    }

    public List<ParkingSlot> getAllFreeSlot(VehicleType vehicleType){
        List<ParkingSlot> freeSlot = new ArrayList<>();
        for(var slot : slots.get(vehicleType)){
            if(!slot.isOccupied()){
                freeSlot.add(slot);
            }
        }
        return freeSlot;
    }

    public List<ParkingSlot> getAllOccupied(VehicleType vehicleType) {
        List<ParkingSlot> occupiedSlot = new ArrayList<>();
        for (var slot : slots.get(vehicleType)) {
            if (slot.isOccupied()) {
                occupiedSlot.add(slot);
            }
        }
        return occupiedSlot;
    }

    static final class Builder{
        private int floorNumber;
        private final Map<VehicleType,List<ParkingSlot>>slots=new HashMap<>();

        public Builder floorNumber(int floorNumber){
            this.floorNumber=floorNumber;
            return this;
        }
        public Builder bikeSlot(int start, int end){
            List<ParkingSlot> bikeSlots = slots.getOrDefault(VehicleType.BIKE, new ArrayList<>());
            for(int i=start;i<=end;i++){
                bikeSlots.add(new ParkingSlot(VehicleType.BIKE, i));
            }
            slots.put(VehicleType.BIKE,bikeSlots);
            return this;
        }
        public Builder carSlot(int start, int end){
            List<ParkingSlot> carSlots = slots.getOrDefault(VehicleType.CAR, new ArrayList<>());
            for(int i=start;i<=end;i++){
                carSlots.add(new ParkingSlot(VehicleType.CAR, i));
            }
            slots.put(VehicleType.CAR,carSlots);
            return this;
        }

        public Builder truckSlot(int start, int end){
            List<ParkingSlot> truckSlots = slots.getOrDefault(VehicleType.TRUCK, new ArrayList<>());
            for(int i=start;i<=end;i++){
                truckSlots.add(new ParkingSlot(VehicleType.TRUCK, i));
            }
            slots.put(VehicleType.TRUCK,truckSlots);
            return this;
        }

        public ParkingFloor build(){
            return new ParkingFloor(this);
        }
    }
}
