package model;

public class Van extends Vehicle {

    Van() {
        super();
    }

    public Van(String vehicleNumber, String vehicleType, Double maximumWeight, int passenger) {
        super(vehicleNumber, vehicleType, maximumWeight, passenger);
    }

    @Override
    public int park() {
        return 0;
    }
}
