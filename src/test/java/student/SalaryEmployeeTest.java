package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryEmployeeTest {
    SalaryEmployee salaryEmployee;

    @BeforeEach
    void setUp() {
        salaryEmployee = new SalaryEmployee("Josh", "s109", 15000, 1000, 20000,
                5000);
    }

    @Test
    void runPayroll() {
    }
}