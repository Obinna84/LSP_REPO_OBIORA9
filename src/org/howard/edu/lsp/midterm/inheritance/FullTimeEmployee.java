package org.howard.edu.lsp.midterm.inheritance;

/**
 * Represents a full-time employee who receives overtime pay.
 */
public class FullTimeEmployee extends Employee {
    private static final double REGULAR_HOURS = 40.0;
    private static final double OVERTIME_MULTIPLIER = 1.5;

    /**
     * Constructs a full-time employee.
     *
     * @param hoursWorked the number of hours worked
     * @param hourlyRate the hourly pay rate
     */
    public FullTimeEmployee(double hoursWorked, double hourlyRate) {
        super(hoursWorked, hourlyRate);
    }

    /**
     * Calculates regular pay and overtime pay beyond 40 hours.
     *
     * @return total full-time pay
     */
    @Override
    public double calculatePay() {
        double regularHours = Math.min(getHoursWorked(), REGULAR_HOURS);
        double overtimeHours = Math.max(0, getHoursWorked() - REGULAR_HOURS);

        return regularHours * getHourlyRate()
                + overtimeHours * getHourlyRate() * OVERTIME_MULTIPLIER;
    }
}
