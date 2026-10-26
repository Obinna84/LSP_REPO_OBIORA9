# Question 1 — Development Log

**Course:** CSCI 363 — Large Scale Programming  
**Assessment:** Fall 2026 Midterm Examination  
**Question:** 1 — Implement Classes from CRC Cards

## Resources used

- **OpenAI ChatGPT (GPT-6):** Transcription of the provided verification driver; assistance implementing and documenting `Book.java` and `Library.java`; discussion of Java packages, collection choice, encapsulation, and documentation requirements.
- **Instructor-provided midterm PDF:** *CSCI 363: Large Scale Programming – Midterm Examination*, Fall 2026, Question 1, pages 1–9. Used as the authoritative source for CRC responsibilities, method signatures, behavioral requirements, provided Driver, and grading rubric.
- **Other websites, lecture notes, or textbooks:** None reported in this conversation. Add any additional resources actually consulted, with full URLs for online sources and explanations of their use.

## Complete AI conversation transcript

**Shareable ChatGPT conversation URL:** https://chatgpt.com/share/6adfd993-2e74-83ea-bdf9-43ababc757ff

The link must expose the complete prompts and responses relevant to Question 1. Verify that it works before submission. The summaries below are supplementary and do not substitute for the full transcript.

## Interaction summaries

### Interaction 1 — Recreate instructor Driver.java

**Human prompt (verbatim):**

> I'm working through a midterm that is open AI. We're going to progress question and part at a time. And I'll fill in with design decisions as we go. Attached is a pdf copy of the midterm. For the first step I need you to recreate the Driver.java file under the crccards folder so that I can paste it into its file locally in my IDE

**AI assistance:** Transcribed the instructor-provided `Driver.java` from pages 4–8, explained its package path and expected 44 passing checks, and noted the need for `Book.java` and `Library.java`.

**How it helped:** Provided the verification driver in copyable Java form without manually retyping the PDF.

### Interaction 2 — Begin recording AI assistance

**Human prompt (verbatim):**

> Yes we should document the assistance as we go. If you could start by transcribing at least the summaries of this conversation, while preserving the exact human queries that'd be greatg

**AI assistance:** Drafted an initial development log retaining the first two exact user prompts, summarizing responses, and explaining that complete transcripts are required.

**How it helped:** Established a consistent approach to disclosure and documentation.

### Interaction 3 — Use a shareable conversation link

**Human prompt (verbatim):**

> the shareable link option work

**AI assistance:** Confirmed that a working shareable link to the complete conversation could serve as the transcript reference and described how to add it to the log.

**How it helped:** Avoided manually copying the full AI conversation into the Markdown file.

### Interaction 4 — Implement Book.java

**Human prompt (verbatim):**

> Alright, now that we have Driver.java and the file structure we can move onto question 1. Lets start with the implementation for the Book class which should store book information, maintain availability, validate borrowing/returning, and provide book details. The class should use the fields isbn, title, author, and available.
>
> Additional Structural Info:
> public Book(String isbn, String title, String author)
>
> public String getIsbn()
>
> public String getTitle()
>
> public String getAuthor()
>
> public boolean isAvailable()
>
> public void borrowBook()
>
> public void returnBook()
>
> public String toString()
>
> • borrowBook() makes an available book unavailable; otherwise it throws IllegalStateException.
>
> • returnBook() makes an unavailable book available; otherwise it throws IllegalStateException.
>
> • Availability cannot be modified directly by other classes.
>
> • toString() format: B101 Effective Java by Joshua Bloch [AVAILABLE]. Use [BORROWED] when unavailable.

**AI assistance:** Generated `Book.java` with private fields, a constructor initializing availability to true, getters, guarded borrowing and returning operations, a formatted `toString()`, and Javadoc.

**How it helped:** Supplied a proposed implementation of the Book CRC responsibilities and explained encapsulation and state validation.

### Interaction 5 — Implement Library.java

**Human prompt (verbatim):**

> Okay lets fill out the library class in the same way. The functions of the library class include (Maintain books; add and find books; coordinate borrowing/returning; enforce borrowing limit; retrieve books by criteria) and the additional info:
>
> public void addBook(Book book)
>
> public Book findBook(String isbn)
>
> public void borrowBook(String isbn)
>
> public void returnBook(String isbn)
>
> public List<Book> getAvailableBooks()
>
> public List<Book> getBooksByAuthor(String author)
>
> public List<Book> getBooksSortedByIsbn()
>
> public int getBorrowedBookCount()
>
> • Duplicate ISBNs are prohibited: addBook() throws IllegalArgumentException and preserves the original book.
>
> • findBook() returns the matching Book instance, or null if absent.
>
> • No more than three books may be borrowed from the Library at one time.
>
> • Library borrowing and returning operations must locate the Book and delegate its state change to the Book.
>
> • Borrowing or returning an ISBN not in the Library throws IllegalArgumentException.
>
> • Borrowing an already borrowed book, returning an available book, or exceeding the three-book limit throws
>
> IllegalStateException.
>
> • Failed operations must not change the collection, the borrowing count, or book availability.
>
> • getAvailableBooks() returns all and only available books; getBooksByAuthor() returns all books matching the author exactly
>
> (case-sensitive), including borrowed books.
>
> • List-returning methods return an empty List when there are no matches; list order is not significant.
>
> getBorrowedBookCount() returns the current number of borrowed books.
>
> getBooksSortedByIsbn() returns all books sorted by ISBN in ascending lexicographical (String) order, regardless of insertion order
>
> or borrowing status. Return an empty List when the Library is empty. The method must not change the Library contents or book
>
> states.
>
> Design assumption: All borrowing and returning of books belonging to a Library occur through Library methods. A standalone
>
> Book may be borrowed or returned directly.

**AI assistance:** Generated `Library.java` using `HashMap<String, Book>` for ISBN lookup and duplicate detection, a three-book limit, delegated Book state changes, retrieval methods, sorting, and Javadoc. Compared HashMap and ArrayList complexity.

**How it helped:** Provided a proposed implementation and rationale for the collection and separation of class responsibilities.

### Interaction 6 — Clarify imports

**Human prompt (verbatim):**

> Given library is stored in a seperate file, it should import the Book class for its implementation

**AI assistance:** Explained that separate Java files in the same declared package can reference one another without an import statement.

**How it helped:** Clarified Java package organization and avoided an unnecessary import.

### Interaction 7 — Distinguish Javadoc from the development log

**Human prompt (verbatim):**

> I notice that we are providing javadocs as we go in both the Book.java and Library.java file, however i'm not sure this is necessary given we will have to duplicate said information in the development_log.md file as well

**AI assistance:** Explained that Javadoc documents class and method behavior, whereas the development log discloses development resources and assistance; both are separately graded.

**How it helped:** Supported the decision to retain Javadoc while avoiding redundant method descriptions in this log.

### Interaction 8 — Create the log and provide run commands

**Human prompt (verbatim):**

> okay sounds good, lets create the development_log.md file for question 1, additionally can you provide the commands needed to run Driver.java from the project root

**AI assistance:** Created this Markdown log and supplied terminal commands to compile the Java files and run the fully qualified Driver class from the repository root.

**How it helped:** Prepared the disclosure artifact and gave a reproducible way to execute the instructor tests. **Testing has not yet been confirmed by the user.**

## Testing status

The instructor's expected result is `44 PASSED, 0 FAILED` and `FUNCTIONAL SCORE: 25.00 / 25`. Actual execution results have not yet been provided; update this section after running the Driver.

## Before submission

Replace the transcript placeholder with a working shareable link, verify that the link includes the complete relevant exchange, and update this log with any additional resources, code changes, and testing outcomes.
