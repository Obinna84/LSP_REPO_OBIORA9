package org.howard.edu.lsp.midterm.crccards;

public class Book {

    private String isbn;
    private String title;
    private String author;
    private boolean available;

    /**
     * Constructs a new book with the specified information.
     * All newly created books are initially available.
     *
     * @param isbn the ISBN identifying the book
     * @param title the title of the book
     * @param author the author of the book
     */
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    /**
     * Returns the ISBN of the book.
     *
     * @return the book's ISBN
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Returns the title of the book.
     *
     * @return the book's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the author of the book.
     *
     * @return the book's author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns whether the book is currently available.
     *
     * @return true if available, false if borrowed
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Borrows the book if it is currently available.
     *
     * @throws IllegalStateException if the book is already borrowed
     */
    public void borrowBook() {
        if (!available) {
            throw new IllegalStateException("Book is already borrowed.");
        }

        available = false;
    }

    /**
     * Returns the book if it is currently borrowed.
     *
     * @throws IllegalStateException if the book is already available
     */
    public void returnBook() {
        if (available) {
            throw new IllegalStateException("Book is already available.");
        }

        available = true;
    }

    /**
     * Returns the book's information and availability status.
     *
     * @return the formatted book information
     */
    @Override
    public String toString() {
        String status = available ? "[AVAILABLE]" : "[BORROWED]";

        return isbn + " " + title + " by " + author + " " + status;
    }
}
