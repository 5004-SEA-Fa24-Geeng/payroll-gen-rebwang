package student;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class PayStub implements IPayStub {
    private IEmployee employee;
    private double netPay;
    private double tax;

    public PayStub(IEmployee employee, double netPay, double tax) {
        this.employee = employee;
        this.netPay = netPay;
        this.tax = tax;

    }

    public double getPay() {
        return this.netPay;
    }

    public double getTaxesPaid() {
        return this.tax;
    }

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
