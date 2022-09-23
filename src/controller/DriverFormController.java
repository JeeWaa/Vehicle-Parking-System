package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Driver;
import views.table.DriverTable;

import java.util.ArrayList;

public class DriverFormController {
    public JFXTextField driverNameText;
    public JFXTextField nicText;
    public JFXTextField driverLicenseText;
    public JFXTextField addressText;
    public JFXTextField contactText;
    public TableView<DriverTable> driverTable;
    public TableColumn nameColumn;
    public TableColumn nicColumn;
    public TableColumn licenseColumn;
    public TableColumn addressColumn;
    public TableColumn contactColumn;
    public JFXButton addDriverButton;

    public static ArrayList<Driver> drivers = new ArrayList<>();

    public void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nicColumn.setCellValueFactory(new PropertyValueFactory<>("nic"));
        licenseColumn.setCellValueFactory(new PropertyValueFactory<>("license"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));

        loadDriver();
    }

    private void loadDriver() {
        ObservableList<DriverTable> list = FXCollections.observableArrayList();
        drivers.forEach(e->{
            list.add(
                    new DriverTable(e.getName(), e.getNic(), e.getLicense(), e.getAddress(), e.getContact())
            );
        });
        driverTable.setItems(list);
    }

    public void addDriver(MouseEvent mouseEvent) {
        Driver driver = new Driver(
                driverNameText.getText(),
                nicText.getText(),
                driverLicenseText.getText(),
                addressText.getText(),
                contactText.getText()
        );
        drivers.add(driver);
        loadDriver();
    }
}
