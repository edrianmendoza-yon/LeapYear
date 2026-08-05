package leapyear;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LeapYearTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testMainMethodOutput() {
        LeapYear.main(new String[]{});

        String expectedOutput = String.join(System.lineSeparator(), 
            "true", 
            "false", 
            "true", 
            "false"
        ) + System.lineSeparator();

        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
    
    @Test
    void DivisibleBy400() {
        LeapYear leapYear = new LeapYear(2000);
        assertTrue(leapYear.isLeapYear());
    }
    
    @Test
    void DivisibleBy100ButNot400() {
        LeapYear leapYear = new LeapYear(1900);
        assertFalse(leapYear.isLeapYear());
    }
    
    @Test
    void DivisibleBy4ButNot100() {
        LeapYear leapYear = new LeapYear(2016);
        assertTrue(leapYear.isLeapYear());
    }
    
    @Test
    void DivisibleBy4() {
        LeapYear leapYear = new LeapYear(2017);
        assertFalse(leapYear.isLeapYear());
    }
    
    @Test
    void RandomLeapYear() {
        LeapYear leapYear = new LeapYear(2020);
        assertTrue(leapYear.isLeapYear());
    }
    
    @Test
    void RandomNonLeapYear() {
        LeapYear leapYear = new LeapYear(2021);
        assertFalse(leapYear.isLeapYear());
    }
    
    @Test
    void DivisibleBy4ButNot100Orr400() {
        LeapYear leapYear = new LeapYear(2100);
        assertFalse(leapYear.isLeapYear());
    }
    
    @Test
    void DivisibleBy4And100ButNot400() {
        LeapYear leapYear = new LeapYear(2200);
        assertFalse(leapYear.isLeapYear());
    }
    
    @Test
    void DivisibleBy100And400() {
        LeapYear leapYear = new LeapYear(2000);
        assertTrue(leapYear.isLeapYear());
    }
    
    @Test
    void DivisibleBy100AndNot400() {
        LeapYear leapYear = new LeapYear(2100);
        assertFalse(leapYear.isLeapYear());
    }
    
    @Test
    void DivisibleBy4And100And400() {
        LeapYear leapYear = new LeapYear(2400);
        assertTrue(leapYear.isLeapYear());
    }
}
