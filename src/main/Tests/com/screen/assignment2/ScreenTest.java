package com.screen.assignment2;

import com.screen.assignment2.Models.Screen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScreenTest {

    private Screen testScreen = new Screen();

    @BeforeEach
    void setUp() {
        testScreen = new Screen(1440, 2560, 24.5, "Acer Predator", "VA", 135, 240);
    }

    @Test
    void setHorizontalResolution() {
        assertEquals(2560, testScreen.getHorizontalResolution());
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            testScreen.setHorizontalResolution(10);
        });
    }

    @Test
    void setVerticalResolution() {
        assertEquals(1440, testScreen.getVerticalResolution());
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            testScreen.setVerticalResolution(10);
        });
    }

    @Test
    void setScreenSize() {
        assertEquals(24.5, testScreen.getScreenSize());
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            testScreen.setScreenSize(-10.1);
        });
    }

    @Test
    void setManufacturer() {
        assertEquals("Acer Predator", testScreen.getManufacturer());
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            testScreen.setManufacturer("");
        });
    }

    @Test
    void setPanelType() {
        assertEquals("VA", testScreen.getPanelType());
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            testScreen.setPanelType("TNT");
        });
    }

    @Test
    void setWattage() {
        assertEquals(135, testScreen.getWattage());
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            testScreen.setWattage(-300);
        });
    }

    @Test
    void setRefreshRate() {
        assertEquals(240, testScreen.getRefreshRate());
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            testScreen.setRefreshRate(10);
        });
    }

    @Test
    void getResolutionString() {
        testScreen.setHorizontalResolution(2560);
        testScreen.setVerticalResolution(1440);
        assertEquals("2560 x 1440", testScreen.getResolutionString());
    }
}