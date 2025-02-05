package student;

public abstract class AbstractEmployee implements IEmployee {
    private EmployeeType employeeType;
    private String name;
    private String id;
    private double payRate;
    private double ytdEarnings;
    private double ytdTaxesPaid;
    private double preTaxDeductions;

    private static final double TAX_PERCENTAGE = 0.2265;
    private static final double ROUNDING = 100.0;

    protected AbstractEmployee(EmployeeType employeeType, String name, String id, double payRate, double pretaxDeductions,
                               double ytdEarnings, double ytdTaxesPaid) {
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

    @Override
    public String toCSV() {
        return String.format("%s,%s,%s,%.2f,%.2f,%.2f,%.2f",
                getEmployeeType(), getName(), getID(), getPayRate(),
                getPretaxDeductions(), getYTDEarnings(), getYTDTaxesPaid());
    }
}