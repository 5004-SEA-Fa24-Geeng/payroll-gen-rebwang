package student;

import java.math.BigDecimal;

public class HourlyEmployee extends AbstractEmployee {

    private static final double MAX_BASE_HOUR = 40;
    private static final double OVERTIME_RATE = 1.5;

    public HourlyEmployee(String name, String id, double payRate, double ytdEarnings, double ytdTaxesPaid,
                          double pretaxDeductions) {
        super(EmployeeType.HOURLY, name, id, payRate, pretaxDeductions, ytdEarnings, ytdTaxesPaid);}

    @Override
    protected double calculateGrossPay(double hoursWorked) {
        if (hoursWorked > 0) {
            return (getPayRate() * Math.min(MAX_BASE_HOUR, hoursWorked))
                    + (getPayRate() * OVERTIME_RATE * Math.max(0, hoursWorked - MAX_BASE_HOUR));
        }
        return 0;
    }
}