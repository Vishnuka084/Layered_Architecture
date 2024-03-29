package lk.ijse.pos.controller;

import lk.ijse.pos.bo.BOFactory;
import lk.ijse.pos.bo.custom.RIderBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.pos.dto.RiderDTO;
import lk.ijse.pos.view.tdm.RiderTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManageRidersFormController {
    public AnchorPane root;
    public JFXButton btnAddNewRider;
    public JFXTextField txtRiderId;
    public JFXTextField txtRiderName;
    public JFXTextField txtRiderAddress;
    public JFXButton btnSave;
    public JFXButton btnDelete;
    public TableView<RiderTM> tblRiders;

 //   private final RIderBO riderBO = new RiderBOImpl();

    private final  RIderBO riderBO = (RIderBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RIDER);

    public void initialize() {

        tblRiders.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("rid"));
        tblRiders.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblRiders.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        initUI();

        tblRiders.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnDelete.setDisable(newValue == null);
            btnSave.setText(newValue != null ? "Update" : "Save");
            btnSave.setDisable(newValue == null);

            if (newValue != null) {
                txtRiderId.setText(newValue.getRid());
                txtRiderName.setText(newValue.getName());
                txtRiderAddress.setText(newValue.getAddress());

                txtRiderId.setDisable(false);
                txtRiderName.setDisable(false);
                txtRiderAddress.setDisable(false);
            }
        });

        txtRiderAddress.setOnAction(event -> btnSave.fire());
        loadAllRiders();
    }

    private void loadAllRiders() {
        tblRiders.getItems().clear();

        try {


            ArrayList<RiderDTO> allRider = riderBO.getAllRider();

            for (RiderDTO rider : allRider) {
                tblRiders.getItems().add(new RiderTM(rider.getRid(),rider.getName(),rider.getAddress()));
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void initUI() {
        txtRiderId.clear();
        txtRiderName.clear();
        txtRiderAddress.clear();
        txtRiderId.setDisable(true);
        txtRiderName.setDisable(true);
        txtRiderAddress.setDisable(true);
        txtRiderId.setEditable(false);
        btnSave.setDisable(true);
        btnDelete.setDisable(true);
    }

    @FXML
    private void navigateToHome(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/lk/ijse/pos/view/Admin-main-form.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());
    }

    public void btnAddNew_OnAction(ActionEvent actionEvent) {
        txtRiderId.setDisable(false);
        txtRiderName.setDisable(false);
        txtRiderAddress.setDisable(false);
        txtRiderId.clear();
        txtRiderId.setText(generateNewId());
        txtRiderName.clear();
        txtRiderAddress.clear();
        txtRiderName.requestFocus();
        btnSave.setDisable(false);
        btnSave.setText("Save");
        tblRiders.getSelectionModel().clearSelection();
    }

    private String generateNewId() {
        try {
            return riderBO.generateNewRiderNewID();

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to generate a new rid " + e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        if (tblRiders.getItems().isEmpty()) {
            return "R00-001";
        } else {
            String rid = getLastCustomerId();
            int newCustomerId = Integer.parseInt(rid.replace("R", "")) + 1;
            return String.format("R00-%03d", newCustomerId);
        }
    }

    private String getLastCustomerId() {
        List<RiderTM> tempRidersList = new ArrayList<>(tblRiders.getItems());
        Collections.sort(tempRidersList);
        return tempRidersList.get(tempRidersList.size() - 1).getRid();
    }

    public void btnSave_OnAction(ActionEvent actionEvent) {
        String rid = txtRiderId.getText();
        String name = txtRiderName.getText();
        String address = txtRiderAddress.getText();

        if (!name.matches("[A-Za-z ]+")) {
            new Alert(Alert.AlertType.ERROR, "Invalid name").show();
            txtRiderName.requestFocus();
            return;
        } else if (!address.matches(".{3,}")) {
            new Alert(Alert.AlertType.ERROR, "Address should be at least 3 characters long").show();
            txtRiderAddress.requestFocus();
            return;
        }

        if (btnSave.getText().equalsIgnoreCase("save")) {
            try {
                if (existRider(rid)) {
                    new Alert(Alert.AlertType.ERROR, rid + " already exists").show();
                }
                riderBO.inserRider(new RiderDTO(rid,name,address));

                tblRiders.getItems().add(new RiderTM(rid, name, address));
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to save the customer " + e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        } else {

            try {
                if (!existRider(rid)) {
                    new Alert(Alert.AlertType.ERROR, "There is no such customer associated with the id " + rid).show();
                }
                riderBO.updateRider(new RiderDTO(rid,name,address));

            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to update the customer " + rid + e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            RiderTM selectedRider= tblRiders.getSelectionModel().getSelectedItem();
            selectedRider.setName(name);
            selectedRider.setAddress(address);
            tblRiders.refresh();
        }

        btnAddNewRider.fire();
    }

    boolean existRider(String rid) throws SQLException, ClassNotFoundException {
        return riderBO.riderExite(rid);

    }

    public void btnDelete_OnAction(ActionEvent actionEvent) {
        String rid = tblRiders.getSelectionModel().getSelectedItem().getRid();
        try {
            if (!existRider(rid)) {
                new Alert(Alert.AlertType.ERROR, "There is no such rider associated with the rid " + rid).show();
            }

            riderBO.deleteRider(rid);
            tblRiders.getItems().remove(tblRiders.getSelectionModel().getSelectedItem());
            tblRiders.getSelectionModel().clearSelection();
            initUI();

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to delete the rider " + rid).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
