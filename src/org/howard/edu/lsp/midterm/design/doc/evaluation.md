# Question 2 — Part 1: Object-Oriented Design Evaluation

The provided `CourseRegistration` class exhibits several object-oriented design issues that negatively affect its cohesion, encapsulation, maintainability, and extensibility. These issues can be evaluated using Arthur Riel's object-oriented design heuristics.

### 1. Poor Abstraction and Responsibility Assignment

The `CourseRegistration` class maintains attributes belonging to distinct entities, including `studentId`, `studentName`, `email`, `courseCode`, and `creditHours`. These attributes could be better represented through separate `Student` and `Course` classes, with `CourseRegistration` representing an individual enrollment record.

This relates to Riel's heuristic **2.1: "All data should be hidden within its class."** Properly distributing the attributes among their respective classes would improve encapsulation and clarify which class is responsible for maintaining each piece of information.

### 2. Low Cohesion and Excessive Responsibilities

The `registerStudent()` method performs several unrelated operations, including tuition calculation, discount application, printing registration information, file persistence, sending confirmation messages, and logging.

This conflicts with Riel's heuristic **2.8: "A class should capture one and only one key abstraction."** Rather than representing a single abstraction, `CourseRegistration` combines enrollment information with responsibilities belonging to several other components.

Consequently, modifying the tuition policy or notification mechanism could require changes to the registration class, increasing maintenance costs and the likelihood of introducing errors.

### 3. Excessive Coupling Between Components

The class directly depends on `FileWriter` to store registration records and `System.out.println()` to produce confirmations and logging output.

Riel's heuristic **2.9: "Keep related data and behavior in one place"** emphasizes the importance of organizing responsibilities around the information they manage. Persistence and notification operations should be delegated to components responsible for those functions rather than embedded directly within the enrollment class.

The current implementation creates unnecessary coupling between registration logic and specific implementation mechanisms. For example, replacing local file storage with database storage would require modifying `CourseRegistration`.

### 4. Lack of Encapsulation

All instance variables are declared `public`, allowing external classes to modify student and course information without validation.

This directly conflicts with Riel's heuristic **2.1**, which emphasizes information hiding within classes.

For example, external code could assign a negative value to `creditHours`, producing an invalid tuition calculation. Private attributes and controlled access methods would help preserve valid object states.

### 5. Hardcoded Business Rules

The tuition rate of $750 per credit hour, the 12-credit discount threshold, and the 10% discount are embedded directly in `registerStudent()`.

This contributes to the class's low cohesion because tuition policy is a separate responsibility from maintaining an enrollment record. A dedicated tuition calculation component would localize these rules, making them easier to update without affecting unrelated registration behavior.

### 6. Inadequate Exception Handling and Error Management

The method catches a general `Exception` when writing registration records and only prints the stack trace. Execution then continues to the confirmation and logging operations even when the registration was not successfully saved.

This creates a correctness issue because the system may indicate that a registration was processed despite a persistence failure.

The registration workflow should handle persistence failures explicitly and prevent successful confirmation when the underlying registration operation has failed.

### Conclusion

The primary weaknesses of the provided `CourseRegistration` class are poor abstraction, low cohesion, excessive coupling, and insufficient encapsulation. Applying Riel's design heuristics would encourage a clearer separation of responsibilities among domain objects and supporting components.

A redesigned system should represent `Student`, `Course`, and `CourseRegistration` as distinct domain classes while delegating tuition calculation, persistence, notifications, and workflow coordination to appropriate collaborators. This would improve maintainability, extensibility, and correctness without placing unrelated responsibilities inside a single class.