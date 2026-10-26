# Question 3 — Development Log

## Resources Used

**AI tool:** OpenAI ChatGPT (GPT-6).

**Purpose:** Transcribe the instructor-provided `Driver.java` into pasteable Java formatting; evaluate the student's proposed inheritance hierarchy; explain abstract classes, method overriding, and runtime polymorphism; generate the implementation of `Employee`, `FullTimeEmployee`, `PartTimeEmployee`, and `Contractor` with Javadoc; and prepare this development log.

**Course materials:** Howard University, CSCI 363 / CSCI 540, Fall 2026 Midterm Examination, Question 3, including the original `EmployeePayCalculator`, requirements, and instructor-provided Driver. These materials defined the required class signatures, pay rules, tests, and documentation requirements.

**Other sources:** No websites, books, or other external resources have been reported for Question 3. Update this statement if additional sources were used.

## Student Contributions and AI Interactions

### Interaction 1 — Driver.java Transcription

**Student prompt (verbatim):**

> question 3 provides a driver.java file similar to question 1. Rewrite it so that its pasteable and preserves the same structure as intended

**AI assistance:** ChatGPT transcribed and reformatted the instructor-provided `Driver.java` into a pasteable Java code block without intending to change its logic. It explained that the Driver expects an `Employee` type and three subclasses and reports 12 checks.

**Outcome:** The instructor's Driver was prepared for use in the `org.howard.edu.lsp.midterm.inheritance` package.

### Interaction 2 — Refactoring with Inheritance and Polymorphism

**Student prompt (verbatim):**

> this is the provided class given for question 3:
>
> Provided Class
>
> public class EmployeePayCalculator {
>
> public double calculatePay(String employeeType,
>
> double hoursWorked,
>
> double hourlyRate) {
>
> if (employeeType.equals("FULL_TIME")) {
>
> return hoursWorked * hourlyRate;
>
> }
>
> if (employeeType.equals("PART_TIME")) {
>
> return hoursWorked * hourlyRate;
>
> }
>
> if (employeeType.equals("CONTRACTOR")) {
>
> return hoursWorked * hourlyRate * 1.15;
>
> }
>
> return 0.0;
>
> }
>
> }
>
> Part 1 asks for a refactoring of its implementation using inheritance, method overriding, and polymorphsim.
>
> From first glance at the provided code and the Driver.java file, we need an Employee class with FullTimeEmployee, PartTimeEmployee, and Contractor subclasses. It also looks like based on the expected results in the Driver.java class that calculatePay() produces different results for each of the subclasses meaning overriding will have to be used in their respective class methods. Provide feedback on my assumptions and the correct implementation based on the requirements for the question

**Student contribution:** The student independently identified the `Employee` superclass, `FullTimeEmployee`, `PartTimeEmployee`, and `Contractor` subclasses, and the need to override `calculatePay()`.

**AI assistance:** ChatGPT confirmed these assumptions, recommended an abstract `Employee` superclass with an abstract `calculatePay()` method, and generated four Java implementation files with Javadoc. The generated implementation stores common `hoursWorked` and `hourlyRate` fields in `Employee` and implements these pay rules:

- Full-time: regular hourly pay up to 40 hours and 1.5× hourly pay for hours above 40.
- Part-time: straight hourly pay for all hours.
- Contractor: hourly pay with a 15% premium for all hours.

ChatGPT also explained how the Driver's `Employee` parameter and `employee.calculatePay()` call demonstrate runtime polymorphism.

**Outcome:** Four implementation classes were supplied for use with the instructor-provided Driver.

### Interaction 3 — Test Verification and Log Request

**Student prompt (verbatim):**

> After running the Driver.java file every test passes. Lets generate the development_log_q3.md file now

**Student contribution:** The student ran the instructor-provided Driver and reported that all tests passed.

**AI assistance:** ChatGPT prepared this development log, summarizing the resources used, the student's design contributions, the generated implementation, and the test result reported by the student.

**Reported test result:** `RESULT: 12 PASSED, 0 FAILED` (reported by the student; not independently re-run for this log).

## Files Involved

- `Driver.java` — instructor-provided verification driver, transcribed into pasteable formatting with AI assistance.
- `Employee.java` — abstract superclass, generated with AI assistance.
- `FullTimeEmployee.java` — full-time and overtime calculation, generated with AI assistance.
- `PartTimeEmployee.java` — straight hourly calculation, generated with AI assistance.
- `Contractor.java` — 15% premium calculation, generated with AI assistance.
- `doc/development_log_q3.md` — AI assistance documentation, generated with AI assistance.

## Complete AI Conversation Transcript

**Required:** Attach or paste the complete AI conversation transcript for the Question 3 interactions, including every student prompt and every ChatGPT response. The summaries above are not substitutes for the complete responses.

**Optional conversation URL:** https://chatgpt.com/share/6adfe2ee-ddcc-83e9-ae3b-160946e363da

The course instructions for Question 3 request the complete transcript, so do not rely solely on the optional URL unless the instructor expressly permits that substitution.

## Disclosure

The student's original design observations and the decision to run the supplied Driver were their own. ChatGPT contributed code transcription, architectural feedback, Java implementation code, explanations, and this development log. The student reported that the resulting implementation passed all 12 Driver tests.
