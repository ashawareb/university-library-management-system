package LMS;

/**
 * Student class is used to do all student operation
 */
import static LMS.Control.books;
import static LMS.Control.getValidInt;
import static LMS.Control.mainPage;
import static LMS.Control.students;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author AbdUlRahman Shawareb
 */
public class Student {

    /**
     * student name
     */
    private String name;
    /**
     * student username
     */
    private String username;
    /**
     * student email
     */
    private String email;
    /**
     * student password
     */
    private String password;
    /**
     * Scanner to take input
     */
    private Scanner input;
    /**
     * ArrayList to store books which student borrow
     */
    private ArrayList<Book> stdBooks;

    /**
     * default constructor
     */
    public Student() {
        input = new Scanner(System.in);
        stdBooks = new ArrayList<Book>();
    }

    /**
     * method to set name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method to set username
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * method to set email
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * method to set password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * method to return name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * method to return username
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * method to return email
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * method to return password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * stdMainPage method is used after logging in as students and shows
     * students five options edit information browse for book borrow book show
     * all student books log out
     */
    public void stdMainPage() {
        int choice = 0;
        System.out.println("1 - Edit information");
        System.out.println("2 - Browse for book");
        System.out.println("3 - Borrow book");
        System.out.println("4 - Show all your books");
        System.out.println("5 - Log out");
        System.out.println("Enter your choice : ");
        choice = getValidInt();
        while (choice < 1 || choice > 5) {
            System.out.println("Invalid input");
            choice = getValidInt();
        }
        if (choice == 1) {
            editInformation();
            stdMainPage();
        } else if (choice == 2) {
            browseBook();
            stdMainPage();
        } else if (choice == 3) {
            borrowBook();
            stdMainPage();
        } else if (choice == 4) {
            showAllBooks();
            stdMainPage();
        } else {
            mainPage();
        }
    }

    /**
     * editInformation method is used to edit student information like name and
     * password to change them
     */
    public void editInformation() {
        int choice = 0;
        String flag = getUsername();
        System.out.println("1 - Edit name");
        System.out.println("2 - Edit password");
        choice = getValidInt();
        while (choice < 1 || choice > 2) {
            System.out.println("Invalid input");
            choice = getValidInt();
        }
        if (choice == 1) {
            String in;
            System.out.print("Enter new name : ");
            in = input.next();
            for (int i = 0; i < students.size(); i++) {
                if (flag.equals(students.get(i).getUsername())) {
                    students.get(i).setName(in);
                    break;
                }
            }
        } else {
            // we can add enter old password a new password twice
            String in;
            System.out.print("Enter new password : ");
            in = input.next();
            for (int i = 0; i < students.size(); i++) {
                if (flag.equals(students.get(i).getUsername())) {
                    students.get(i).setPassword(in);
                    break;
                }
            }

        }
    }

    /**
     * browseBook method is used to make student able to browse for book by its
     * name, id, category, author name, publication year or ISBN
     */
    public void browseBook() {
        int choice;
        int in1;
        String in;
        System.out.println("Browse by : ");
        System.out.println("\t 1 - Book Name");
        System.out.println("\t 2 - Book ID");
        System.out.println("\t 3 - Book category");
        System.out.println("\t 4 - Book author");
        System.out.println("\t 5 - Book publication year");
        System.out.println("\t 6 - Book ISBN");
        System.out.print("Enter your choice : ");
        choice = getValidInt();
        while (choice < 1 || choice > 6) {
            System.out.println("Invalid choice");
            choice = getValidInt();
        }
        if (choice == 1) {
            boolean sign = false;
            System.out.print("Enter book name : ");
            in = input.next();
            for (int i = 0; i < books.size(); i++) {
                if (in.equalsIgnoreCase(books.get(i).getName())) {
                    sign = true;
                    System.out.println(books.get(i).toString());
                    System.out.println("_________________________________________");
                }
            }
            if (!sign) {
                System.out.println("No books with that name");
            }

        } else if (choice == 2) {
            System.out.print("Enter book ID : ");
            in1 = getValidInt();
            while (in1 <= 0 || in1 > books.size()) {
                System.out.print("Invalid ID, please enter book ID again : ");
                in1 = getValidInt();
            }
            System.out.println(books.get(in1 - 1).toString());
            System.out.println("_________________________________________");
        } else if (choice == 3) {
            boolean sign = false;
            System.out.print("Enter book category : ");
            in = input.next();
            for (int i = 0; i < books.size(); i++) {
                if (in.equalsIgnoreCase(books.get(i).getCategory())) {
                    sign = true;
                    System.out.println(books.get(i).toString());
                    System.out.println("_________________________________________");
                }
            }
            if (!sign) {
                System.out.println("No books with this category");
            }

        } else if (choice == 4) {
            boolean sign = false;
            System.out.print("Enter book author name : ");
            in = input.next();
            for (int i = 0; i < books.size(); i++) {
                if (in.equalsIgnoreCase(books.get(i).getAuthor())) {
                    sign = true;
                    System.out.println(books.get(i).toString());
                    System.out.println("_________________________________________");
                }
            }
            if (!sign) {
                System.out.println("No book with this author name");
            }
        } else if (choice == 5) {
            boolean sign = false;
            System.out.print("Enter book publiction year : ");
            in1 = getValidInt();
            for (int i = 0; i < books.size(); i++) {
                if (in1 == books.get(i).getPyear()) {
                    sign = true;
                    System.out.println(books.get(i).toString());
                    System.out.println("_________________________________________");
                }
            }
            if (!sign) {
                System.out.println("No books with this publication year");
            }
        } else {
            boolean sign = false;
            System.out.print("Enter book ISBN : ");
            in1 = getValidInt();
            for (int i = 0; i < books.size(); i++) {
                if (in1 == books.get(i).getIsbn()) {
                    sign = true;
                    System.out.println(books.get(i).toString());
                    System.out.println("_________________________________________");
                }
            }
            if (!sign) {
                System.out.println("No books with this ISBN");
            }
        }

    }

    /**
     * insertBook method is used to insert book in stdBooks arrayList when
     * student want to borrow book
     *
     * @param in
     */
    public void insertBook(Book in) {
        stdBooks.add(in);
    }

    /**
     * borrowBook method is used to borrow book from the avilable books and
     * store it in stdBooks
     */
    public void borrowBook() {
        int bID;
        String flag = getUsername();
        Book in = new Book();
        if (books.size() == 0) {
            System.out.println("No books to borrow.");
            return;
        } else {
            System.out.print("Enter book ID : ");
            bID = getValidInt();
            while (bID < 1 || bID > books.size()) {
                System.out.println("No book with this ID, please enter ID again : ");
                bID = getValidInt();
            }
            in = books.get(bID - 1);
            for (int i = 0; i < students.size(); i++) {
                if (flag.equals(students.get(i).getUsername())) {
                    students.get(i).insertBook(in);
                    break;
                }
            }
            System.out.println("Book added succesfully to your list");
        }

    }

    /**
     * printStdBooks method is used to print books data
     */
    public void printStdBooks() {
        if (stdBooks.size() == 0) {
            System.out.println("You do not have any books.");
            return;
        } else {
            for (int i = 0; i < stdBooks.size(); i++) {
                System.out.println(stdBooks.get(i).toString());
                System.out.println("_________________________________________");

            }
        }
    }

    /**
     * showAllBooks method is used to print all the books which the student
     * borrowed
     */
    public void showAllBooks() {
        String flag = getUsername();
        for (int i = 0; i < students.size(); i++) {
            if (flag.equals(students.get(i).getUsername())) {
                students.get(i).printStdBooks();
                break;
            }
        }
    }

}
