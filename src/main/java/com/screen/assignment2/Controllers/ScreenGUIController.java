package com.screen.assignment2.Controllers;

import com.screen.assignment2.Util.Inventory;
import com.screen.assignment2.Models.ComputerScreen;
import com.screen.assignment2.Models.MobileScreen;
import com.screen.assignment2.Models.Screen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/*
 * Name: Arin Dhiman
 * Description: This class is a controller for the view as per the MVC model
 * */

public class ScreenGUIController implements Initializable {

    /**
     * Flag variables to track objects and view
     */
    private int current = 0;
    private int selectedObject = 0;

    /**
     * Gui control variables
     */
    @FXML
    private Label LabelForTotalInventory;

    @FXML
    private Label LabelForTotalSelectedObject;

    @FXML
    private Label ValueForTotalSelectedObject;

    @FXML
    private Label LabelForAttribute00;

    @FXML
    private Label LabelForAttribute01;

    @FXML
    private Label LabelForAttribute03;

    @FXML
    private Label LabelForManufacturer;

    @FXML
    private Label LabelForPanelType;

    @FXML
    private Label LabelForRefreshRate;

    @FXML
    private Label LabelForResolution;

    @FXML
    private Label LabelForScreenSize;

    @FXML
    private Label LabelForTop;

    @FXML
    private Label LabelForWattage;

    @FXML
    private Label LabelForAttribute02;

    @FXML
    private Label ValueForAttribute00;

    @FXML
    private Label ValueForAttribute01;

    @FXML
    private Label ValueForAttribute02;

    @FXML
    private Label ValueForAttribute03;

    @FXML
    private ComboBox ComboBox;

    @FXML
    private Button createObjectBTN;

    /**
     * inventory object to handle collections
     */
    private Inventory inventory;

    /**
     * placeholders for their respective arrayList
     */
    private ArrayList <Screen> screenList;
    private ArrayList <ComputerScreen> computerScreenList;
    private ArrayList <MobileScreen> mobileScreenList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //combo box items
        ComboBox.getItems().addAll("Screen", "Computer Screen", "Mobile Screen");
        ComboBox.setValue("Screen");

        //initializing inventory object
        inventory = new Inventory();

        //getting each collection
        screenList = inventory.getScreenList();
        computerScreenList = inventory.getComputerScreenList();
        mobileScreenList = inventory.getMobileScreenList();

        //displaying total objects
        LabelForTotalInventory.setText(Integer.toString(inventory.getTotal()));

        view();
    }

    /**
     * Displays the next object when next button is pressed
     */
    @FXML
    void ViewNextScreen(ActionEvent event) {
        if(selectedObject == 0) {
            if (current < screenList.size() - 1) {
                current++;
                view();
            } else {
                //to communicate to the user that no more objects left to show
                LabelForTop.setText("No More Screens Up there...");
            }
        }
        else if(selectedObject == 1) {
            if (current < computerScreenList.size() - 1) {
                current++;
                view();
            } else {
                //to communicate to the user that no more objects left to show
                LabelForTop.setText("No More Screens Up there...");
            }
        }
        else if(selectedObject == 2) {
            if (current < mobileScreenList.size() - 1) {
                current++;
                view();
            } else {
                //to communicate to the user that no more objects left to show
                LabelForTop.setText("No More Screens Up there...");
            }
        }
    }

    /**
     * Displays the previous object when previous button is clicked
     */
    @FXML
    void ViewPrevScreen(ActionEvent event) {
        if (current > 0) {
            current--;
            view();
        } else {
            //to communicate to the user that no more objects left to show
            LabelForTop.setText("No More Screens Back there...");
        }
    }

    /**
     * This method just populates the fields in GUI
     */
    void view() {
        if(selectedObject == 0) {
            //if the selected object is Screen
            Screen currentScreen = screenList.get(current);

            LabelForTop.setText("Screen Details");
            LabelForManufacturer.setText(currentScreen.getManufacturer());
            LabelForResolution.setText(currentScreen.getResolutionString());
            LabelForRefreshRate.setText(Integer.toString(currentScreen.getRefreshRate()));
            LabelForWattage.setText(Integer.toString(currentScreen.getWattage()));
            LabelForScreenSize.setText(Double.toString(currentScreen.getScreenSize()));
            LabelForPanelType.setText(currentScreen.getPanelType());
            LabelForAttribute00.setText("");
            LabelForAttribute01.setText("");
            LabelForAttribute02.setText("");
            LabelForAttribute03.setText("");
            ValueForAttribute00.setText("");
            ValueForAttribute01.setText("");
            ValueForAttribute02.setText("");
            ValueForAttribute03.setText("");
            LabelForTotalSelectedObject.setText("Total Generic Screens");
            ValueForTotalSelectedObject.setText(Integer.toString(inventory.getScreens()));

        }
        else if(selectedObject == 1){
            //if the selected object is Computer Screen
            ComputerScreen currentScreen = computerScreenList.get(current);

            LabelForTop.setText("Computer Screen Details");
            LabelForManufacturer.setText(currentScreen.getManufacturer());
            LabelForResolution.setText(currentScreen.getResolutionString());
            LabelForRefreshRate.setText(Integer.toString(currentScreen.getRefreshRate()));
            LabelForWattage.setText(Integer.toString(currentScreen.getWattage()));
            LabelForScreenSize.setText(Double.toString(currentScreen.getScreenSize()));
            LabelForPanelType.setText(currentScreen.getPanelType());
            LabelForAttribute00.setText("sRgb Coverage (%)");
            LabelForAttribute01.setText("Aspect Ratio");
            LabelForAttribute02.setText("A Sync Type");
            LabelForAttribute03.setText("Response Time (GTG)");
            ValueForAttribute00.setText(Integer.toString(currentScreen.getsRGB()));
            ValueForAttribute01.setText(currentScreen.getAspectRatio().toString());
            ValueForAttribute02.setText(currentScreen.getaSyncType());
            ValueForAttribute03.setText(Integer.toString(currentScreen.getResponseTime()));
            LabelForTotalSelectedObject.setText("Total Computer Screens");
            ValueForTotalSelectedObject.setText(Integer.toString(inventory.getComputerScreens()));
        }
        else if(selectedObject == 2) {
            //if the selected object is Mobile Screen
            MobileScreen currentScreen = mobileScreenList.get(current);

            LabelForTop.setText("Mobile Screen Details");
            LabelForManufacturer.setText(currentScreen.getManufacturer());
            LabelForResolution.setText(currentScreen.getResolutionString());
            LabelForRefreshRate.setText(Integer.toString(currentScreen.getRefreshRate()));
            LabelForWattage.setText(Integer.toString(currentScreen.getWattage()));
            LabelForScreenSize.setText(Double.toString(currentScreen.getScreenSize()));
            LabelForPanelType.setText(currentScreen.getPanelType());
            LabelForAttribute00.setText("Max Brightness");
            LabelForAttribute01.setText("Pixel Density (PPI)");
            LabelForAttribute02.setText("Camera Support");
            LabelForAttribute03.setText("");
            ValueForAttribute00.setText(Integer.toString(currentScreen.getMaxBrightness()));
            ValueForAttribute01.setText(Integer.toString(currentScreen.getPixelDensity()));
            ValueForAttribute02.setText(currentScreen.getCameraSupport());
            ValueForAttribute03.setText("");
            LabelForTotalSelectedObject.setText("Total Mobile Screens");
            ValueForTotalSelectedObject.setText(Integer.toString(inventory.getMobileScreens()));
        }
    }

    /**
     * This method handles the combo box selection and applies it to the flag variable
     * the combo box lets the user pick the type of object they want to see
     */
    @FXML
    void SelectObject(ActionEvent event) {
        String object = ComboBox.getSelectionModel().getSelectedItem().toString();

        if(object.toLowerCase().equals("screen")) {
            selectedObject = 0;
            current = 0;
            view();
        }
        else if(object.trim().equalsIgnoreCase("computer Screen")) {
            selectedObject = 1;
            current = 0;
            view();
        }
        else if(object.trim().equalsIgnoreCase("mobile Screen")) {
            selectedObject = 2;
            current = 0;
            view();
        }
    }

    @FXML
    void getCreateView(ActionEvent event) {
        try {
            SceneController.changeScene(event, "Create");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

