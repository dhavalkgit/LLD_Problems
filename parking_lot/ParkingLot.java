package parking_lot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingLot {
    private final String id;
    private final List<ParkingFloor> floors;
    private int totalFloors;

    public ParkingLot(String id, int totalFloors){
        this.id=id;
        this.totalFloors=totalFloors;
        this.floors=new ArrayList<>();
        for(int i=0;i<totalFloors;i++){
            this.floors.add(new ParkingFloor.Builder()
                    .floorNumber(i+1)
                    .truckSlot(1,1)
                    .bikeSlot(2,3)
                    .carSlot(4,10)
                    .build()
            );
        }
    }

    public String getId(){return this.id;}

    public void addFloor(ParkingFloor parkingFloor){
        floors.add(parkingFloor);
        totalFloors++;
    }

    private Optional<FirstFreeSlotDTO> getFirstFreeSlot(VehicleType vehicleType){
        Optional<FirstFreeSlotDTO> parkingSlot = Optional.empty();
        for(var floor : floors){
            ParkingSlot res = floor.getFreeSlot(vehicleType);
            if(res!=null){
                parkingSlot = Optional.of(new FirstFreeSlotDTO(floor,res));
            }
        }
        return parkingSlot;
    }

    public Ticket park(Vehicle vehicle){
        Optional<FirstFreeSlotDTO> firstFreeSlot = getFirstFreeSlot(vehicle.getVehicleType());
        if(firstFreeSlot.isPresent()){
            firstFreeSlot.get().parkingSlot().parkVehicle(vehicle);
           return Ticket.generateTicket(vehicle,id,firstFreeSlot.get().parkingFloor().getFloorNumber(),
                    firstFreeSlot.get().parkingSlot().getSlotNumber());
        }
        else{
            System.out.println("Sorry parking lot is full...");
            return null;
        }
    }

    public void unPark(String id){
        Ticket ticket = Ticket.getTicket(id);
        ParkingFloor parkingFloor = floors.get(ticket.getFloorNumber() - 1);
        ParkingSlot slotById = parkingFloor.getSlotById(ticket.getParkingSlotNumber(), ticket.getVehicle().getVehicleType());
        slotById.unParkVehicle();
        System.out.println("Your vehicle is un-parked");
    }

}
