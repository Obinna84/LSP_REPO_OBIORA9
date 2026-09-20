package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private BigDecimal hoursWorked;
    private BigDecimal hourlyRate;
    private BigDecimal grossPay;
    private String payLevel;
    private String employmentStatus;

    public Employee(int employeeId, String name, String department, BigDecimal hoursWorked, BigDecimal hourlyRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public int getEmployeeId() {
        return this.employeeId;
    }

    public String getName() {
        return this.name;
    }

    public String getDepartment() {
        return this.department;
    }

    public BigDecimal getHoursWorked() {
        return this.hoursWorked;
    }

    public BigDecimal getHourlyRate() {
        return this.hourlyRate;
    }
    public BigDecimal getGrossPay() {
        return this.grossPay;
    }
    public String getPayLevel() {
        return this.payLevel;
    }
    public String getEmploymentStatus() {
        return this.employmentStatus;
    }
    public void setGrossPay() {
        BigDecimal grossPay;
        BigDecimal forty = new BigDecimal("40.00");

        if (hoursWorked.compareTo(forty) <= 0) {
            grossPay = hoursWorked.multiply(hourlyRate);
                } else {
                    BigDecimal regularPay = forty.multiply(hourlyRate);
                    BigDecimal overtimeHours = hoursWorked.subtract(forty);
                    BigDecimal overtimePay = overtimeHours.multiply(hourlyRate).multiply(new BigDecimal("1.5"));
                    grossPay = regularPay.add(overtimePay);
                }

                //Apply %5 bonus for employees in IT Department after overtime calc
                if (department.equalsIgnoreCase("IT")) {
                    BigDecimal bonus = grossPay.multiply(new BigDecimal("0.05"));
                    grossPay = grossPay.add(bonus);
                }
        this.grossPay = grossPay;
        
    }
    public void setPayLevel() {
        if (this.grossPay.compareTo(new BigDecimal("500.00")) < 0) {
            this.payLevel = "Low";
        } else if (this.grossPay.compareTo(new BigDecimal("1000.00")) < 0) {
            this.payLevel = "Medium";
        } else if (this.grossPay.compareTo(new BigDecimal("2000.00")) < 0) {
            this.payLevel = "High";
        } else {
            this.payLevel = "Executive";
        }
    }
    public void determineEmploymentStatus() {
        if (this.hoursWorked.compareTo(new BigDecimal("30.00")) < 0) {
            this.employmentStatus = "Part-Time";
        } else {
            this.employmentStatus = "Full-Time";
        }
    }
    public String toString() {
        return employeeId + "," +
                name + "," +
                department + "," +
                hoursWorked.setScale(2, RoundingMode.HALF_UP).toPlainString() + "," +
                hourlyRate.setScale(2, RoundingMode.HALF_UP).toPlainString() + "," +
                grossPay.setScale(2, RoundingMode.HALF_UP).toPlainString() + "," +
                payLevel + "," +
                employmentStatus;
    }
}