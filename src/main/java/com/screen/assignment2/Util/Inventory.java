package com.screen.assignment2.Util;

import com.screen.assignment2.Models.ComputerScreen;
import com.screen.assignment2.Models.MobileScreen;
import com.screen.assignment2.Models.Screen;

import java.util.ArrayList;

/**Name: Arin Dhiman
 * Student no.: 2004897090
 * Date: 09/04/2022
 * Description: This class serves as a collection handler class
 * */

public class Inventory {

    /*
    *3 arraylists for each type of object
    */
    private ArrayList<Screen> screens;
    private ArrayList<MobileScreen> mobileScreens;
    private ArrayList<ComputerScreen> computerScreens;

    /**
     * This constructor is called upon
     */
    public Inventory()
    {
        /*
        * Initialising the arraylists
        * */
        screens = new ArrayList<>();
        mobileScreens = new ArrayList<>();
        computerScreens = new ArrayList<>();

        screens = DBUtil.getScreens();
        mobileScreens = DBUtil.getMobileScreens();
        computerScreens = DBUtil.getComputerScreens();
    }

    /*
     * adding methods for each arraylist
     */
    public void addScreen(Screen screenObject){
        screens.add(screenObject);
    }
    public void addMobileScreen(MobileScreen mobileScreenObject){
        mobileScreens.add(mobileScreenObject);
    }
    public void addComputerScreen(ComputerScreen computerScreenScreenObject){
        computerScreens.add(computerScreenScreenObject);
    }

    /**
     * Get method for each array List
     */

    public ArrayList<Screen> getScreenList() {
        return screens;
    }
    public ArrayList<ComputerScreen> getComputerScreenList() {
        return computerScreens;
    }
    public ArrayList<MobileScreen> getMobileScreenList() {
        return mobileScreens;
    }

    /**
     * These three methods return number of objects in their respective arraylist
     */
    public int getScreens(){
        return screens.size();
    }
    public int getMobileScreens(){
        return mobileScreens.size();
    }
    public int getComputerScreens(){
        return computerScreens.size();
    }

    /**
     * Return the total number of objects in all the arraylists
     */
    public int getTotal(){
        return getScreens() + getMobileScreens() + getComputerScreens();
    }
}
