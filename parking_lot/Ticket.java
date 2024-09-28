package parking_lot;

import java.util.HashMap;
import java.util.Map;

public class Ticket {
    private final Vehicle vehicle;
    private final String parkingLotID;
    private final int floorNumber;
    private final int parkingSlotNumber;
    private final static Map<String, Ticket> ticketList = new HashMap<>();

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getParkingLotID() {
        return parkingLotID;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getParkingSlotNumber() {
        return parkingSlotNumber;
    }

    public Ticket(Vehicle vehicle, String parkingLotID, int floorNumber, int parkingSlotNumber) {
        this.vehicle = vehicle;
        this.parkingLotID = parkingLotID;
        this.floorNumber = floorNumber;
        this.parkingSlotNumber = parkingSlotNumber;
    }

    public static Ticket generateTicket(Vehicle vehicle, String lotID, int floorNumber, int slotNumber){
        Ticket ticket = new Ticket(vehicle, lotID, floorNumber, slotNumber);
        String ticketId = lotID + "_" + String.valueOf(lotID) + "_" + String.valueOf(slotNumber);
        ticketList.put(ticketId,ticket);
        return ticket;
    }

    public static Ticket getTicket(String id){
        if(ticketList.containsKey(id)){
            return ticketList.get(id);
        }
        return null;
    }
}
