package lk.ijse.pos.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class CreateAdminAccountController {
    public TextField txtName;
    public TextField txtId;
    public TextField txtAddress;
    public PasswordField txtPassword;
    public JFXButton btnSave;
    LinkedHashMap<TextField, Pattern> map =new LinkedHashMap<>();

    public void initialize() {
        btnSave.setDisable(true);

        Pattern namePattern = Pattern.compile("^[A-z ]{3,15}$");
        Pattern idPattern = Pattern.compile("^[0-9]{11,13}$");
        Pattern addressPattern = Pattern.compile("^[A-z0-9 ,/]{4,20}$");
        Pattern passwordPattern = Pattern.compile("^[A-z0-9]{3,10}$");

        map.put(txtName, namePattern);
        map.put(txtId, idPattern);
        map.put(txtAddress, addressPattern);
        map.put(txtPassword, passwordPattern);

    }

    private void clears() {
        txtPassword.clear();
        txtAddress.clear();
        txtId.clear();
        txtName.clear();
        setBorders(txtPassword,txtAddress,txtId,txtName);
    }


    public void setBorders(TextField... textFields) {
        for (TextField textField : textFields) {
            textField.getParent().setStyle("-fx-border-color: rgba(76, 73, 73, 0.83)");
        }
    }

    public void textFields_Key_Released(KeyEvent keyEvent) {
        /*
         ValidationUtil.validate(map, btnCreate);
        if (keyEvent.getCode() == KeyCode.ENTER) {
            Object response = ValidationUtil.validate(map, btnCreate);
            ;
            if (response instanceof TextField) {
                TextField textField = (TextField) response;
                textField.requestFocus();
            } else if (response instanceof Boolean) {
                System.out.println("Work");
                SaveAdmin();
            }
         */

    }

    public void btnSave_OnAction(ActionEvent actionEvent) {

        /*
        Admin admin = new Admin(
                txtName.getText(),
                txtId.getText(),
                txtAddress.getText(),
                txtEmail.getText(),
                txtPassword.getText(),
                txtRePassword.getText()
        );


        try {
            if (txtPassword.getText().equals(txtRePassword.getText())) {
                CrudUtil.executeUpdate("INSERT INTO Admin VALUES (?,?,?,?,?,?)", admin.getName(), admin.getAId()
                        , admin.getAddress(), admin.getEmail(), admin.getPassword(), admin.getRePassword());

                Not.notificationsConfirm("Admin Added System","Saved");
                clears();
                Parent parent= FXMLLoader.load(getClass().getResource("../view/MainPage.fxml"));
                Stage stage=new Stage();
                stage.setScene(new Scene(parent));
                Stage stage2 = (Stage) Context.getScene().getWindow();
                stage2.close();
                stage.show();


            } else {
                Not.notificationError("Please Insert Data Correctly","Unsucessfully");
            }


        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();

        }
         */
    }
}
