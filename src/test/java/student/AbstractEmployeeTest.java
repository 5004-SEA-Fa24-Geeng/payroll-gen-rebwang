package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class AbstractEmployeeTest {
    private HourlyEmployee hourlyEmployee;
    private SalaryEmployee salaryEmployee;

    @BeforeEach
    void setUp() {
        hourlyEmployee = new HourlyEmployee("Karen","a165",30.0,6000,100,20);
        salaryEmployee = new SalaryEmployee("Josh", "s109", 15000, 20000, 5000, 1000);
    }

    @Test
    void getName() {
        assertEquals("Karen", hourlyEmployee.getName());
        assertEquals("Josh", salaryEmployee.getName());
    }

    @Test
    void getID() {
        assertEquals("a165", hourlyEmployee.getID());
        assertEquals("s109", salaryEmployee.getID());
    }

    @Test
    void getPayRate() {
        assertEquals(30.0, hourlyEmployee.getPayRate());
        assertEquals(15000, salaryEmployee.getPayRate());
    }

    @Test
    void getEmployeeType() {
        assertEquals("HOURLY", hourlyEmployee.getEmployeeType());
        assertEquals("SALARY", salaryEmployee.getEmployeeType());
    }

    @Test
    void getYTDEarnings() {
        assertEquals(6000, hourlyEmployee.getYTDEarnings());
        assertEquals(20000, salaryEmployee.getYTDEarnings());
    }

    @Test
    void getYTDTaxesPaid() {
        assertEquals(100, hourlyEmployee.getYTDTaxesPaid());
        assertEquals(5000, salaryEmployee.getYTDTaxesPaid());
    }

    @Test
    void getPretaxDeductions() {
        assertEquals(20, hourlyEmployee.getPretaxDeductions());
        assertEquals(1000, salaryEmployee.getPretaxDeductions());
    }

    @Test
    void runPayroll() {
        // Test negative working hours
        assertNull(hourlyEmployee.runPayroll(-5));
        assertNull(salaryEmployee.runPayroll(-2));

        // Test salary employee working 0 hr still gets paid
        assertNotNull(salaryEmployee.runPayroll(0));

        // Test hourly employee working normal hours
        IPayStub hourlyPayStub = hourlyEmployee.runPayroll(5);
        assertNotNull(hourlyPayStub);
        assertEquals(100.55, hourlyPayStub.getPay());
        assertEquals(29.45, hourlyPayStub.getTaxesPaid());
    }

    @Test
    void toCSV() {
        assertEquals("HOURLY,Karen,a165,30.00,20.00,6000.00,100.00", hourlyEmployee.toCSV());
        assertEquals("SALARY,Josh,s109,15000.00,1000.00,20000.00,5000.00", salaryEmployee.toCSV());
    }

    @Test
    void constructorThrowsExceptionPayRate() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
        { new HourlyEmployee("Karen","a165",-30.0,20,6000,100);});
        assertEquals("payRate cannot be negative", exception.getMessage());
    }

    @Test
    void constructorThrowsExceptionPretaxDeductions() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new HourlyEmployee("Karen","a165",30.0,20,6000,-100);
        });
        assertEquals("pretaxDeductions cannot be negative", exception.getMessage());
    }

    @Test
    void constructorThrowsExceptionYTDEarnings() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new SalaryEmployee("Josh", "s109", 15000, -1000, 20000, 5000);
        });
        assertEquals("ytdEarnings cannot be negative", exception.getMessage());
    }

    @Test
    void constructorThrowsExceptionYTDTaxesPaid() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new SalaryEmployee("Josh", "s109", 15000, 1000, -20000, 5000);
        });
        assertEquals("ytdTaxesPaid cannot be negative", exception.getMessage());
    }
}