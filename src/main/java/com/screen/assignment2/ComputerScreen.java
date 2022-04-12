package com.screen.assignment2;

public class ComputerScreen extends Screen
{
    private int sRGB;
    private AspectRatio aspectRatio;
    private int responseTime;
    private String aSyncType;
    private String[] aSyncList = {"GSYNC", "FREESYNC","NONE","FREESYNC1","ADAPTIVESYNC"};

    public ComputerScreen(int verticalResolution, int horizontalResolution, double screenSize, String manufacturer, String panelType, int wattage, int refreshRate, int sRGB, AspectRatio aspectRatio, int responseTime, String aSyncType)
    {
        setVerticalResolution(verticalResolution);
        setHorizontalResolution(horizontalResolution);
        setScreenSize(screenSize);
        setManufacturer(manufacturer);
        setPanelType(panelType);
        setWattage(wattage);
        setRefreshRate(refreshRate);
        setsRGB(this.sRGB);
        setAspectRatio(this.aspectRatio);
        setResponseTime(this.responseTime);
        setASyncType(this.aSyncType);
    }

    public void setsRGB(int sRGB){
        if(this.sRGB >= 1 && this.sRGB <= 100) {
            this.sRGB = sRGB;
        }
        else{
            throw new IllegalArgumentException("sRGB coverage can be between 1 and 100 only...");
        }
    }

    public void setAspectRatio(AspectRatio aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public void setAspectRatio(int horizontal, int vertical) {
        aspectRatio.setVertical(vertical);
        aspectRatio.setHorizontal(horizontal);
    }

    public void setResponseTime(int responseTime) {
        if(this.responseTime >= 1 && this.responseTime <= 50){
            this.responseTime = responseTime;
        }
        else{
            throw new IllegalArgumentException("Response Time can be between 1 and 50 inclusive...");
        }
    }

    private void setASyncType(String aSyncType){
        int check = 0;
        this.aSyncType = this.aSyncType.trim();
        this.aSyncType = this.aSyncType.toUpperCase();
        for(String s : aSyncList)
        {
            if(this.aSyncType.equals(s))
            {
                check = 1;
                break;
            }
        }
        if(check == 1){
            this.aSyncType = aSyncType;
        }
        else{
            throw new IllegalArgumentException("Adaptive sync type does not match anything on the list...");
        }
    }

    public int getsRGB() {
        return sRGB;
    }

    public AspectRatio getAspectRatio() {
        return aspectRatio;
    }

    public int getResponseTime() {
        return responseTime;
    }

    public String getaSyncType() {
        return aSyncType;
    }
}
