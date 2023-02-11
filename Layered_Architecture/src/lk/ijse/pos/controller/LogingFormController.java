package lk.ijse.pos.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogingFormController {
    public AnchorPane Context;
    public Label lblTime1;
    public Label lblDate;
    public JFXTextField txtAdminName;
    public JFXPasswordField txtPassword;

    public void initialize(){
        setDateAndTime();
    }

    private void setDateAndTime() {
        Timeline time =new Timeline(
                new KeyFrame(Duration.ZERO, event -> {
                    DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("HH:mm:ss");
                    lblTime1.setText(LocalDateTime.now().format(formatter));

                }), new KeyFrame(Duration.seconds(1)));
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    public void CreateNewAccountOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/CreateAdminAccount.fxml"));
        Stage stage= new Stage();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    public void UserLoginOnAction(ActionEvent actionEvent) throws IOException {
        Context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/UserLoginForm.fxml"));
        Context.getChildren().add(parent);

    }

    public void LoginBtnOnAction(ActionEvent actionEvent) throws IOException {
        String adminName = txtAdminName.getText();
        String password = txtPassword.getText();
        if (adminName.trim().equals("vishnuka") && password.trim().equals("2001")) {
            new Alert(Alert.AlertType.INFORMATION, "Loging has successfully").show();
            Parent parent = FXMLLoader.load(getClass().getResource("../view/Admin-main-form.fxml"));
            Stage stage= new Stage();
            stage.setScene(new Scene(parent));
            stage.show();


            Clear();
        } else {
            new Alert(Alert.AlertType.ERROR, "Login has not  successfully").show();
            Clear();
        }

    }

    private void Clear(){
        txtAdminName.clear();
        txtPassword.clear();
    }
}
