package com.screen.assignment2.Models;

import java.util.Arrays;
import java.util.Collections;

/**Name: Arin Dhiman
 * Description: This is a derived class from Screen paretn class
 * */

public class MobileScreen extends Screen
{
    /**
     * 3 additional attributes for Mobile Screen object
     * String array to check against for validation for cameraSupport
     */
    private int maxBrightness;
    private int pixelDensity;
    private String cameraSupport;
    private static String[] supportList = {"PUNCH-HOLE","NOTCH","UNDER-SCREEN", "NONE"};

    /**
     * Constructor to pass in attributes for parent class and this derived class
     * @param verticalResolution
     * @param horizontalResolution
     * @param screenSize
     * @param manufacturer
     * @param panelType
     * @param wattage
     * @param refreshRate
     * @param $maxBrightness
     * @param $pixelDensity
     * @param $cameraSupport
     */
    public MobileScreen(int verticalResolution, int horizontalResolution, double screenSize, String manufacturer, String panelType, int wattage, int refreshRate, int $maxBrightness, int $pixelDensity, String $cameraSupport)
    {
        setVerticalResolution(verticalResolution);
        setHorizontalResolution(horizontalResolution);
        setScreenSize(screenSize);
        setManufacturer(manufacturer);
        setPanelType(panelType);
        setWattage(wattage);
        setRefreshRate(refreshRate);
        setMaxBrightness($maxBrightness);
        setPixelDensity($pixelDensity);
        setCameraSupport($cameraSupport);
    }

    /**
     * Get methods for each attribute exclusive to mobile screen class
     */
    public int getMaxBrightness() {
        return maxBrightness;
    }
    public int getPixelDensity() {
        return pixelDensity;
    }
    public String getCameraSupport() {
        return cameraSupport;
    }
    public static String[] getSupportList() {
        Collections.sort(Arrays.asList(supportList));
        return supportList;
    }

    /**
     * Set methods with verification for each attribute exclusive to this class
     */
    public void setMaxBrightness(int $maxBrightness) {
        if($maxBrightness >= 200 && $maxBrightness <= 550) {
            maxBrightness = $maxBrightness;
        }
        else{
            throw new IllegalArgumentException("Max brightness cant be less than 200 nits...");
        }
    }
    public void setPixelDensity(int $pixelDensity) {
        if ($pixelDensity >= 100) {
            pixelDensity = $pixelDensity;
        }
        else{
            throw new IllegalArgumentException("Pixel Density can be less than 100 PPI...");
        }
    }
     public void setCameraSupport(String $cameraSupport){
        int check = 0;
        $cameraSupport = $cameraSupport.trim();
        $cameraSupport = $cameraSupport.toUpperCase();
        for(String s : supportList)
         {
             if($cameraSupport.equals(s))
             {
                 check = 1;
                 break;
             }
         }
        if(check == 1) {
            cameraSupport = $cameraSupport;
        }
        else{
            throw new IllegalArgumentException("Camera Support is not correct...");
        }
     }

    @Override
    public String toString() {
        return "MobileScreen{" +
                "verticalResolution=" + getVerticalResolution() +
                ", horizontalResolution=" + getHorizontalResolution()+
                ", screenSize=" + getScreenSize() +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", panelType='" + getPanelType() + '\'' +
                ", wattage=" + getWattage() +
                ", refreshRate=" + getRefreshRate() +
                ", maxBrightness=" + maxBrightness +
                ", pixelDensity=" + pixelDensity +
                ", cameraSupport='" + cameraSupport + '\'' +
                '}';
    }
}
