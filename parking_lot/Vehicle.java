package parking_lot;

public class Vehicle {
    private final VehicleType vehicleType;
    private final String  registrationNo;
    private String color;

    public Vehicle(String registrationNo, VehicleType vehicleType, String color) {
        this.registrationNo = registrationNo;
        this.vehicleType = vehicleType;
        this.color = color;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public String getColor() {
        return color;
    }
}

