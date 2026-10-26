
package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;

public class Library {

    private Map<String, Book> books;
    private int borrowedBookCount;
    private static final int BORROW_LIMIT = 3;

    /**
     * Constructs an empty library with no borrowed books.
     */
    public Library() {
        books = new HashMap<>();
        borrowedBookCount = 0;
    }

    /**
     * Adds a book to the library.
     * Books with duplicate ISBNs are not permitted.
     *
     * @param book the book to add
     * @throws IllegalArgumentException if the ISBN already exists
     */
    public void addBook(Book book) {
        if (books.containsKey(book.getIsbn())) {
            throw new IllegalArgumentException(
                "A book with this ISBN already exists."
            );
        }

        books.put(book.getIsbn(), book);
    }

    /**
     * Finds a book in the library using its ISBN.
     *
     * @param isbn the ISBN of the book to locate
     * @return the matching Book object, or null if not found
     */
    public Book findBook(String isbn) {
        return books.get(isbn);
    }

    /**
     * Borrows a book from the library.
     * Delegates the availability change to the Book class.
     *
     * @param isbn the ISBN of the book to borrow
     * @throws IllegalArgumentException if the book does not exist
     * @throws IllegalStateException if the book is already borrowed
     *         or the borrowing limit has been reached
     */
    public void borrowBook(String isbn) {
        Book book = findBook(isbn);

        if (book == null) {
            throw new IllegalArgumentException(
                "Book not found in library."
            );
        }

        if (!book.isAvailable()) {
            throw new IllegalStateException(
                "Book is already borrowed."
            );
        }

        if (borrowedBookCount >= BORROW_LIMIT) {
            throw new IllegalStateException(
                "Library borrowing limit reached."
            );
        }

        book.borrowBook();
        borrowedBookCount++;
    }

    /**
     * Returns a previously borrowed book to the library.
     * Delegates the availability change to the Book class.
     *
     * @param isbn the ISBN of the book to return
     * @throws IllegalArgumentException if the book does not exist
     * @throws IllegalStateException if the book is already available
     */
    public void returnBook(String isbn) {
        Book book = findBook(isbn);

        if (book == null) {
            throw new IllegalArgumentException(
                "Book not found in library."
            );
        }

        book.returnBook();
        borrowedBookCount--;
    }

    /**
     * Retrieves all books that are currently available.
     *
     * @return a list of available books
     */
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();

        for (Book book : books.values()) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }

        return availableBooks;
    }

    /**
     * Retrieves all books written by the specified author.
     * Author matching is case-sensitive and includes
     * both available and borrowed books.
     *
     * @param author the author to search for
     * @return a list of books matching the author
     */
    public List<Book> getBooksByAuthor(String author) {
        List<Book> authorBooks = new ArrayList<>();

        for (Book book : books.values()) {
            if (book.getAuthor().equals(author)) {
                authorBooks.add(book);
            }
        }

        return authorBooks;
    }

    /**
     * Retrieves all library books sorted by ISBN
     * in ascending lexicographical order.
     * Does not modify the library's internal collection.
     *
     * @return a list of books sorted by ISBN
     */
    public List<Book> getBooksSortedByIsbn() {
        List<Book> sortedBooks = new ArrayList<>(books.values());

        sortedBooks.sort(
            Comparator.comparing(Book::getIsbn)
        );

        return sortedBooks;
    }

    /**
     * Returns the number of books currently borrowed
     * from the library.
     *
     * @return the current borrowed book count
     */
    public int getBorrowedBookCount() {
        return borrowedBookCount;
    }
}
