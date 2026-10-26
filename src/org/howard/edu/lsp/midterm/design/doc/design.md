# Question 2 — Part 2: Improved Object-Oriented Design Using CRC Cards

## Design Overview

The proposed design separates the original `CourseRegistration` class into several classes with distinct responsibilities. `Student` and `Course` represent independent domain entities, while `CourseRegistration` represents an individual student's enrollment in a course.

A `RegistrationService` coordinates the registration process by collaborating with components responsible for tuition calculation, persistence, and notifications. This separation improves cohesion, reduces coupling, and follows Arthur Riel's heuristic that a class should capture one key abstraction.

---

### CRC Card 1

**Class:** Student

**Responsibilities:**
- Maintain student information, including student ID, name, and contact information.
- Provide controlled access to student attributes.
- Validate student information when necessary.

**Collaborators:** None

### CRC Card 2

**Class:** Course

**Responsibilities:**
- Maintain course information, including course code and credit hours.
- Provide controlled access to course attributes.
- Validate course information, such as ensuring credit hours are nonnegative.

**Collaborators:** None

### CRC Card 3

**Class:** CourseRegistration

**Responsibilities:**
- Represent an individual student's enrollment in a particular course.
- Maintain references to the associated Student and Course objects.
- Store enrollment-specific information, including tuition charged and registration status.
- Provide access to registration details and maintain valid enrollment state.

**Collaborators:** Student, Course

### CRC Card 4

**Class:** RegistrationService

**Responsibilities:**
- Coordinate the registration process.
- Request tuition calculations for a student's selected course.
- Create a CourseRegistration record.
- Coordinate persistence of the registration record.
- Request confirmation after the registration has been successfully saved.
- Handle registration failures appropriately.

**Collaborators:** Student, Course, CourseRegistration, TuitionCalculator, RegistrationRepository, NotificationService

### CRC Card 5

**Class:** TuitionCalculator

**Responsibilities:**
- Calculate tuition based on course credit hours.
- Apply the tuition rate of $750 per credit hour.
- Apply the 10% discount when the applicable credit-hour total is at least 12.
- Keep tuition calculation rules separate from enrollment management.

**Collaborators:** Course

### CRC Card 6

**Class:** RegistrationRepository (Interface)

**Responsibilities:**
- Define operations for saving and retrieving registration records.
- Abstract the underlying storage mechanism from registration processing.
- Establish a consistent persistence contract for different storage implementations.

**Collaborators:** CourseRegistration

### CRC Card 7

**Class:** FileRegistrationRepository

**Responsibilities:**
- Implement the RegistrationRepository persistence operations using local file storage.
- Save registration information to the designated file.
- Handle file-related errors and communicate persistence failures.

**Collaborators:** RegistrationRepository, CourseRegistration

### CRC Card 8

**Class:** NotificationService (Interface)

**Responsibilities:**
- Define operations for sending registration confirmations.
- Provide an abstraction for different notification mechanisms.
- Keep notification responsibilities separate from registration processing.

**Collaborators:** Student, CourseRegistration

---

## Design Rationale

The proposed design addresses the original implementation's low cohesion by distributing unrelated responsibilities among specialized classes. `Student`, `Course`, and `CourseRegistration` manage domain information, while `RegistrationService` coordinates the overall registration workflow.

`TuitionCalculator` owns tuition policies, preventing changes in pricing rules from affecting enrollment records. `RegistrationRepository` and `NotificationService` establish abstractions for persistence and communication, reducing the registration workflow's dependency on specific implementation mechanisms.

The design also improves encapsulation by allowing domain objects to maintain their own state rather than exposing public instance variables. These changes support maintainability and extensibility while remaining consistent with the principles discussed in the Part 1 evaluation.