package student;

/**
 * This class constructs a salaried employee, a subclass of AbstractEmployee.
 */
public class SalaryEmployee extends AbstractEmployee {
    private static final double PAY_TERM = 24;
    private static final double ROUNDING = 100.0;

    /**
     * Constructs a SalaryEmployee object.
     *
     * @param name            String - employee's name
     * @param id              String - employee's ID
     * @param payRate         double - the annual salary of the employee
     * @param ytdEarnings     double - year-to-date total earnings
     * @param ytdTaxesPaid    double - year-to-date total taxes paid
     * @param pretaxDeductions double - the total pre-tax deductions
     */
    public SalaryEmployee(String name, String id, double payRate, double ytdEarnings, double ytdTaxesPaid,
                          double pretaxDeductions) {
        super(EmployeeType.SALARY, name, id, payRate, pretaxDeductions, ytdEarnings, ytdTaxesPaid); }


    /**
     * Calculates the gross pay for a salaried employee.
     * The salary is divided by the number of pay periods (24) per year.
     *
     * @param hoursWorked double - as long as it's a non-negative number, salaried employee still gets paid.
     * @return The calculated gross pay for the pay period.
     */
    @Override
    protected double calculateGrossPay(double hoursWorked) {
        return Math.round((getPayRate() / PAY_TERM) * ROUNDING) / ROUNDING;
    }
}
