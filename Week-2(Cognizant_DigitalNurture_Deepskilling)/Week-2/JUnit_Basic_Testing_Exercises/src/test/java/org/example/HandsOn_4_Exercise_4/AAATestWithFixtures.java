package org.example.exercise4;

import org.example.App;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AAATestWithFixtures {

    private App app;

    @Before
    public void setUp() {
        app = new App();
        System.out.println("Before each test");
    }

    @After
    public void tearDown() {
        System.out.println("After each test");
    }

    @Test
    public void testAddMethod() {
        int a = 3;
        int b = 4;

        int result = app.add(a, b);

        assertEquals(7, result);

        System.out.println("Test Passed: Addition Result is " + result);
    }
}
