package com.screen.assignment2;

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
    public Screen(int verticalResolution, int horizontalResolution, double screenSize, String manufacturer, String panelType, int wattage, int refreshRate)
    {
        setVerticalResolution(this.verticalResolution);
        setHorizontalResolution(this.horizontalResolution);
        setScreenSize(this.screenSize);
        setManufacturer(this.manufacturer);
        setPanelType(this.panelType);
        setWattage(this.wattage);
        setRefreshRate(this.refreshRate);
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
    public double getScreenSize()
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
    public void setHorizontalResolution(int horizontalResolution)
    {
        if(this.horizontalResolution >= 640) {
            this.horizontalResolution = horizontalResolution;
        }
        else{
            throw new IllegalArgumentException("The horizontal resolution cant be lower than 640...");
        }
    }
    public void setVerticalResolution(int verticalResolution)
    {
        if(this.verticalResolution >= 480) {
            this.verticalResolution = verticalResolution;
        }
        else{
            throw new IllegalArgumentException("The vertical resolution cannot be lower than 460...");
        }
    }
    public void setScreenSize(double screenSize)
    {
        if(this.screenSize >= 4.2) {
            this.screenSize = screenSize;
        }
        else{
            throw new IllegalArgumentException("Screen size cant be lees than 4.2 inches...");
        }
    }
    public void setManufacturer(String manufacturer) {
        if (this.manufacturer.length() > 1) {
            this.manufacturer = manufacturer;
        }
        else{
            throw new IllegalArgumentException("Manufacturer name should have at least 2 characters...");
        }
    }
    public void setPanelType(String panelType)
    {
        int check = 0;
        this.panelType = this.panelType.trim();
        this.panelType = this.panelType.toUpperCase();
        for (String s : panelList) {
            if (this.panelType.equals(s)) {
                check = 1;
                break;
            }
        }
        if(check == 1)
        {
            this.panelType = panelType;
        }
        else
        {
            throw new IllegalArgumentException("Panel Type doesnt match any of the available types...");
        }
    }
    public void setWattage(int wattage) {
        if (this.wattage >= 15) {
            this.wattage = wattage;
        }
        else{
            throw new IllegalArgumentException("Wattage cannot be less than 15...");
        }
    }
    public void setRefreshRate(int refreshRate) {
        if (this.refreshRate >= 60) {
            this.refreshRate = refreshRate;
        }
        else{
            throw new IllegalArgumentException("Refresh Rate cannot be less than 60Hz...");
        }
    }
}
