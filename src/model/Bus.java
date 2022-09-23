package model;

public class Bus extends Vehicle {

    Bus() {
        super();
    }

    public Bus(String vehicleNumber, String vehicleType, Double maximumWeight, int passenger) {
        super(vehicleNumber, vehicleType, maximumWeight, passenger);
    }

    @Override
    public int park() {
        return 0;
    }
}
