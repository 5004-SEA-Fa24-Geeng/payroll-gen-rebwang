package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeCardTest {
    private TimeCard timeCard1;

    @BeforeEach
    void setUp() {
        timeCard1 = new TimeCard("s192",45);
    }

    @Test
    void getEmployeeID() {
        assertEquals("s192", timeCard1.getEmployeeID());
    }

    @Test
    void getHoursWorked() {
        assertEquals(45, timeCard1.getHoursWorked());
    }
}