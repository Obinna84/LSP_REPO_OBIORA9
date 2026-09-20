# Question 1: How was your Assignment #2 solution organized?
## My assignment 2 solution used functional programming to accomplish the task of transforming the data. After loading all of the comma seperated values for each employee, the extra columns (Gross pay, pay level, and employment status) were defined in the main function of my program, as well as the employee details string that was written to my `transformed_employees.csv` file

# Question 2: What design changes did you make for Assignment #3?
## For assignment 3 I utilized object oriented programming principles, by creating an Employee class, that used private attributes to store key employee information. The class also utilized a constructor function, to create an `Employee` instance with the variables provided from the initial `employees.csv` file. Additionally the class contained instance functions (`setGrossPay()`,`setPayLevel()`, and `determineEmploymentStatus()`) that alter the instance variables that aren't provided by the `employee.csv` file.

# Question 3: What classes or abstractions did you introduce and why?
## I introduced the employee class to store the employee attributes exported from the `employee.csv` file.

# Question 4: How did you divide the responsibilities differently?
## The main function handles the reading and writing functions of the program. I didn't see a need to abstract those features as the functions were already defined in an imported package. I created the Employee class to handle all employee details.

# Question 5: Why do you believe your Assignment #3 is an improvement?
## My assignment three adds an object oriented structure that was missing from the first assignment. This is an improvement because it makes the program more malleable, and increases the possibilities of further improvements as there is now a class that can store, and manipulate employee object information that survives longer than a single loop iteration.


### No AI was used for this assignment besides the native autocomplete feature in VSCode IDE.