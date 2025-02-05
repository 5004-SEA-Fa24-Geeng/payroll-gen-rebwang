package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HourlyEmployeeTest {
    HourlyEmployee hourlyEmployee;

    @BeforeEach
    void setUp() {
        hourlyEmployee = new HourlyEmployee("Karen","a165",30.0,6000,100,20);
    }

    @Test
    void calculateGrossPay() {
        assertEquals(1650, hourlyEmployee.calculateGrossPay(50));
    }
}