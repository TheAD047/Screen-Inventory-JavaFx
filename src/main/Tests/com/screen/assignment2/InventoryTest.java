package com.screen.assignment2;

import com.screen.assignment2.Util.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    private Inventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
    }

    @Test
    void getScreens() {
        assertEquals(2, inventory.getScreens());
    }

    @Test
    void getMobileScreens() {
        assertEquals(2, inventory.getMobileScreens());
    }

    @Test
    void getComputerScreens() {
        assertEquals(2, inventory.getComputerScreens());
    }

    @Test
    void getTotal() {
        assertEquals(6, inventory.getTotal());
    }
}