package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuilderTest {

    @Test
    void buildHourlyEmployeeFromCSV() {
        String csv1 = "HOURLY,Luffy,s192,30.00,0,20000,4530";
        IEmployee employee1 = Builder.buildEmployeeFromCSV(csv1);
        assertNotNull(employee1);
        assertInstanceOf(HourlyEmployee.class, employee1);
        assertEquals("HOURLY", employee1.getEmployeeType());
        assertEquals("Luffy", employee1.getName());
    }

    @Test
    void buildSalaryEmployeeFromCSV() {
        String csv2 = "SALARY,Nami,s193,200000,1000,17017,4983";
        IEmployee employee2 = Builder.buildEmployeeFromCSV(csv2);
        assertNotNull(employee2);
        assertInstanceOf(SalaryEmployee.class, employee2);
        assertEquals("SALARY", employee2.getEmployeeType());
        assertEquals(200000, employee2.getPayRate());
    }

    @Test
    void buildEmployeeFromCSVInvalidInputException() {
        String csvException = "HOURLY,Jay";
        RuntimeException exception = assertThrows(RuntimeException.class, () -> Builder.buildEmployeeFromCSV(csvException));
        assertEquals("Invalid CSV format: should have 7 parts", exception.getMessage());
    }

    @Test
    void buildEmployeeFromCSVEmployeeTypeException() {
        String employeeTypeError = "Hourly,Nami,s193,200000,1000,17017,4983";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                Builder.buildEmployeeFromCSV(employeeTypeError));
        assertEquals("Invalid employee type: Hourly", exception.getMessage());
    }

    @Test
    void buildTimeCardFromCSV() {
        String csv3 = "s193,60";
        ITimeCard timeCard1 = Builder.buildTimeCardFromCSV(csv3);
        assertNotNull(timeCard1);
        assertInstanceOf(TimeCard.class, timeCard1);
        assertEquals("s193", timeCard1.getEmployeeID());
        assertEquals(60, timeCard1.getHoursWorked());
    }

    @Test
    void timeCardConstructorException() {
        String csv4 = "x199,-30";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Builder.buildTimeCardFromCSV(csv4);
        });
        assertEquals("Hours worked cannot be negative", exception.getMessage());
    }
}