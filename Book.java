
package project1;

public class Book {
    private String title;
    private String author;
    private boolean isBorrowed;
    private String borrowedBy;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
        this.borrowedBy = "";
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public String getBorrowedBy() {
        return borrowedBy;
    }

    public void borrowBook(String borrower) {
        if (!isBorrowed) {
            isBorrowed = true;
            borrowedBy = borrower;
            System.out.println(borrower + " borrowed " + title);
        } else {
            System.out.println("Book is already borrowed by " + borrowedBy);
        }
    }

    public void returnBook() {
        if (isBorrowed) {
            System.out.println(borrowedBy + " returned " + title);
            isBorrowed = false;
            borrowedBy = "";
        } else {
            System.out.println("Book is not borrowed.");
        }
    }
}
