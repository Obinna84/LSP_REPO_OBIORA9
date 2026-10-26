# Question 2 — AI Development Log

## AI Tool Used

- **Tool:** ChatGPT (OpenAI)
- **Purpose:** Evaluate the object-oriented design of the provided `CourseRegistration` class, discuss architectural alternatives, develop CRC cards, and explain how the proposed design accommodates evolving requirements.
- **Scope:** Question 2, Parts 1–3.
- **Human involvement:** The student identified initial design issues, selected the architectural approach, and directed the development of each deliverable.

## Complete AI Conversation

**Conversation link:** [INSERT SHAREABLE CHATGPT CONVERSATION LINK]

The linked conversation contains the complete prompts and AI responses used while completing Question 2, including the discussion of architectural alternatives and the development of the three deliverables.

The entries below summarize the interactions and identify the student's contributions.

---

## Interaction 1 — Initial Design Evaluation

**Student prompt:**

"After running the driver it looks like everything works for question 1.

Moving onto question 2 - Evaluating Object Oriented Design, based on the code provided the first issues that primarily jump out to me is that Student and Course could be defined classes and maintained as objects. Let me know if my assumption is right and provide any other issues that are apparent from the provided code"

**AI assistance:**

ChatGPT confirmed the student's observation that `Student` and `Course` should be separate classes. It identified additional problems involving low cohesion, excessive coupling, public instance variables, hardcoded tuition rules, and exception handling.

It also discussed connections between these problems and Arthur Riel's object-oriented design heuristics.

**Student contribution:**

Independently identified the lack of separate `Student` and `Course` objects as an initial design weakness.

**Outcome:**

Established the issues to address in `evaluation.md`.

---

## Interaction 2 — Comparing Architectural Alternatives

**Student prompt:**

"explain the trade offs of both options so i can make the best decision"

**AI assistance:**

ChatGPT compared two possible responsibilities for `CourseRegistration`:

1. Representing an individual student's enrollment in a course.
2. Serving as a coordinating service that processes registrations.

It explained the advantages and disadvantages of each approach in terms of cohesion, coupling, extensibility, and complexity. It also discussed an architecture that separates the enrollment record from the registration-processing service.

**Student contribution:**

Requested a comparison of the alternatives before selecting the design.

**Outcome:**

Provided the reasoning needed to make an architectural decision.

---

## Interaction 3 — Selecting the Enrollment Record Design

**Student prompt:**

"It makes more sense for it to serve as an individual enrollment record"

**AI assistance:**

ChatGPT explained how this decision would affect class responsibilities. It proposed keeping `CourseRegistration` focused on enrollment information while assigning workflow coordination to a separate `RegistrationService`.

**Student contribution:**

Personally selected `CourseRegistration` as an individual enrollment record rather than a workflow service.

**Outcome:**

Established the primary architectural decision used throughout the remainder of Question 2.

---

## Interaction 4 — Completing Part 1: Design Evaluation

**Student prompt:**

"alright lets complete part 1 and make sure to use Arthur Riel's design heuristic"

**AI assistance:**

ChatGPT drafted `evaluation.md`, discussing poor abstraction, low cohesion, excessive coupling, lack of encapsulation, hardcoded business rules, and inadequate exception handling.

It related these observations to Arthur Riel's object-oriented design heuristics and explained how the original implementation could be improved.

**Student contribution:**

Directed the evaluation to use Arthur Riel's heuristics and retained the original observation about separating `Student` and `Course`.

**Outcome:**

Produced the draft of `evaluation.md`.

---

## Interaction 5 — Completing Part 2: CRC Cards

**Student prompt:**

"now lets complete the crc cards per part 2"

**AI assistance:**

ChatGPT drafted `design.md` with eight CRC cards:

- `Student`
- `Course`
- `CourseRegistration`
- `RegistrationService`
- `TuitionCalculator`
- `RegistrationRepository`
- `FileRegistrationRepository`
- `NotificationService`

Each CRC card identified the class's responsibilities and collaborators.

The design incorporated the student's decision to treat `CourseRegistration` as an enrollment record and introduced interfaces for storage and notification responsibilities.

**Student contribution:**

Directed the creation of the CRC cards using the previously selected architecture.

**Outcome:**

Produced the draft of `design.md`.

---

## Interaction 6 — Completing Part 3: Evolving Requirements

**Student prompt:**

"Alright now we can work on part 3 where we must explain how this design would accommodate a local file or database for the registration records. It should also support sending confirmations by email or text. We also need to identify changes that would have to be made to the produced crc cards, and justify class ownership"

**AI assistance:**

ChatGPT drafted `design_rationale.md`, explaining how the design accommodates alternative storage and notification implementations.

It proposed adding:

- `DatabaseRegistrationRepository`
- `EmailNotificationService`
- `TextNotificationService`

It also proposed updating the `Student` CRC card to include phone contact information and clarifying the responsibilities of `RegistrationService`.

The response justified class ownership and explained why storage and notification details should remain separate from the enrollment record.

**Student contribution:**

Specified the evolving requirements, requested identification of CRC changes, and emphasized justification of class ownership.

**Outcome:**

Produced the draft of `design_rationale.md`.

---

## Interaction 7 — Preparing the AI Development Log

**Student prompt:**

"now similar to the development_log we generated for question 1 we should generate one for question 2"

**AI assistance:**

ChatGPT organized the Question 2 interactions into a development log, preserving the student's prompts and summarizing the AI's contributions, the student's decisions, and the resulting deliverables.

**Outcome:**

Produced `development_log_q2.md`.

---

## Final Design Decisions

The following decisions guided the proposed design:

1. `Student` and `Course` should be modeled as independent classes.
2. `CourseRegistration` should represent an individual enrollment record, not a registration-processing service.
3. `RegistrationService` should coordinate the registration workflow.
4. Tuition calculation should be separated from enrollment management.
5. Persistence should be abstracted through `RegistrationRepository`.
6. Confirmations should be abstracted through `NotificationService`.
7. Concrete storage and notification implementations should own their respective technical details.

The student independently proposed the first decision and explicitly selected the second after reviewing alternatives presented by ChatGPT. The remaining design elements were developed with AI assistance.

## Deliverables Produced With AI Assistance

| File | Purpose |
|---|---|
| `evaluation.md` | Critique the original design using object-oriented principles and Arthur Riel's heuristics |
| `design.md` | Present the improved design using CRC cards |
| `design_rationale.md` | Explain how the design accommodates changing storage and notification requirements |
| `development_log_q2.md` | Document AI assistance and student contributions |

## References and Resources

- **Arthur J. Riel, *Object-Oriented Design Heuristics* (1996).** Referenced for object-oriented design principles involving class responsibilities, cohesion, coupling, and encapsulation.
- **Question 2 midterm instructions and provided `CourseRegistration` code.** Used as the basis for the design evaluation and proposed improvements.
- **ChatGPT conversation.** Used for design discussion, drafting, and organizing the deliverables. The complete interaction is available through the conversation link above.

## AI Assistance Disclosure

ChatGPT was used to analyze the supplied code, discuss design alternatives, generate draft CRC cards, explain evolving requirements, and prepare written documentation.

The student's original contribution included identifying the need for separate `Student` and `Course` classes, evaluating the proposed architectural alternatives, and choosing to model `CourseRegistration` as an individual enrollment record.

All Question 2 deliverables were developed with the assistance described above.