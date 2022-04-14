package com.screen.assignment2;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;

public class FileHandler {

    @SerializedName("Screen")
    public Screen[] screen;

    public Screen[] getSearch() {
        return screen;
    }

    public static FileHandler getScreenFromFile(String fileName) {
        Gson reader = new Gson();
        FileHandler response = null;

        try (
                FileReader fileReader = new FileReader(fileName);
                JsonReader jsonReader = new JsonReader(fileReader);) {
            response = reader.fromJson(jsonReader, FileHandler.class);
        } catch (Exception e){
            e.printStackTrace();
        }

        return response;
    }
}
