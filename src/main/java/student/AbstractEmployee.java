package student;

public abstract class AbstractEmployee implements IEmployee {
    private EmployeeType employeeType;
    private String name;
    private String id;
    private double payRate;
    private double ytdEarnings;
    private double ytdTaxesPaid;
    private double preTaxDeductions;

    public AbstractEmployee(EmployeeType employeeType, String name, String id, double payRate, double pretaxDeductions,
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
        if (hoursWorked < 0) {
            return null;
        }
        double grossPay = calculateGrossPay(hoursWorked);
        double tax = Math.round(((grossPay - getPretaxDeductions()) * 0.2265) * 100.0) / 100.0;
        double netPay = Math.round((grossPay - getPretaxDeductions() - tax) * 100.0) / 100.0;
        this.ytdEarnings = this.ytdEarnings + netPay;
        this.ytdTaxesPaid = this.ytdTaxesPaid + tax;
        return new PayStub(this, netPay, tax);
    }

    public String toCSV() {
        switch (this.employeeType) {
            case SALARY:
                return String.format("%s,%s,%s,%.0f,%.0f,%.0f,%.0f\n",
                        getEmployeeType(), getName(), getID(), getPayRate(),
                        getPretaxDeductions(), getYTDEarnings(), getYTDTaxesPaid());
            case HOURLY:
                return String.format("%s,%s,%s,%.2f,%.0f,%.0f,%.0f\n",
                        getEmployeeType(), getName(), getID(), getPayRate(),
                        getPretaxDeductions(), getYTDEarnings(), getYTDTaxesPaid());
            default:
                throw new IllegalStateException("Unexpected EmployeeType: " + this.employeeType);
        }
    }
}
