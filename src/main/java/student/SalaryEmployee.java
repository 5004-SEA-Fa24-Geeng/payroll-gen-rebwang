package student;

import java.math.BigDecimal;

public class SalaryEmployee extends Employee {

    public SalaryEmployee(String name, String id, double payRate, double pretaxDeductions,
                          double ytdEarnings, double ytdTaxesPaid) {
        super(EmployeeType.SALARY, name, id, payRate, pretaxDeductions, ytdEarnings, ytdTaxesPaid);}

    @Override
    protected double calculateGrossPay(double hoursWorked) {
        if (hoursWorked > 0) {
            return getPayRate() / 24;
        }
        return 0;
    }
}