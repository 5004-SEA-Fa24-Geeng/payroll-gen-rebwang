package student;

import java.io.IOException;

/**
 * This is a static class (essentially functions) that will help you build objects from CSV strings.
 * These objects are then used in the rest of the program. Often these builders are associated
 * with the objects themselves and the concept of a factory, but we placed
 * them here to keep the code clean (and to help guide you).
 */
public final class Builder {

    private Builder() {
    }

     /**
     * Builds an employee object from a CSV string.
     * You may end up checking the type of employee (hourly or salary) by looking at the first
     * element of the CSV string. Then building an object specific to that type.
     * @param csv the CSV string
     * @return the employee object
     */
    public static IEmployee buildEmployeeFromCSV(String csv) throws RuntimeException {

        String[] parts = csv.split(",");
        if (parts.length != 7) {
            throw new RuntimeException("Invalid CSV format: should have 7 parts");
        }

        String name = parts[1];
        String id = parts[2];

        double payRate;
        try {
            payRate = Double.parseDouble(parts[3]);
        } catch(NumberFormatException e) {
            // handle the error
            throw new NumberFormatException("Invalid payRate");
        }

        double pretaxDeductions;
        try {
            pretaxDeductions = Double.parseDouble(parts[4]);
        } catch(NumberFormatException e) {
            // handle the error
            throw new NumberFormatException("Invalid pretaxDeductions");
        }

        double ytdEarnings;
        try {
            ytdEarnings = Double.parseDouble(parts[5]);
        } catch(NumberFormatException e) {
            // handle the error
            throw new NumberFormatException("Invalid ytdEarnings");
        }

        double ytdTaxesPaid;
        try {
            ytdTaxesPaid = Double.parseDouble(parts[6]);
        } catch(NumberFormatException e) {
            // handle the error
            throw new NumberFormatException("Invalid ytdTaxesPaid");
        }

        try {
            EmployeeType type = EmployeeType.valueOf(parts[0]); // Converts "HOURLY" or "SALARY" to an enum
            switch (type) {
                case HOURLY:
                    return new HourlyEmployee(name, id, payRate, pretaxDeductions, ytdEarnings, ytdTaxesPaid);
                case SALARY:
                    return new SalaryEmployee(name, id, payRate, pretaxDeductions, ytdEarnings, ytdTaxesPaid);
                default:
                    throw new IllegalArgumentException("Invalid employee type: " + parts[0]);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid employee type: " + parts[0], e);
        }
    }

   /**
     * Converts a TimeCard from a CSV String.
     * 
     * @param csv csv string
     * @return a TimeCard object
     */
    public static ITimeCard buildTimeCardFromCSV(String csv) {
        String[] parts = csv.split(",");
        String id = parts[0];
        double hoursWorked = Double.parseDouble(parts[1]);
        return new TimeCard(id, hoursWorked);
    }
}
