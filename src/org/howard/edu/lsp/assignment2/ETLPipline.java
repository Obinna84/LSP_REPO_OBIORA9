package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import org.howard.edu.lsp.assignment3.Employee;

public class ETLPipline {
    public static void main(String[] args) {
        String inputFilePath = "LSP_REPO_OBIORA9/data/employees.csv";
        String outputFilePath = "LSP_REPO_OBIORA9/data/transformed_employees.csv";

        int rowsRead = 0;
        int rowsTransformed = 0;
        int rowsSkipped = 0;

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))
        ) {
            String header = reader.readLine(); // Read the header line
            writer.write("Employee ID,Name,Department,HoursWorked,HourlyRate,GrossPay,PayLevel,EmploymentStatus");
            writer.newLine(); // Write the header to the output file

            String line;

            // Process each line of the input file
            while ((line = reader.readLine()) != null) {
                rowsRead++;
                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue; // Skip empty lines
                }
                String[] fields = line.split(",",-1); // Split the line into fields

                if (fields.length != 5) {
                    rowsSkipped++;
                    continue; // Skip lines with incorrect number of fields
                }

                //Trim whitespace from each field
                for (int i = 0; i < fields.length; i++) {
                    fields[i] = fields[i].trim();
                }

                Employee employee;

                int employeeId;
                BigDecimal hoursWorked;
                BigDecimal hourlyRate;

                //validate employeeId
                try {
                    employeeId = Integer.parseInt(fields[0]);
                } catch (NumberFormatException e) {
                    rowsSkipped++;
                    continue; // Skip lines with invalid employee ID
                }

                //validate hoursWorked
                try {
                    hoursWorked = new BigDecimal(fields[3]);
                } catch (NumberFormatException e) {
                    rowsSkipped++;
                    continue; // Skip lines with invalid hours worked
                }

                //validate hourlyRate
                try {
                    hourlyRate = new BigDecimal(fields[4]);
                } catch (NumberFormatException e) {
                    rowsSkipped++;
                    continue; // Skip lines with invalid hourly rate
                }

                //hoursWorked and hourlyRate should be non-negative
                if (hoursWorked.compareTo(BigDecimal.ZERO) < 0 || hourlyRate.compareTo(BigDecimal.ZERO) < 0) {
                    rowsSkipped++;
                    continue; // Skip lines with negative hours worked or hourly rate 
                }

                //Normalize the name to UpperCase
                String name = fields[1].toUpperCase();

                //Department unchanged
                String department = fields[2];
                employee = new Employee(employeeId, name, department, hoursWorked, hourlyRate);

                //Calculate Base and Overtime Pay
                employee.setGrossPay();

                //Set Pay Level based on Gross Pay
                employee.setPayLevel();

                //Determine Employment Status
                employee.determineEmploymentStatus();

                //Write the transformed data to the output file
                writer.write(employee.toString());

                writer.newLine();
                rowsTransformed++;
            }

            //Print summary of processing
            System.out.println("Rows Read: " + rowsRead);
            System.out.println("Rows Transformed: " + rowsTransformed);
            System.out.println("Rows Skipped: " + rowsSkipped);
            System.out.println("Output file: " + outputFilePath);

        } catch (IOException e) { System.out.println("Error processing files: " + e.getMessage()); }
    }
}


