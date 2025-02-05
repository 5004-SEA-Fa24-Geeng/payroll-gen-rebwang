package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HourlyEmployeeTest {
    private HourlyEmployee hourlyEmployee;

    @BeforeEach
    void setUp() {
        hourlyEmployee = new HourlyEmployee("Karen","a165",30.0,6000,100,20);
    }

    @Test
    void calculateGrossPay() {
        assertEquals(900, hourlyEmployee.calculateGrossPay(30));
        assertEquals(1650, hourlyEmployee.calculateGrossPay(50));
        assertEquals(0, hourlyEmployee.calculateGrossPay(0));
        assertEquals(0, hourlyEmployee.calculateGrossPay(-5));
    }
}