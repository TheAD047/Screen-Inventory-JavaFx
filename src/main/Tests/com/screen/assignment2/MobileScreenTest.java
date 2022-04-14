package com.screen.assignment2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MobileScreenTest {

    private MobileScreen mobileScreen;

    @BeforeEach
    void setUp() {
        mobileScreen = new MobileScreen(3640, 2160, 6.5, "LG", "AMOLED", 20, 75, 310, 381, "Punch-hole");
    }

    @Test
    void setMaxBrightness() {
        assertEquals(310, mobileScreen.getMaxBrightness());
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mobileScreen.setMaxBrightness(-32984);
        });
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mobileScreen.setMaxBrightness(32984);
        });
    }

    @Test
    void setPixelDensity() {
        assertEquals(381, mobileScreen.getPixelDensity());
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mobileScreen.setPixelDensity(10);
        });
    }

    @Test
    void setCameraSupport() {
        assertEquals("PUNCH-HOLE", mobileScreen.getCameraSupport());
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mobileScreen.setCameraSupport("blah");
        });
    }
}