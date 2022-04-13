package com.screen.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ScreenGUIController implements Initializable {

    private int current = -1;

    private int selectedObject = 0;

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
    private javafx.scene.control.ComboBox ComboBox;

    private Inventory inventory; //= new Screen(1080, 1920, 27.2, "Samsung", "ips", 120, 144);

    private ArrayList <Screen> screenList;
    private ArrayList <ComputerScreen> computerScreenList;
    private ArrayList <MobileScreen> mobileScreenList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ComboBox.getItems().addAll("Screen", "Computer Screen", "Mobile Screen");
        ComboBox.setValue("Screen");

        inventory = new Inventory();

        screenList = inventory.getScreenList();
        computerScreenList = inventory.getComputerScreenList();
        mobileScreenList = inventory.getMobileScreenList();

        LabelForTotalInventory.setText(Integer.toString(inventory.getTotal()));

        ActionEvent e = new ActionEvent();
        ViewNextScreen(e);
    }

    @FXML
    void ViewNextScreen(ActionEvent event) {
        if(current < screenList.size() - 1) {
            current++;
            view();
        }
        else {
            LabelForTop.setText("No More Screens Up there...");
        }
    }

    @FXML
    void ViewPrevScreen(ActionEvent event) {
        if(current > 0) {
            current--;
            view();
        }
        else{
            LabelForTop.setText("No More Screens Back there...");
        }
    }

    void view() {
        if(selectedObject == 0) {
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
            ValueForAttribute01.setText(currentScreen.getAspectRatio().ToString());
            ValueForAttribute02.setText(currentScreen.getaSyncType());
            ValueForAttribute03.setText(Integer.toString(currentScreen.getResponseTime()));
            LabelForTotalSelectedObject.setText("Total Computer Screens");
            ValueForTotalSelectedObject.setText(Integer.toString(inventory.getComputerScreens()));
        }
        else if(selectedObject == 2) {
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

    @FXML
    void SelectObject(ActionEvent event) {
        String object = ComboBox.getSelectionModel().getSelectedItem().toString();

        if(object.toLowerCase().equals("screen")) {
            selectedObject = 0;
            view();
            System.out.println(selectedObject);
        }
        else if(object.trim().equalsIgnoreCase("computer Screen")) {
            selectedObject = 1;
            view();
            System.out.println(selectedObject);
        }
        else if(object.trim().equalsIgnoreCase("mobile Screen")) {
            selectedObject = 2;
            view();
            System.out.println(selectedObject);
        }
    }
}

