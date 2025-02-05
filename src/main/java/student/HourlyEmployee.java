package student;

import java.math.BigDecimal;

public class HourlyEmployee extends AbstractEmployee {

    public HourlyEmployee(String name, String id, double payRate, double ytdEarnings, double ytdTaxesPaid,
                          double pretaxDeductions) {
        super(EmployeeType.HOURLY, name, id, payRate, pretaxDeductions, ytdEarnings, ytdTaxesPaid);}

    @Override
    protected double calculateGrossPay(double hoursWorked) {
        if (hoursWorked > 0) {
            return (getPayRate() * Math.min(40, hoursWorked)) + (getPayRate() * 1.5 * Math.max(0, hoursWorked - 40));
        }
        return 0;
    }
}