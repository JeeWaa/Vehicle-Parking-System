package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Driver;
import model.Vehicle;
import views.table.DeliveryTable;
import views.table.ParkingTable;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import static controller.ParkingFormController.parking;
import static controller.DeliveryFormController.delivery;

public class DashboardFormController {
    public Label time;
    public Label date;
    public JFXComboBox<String> vehicleComboBox;
    public JFXComboBox<String> driverComboBox;
    public Label vehicleTypeText;
    public Label driverText;
    public Label slotNumberText;
    public JFXButton loginButton;
    public JFXButton onDeliveryButton;
    public JFXButton parkVehicleButton;

    int slot = 2;

    public static ArrayList<Vehicle> vehicleArrayList = VehicleFormController.vehicles;
    public static ArrayList<Driver> driverArrayList = DriverFormController.drivers;

    public void initialize() {
        setTimeAndDate();
        loadVehicle();
        loadDriver();

        vehicleComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setVehicleData(newValue);
        });
        driverComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            vehicleTypeText.setText(newValue);
        });
    }

    private void parkingSlotNumber() {
        if (slot < 15) {
            slotNumberText.setText(String.valueOf(slot));
            slot = slot + 1;
        }
    }

    private void deliverySlotNumber() {
        if (slot > 0) {
            slot = slot - 1;
            slotNumberText.setText(String.valueOf(slot));
        }
    }

    private void setVehicleData(String newValue) {
        for (Vehicle vehicle : vehicleArrayList) {
            if (vehicle.getVehicleNumber() == newValue) {
                vehicleTypeText.setText(vehicle.getVehicleType());
            }
        }
    }

    private void loadVehicle() {
        ObservableList<String> vehicles = FXCollections.observableArrayList();
        for (Vehicle vehicle : vehicleArrayList) {
            vehicles.add(vehicle.getVehicleNumber());
        }
        vehicleComboBox.setItems(vehicles);
    }

    private void loadDriver() {
        ObservableList<String> drivers = FXCollections.observableArrayList();
        for (Driver driver : driverArrayList) {
            drivers.add(driver.getName());
        }
        driverComboBox.setItems(drivers);
    }

    private void setTimeAndDate() {
        Date d = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        date.setText(f.format(d));

        Timeline t = new Timeline(new KeyFrame(Duration.ZERO, e ->{
            LocalTime localTime = LocalTime.now();
            time.setText(
                    localTime.getHour() + " : " + localTime.getMinute() + " : " + localTime.getSecond() + "  "
            );
        }),
                new KeyFrame(Duration.seconds(1))
        );
        t.setCycleCount(Animation.INDEFINITE);
        t.play();
    }

    public void parkVehicle(MouseEvent mouseEvent) {
        ParkingTable table = new ParkingTable(
                vehicleComboBox.getValue(),
                vehicleTypeText.getText(),
                slotNumberText.getText(),
                date.getText() + " " + time.getText()
        );
        parking.add(table);
        parkingSlotNumber();
    }

    public void onDeliveryShift(MouseEvent mouseEvent) {
        DeliveryTable table = new DeliveryTable(
                vehicleComboBox.getValue(),
                vehicleTypeText.getText(),
                driverComboBox.getValue(),
                date.getText() + " " + time.getText()
        );
        delivery.add(table);
        deliverySlotNumber();
    }

    public void managerLogin(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../views/LoginForm.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        final Node node = (Node) mouseEvent.getSource();
        stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
}
