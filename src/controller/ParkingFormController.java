package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import views.table.DriverTable;
import views.table.ParkingTable;

import java.io.IOException;

public class ParkingFormController {
    public JFXComboBox<String> parkingComboBox;
    public TableView parkingTable;
    public TableColumn vehicleNumberColumn;
    public TableColumn vehicleTypeColumn;
    public TableColumn parkingSlotColumn;
    public TableColumn parkedTimeColumn;
    public JFXButton logOutButton;
    public JFXButton addVehicleButton;
    public JFXButton addDriverButton;
    public JFXButton homeButton;

    public static ObservableList<ParkingTable> parking = FXCollections.observableArrayList();

    public void initialize() {
        vehicleNumberColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        vehicleTypeColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        parkingSlotColumn.setCellValueFactory(new PropertyValueFactory<>("slotNumber"));
        parkedTimeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));

        parkingComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                navigate(newValue);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        loadComboBox();
        loadParking();
    }

    private void navigate(String newValue) throws IOException {
        if (newValue == "On Delivery") {
            Parent parent = FXMLLoader.load(getClass().getResource("../views/DeliveryForm.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
    }

    private void loadComboBox() {
        parkingComboBox.getItems().addAll("In Parking", "On Delivery");
    }

    private void loadParking() {
        ObservableList<ParkingTable> list = FXCollections.observableArrayList();
        parking.forEach(e->{
            list.add(
                    new ParkingTable(e.getVehicleNumber(), e.getVehicleType(), e.getSlotNumber(), e.getTime())
            );
        });
        parkingTable.setItems(list);
    }

    public void addVehicle(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../views/VehicleForm.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void addDriver(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../views/DriverForm.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void home(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../views/DashboardForm.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        final Node node = (Node) mouseEvent.getSource();
        stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    public void logOut(MouseEvent mouseEvent) {
        final Node node = (Node) mouseEvent.getSource();
        final Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
}
