package model;

public class CargoLorry extends Vehicle {

    CargoLorry() {
        super();
    }

    public CargoLorry(String vehicleNumber, String vehicleType, Double maximumWeight, int passenger) {
        super(vehicleNumber, vehicleType, maximumWeight, passenger);
    }

    @Override
    public int park() {
        return 0;
    }
}
