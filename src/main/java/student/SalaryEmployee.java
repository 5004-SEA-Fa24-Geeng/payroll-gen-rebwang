package student;

public class SalaryEmployee extends AbstractEmployee {
    private static final double PAY_TERM = 24;
    private static final double ROUNDING = 100.0;

    public SalaryEmployee(String name, String id, double payRate, double ytdEarnings, double ytdTaxesPaid,
                          double pretaxDeductions) {
        super(EmployeeType.SALARY, name, id, payRate, pretaxDeductions, ytdEarnings, ytdTaxesPaid);}

    @Override
    protected double calculateGrossPay(double hoursWorked) {
        return Math.round((getPayRate() / PAY_TERM) * ROUNDING) / ROUNDING;
    }
}