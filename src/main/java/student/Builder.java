package student;

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
    public static IEmployee buildEmployeeFromCSV(String csv) {
        String[] parts = csv.split(",");
        if (parts.length != 7) {
            return null;
        }

        String employeeType = parts[0];
        String name = parts[1];
        String id = parts[2];

        double payRate;
        double pretaxDeductions;
        double ytdEarnings;
        double ytdTaxesPaid;
        try {
            payRate = Double.parseDouble(parts[3]);
            pretaxDeductions = Double.parseDouble(parts[4]);
            ytdEarnings = Double.parseDouble(parts[5]);
            ytdTaxesPaid = Double.parseDouble(parts[6]);
        } catch (NumberFormatException e) {
            // handle the error
            return null;
        }

        if (employeeType.equals("HOURLY")) {
            return new HourlyEmployee(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions); }
        else if (employeeType.equals("SALARY")) {
            return new SalaryEmployee(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions); }
        else {
            return null; }
    }

   /**
     * Converts a TimeCard from a CSV String.
     * 
     * @param csv csv string
     * @return a TimeCard object or null if the input is invalid
     */
    public static ITimeCard buildTimeCardFromCSV(String csv) {
        String[] parts = csv.split(",");
        if (parts.length != 2) {
            return null;
        }
        String id = parts[0];
        double hoursWorked;
        try {
            hoursWorked = Double.parseDouble(parts[1]);
        } catch (NumberFormatException e) {
            return null;
        }
        return new TimeCard(id, hoursWorked);
    }
}
