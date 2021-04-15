package model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class MenuItemTest {

    @Test
    void isValid() {
        MenuItem menuItem = new MenuItem("Asiago Bagel", BigDecimal.valueOf(2.99));

        assertTrue(menuItem.isValid().isEmpty());
    }

    @Test
    void isNotValid() {
        MenuItem menuItem = new MenuItem("Asiago Bagel", BigDecimal.valueOf(-2.99));

        assertFalse(menuItem.isValid().isEmpty());
    }

    @Test
    void toStringTest() {
        MenuItem actual = new MenuItem("Asiago Bagel", BigDecimal.valueOf(2.99));
        String expected = "Asiago Bagel: $2.99";
        assertEquals(expected, actual.toString());
    }
}