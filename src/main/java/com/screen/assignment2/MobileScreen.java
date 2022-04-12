package com.screen.assignment2;

import java.util.Locale;

public class MobileScreen extends Screen
{
    private int maxBrightness;
    private int pixelDensity;
    private String cameraSupport;
    private String[] supportList = {"PUNCH-HOLE","NOTCH","UNDER-SCREEN"};

    public MobileScreen(int verticalResolution, int horizontalResolution, double screenSize, String manufacturer, String panelType, int wattage, int refreshRate, int maxBrightness, int pixelDensity, String cameraSupport)
    {
        setVerticalResolution(verticalResolution);
        setHorizontalResolution(horizontalResolution);
        setScreenSize(screenSize);
        setManufacturer(manufacturer);
        setPanelType(panelType);
        setWattage(wattage);
        setRefreshRate(refreshRate);
        setMaxBrightness(this.maxBrightness);
        setPixelDensity(this.pixelDensity);
        setCameraSupport(this.cameraSupport);
    }

    public int getMaxBrightness() {
        return maxBrightness;
    }

    public int getPixelDensity() {
        return pixelDensity;
    }

    public String getCameraSupport() {
        return cameraSupport;
    }

    public void setMaxBrightness(int maxBrightness) {
        if(this.maxBrightness >= 200) {
            this.maxBrightness = maxBrightness;
        }
        else{
            throw new IllegalArgumentException("Max brightness cant be less than 200 nits...");
        }
    }

    public void setPixelDensity(int pixelDensity) {
        if (this.pixelDensity <= 100) {
            this.pixelDensity = pixelDensity;
        }
        else{
            throw new IllegalArgumentException("Pixel Density can be less than 100 PPI...");
        }
    }

     public void setCameraSupport(String cameraSupport){
        int check = 0;
        this.cameraSupport = this.cameraSupport.trim();
        this.cameraSupport = this.cameraSupport.toUpperCase();
        for(String s : supportList)
         {
             if(this.cameraSupport.equals(s))
             {
                 check = 1;
                 break;
             }
         }
        if(check == 1) {
            this.cameraSupport = cameraSupport;
        }
        else{
            throw new IllegalArgumentException("Camera Support is not correct...");
        }
     }
}
