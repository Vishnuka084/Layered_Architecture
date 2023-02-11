package controller;

import bo.BOFactory;
import bo.SuperBO;
import bo.custom.VehicaleBO;
import bo.custom.impl.VehicaleBOImpl;
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
import model.VehicaleDTO;
import view.tdm.VehicaleTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManageVehicaleFormController {
    public AnchorPane root;
    public JFXButton btnAddNewVehicale;
    public JFXTextField txtVehicaleId;
    public JFXTextField txtVehicaleName;
    public JFXTextField txtVehicaleColour;
    public JFXButton btnSave;
    public JFXButton btnDelete;
    public TableView<VehicaleTM> tblVehicale;

//    private VehicaleBO vehicaleBO = new VehicaleBOImpl();
    private final VehicaleBO vehicaleBO = (VehicaleBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.VEHICALE);

    public void initialize() {

        tblVehicale.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("vid"));
        tblVehicale.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblVehicale.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("colour"));

        initUI();

        tblVehicale.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnDelete.setDisable(newValue == null);
            btnSave.setText(newValue != null ? "Update" : "Save");
            btnSave.setDisable(newValue == null);

            if (newValue != null) {
                txtVehicaleId.setText(newValue.getVid());
                txtVehicaleName.setText(newValue.getName());
                txtVehicaleColour.setText(newValue.getColour());

                txtVehicaleId.setDisable(false);
                txtVehicaleName.setDisable(false);
                txtVehicaleColour.setDisable(false);
            }
        });

        txtVehicaleColour.setOnAction(event -> btnSave.fire());
        loadAllVehicales();
    }

    private void loadAllVehicales() {
        tblVehicale.getItems().clear();
        try {


            ArrayList<VehicaleDTO> allVehicales = vehicaleBO.getAllVehicale();

            for (VehicaleDTO vehicale : allVehicales) {
                tblVehicale.getItems().add(new VehicaleTM(vehicale.getVid(),vehicale.getName(),vehicale.getColour()));
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    public void btnAddNew_OnAction(ActionEvent actionEvent) {
        txtVehicaleId.setDisable(false);
        txtVehicaleName.setDisable(false);
        txtVehicaleColour.setDisable(false);
        txtVehicaleId.clear();
        txtVehicaleId.setText(generateNewId());
        txtVehicaleName.clear();
        txtVehicaleColour.clear();
        txtVehicaleName.requestFocus();
        btnSave.setDisable(false);
        btnSave.setText("Save");
        tblVehicale.getSelectionModel().clearSelection();
    }

    private String generateNewId() {
        try {

            return vehicaleBO.generateNewVehicaleNewID();

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to generate a new vid " + e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        if (tblVehicale.getItems().isEmpty()) {
            return "V00-001";
        } else {
            String vid = getLastVehicaleId();
            int newVehicaleId = Integer.parseInt(vid.replace("V", "")) + 1;
            return String.format("V00-%03d", newVehicaleId);
        }

    }

    private String getLastVehicaleId() {
        List<VehicaleTM> tempVehicaleList = new ArrayList<>(tblVehicale.getItems());
        Collections.sort(tempVehicaleList);
        return tempVehicaleList.get(tempVehicaleList.size() - 1).getVid();

    }

    public void btnSave_OnAction(ActionEvent actionEvent) {
        String vid = txtVehicaleId.getText();
        String name = txtVehicaleName.getText();
        String colour = txtVehicaleColour.getText();

        if (!name.matches("[A-Za-z ]+")) {
            new Alert(Alert.AlertType.ERROR, "Invalid name").show();
            txtVehicaleName.requestFocus();
            return;
        } else if (!colour.matches(".{3,}")) {
            new Alert(Alert.AlertType.ERROR, "Colour should be at least 3 characters long").show();
            txtVehicaleColour.requestFocus();
            return;
        }

        if (btnSave.getText().equalsIgnoreCase("save")) {
            try {
                if (existVehicale(vid)) {
                    new Alert(Alert.AlertType.ERROR, vid + " already exists").show();
                }
                vehicaleBO.inserVehicale(new VehicaleDTO(vid,name,colour));

                tblVehicale.getItems().add(new VehicaleTM(vid, name, colour));
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to save the vehicale " + e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        } else {

            try {
                if (!existVehicale(vid)) {
                    new Alert(Alert.AlertType.ERROR, "There is no such vehicale associated with the id " + vid).show();
                }
                vehicaleBO.updateVehicale(new VehicaleDTO(vid,name,colour));

            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to update the vehicale " + vid + e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            VehicaleTM selectedVehicale = tblVehicale.getSelectionModel().getSelectedItem();
            selectedVehicale.setName(name);
            selectedVehicale.setColour(colour);
            tblVehicale.refresh();
        }

        btnAddNewVehicale.fire();
    }

    public void btnDelete_OnAction(ActionEvent actionEvent) {
        String vid = tblVehicale.getSelectionModel().getSelectedItem().getVid();
        try {
            if (!existVehicale(vid)) {
                new Alert(Alert.AlertType.ERROR, "There is no such vehicale associated with the vid " + vid).show();
            }
            vehicaleBO.deleteVehicale(vid);


            tblVehicale.getItems().remove(tblVehicale.getSelectionModel().getSelectedItem());
            tblVehicale.getSelectionModel().clearSelection();
            initUI();

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to delete the customer " + vid).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    boolean existVehicale(String vid) throws SQLException, ClassNotFoundException {
        return vehicaleBO.vehicaleExite(vid);

    }

    private void initUI() {
        txtVehicaleId.clear();
        txtVehicaleName.clear();
        txtVehicaleColour.clear();
        txtVehicaleId.setDisable(true);
        txtVehicaleName.setDisable(true);
        txtVehicaleColour.setDisable(true);
        txtVehicaleId.setEditable(false);
        btnSave.setDisable(true);
        btnDelete.setDisable(true);
    }

    @FXML
    private void navigateToHome(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/Admin-main-form.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());
    }



}
