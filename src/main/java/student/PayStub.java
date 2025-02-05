package student;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class PayStub implements IPayStub {
    private String employeeName;
    private String id;
    private double ytdEarnings;
    private double ytdTaxesPaid;
    private double grossPay;
    private double pretaxDeduction;

    public PayStub(String employeeName,String id, double pretaxDeduction, double ytdEarnings, double ytdTaxesPaid, double grossPay) {
        this.employeeName = employeeName;
        this.id = id;
        this.pretaxDeduction = pretaxDeduction;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.grossPay = grossPay;
    }

    public double getPay() {
        return this.grossPay - this.pretaxDeduction - getTaxesPaid();
    }

    public double getTaxesPaid() {
        return (this.grossPay - this.pretaxDeduction) * 0.2265;
    }

    public String toCSV() {
        String str;
        str = this.employeeName + "," +
                String.format("%.2f",getPay()) + "," +
                String.format("%.2f",getTaxesPaid()) + "," +
                String.format("%.2f", this.ytdEarnings + getPay()) + "," +
                String.format("%.2f", this.ytdTaxesPaid + getTaxesPaid());
        return str;
    }
}
