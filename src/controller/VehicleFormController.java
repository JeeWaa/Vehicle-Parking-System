package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Bus;
import model.CargoLorry;
import model.Van;
import model.Vehicle;
import views.table.VehicleTable;

import java.util.ArrayList;

public class VehicleFormController {
    public JFXComboBox vehicleComboBox;
    public JFXTextField vehicleNumberText;
    public JFXTextField maximumWeightText;
    public JFXTextField passengerText;
    public TableView<VehicleTable> vehicleTable;
    public TableColumn typeColumn;
    public TableColumn numberColumn;
    public TableColumn weightColumn;
    public TableColumn passengerColumn;
    public JFXButton addVehicleButton;

    public static ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void initialize() {
        vehicleComboBox.getItems().addAll("Van", "Bus", "CargoLorry");

        typeColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("maximumWeight"));
        passengerColumn.setCellValueFactory(new PropertyValueFactory<>("passenger"));

        loadVehicle();
    }

    private void loadVehicle() {
        ObservableList<VehicleTable> list = FXCollections.observableArrayList();
        vehicles.forEach(e->{
            list.add(
                    new VehicleTable(e.getVehicleType(), e.getVehicleNumber(), e.getMaximumWeight(), e.getPassenger())
            );
        });
        vehicleTable.setItems(list);
    }

    public void addVehicle(MouseEvent mouseEvent) {
        if (vehicles.size() < 15) {
            if (vehicleComboBox.getValue() == "Van") {
                Vehicle van = new Van(
                        vehicleNumberText.getText(),
                        vehicleComboBox.getValue().toString(),
                        Double.parseDouble(maximumWeightText.getText()),
                        Integer.parseInt(passengerText.getText())
                );
                vehicles.add(van);
                loadVehicle();
            }
            if (vehicleComboBox.getValue() == "Bus") {
                Vehicle bus = new Bus(
                        vehicleNumberText.getText(),
                        vehicleComboBox.getValue().toString(),
                        Double.parseDouble(maximumWeightText.getText()),
                        Integer.parseInt(passengerText.getText())
                );
                vehicles.add(bus);
                loadVehicle();
            }
            if (vehicleComboBox.getValue() == "CargoLorry") {
                Vehicle lorry = new CargoLorry(
                        vehicleNumberText.getText(),
                        vehicleComboBox.getValue().toString(),
                        Double.parseDouble(maximumWeightText.getText()),
                        Integer.parseInt(passengerText.getText())
                );
                vehicles.add(lorry);
                loadVehicle();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "Full").show();
        }
    }
}
