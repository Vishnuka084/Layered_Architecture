package lk.ijse.pos.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserLogingFormController {
    public AnchorPane Context;
    public Label lblTime1;
    public Label lblDate;
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;

    public void AdminLoginOnAction(ActionEvent actionEvent) throws IOException {
        Context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/LogingForm.fxml"));
        Context.getChildren().add(parent);
    }

    public void LoginBtnOnAction(ActionEvent actionEvent) throws IOException {
        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        if (userName.trim().equals("vishnuka") && password.trim().equals("20010717")) {
            new Alert(Alert.AlertType.INFORMATION, "Loging has successfully").show();
            Parent parent = FXMLLoader.load(getClass().getResource("../view/main-form.fxml"));
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
        txtUserName.clear();
        txtPassword.clear();
    }
}
