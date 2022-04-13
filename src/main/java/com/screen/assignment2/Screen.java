package com.screen.assignment2;

import com.google.gson.annotations.SerializedName;

/**Name: Arin Dhiman
 * Student no.: 2004897090
 * Date: 02/04/2022 Sat
 * Description: This class serves as a parent or abstract class for the other two derived classes
 * */

public class Screen
{
    /* Attributes for the screen class as well as a list of panel types to check against while setting panel type
    **/
    private int verticalResolution;
    private int horizontalResolution;
    private double screenSize;
    private String manufacturer;
    private String panelType;
    private int wattage;
    private int refreshRate;
    private String[] panelList = {"TN", "VA", "IPS", "OLED", "LCD", "LED", "AMOLED"};

    /* Default constructor to enable inheritance
    **/
    public Screen()
    {}

    /* Custom constructor to instantiate a screen object
    **/
    public Screen(int $verticalResolution, int $horizontalResolution, double $screenSize, String $manufacturer, String $panelType, int $wattage, int $refreshRate)
    {
        setVerticalResolution($verticalResolution);
        setHorizontalResolution($horizontalResolution);
        setScreenSize($screenSize);
        setManufacturer($manufacturer);
        setPanelType($panelType);
        setWattage($wattage);
        setRefreshRate($refreshRate);
    }

    /* setter methods for all the attributes except for panelList
    **/
    public int getHorizontalResolution()
    {
        return horizontalResolution;
    }
    public int getVerticalResolution()
    {
        return verticalResolution;
    }
    public Double getScreenSize()
    {
        return screenSize;
    }
    public String getManufacturer()
    {
        return manufacturer;
    }
    public String getPanelType()
    {
        return panelType;
    }
    public int getWattage()
    {
        return wattage;
    }
    public int getRefreshRate()
    {
        return refreshRate;
    }

    /* Setter methods for every attribute (except for panelList) with verification
    **/
    public void setHorizontalResolution(int $horizontalResolution)
    {
        if($horizontalResolution >= 640) {
            horizontalResolution = $horizontalResolution;
        }
        else{
            throw new IllegalArgumentException("The horizontal resolution cant be lower than 640...");
        }
    }
    public void setVerticalResolution(int $verticalResolution)
    {
        if($verticalResolution >= 480) {
            verticalResolution = $verticalResolution;
        }
        else{
            throw new IllegalArgumentException("The vertical resolution cannot be lower than 460...");
        }
    }
    public void setScreenSize(double $screenSize)
    {
        if($screenSize >= 4.2) {
            screenSize = $screenSize;
        }
        else{
            throw new IllegalArgumentException("Screen size cant be lees than 4.2 inches...");
        }
    }
    public void setManufacturer(String $manufacturer) {
        if ($manufacturer.length() > 1) {
            manufacturer = $manufacturer;
        }
        else{
            throw new IllegalArgumentException("Manufacturer name should have at least 2 characters...");
        }
    }
    public void setPanelType(String $panelType)
    {
        int check = 0;

        //making the check case independent
        $panelType = $panelType.trim();
        $panelType = $panelType.toUpperCase();
        for (String s : panelList) {
            if ($panelType.equals(s)) {
                check = 1;
                break;
            }
        }

        if(check == 1)
        {
            //if panel type matches the one on list
            panelType = $panelType;
        }
        else
        {
            throw new IllegalArgumentException("Panel Type doesnt match any of the available types...");
        }
    }
    public void setWattage(int $wattage) {
        if ($wattage>= 15) {
            wattage = $wattage;
        }
        else{
            throw new IllegalArgumentException("Wattage cannot be less than 15...");
        }
    }
    public void setRefreshRate(int $refreshRate) {
        if ($refreshRate >= 60) {
            refreshRate = $refreshRate;
        }
        else{
            throw new IllegalArgumentException("Refresh Rate cannot be less than 60Hz...");
        }
    }

    /**
     * Special method to return a string representation of resolution
     * The reason for not making a separate object is for quality of life instead of making a new object define the attributes within this class
     */
    public String getResolutionString() {
        return horizontalResolution + " x " + verticalResolution;
    }
}
