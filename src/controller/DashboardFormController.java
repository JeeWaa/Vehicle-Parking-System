package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class DashboardFormController {
    public Label time;
    public Label date;
    public JFXComboBox vehicleComboBox;
    public JFXComboBox driverComboBox;
    public Label vehicleTypeText;
    public Label driverText;
    public Label slotNumberText;
    public JFXButton loginButton;
    public JFXButton onDeliveryButton;
    public JFXButton parkVehicleButton;

    public void initialize() {
        setTimeAndDate();
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
    }

    public void onDeliveryShift(MouseEvent mouseEvent) {
    }

    public void managerLogin(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../views/LoginForm.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
