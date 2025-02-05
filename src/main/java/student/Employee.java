package student;

public abstract class Employee implements IEmployee {
    private final EmployeeType employeeType;
    private final String name;
    private final String id;
    private final double payRate;
    private final double ytdEarnings;
    private final double ytdTaxesPaid;
    private final double preTaxDeductions;

    public Employee(EmployeeType employeeType, String name, String id, double payRate, double pretaxDeductions,
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

    public String getName() { return this.name; }
    public String getID() { return this.id; }
    public double getPayRate() { return this.payRate; }
    public String getEmployeeType() { return this.employeeType.toString(); }
    public double getYTDEarnings() { return this.ytdEarnings; }
    public double getYTDTaxesPaid() { return this.ytdTaxesPaid; }
    public double getPretaxDeductions() { return this.preTaxDeductions; }

    protected abstract double calculateGrossPay(double hoursWorked);

    public IPayStub runPayroll (double hoursWorked) {
        if (hoursWorked <= 0) {
            return null;
        }
        double grossPay = calculateGrossPay(hoursWorked);
        return new PayStub(getName(),getID(),getPretaxDeductions(),getYTDEarnings(),getYTDTaxesPaid(),grossPay);
    }

    public String toCSV() {
        switch (this.employeeType) {
            case SALARY:
                return String.format("%s,%s,%s,%.0f,%.0f,%.0f,%.0f\n",
                        this.employeeType, this.name, this.id, this.payRate,
                        this.preTaxDeductions, this.ytdEarnings, this.ytdTaxesPaid);
            case HOURLY:
                return String.format("%s,%s,%s,%.2f,%.0f,%.0f,%.0f\n",
                        this.employeeType, this.name, this.id, this.payRate,
                        this.preTaxDeductions, this.ytdEarnings, this.ytdTaxesPaid);
            default:
                throw new IllegalStateException("Unexpected EmployeeType: " + this.employeeType);
        }
    }
}
