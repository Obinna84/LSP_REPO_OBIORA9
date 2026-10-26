package org.howard.edu.lsp.midterm.inheritance;

/**
 * Represents a contractor receiving a 15 percent pay premium.
 */
public class Contractor extends Employee {
    private static final double PREMIUM_MULTIPLIER = 1.15;

    /**
     * Constructs a contractor.
     *
     * @param hoursWorked the number of hours worked
     * @param hourlyRate the hourly pay rate
     */
    public Contractor(double hoursWorked, double hourlyRate) {
        super(hoursWorked, hourlyRate);
    }

    /**
     * Calculates hourly pay with a 15 percent premium.
     *
     * @return total contractor pay
     */
    @Override
    public double calculatePay() {
        return getHoursWorked() * getHourlyRate() * PREMIUM_MULTIPLIER;
    }
}
