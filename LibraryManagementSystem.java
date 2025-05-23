
package project1;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        User admin = new User("safa", "PaSs1234");

        System.out.println("=== Library Login ===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (!admin.authenticate(username, password)) {
            System.out.println("Invalid credentials. Exiting.");
            return;
        }

        System.out.println("Login successful. Welcome, " + admin.getName());

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    books.add(new Book(title, author));
                    System.out.println("Book added.");
                    break;
                case "2":
                    System.out.print("Enter title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    boolean foundBorrow = false;
                    for (Book book : books) {
                        if (book.getTitle().equalsIgnoreCase(borrowTitle)) {
                            book.borrowBook(admin.getName());
                            foundBorrow = true;
                            break;
                        }
                    }
                    if (!foundBorrow) System.out.println("Book not found.");
                    break;
                case "3":
                    System.out.print("Enter title to return: ");
                    String returnTitle = scanner.nextLine();
                    boolean foundReturn = false;
                    for (Book book : books) {
                        if (book.getTitle().equalsIgnoreCase(returnTitle)) {
                            book.returnBook();
                            foundReturn = true;
                            break;
                        }
                    }
                    if (!foundReturn) System.out.println("Book not found.");
                    break;
                case "4":
                    System.out.println("Books in Library:");
                    for (Book book : books) {
                        System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor()
                                + (book.isBorrowed() ? " (Borrowed by: " + book.getBorrowedBy() + ")" : " (Available)"));
                    }
                    break;
                case "5":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
