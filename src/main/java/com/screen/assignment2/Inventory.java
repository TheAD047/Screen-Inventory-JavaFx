package com.screen.assignment2;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Screen> screens;
    private ArrayList<MobileScreen> mobileScreens;
    private ArrayList<ComputerScreen> computerScreens;

    public Inventory()
    {
        screens = new ArrayList<>();
        mobileScreens = new ArrayList<>();
        computerScreens = new ArrayList<>();
    }

    public void addScreen(Screen screenObject){
        screens.add(screenObject);
    }

    public void addMobileScreen(MobileScreen mobileScreenObject){
        mobileScreens.add(mobileScreenObject);
    }

    public void addComputerScreen(ComputerScreen computerScreenScreenObject){
        computerScreens.add(computerScreenScreenObject);
    }

    public int getScreens(){
        int sum = 0;
        for(int i = 0;i < screens.size(); i++){
            sum++;
        }
        return sum;
    }

    public int getMobileScreens(){
        int sum = 0;
        for(int i = 0;i < mobileScreens.size(); i++){
            sum++;
        }
        return sum;
    }

    public int getComputerScreens(){
        int sum = 0;
        for(int i = 0;i < computerScreens.size(); i++){
            sum++;
        }
        return sum;
    }

    public int getTotal(){
        return getScreens() + getMobileScreens() + getComputerScreens();
    }
}
