package com.screen.assignment2.Controllers;

import com.screen.assignment2.Models.AspectRatio;
import com.screen.assignment2.Models.ComputerScreen;
import com.screen.assignment2.Models.MobileScreen;
import com.screen.assignment2.Models.Screen;
import com.screen.assignment2.Util.DBUtil;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

/*
 * Name: Arin Dhiman
 * Description: Controller Class for Create.fxml file
 * */

public class CreateController implements Initializable {

    private int selectedObject = 0;

    @FXML
    private ComboBox ComboBox;

    @FXML
    private Label LabelForAttribute00;

    @FXML
    private Label LabelForAttribute01;

    @FXML
    private Label LabelForAttribute02;

    @FXML
    private Label LabelForAttribute03;

    @FXML
    private Label LabelForTop;

    @FXML
    private Button createObjectBTN;

    @FXML
    private TextField fieldForHorizontalResolution;

    @FXML
    private TextField fieldForManufacturer;

    @FXML
    private ComboBox<String> comboBoxForPanelType;

    @FXML
    private TextField fieldForRefreshRate;

    @FXML
    private TextField fieldForScreenSize;

    @FXML
    private TextField fieldForVerticalResolution;

    @FXML
    private TextField fieldForWattage;

    @FXML
    private Button getInventoryView;

    @FXML
    private TextField fieldForAttribute00;

    @FXML
    private TextField fieldForAttribute01;

    @FXML
    private ComboBox<String> comboBoxForAttribute02;

    @FXML
    private ComboBox<AspectRatio> comboBoxForAspectRatio;

    @FXML
    private TextField fieldForAttribute03;

    /**
     * Change the view to provide the correct fields and lalbels for object creation
     */
    @FXML
    void SelectObject(ActionEvent event) {
        String object = ComboBox.getSelectionModel().getSelectedItem().toString();

        if(object.equals("screen")) {
            selectedObject = 0;
            view();
        }
        else if(object.trim().equalsIgnoreCase("computer Screen")) {
            selectedObject = 1;
            view();
        }
        else if(object.trim().equalsIgnoreCase("mobile Screen")) {
            selectedObject = 2;
            view();
        }
    }

    /**
     * Create an object based on the value of the combo box to decide which one to create
     */
    @FXML
    void createObject(ActionEvent event) {
        if(selectedObject == 0) {
            //Create Screen
            try {
                Screen screen = new Screen(
                        Integer.parseInt(fieldForVerticalResolution.getText().trim()),
                        Integer.parseInt(fieldForHorizontalResolution.getText().trim()),
                        Double.parseDouble(fieldForScreenSize.getText().trim()),
                        fieldForManufacturer.getText(),
                        comboBoxForPanelType.getValue().toString(),
                        Integer.parseInt(fieldForWattage.getText()),
                        Integer.parseInt(fieldForRefreshRate.getText())
                );

                DBUtil.insertScreen(screen);

                LabelForTop.setText("Screen Added into the inventory...");
            }
            catch (Exception e) {
                LabelForTop.setText("Something Went Wrong...");
            }
        }
        else if(selectedObject == 1) {
            //Create Computer Screen
            try {
                ComputerScreen computerScreen = new ComputerScreen(
                        Integer.parseInt(fieldForVerticalResolution.getText().trim()),
                        Integer.parseInt(fieldForHorizontalResolution.getText().trim()),
                        Double.parseDouble(fieldForScreenSize.getText().trim()),
                        fieldForManufacturer.getText(),
                        comboBoxForPanelType.getValue().toString(),
                        Integer.parseInt(fieldForWattage.getText()),
                        Integer.parseInt(fieldForRefreshRate.getText()),
                        Integer.parseInt(fieldForAttribute00.getText()),
                        comboBoxForAspectRatio.getValue(),
                        Integer.parseInt(fieldForAttribute03.getText()),
                        comboBoxForAttribute02.getValue().toString()
                );

                DBUtil.insertComputerScreen(computerScreen);

                LabelForTop.setText("Computer Screen Added into the inventory...");
            }
            catch (Exception e) {
                LabelForTop.setText("Something Went Wrong...");
            }
        }
        else if(selectedObject == 2) {
            //Create Mobile Screen
            try {
                MobileScreen mobileScreen = new MobileScreen(
                        Integer.parseInt(fieldForVerticalResolution.getText().trim()),
                        Integer.parseInt(fieldForHorizontalResolution.getText().trim()),
                        Double.parseDouble(fieldForScreenSize.getText().trim()),
                        fieldForManufacturer.getText(),
                        comboBoxForPanelType.getValue().toString(),
                        Integer.parseInt(fieldForWattage.getText()),
                        Integer.parseInt(fieldForRefreshRate.getText()),
                        Integer.parseInt(fieldForAttribute00.getText()),
                        Integer.parseInt(fieldForAttribute01.getText()),
                        comboBoxForAttribute02.getValue()
                );

                DBUtil.insertMobileScreen(mobileScreen);

                LabelForTop.setText("Mobile Screen Added into the inventory...");
            }
            catch (Exception e) {
                LabelForTop.setText("Something Went Wrong...");
            }
        }
    }

    /**
     * Go back to Inventory View
     */
    @FXML
    void getInventoryView(ActionEvent event) {
        try {
            SceneController.changeScene(event, "ScreenGUI");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Prepare the view by adding listeners so that invalid values can't be passed in
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ComboBox.getItems().addAll("Screen", "Computer Screen", "Mobile Screen");
        ComboBox.setValue("Screen");

        comboBoxForAspectRatio.getItems().addAll(DBUtil.getAspectRatio());

        comboBoxForPanelType.getItems().addAll(Screen.getPanelList());

        fieldForScreenSize.textProperty().addListener((ObservableValue, oldVal, newVal) -> {
            try {
                if(!newVal.isBlank()) {
                    Double.parseDouble(newVal);
                }
            }
            catch (Exception e) {
                fieldForScreenSize.setText(oldVal);
            }
        });

        fieldForWattage.textProperty().addListener((ObservableValue, oldVal, newVal) -> {
            try {
                if(!newVal.isBlank()) {
                    Integer.parseInt(newVal);
                }
            }
            catch (Exception e) {
                fieldForWattage.setText(oldVal);
            }
        });

        fieldForVerticalResolution.textProperty().addListener((ObservableValue, oldVal, newVal) -> {
            try {
                if(!newVal.isBlank()) {
                    Integer.parseInt(newVal);
                }
            }
            catch (Exception e) {
                fieldForVerticalResolution.setText(oldVal);
            }
        });

        fieldForHorizontalResolution.textProperty().addListener((ObservableValue, oldVal, newVal) -> {
            try {
                if(!newVal.isBlank()) {
                    Integer.parseInt(newVal);
                }
            }
            catch (Exception e) {
                fieldForHorizontalResolution.setText(oldVal);
            }
        });

        fieldForRefreshRate.textProperty().addListener((ObservableValue, oldVal, newVal) -> {
            try {
                if(!newVal.isBlank()) {
                    Integer.parseInt(newVal);
                }
            }
            catch (Exception e) {
                fieldForRefreshRate.setText(oldVal);
            }
        });

        fieldForAttribute00.textProperty().addListener((ObservableValue, oldVal, newVal) -> {
            try {
                if(!newVal.isBlank()) {
                    Integer.parseInt(newVal);
                }
            }
            catch (Exception e) {
                fieldForAttribute00.setText(oldVal);
            }
        });

        fieldForAttribute01.textProperty().addListener((ObservableValue, oldVal, newVal) -> {
            try {
                if(!newVal.isBlank()) {
                    Integer.parseInt(newVal);
                }
            }
            catch (Exception e) {
                fieldForAttribute01.setText(oldVal);
            }
        });

        fieldForAttribute03.textProperty().addListener((ObservableValue, oldVal, newVal) -> {
            try {
                if(!newVal.isBlank()) {
                    Integer.parseInt(newVal);
                }
            }
            catch (Exception e) {
                fieldForAttribute03.setText(oldVal);
            }
        });

        view();
    }

    /**
     * Controls the view so that the labels have the proper values
     */
    void view() {
        if(selectedObject == 0) {
            //if the selected object is Screen

            LabelForTop.setText("Create A Screen");
            LabelForAttribute00.setText("");
            LabelForAttribute01.setText("");
            LabelForAttribute02.setText("");
            LabelForAttribute03.setText("");
            fieldForAttribute00.setVisible(false);
            fieldForAttribute01.setVisible(false);
            comboBoxForAttribute02.setVisible(false);
            fieldForAttribute03.setVisible(false);
            comboBoxForAspectRatio.setVisible(false);

        }
        else if(selectedObject == 1){
            //if the selected object is Computer Screen

            LabelForTop.setText("Create A Computer Screen");
            LabelForAttribute00.setText("sRgb Coverage (%)");
            LabelForAttribute01.setText("Aspect Ratio");
            LabelForAttribute02.setText("A Sync Type");
            LabelForAttribute03.setText("Response Time (GTG)");
            fieldForAttribute00.setVisible(true);
            fieldForAttribute01.setVisible(false);
            comboBoxForAttribute02.setVisible(true);
            fieldForAttribute03.setVisible(true);
            comboBoxForAspectRatio.setVisible(true);

            comboBoxForAttribute02.getItems().remove(0, comboBoxForAttribute02.getItems().size());
            comboBoxForAttribute02.getItems().addAll(ComputerScreen.getaSyncList());

        }
        else if(selectedObject == 2) {
            //if the selected object is Mobile Screen

            LabelForTop.setText("Create A Mobile Screen");
            LabelForAttribute00.setText("Max Brightness");
            LabelForAttribute01.setText("Pixel Density (PPI)");
            LabelForAttribute02.setText("Camera Support");
            LabelForAttribute03.setText("");
            fieldForAttribute00.setVisible(true);
            fieldForAttribute01.setVisible(true);
            comboBoxForAttribute02.setVisible(true);
            fieldForAttribute03.setVisible(false);
            comboBoxForAspectRatio.setVisible(false);

            comboBoxForAttribute02.getItems().remove(0, comboBoxForAttribute02.getItems().size());
            comboBoxForAttribute02.getItems().addAll(MobileScreen.getSupportList());

        }
    }
}
