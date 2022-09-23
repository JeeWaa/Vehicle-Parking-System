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
import views.table.DeliveryTable;
import views.table.ParkingTable;

import java.io.IOException;

public class DeliveryFormController {
    public JFXComboBox deliveryComboBox;
    public TableView deliveryTable;
    public TableColumn vehicleNumberColumn;
    public TableColumn vehicleTypeColumn;
    public TableColumn driverNameColumn;
    public TableColumn leftTimeColumn;
    public JFXButton logOutButton;
    public JFXButton addVehicleButton;
    public JFXButton addDriverButton;
    public JFXButton homeButton;

    public static ObservableList<DeliveryTable> delivery = FXCollections.observableArrayList();

    public void initialize() {
        vehicleNumberColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        vehicleTypeColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        driverNameColumn.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        leftTimeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));

        deliveryComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                navigate(newValue);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        loadComboBox();
        loadDelivery();
    }

    private void navigate(Object newValue) throws IOException {
        if (newValue == "In Parking") {
            Parent parent = FXMLLoader.load(getClass().getResource("../views/ParkingForm.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
    }

    private void loadComboBox() {
        deliveryComboBox.getItems().addAll("On Delivery", "In Parking");
    }

    private void loadDelivery() {
        ObservableList<DeliveryTable> list = FXCollections.observableArrayList();
        delivery.forEach(e->{
            list.add(
                    new DeliveryTable(e.getVehicleNumber(), e.getVehicleType(), e.getDriverName(), e.getTime())
            );
        });
        deliveryTable.setItems(list);
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
