package org.howard.edu.lsp.midterm.inheritance;

/**
 * Represents a part-time employee receiving straight hourly pay.
 */
public class PartTimeEmployee extends Employee {

    /**
     * Constructs a part-time employee.
     *
     * @param hoursWorked the number of hours worked
     * @param hourlyRate the hourly pay rate
     */
    public PartTimeEmployee(double hoursWorked, double hourlyRate) {
        super(hoursWorked, hourlyRate);
    }

    /**
     * Calculates straight hourly pay.
     *
     * @return total part-time pay
     */
    @Override
    public double calculatePay() {
        return getHoursWorked() * getHourlyRate();
    }
}
