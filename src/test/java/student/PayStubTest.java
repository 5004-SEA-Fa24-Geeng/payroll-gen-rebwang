package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PayStubTest {
    private IEmployee employee1;
    private IEmployee employee2;
    private PayStub payStub1;
    private PayStub payStub2;

    @BeforeEach
    void setUp() {
        employee1 = new HourlyEmployee("Luffy","s192",30.00,20000,
                4530,0);
        employee2 = new SalaryEmployee("Misa Amane","x102",150000,12000,
                3500,500);
        payStub1 = new PayStub(employee1, 1102.24,322.76);
        payStub2 = new PayStub(employee2, 4447.63, 1302.38);
    }

    @Test
    void getPay() {
        assertEquals(1102.24, payStub1.getPay());
        assertEquals(4447.63, payStub2.getPay());
    }

    @Test
    void getTaxesPaid() {
        assertEquals(322.76, payStub1.getTaxesPaid());
        assertEquals(1302.38, payStub2.getTaxesPaid());
    }

    @Test
    void toCSV() {
        assertEquals("Luffy,1102.24,322.76,20000.00,4530.00", payStub1.toCSV());
        assertEquals("Misa Amane,4447.63,1302.38,12000.00,3500.00", payStub2.toCSV());
    }
}