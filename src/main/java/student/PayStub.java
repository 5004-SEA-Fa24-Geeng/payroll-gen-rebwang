package student;

/**
 * This payStub class contains payment details for the current pay period.
 */
public class PayStub implements IPayStub {
    /**
     * IEmployee - an instance of an employee.
     */
    private IEmployee employee;

    /**
     * double - the net pay amount for the current period.
     */
    private double netPay;

    /**
     * double - the amount of tax for the current period.
     */
    private double tax;

    /**
     * Constructs a PayStub object.
     *
     * @param employee IEmployee - an instance of an employee
     * @param netPay   double - the net pay amount for the current period
     * @param tax      double - the amount of tax for the current period
     */
    public PayStub(IEmployee employee, double netPay, double tax) {
        this.employee = employee;
        this.netPay = netPay;
        this.tax = tax;
    }

    /**
     * Gets the net pay of current period.
     *
     * @return The net pay amount.
     */
    @Override
    public double getPay() {
        return this.netPay;
    }

    /**
     * Gets the taxes paid of current period.
     *
     * @return The tax amount of current period.
     */
    @Override
    public double getTaxesPaid() {
        return this.tax;
    }

    /**
     * Converts the pay stub details to a CSV-formatted string.
     *
     * @return A string representing the pay stub in CSV format.
     */
    @Override
    public String toCSV() {
        String str;
        str = String.format("%s,%.2f,%.2f,%.2f,%.2f",
                employee.getName(),
                getPay(),
                getTaxesPaid(),
                employee.getYTDEarnings(),
                employee.getYTDTaxesPaid());
        return str;
    }
}
