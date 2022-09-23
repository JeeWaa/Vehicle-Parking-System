package views.table;

public class DeliveryTable {
    String vehicleNumber;
    String vehicleType;
    String driverName;
    String time;

    public DeliveryTable() {
    }

    public DeliveryTable(String vehicleNumber, String vehicleType, String driverName, String time) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.driverName = driverName;
        this.time = time;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "DeliveryTable{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", driverName='" + driverName + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
