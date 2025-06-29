package org.example.exercise3;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        // Assert equals
        assertEquals(5, 2 + 3);
        System.out.println("assertEquals passed");

        // Assert true
        assertTrue(5 > 3);
        System.out.println("assertTrue passed");

        // Assert false
        assertFalse(5 < 3);
        System.out.println("assertFalse passed");

        // Assert null
        assertNull(null);
        System.out.println("assertNull passed");

        // Assert not null
        assertNotNull(new Object());
        System.out.println("assertNotNull passed");
    }
}
