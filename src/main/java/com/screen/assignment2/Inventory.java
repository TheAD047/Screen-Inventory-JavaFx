package com.screen.assignment2;

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

        Screen screen1 = new Screen(1080, 1920, 27.2, "Samsung", "IPS", 120, 144);
        Screen screen2 = new Screen(1440, 2560, 24.5, "Acer Predator", "VA", 135, 240);
        Screen screen3 = new Screen(1080, 1920, 21.4, "ASUS", "TN", 95, 60);
        Screen screen4 = new Screen(1200, 1920, 24.1, "BENQ", "VA", 125, 265);

        screens.add(screen1);
        screens.add(screen2);
        screens.add(screen3);
        screens.add(screen4);

        AspectRatio aspectRatio = new AspectRatio(16, 9);
        AspectRatio aspectRatio1 = new AspectRatio(21, 9);
        ComputerScreen comp1 = new ComputerScreen(1080, 1920, 27.2, "Samsung", "IPS", 120, 144, 94, aspectRatio, 5, "GSYNC");
        ComputerScreen comp2 = new ComputerScreen(1440, 2560, 24.5, "Acer Predator", "VA", 135, 240, 75, aspectRatio, 2, "FREESYNC");
        ComputerScreen comp3 = new ComputerScreen(1440, 3840, 34.0, "LG", "LED", 155, 165, 91, aspectRatio1, 7, "GSYNC");

        computerScreens.add(comp1);
        computerScreens.add(comp2);
        computerScreens.add(comp3);

        MobileScreen mob1 = new MobileScreen(1920, 1080, 6.1, "Samsung", "OLED", 15, 90, 350, 275, "NOTCH");
        MobileScreen mob2 = new MobileScreen(3640, 2160, 6.5, "LG", "AMOLED", 20, 75, 310, 381, "Punch-hole");
        MobileScreen mob3 = new MobileScreen(720, 1280, 4.2, "Apple", "LCD", 35, 60, 230, 346, "none");
        MobileScreen mob4 = new MobileScreen(2100, 1440, 6.6, "Generic", "LED", 20, 60, 290, 325,"notch");

        mobileScreens.add(mob1);
        mobileScreens.add(mob2);
        mobileScreens.add(mob3);
        mobileScreens.add(mob4);
    }

    /*
    *adding methods for each arraylist
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
