package com.screen.assignment2.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**Name: Arin Dhiman
 * Description: This class is one of the derived classes from parent class Screen
 * */

public class ComputerScreen extends Screen
{
    /**
     * Additional attributes for a computer screen and a list to check against for valid aSyncType
     */
    private int sRGB;
    private AspectRatio aspectRatio;
    private int responseTime;
    private String aSyncType;
    private static String[] aSyncList = {"GSYNC", "FREESYNC","NONE","FREESYNC2","ADAPTIVESYNC"};

    /**
     * Constructor which passes attributes for parent class and additional attributes introduced in this class
     * @param verticalResolution
     * @param horizontalResolution
     * @param screenSize
     * @param manufacturer
     * @param panelType
     * @param wattage
     * @param refreshRate
     * @param $sRGB
     * @param $aspectRatio
     * @param $responseTime
     * @param $aSyncType
     */
    public ComputerScreen(int verticalResolution, int horizontalResolution, double screenSize, String manufacturer, String panelType, int wattage, int refreshRate, int $sRGB, AspectRatio $aspectRatio, int $responseTime, String $aSyncType)
    {
        setVerticalResolution(verticalResolution);
        setHorizontalResolution(horizontalResolution);
        setScreenSize(screenSize);
        setManufacturer(manufacturer);
        setPanelType(panelType);
        setWattage(wattage);
        setRefreshRate(refreshRate);
        setsRGB($sRGB);
        setAspectRatio($aspectRatio);
        setResponseTime($responseTime);
        setASyncType($aSyncType);
    }

    /**
     * Set methods with verification for each attribute exclusive to the ComputerScreen class
     */
    public void setsRGB(int $sRGB){
        if($sRGB >= 1 && $sRGB <= 100) {
            sRGB = $sRGB;
        }
        else{
            throw new IllegalArgumentException("sRGB coverage can be between 1 and 100 only...");
        }
    }
    public void setAspectRatio(AspectRatio $aspectRatio) {
        aspectRatio = $aspectRatio;
    }
    public void setResponseTime(int $responseTime) {
        if($responseTime >= 1 && $responseTime<= 50){
            responseTime = $responseTime;
        }
        else{
            throw new IllegalArgumentException("Response Time can be between 1 and 50 inclusive...");
        }
    }
    public void setASyncType(String $aSyncType){
        int check = 0;

        //makes the case independent
        $aSyncType = $aSyncType.trim();
        $aSyncType = $aSyncType.toUpperCase();
        for(String s : aSyncList)
        {
            if($aSyncType.equals(s))
            {
                //if a match is found
                check = 1;
                break;
            }
        }
        if(check == 1){
            aSyncType = $aSyncType;
        }
        else{
            throw new IllegalArgumentException("Adaptive sync type does not match anything on the list...");
        }
    }

    /**
     * Get methods for each attribute exclusive to the Computer Class
     */
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
    public static String[] getaSyncList() {
        Collections.sort(Arrays.asList(aSyncList));
        return aSyncList;
    }

    @Override
    public String toString() {
        return "ComputerScreen{" +
                "verticalResolution=" + getVerticalResolution() +
                ", horizontalResolution=" + getHorizontalResolution()+
                ", screenSize=" + getScreenSize() +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", panelType='" + getPanelType() + '\'' +
                ", wattage=" + getWattage() +
                ", refreshRate=" + getRefreshRate() +
                ", sRGB=" + sRGB +
                ", aspectRatio=" + aspectRatio +
                ", responseTime=" + responseTime +
                ", aSyncType='" + aSyncType + '\'' +
                ", aSyncList=" + Arrays.toString(aSyncList) +
                '}';
    }
}
