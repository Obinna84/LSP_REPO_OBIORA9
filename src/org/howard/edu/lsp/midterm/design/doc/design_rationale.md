# Question 2 — Part 3: Evolving Requirements and Design Rationale

## Accommodating Multiple Registration Storage Methods

The proposed design accommodates storing registration records in either a local file or a database through the `RegistrationRepository` interface. This interface defines the operations required to save and retrieve `CourseRegistration` objects without specifying how the data must be stored.

The existing `FileRegistrationRepository` class implements this interface using local file storage. To accommodate database storage, a new `DatabaseRegistrationRepository` class would be introduced to implement the same interface using database operations.

`RegistrationService` would depend on the `RegistrationRepository` interface rather than directly using either concrete implementation. This allows the system to select a file-based or database-based repository without changing the registration workflow.

This separation reduces coupling and improves extensibility. Database connection management, SQL operations, and file-writing operations belong to their respective repository implementations, not to `CourseRegistration` or `RegistrationService`.

## Accommodating Email and Text Confirmations

The design accommodates both email and text-message confirmations through the `NotificationService` interface, which defines the operation for sending a registration confirmation.

Two concrete implementations would be introduced:

- `EmailNotificationService`, responsible for sending confirmations to a student's email address.
- `TextNotificationService`, responsible for sending confirmations to a student's phone number.

Both implementations would follow the same notification interface, allowing `RegistrationService` to request a confirmation without knowing whether it will be delivered by email or text.

The `Student` CRC card would be updated to include an optional phone number and validation of the contact information required for the selected notification method.

This design makes it possible to change the confirmation mechanism without modifying the enrollment record or the registration-processing workflow.

## Required CRC Card Changes

The following modifications would be made to the CRC cards produced in Part 2.

### Modified CRC Card: Student

**Additional responsibilities:**
- Maintain an optional phone number.
- Provide controlled access to email and phone contact information.
- Validate contact information as appropriate.

**Collaborators:** None

### Modified CRC Card: RegistrationService

**Clarified responsibilities:**
- Coordinate registration using a configured `RegistrationRepository` implementation.
- Request confirmations through a configured `NotificationService` implementation.
- Ensure a registration is successfully saved before requesting confirmation.
- Handle storage or notification failures appropriately.

**Collaborators:** Student, Course, CourseRegistration, TuitionCalculator, RegistrationRepository, NotificationService

### New CRC Card: DatabaseRegistrationRepository

**Responsibilities:**
- Implement the `RegistrationRepository` interface using database storage.
- Save and retrieve registration records.
- Manage database interactions and report persistence failures.

**Collaborators:** RegistrationRepository, CourseRegistration

### New CRC Card: EmailNotificationService

**Responsibilities:**
- Implement the `NotificationService` interface for email delivery.
- Retrieve the student's email address.
- Format and send registration confirmation emails.
- Report delivery failures.

**Collaborators:** NotificationService, Student, CourseRegistration

### New CRC Card: TextNotificationService

**Responsibilities:**
- Implement the `NotificationService` interface for text-message delivery.
- Retrieve the student's phone number.
- Format and send registration confirmation text messages.
- Report delivery failures.

**Collaborators:** NotificationService, Student, CourseRegistration

The remaining CRC cards do not require changes because their responsibilities are unaffected by the new storage and communication requirements.

## Justification of Class Ownership

The design assigns responsibilities according to the information and behavior each class owns, following Arthur Riel's emphasis on cohesion, encapsulation, and appropriate responsibility assignment.

**Student** owns contact information because email addresses and phone numbers describe the student, not an individual enrollment.

**CourseRegistration** owns the relationship between a student and a course, along with enrollment-specific information such as tuition charged and registration status. It should not be responsible for persisting itself or sending notifications because those operations are independent of the enrollment record's state.

**RegistrationService** owns workflow coordination because successful registration requires interactions among multiple collaborators. It delegates specialized tasks rather than implementing those tasks directly.

**RegistrationRepository** defines the persistence contract, while `FileRegistrationRepository` and `DatabaseRegistrationRepository` own their respective storage implementations. This keeps storage-specific operations localized and prevents changes in storage technology from affecting the domain classes.

**NotificationService** defines the confirmation contract, while `EmailNotificationService` and `TextNotificationService` own the details of their respective communication mechanisms. These responsibilities belong in separate classes because each communication channel has different formatting, delivery, and error-handling requirements.

**TuitionCalculator** continues to own tuition rules because those rules are unrelated to either storage or notification methods.

## Conclusion

The revised design supports both evolving requirements by introducing alternative implementations of the existing repository and notification interfaces.

Rather than modifying `CourseRegistration` whenever storage or communication requirements change, the system delegates those responsibilities to specialized classes. This preserves the enrollment record as a focused domain object, minimizes coupling, and allows the registration workflow to remain consistent as new technologies are introduced.

The resulting design demonstrates how clear class ownership and responsibility assignment make an object-oriented system easier to extend and maintain.