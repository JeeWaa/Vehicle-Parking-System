package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public JFXTextField usernameText;
    public JFXPasswordField passwordText;
    public JFXButton loginButton;

    public void login(MouseEvent mouseEvent) throws IOException {
        String u = "admin";
        String p = "1234";
        String user = usernameText.getText();
        String password = passwordText.getText();

        if (u.equals(user) && p.equals(password)) {
            Parent parent = FXMLLoader.load(getClass().getResource("../views/ParkingForm.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            final Node node = (Node) mouseEvent.getSource();
            stage = (Stage) node.getScene().getWindow();
            stage.close();
        }
    }
}
