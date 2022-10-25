package com.screen.assignment2;

import com.screen.assignment2.Models.AspectRatio;
import com.screen.assignment2.Models.ComputerScreen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerScreenTest {

    private ComputerScreen computerScreen;
    private AspectRatio aspectRatio;

    @BeforeEach
    void setUp() {
        aspectRatio = new AspectRatio(1,16,9);
        computerScreen = new ComputerScreen(1440, 2560, 24.5, "Acer Predator", "VA", 135, 240, 75, aspectRatio, 2, "FREESYNC");
    }

    @Test
    void getsRGB() {
        assertEquals(75, computerScreen.getsRGB());
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            computerScreen.setsRGB(125);
        });
    }

    @Test
    void getAspectRatio() {
        assertEquals(aspectRatio, computerScreen.getAspectRatio());
    }

    @Test
    void getResponseTime() {
        assertEquals(2,computerScreen.getResponseTime());
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            computerScreen.setResponseTime(-10);
        });
    }

    @Test
    void getaSyncType() {
        assertEquals("FREESYNC", computerScreen.getaSyncType());
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            computerScreen.setASyncType("freeffrom");
        });
    }
}