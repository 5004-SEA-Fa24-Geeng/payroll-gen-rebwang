package student;

/**
 * AbstractEmployee is an Abstract class that has essential payroll attributes.
 * This class implements IEmployee interface and provides common functionalities for all employee types.
 */
public abstract class AbstractEmployee implements IEmployee {
    /**
     * String - the type of employee - SALARY or HOURLY
     */
    private EmployeeType employeeType;

    /**
     * String - Employee's name
     */
    private String name;

    /**
     * String - Employee's ID
     */
    private String id;

    /**
     * double - Employee's pay rate
     */
    private double payRate;

    /**
     * double - year-to-date total earnings
     */
    private double ytdEarnings;

    /**
     * double - year-to-date total taxes paid
     */
    private double ytdTaxesPaid;

    /**
     * double - the deductions before tax deduction
     */
    private double preTaxDeductions;

    /**
     * constant - total percentage for calculating tax
     */
    private static final double TAX_PERCENTAGE = 0.2265;

    /**
     * constant - rounding aid for calculations.
     */
    private static final double ROUNDING = 100.0;

    /**
     * Constructs an AbstractEmployee with the below attributes.
     * @param employeeType      String - the type of employee - SALARY or HOURLY
     * @param name              String - Employee's name
     * @param id                String - Employee's ID
     * @param payRate           double - Employee's pay rate
     * @param pretaxDeductions  double - the deductions before tax deduction
     * @param ytdEarnings       double - year-to-date total earnings
     * @param ytdTaxesPaid      double - year-to-date total taxes paid
     */
    protected AbstractEmployee(EmployeeType employeeType,
                               String name,
                               String id,
                               double payRate,
                               double pretaxDeductions,
                               double ytdEarnings,
                               double ytdTaxesPaid) {
        this.employeeType = employeeType;
        this.name = name;
        this.id = id;

        validateNonNegative(payRate, "payRate");
        validateNonNegative(pretaxDeductions, "pretaxDeductions");
        validateNonNegative(ytdEarnings, "ytdEarnings");
        validateNonNegative(ytdTaxesPaid, "ytdTaxesPaid");

        this.payRate = payRate;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.preTaxDeductions = pretaxDeductions;
    }

    /**
     * Validates that a given value is non-negative.
     *
     * @param value     The value to validate.
     * @param fieldName The name of the field being validated.
     * @throws IllegalArgumentException if the value is negative.
     */
    private static void validateNonNegative(double value, String fieldName) {
        if (value < 0) {
            throw new IllegalArgumentException(fieldName + " cannot be negative");
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public double getPayRate() {
        return this.payRate;
    }

    @Override
    public String getEmployeeType() {
        return this.employeeType.toString();
    }

    @Override
    public double getYTDEarnings() {
        return this.ytdEarnings;
    }

    @Override
    public double getYTDTaxesPaid() {
        return this.ytdTaxesPaid;
    }

    @Override
    public double getPretaxDeductions() {
        return this.preTaxDeductions;
    }

    /**
     * Abstract method to calculate gross pay based on hours worked.
     *
     * @param hoursWorked The number of hours worked.
     * @return The calculated gross pay.
     */
    protected abstract double calculateGrossPay(double hoursWorked);

    @Override
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0) {
            return null;
        }
        double grossPay = calculateGrossPay(hoursWorked);
        double tax = Math.round(((grossPay - getPretaxDeductions()) * TAX_PERCENTAGE) * ROUNDING) / ROUNDING;
        double netPay = Math.round((grossPay - getPretaxDeductions() - tax) * ROUNDING) / ROUNDING;
        this.ytdEarnings = this.ytdEarnings + netPay;
        this.ytdTaxesPaid = this.ytdTaxesPaid + tax;
        return new PayStub(this, netPay, tax);
    }

    /**
     * Converts the employee's information into a CSV format.
     *
     * @return A string with the employee's details. This will be written to CSV file.
     */
    @Override
    public String toCSV() {
        return String.format("%s,%s,%s,%.2f,%.2f,%.2f,%.2f",
                getEmployeeType(), getName(), getID(), getPayRate(),
                getPretaxDeductions(), getYTDEarnings(), getYTDTaxesPaid());
    }
}
