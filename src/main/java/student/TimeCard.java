package student;

public class TimeCard implements ITimeCard {
    private String id;
    private double hoursWorked;

    public TimeCard(String id, double hoursWorked) throws IllegalArgumentException {
        this.id = id;

        if (hoursWorked < 0) {
            throw new IllegalArgumentException("Hours worked cannot be negative");
        }
        this.hoursWorked = hoursWorked;
    }

    public String getEmployeeID() {
        return this.id;
    }

    public double getHoursWorked() {
        return this.hoursWorked;
    };

}
