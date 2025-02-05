package student;

public class SalaryEmployee extends AbstractEmployee {

    public SalaryEmployee(String name, String id, double payRate, double ytdEarnings, double ytdTaxesPaid,
                          double pretaxDeductions) {
        super(EmployeeType.SALARY, name, id, payRate, pretaxDeductions, ytdEarnings, ytdTaxesPaid);}

    @Override
    protected double calculateGrossPay(double hoursWorked) {
        if (hoursWorked > 0) {
            return Math.round(getPayRate() / 24 * 100.0) / 100.0;
        }
        return 0;
    }
}