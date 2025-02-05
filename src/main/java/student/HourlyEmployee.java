package student;

/**
 * This class constructs an hourly employee, a subclass of AbstractEmployee.
 */
public class HourlyEmployee extends AbstractEmployee {

    private static final double MAX_BASE_HOUR = 40;
    private static final double OVERTIME_RATE = 1.5;

    /**
     * Constructs an HourlyEmployee object.
     *
     * @param name            String - employee's name
     * @param id              String - employee's ID
     * @param payRate         double - hourly pay rate
     * @param ytdEarnings     double - year-to-date total earnings
     * @param ytdTaxesPaid    double - year-to-date total taxes paid
     * @param pretaxDeductions double - the total pre-tax deductions
     */
    public HourlyEmployee(String name, String id, double payRate, double ytdEarnings, double ytdTaxesPaid,
                          double pretaxDeductions) {
        super(EmployeeType.HOURLY, name, id, payRate, pretaxDeductions, ytdEarnings, ytdTaxesPaid); }

    /**
     * Calculates the gross pay for an hourly employee based on hours worked.
     *
     * @param hoursWorked The number of hours worked.
     * @return The calculated gross pay.
     */
    @Override
    protected double calculateGrossPay(double hoursWorked) {
        if (hoursWorked > 0) {
            return (getPayRate() * Math.min(MAX_BASE_HOUR, hoursWorked))
                    + (getPayRate() * OVERTIME_RATE * Math.max(0, hoursWorked - MAX_BASE_HOUR));
        }
        return 0;
    }
}
