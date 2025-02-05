package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayStubTest {
    PayStub hourlyEmployee;
    PayStub salaryEmployee;

    @BeforeEach
    void setUp() {
        hourlyEmployee = new PayStub("Luffy","s192",0,20000,
                4530,1425);
        salaryEmployee = new PayStub("Misa Amane","x102",500,12000,
                3500,6250);
    }

    @Test
    void getPay() {
        assertEquals(1102.24,hourlyEmployee.getPay());
        assertEquals(4447.62,salaryEmployee.getPay());
    }

    @Test
    void getTaxesPaid() {
        assertEquals(322.76, hourlyEmployee.getTaxesPaid());
        assertEquals(1302.38, salaryEmployee.getTaxesPaid());

    }

    @Test
    void toCSV() {
        assertEquals("Luffy,1102.24,322.76,21102.24,4852.76", hourlyEmployee.toCSV());
        assertEquals("Misa Amane,4447.62,1302.38,16447.62,4802.38", salaryEmployee.toCSV());
    }
}