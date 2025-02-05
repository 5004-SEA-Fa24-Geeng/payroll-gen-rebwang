package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HourlyEmployeeTest {
    HourlyEmployee hourlyEmployee;

    @BeforeEach
    void setUp() {
        hourlyEmployee = new HourlyEmployee("Karen","a165",30.0,20,6000,100);
    }

    @Test
    void runPayroll() {
    }
}