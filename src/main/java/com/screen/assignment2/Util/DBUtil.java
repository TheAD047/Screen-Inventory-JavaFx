package com.screen.assignment2.Util;

import com.screen.assignment2.Models.AspectRatio;
import com.screen.assignment2.Models.ComputerScreen;
import com.screen.assignment2.Models.MobileScreen;
import com.screen.assignment2.Models.Screen;

import java.sql.*;
import java.util.ArrayList;

/*
 * Name: Arin Dhiman
 * Description: A Utility Class to manage Database operations
 * */

public class DBUtil {
    private static String user = "root";
    private static String password = "root";
    private static String url = "jdbc:mysql://127.0.01/Screens";

    /**
     * returns a Connection object, this was made private so that not everyone can open a connection
     */
    private static Connection startConnection() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        }
        catch (Exception e) {
            System.out.println("session not commenced...");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method to get all the aspect ratios
     */
    public static ArrayList<AspectRatio> getAspectRatio(){
        String sql = "SELECT * FROM aspect_ratio";
        ArrayList<AspectRatio> aspectRatios = new ArrayList<>();

        try(
                Connection connection = startConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                ){
        while (resultSet.next()){
            AspectRatio aspectRatio = new AspectRatio(
                    resultSet.getInt("ID"),
                    resultSet.getInt("horizontal"),
                    resultSet.getInt("vertical")
            );

            aspectRatios.add(aspectRatio);
        }

        return aspectRatios;

        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method to return one Aspect Ratio object which has the same ID as
     * @param ID
     */
    public static AspectRatio getAspectRatio(int ID){
        String sql = "SELECT * FROM aspect_ratio WHERE ID = ?";
        AspectRatio aspectRatio = null;

        try(
                Connection connection = startConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setInt(1, ID);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                aspectRatio = new AspectRatio(
                        resultSet.getInt("ID"),
                        resultSet.getInt("horizontal"),
                        resultSet.getInt("vertical")
                );
            }

            resultSet.close();

            return aspectRatio;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Gets all the screens in the Database
     */
    public static ArrayList<Screen> getScreens(){
        String sql = "SELECT * FROM Screens";
        ArrayList<Screen> screens = new ArrayList<>();

        try(
                Connection connection = startConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                ){
            while (resultSet.next()){
                Screen screen = new Screen(
                    resultSet.getInt("vertical_res"),
                    resultSet.getInt("horizontal_res"),
                    resultSet.getDouble("screen_size"),
                    resultSet.getString("manufacturer"),
                    resultSet.getString("panel_type"),
                    resultSet.getInt("wattage"),
                    resultSet.getInt("refresh_rate")
                );

                screens.add(screen);
            }

            return screens;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Gets all the computer screens in the Database
     */
    public static ArrayList<ComputerScreen> getComputerScreens() {
        String sql = "SELECT * FROM Computer_screens";
        ArrayList<ComputerScreen> computerScreens = new ArrayList<>();

        try(
                Connection connection = startConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                ){
            while (resultSet.next()) {
                ComputerScreen computerScreen = new ComputerScreen(
                        resultSet.getInt("vertical_res"),
                        resultSet.getInt("horizontal_res"),
                        resultSet.getDouble("screen_size"),
                        resultSet.getString("manufacturer"),
                        resultSet.getString("panel_type"),
                        resultSet.getInt("wattage"),
                        resultSet.getInt("refresh_rate"),
                        resultSet.getInt("sRGB"),
                        DBUtil.getAspectRatio(resultSet.getInt("ratio_ID")),
                        resultSet.getInt("response_time"),
                        resultSet.getString("async_type")
                );

                computerScreens.add(computerScreen);
            }

            return computerScreens;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Gets all the mobile screens in the Database
     */
    public static ArrayList<MobileScreen> getMobileScreens(){
        String sql = "SELECT * FROM Mobile_screens";
        ArrayList<MobileScreen> mobileScreens = new ArrayList<>();

        try(
                Connection connection = startConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                ){
            while (resultSet.next()) {
                MobileScreen mobileScreen = new MobileScreen(
                        resultSet.getInt("vertical_res"),
                        resultSet.getInt("horizontal_res"),
                        resultSet.getDouble("screen_size"),
                        resultSet.getString("manufacturer"),
                        resultSet.getString("panel_type"),
                        resultSet.getInt("wattage"),
                        resultSet.getInt("refresh_rate"),
                        resultSet.getInt("max_brightness"),
                        resultSet.getInt("pixel_density"),
                        resultSet.getString("camera_support")
                );

                mobileScreens.add(mobileScreen);
            }

            return mobileScreens;

        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method to insert a valid screen object into the Database
     */
    public static void insertScreen(Screen screen) {
        String sql = "INSERT INTO Screens(vertical_res, horizontal_res, screen_size, manufacturer, panel_type, wattage, refresh_rate )" +
                "VALUES(?,?,?,?,?,?,?)";

        try(
                Connection connection = startConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ) {
            statement.setInt(1, screen.getVerticalResolution());
            statement.setInt(2, screen.getHorizontalResolution());
            statement.setDouble(3, screen.getScreenSize());
            statement.setString(4, screen.getManufacturer());
            statement.setString(5, screen.getPanelType());
            statement.setInt(6, screen.getWattage());
            statement.setInt(7, screen.getRefreshRate());

            statement.executeUpdate();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to insert a valid computer screen object into the Database
     */
    public static void insertComputerScreen(ComputerScreen screen) {
        String sql = "INSERT INTO Computer_screens(vertical_res, horizontal_res, screen_size, manufacturer, panel_type, wattage, refresh_rate, sRGB, response_time, async_type, ratio_ID)" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        try(
                Connection connection = startConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, screen.getVerticalResolution());
            statement.setInt(2, screen.getHorizontalResolution());
            statement.setDouble(3, screen.getScreenSize());
            statement.setString(4, screen.getManufacturer());
            statement.setString(5, screen.getPanelType());
            statement.setInt(6, screen.getWattage());
            statement.setInt(7, screen.getRefreshRate());
            statement.setInt(8, screen.getsRGB());
            statement.setInt(9, screen.getResponseTime());
            statement.setString(10, screen.getaSyncType());
            statement.setInt(11, screen.getAspectRatio().getID());

            statement.executeUpdate();

            System.out.println("Done");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to insert a valid mobile screen object into the Database
     */
    public static void insertMobileScreen(MobileScreen screen) {
        String sql = "INSERT INTO Mobile_screens(vertical_res, horizontal_res, screen_size, manufacturer, panel_type, wattage, refresh_rate, max_brightness, pixel_density, camera_support)" +
                "VALUES(?,?,?,?,?,?,?,?,?,?)";

        try(
                Connection connection = startConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, screen.getVerticalResolution());
            statement.setInt(2, screen.getHorizontalResolution());
            statement.setDouble(3, screen.getScreenSize());
            statement.setString(4, screen.getManufacturer());
            statement.setString(5, screen.getPanelType());
            statement.setInt(6, screen.getWattage());
            statement.setInt(7, screen.getRefreshRate());
            statement.setInt(8, screen.getMaxBrightness());
            statement.setInt(9, screen.getPixelDensity());
            statement.setString(10, screen.getCameraSupport());

            statement.executeUpdate();

            System.out.println("Done");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
