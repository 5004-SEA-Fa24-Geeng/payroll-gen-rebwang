package student;

/**
 * This class constructs a time card for an employee, recording hours worked.
 */
public class TimeCard implements ITimeCard {
    /**
     * String - employee's ID.
     */
    private String id;

    /**
     * double - the number of hours worked.
     */
    private double hoursWorked;

    /**
     * Constructs a TimeCard with the given employee ID and hours worked.
     *
     * @param id            String - employee's ID
     * @param hoursWorked   double - the number of hours worked
     */
    public TimeCard(String id, double hoursWorked) {
        this.id = id;
        this.hoursWorked = hoursWorked;
    }


    /**
     * Gets the employee ID.
     *
     * @return String - employee's ID
     */
    public String getEmployeeID() {
        return this.id;
    }

    /**
     * Gets the total hours worked recorded on time card.
     *
     * @return double - the number of hours worked by the employee.
     */
    public double getHoursWorked() {
        return this.hoursWorked;
    };

}
