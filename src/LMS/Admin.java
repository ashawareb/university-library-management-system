package LMS;

/**
 * Admin class is used to do all admin operation
 */
import static LMS.Control.admins;
import static LMS.Control.books;
import static LMS.Control.chAdminEmail;
import static LMS.Control.chAdminUsername;
import static LMS.Control.chStdEmail;
import static LMS.Control.chStdUsername;
import static LMS.Control.getValidInt;
import static LMS.Control.mainPage;
import java.util.Scanner;

/**
 *
 * @author AbdUlRahman Shawareb
 */
public class Admin {

    /**
     * admin name
     */
    private String name;
    /**
     * admin username
     */
    private String username;
    /**
     * admin email
     */
    private String email;
    /**
     * admin password
     */
    private String password;
    /**
     * Scanner to take input
     */
    private Scanner input;

    /**
     * default constructor
     */
    public Admin() {
        input = new Scanner(System.in);
    }

    /**
     * intial method is used to intialize admin to defualt value
     */
    public void intial() {
        this.name = "admin";
        this.username = "admin";
        this.email = "admin";
        this.password = "admin";
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
     * adminMainPage method is used after logging in as admin to show admin
     * options add new admin, edit information, update book information, add new
     * book, show all books, log out
     */
    public void adminMainPage() {
        int choice;
        System.out.println("1 - Add new admin");
        System.out.println("2 - Edit personal information");
        System.out.println("3 - Update book information");
        System.out.println("4 - Add new book");
        System.out.println("5 - Show all books");
        System.out.println("6 - Log out");
        System.out.print("Enter your choice : ");
        choice = getValidInt();
        while (choice < 1 || choice > 6) {
            System.out.println("Invalid input");
            choice = getValidInt();
        }
        if (choice == 1) {
            addAdmin();
            adminMainPage();
        } else if (choice == 2) {
            editInformation();
            adminMainPage();
        } else if (choice == 3) {
            updateBookInformation();
            adminMainPage();
        } else if (choice == 4) {
            addNewBook();
            adminMainPage();
        } else if (choice == 5) {
            showAllBooks();
            adminMainPage();
        } else {
            mainPage();
        }
    }

    /**
     * addAdmin method is used to add new admin and store it in amdins arrayList
     */
    public void addAdmin() {
        Admin ob = new Admin();
        String in;
        System.out.print("Name : ");
        in = input.next();
        ob.setName(in);
        System.out.print("Username : ");
        in = input.next();
        while (chStdUsername(in) || chAdminUsername(in)) {
            System.out.print("\tthis username already exists, please try another one : ");
            in = input.next();
        }
        ob.setUsername(in);
        System.out.print("Email : ");
        in = input.next();
        while (chStdEmail(in) || chAdminEmail(in)) {
            System.out.print("\tthis email already exists, please enter another one : ");
            in = input.next();
        }
        ob.setEmail(in);
        System.out.print("Password : ");
        in = input.next();
        ob.setPassword(in);
        admins.add(ob);
        System.out.println("Admin added successfully");

    }

    /**
     * editInformation method is used to edit admin information edit admin name
     * or admin password
     */
    public void editInformation() {
        int choice;
        String flag = getUsername();
        System.out.println("1 - Edit name");
        System.out.println("2 - Edit password");
        choice = getValidInt();
        while (choice < 1 && choice > 2) {
            System.out.println("Invalid input");
            choice = getValidInt();
        }
        if (choice == 1) {
            String in;
            System.out.print("Enter new name : ");
            in = input.next();
            for (int i = 0; i < admins.size(); i++) {
                if (flag.equals(admins.get(i).getUsername())) {
                    admins.get(i).setName(in);
                    break;
                }
            }
        } else {
            // we can add enter old password a new password twice
            String in;
            System.out.print("Enter new password : ");
            in = input.next();
            for (int i = 0; i < admins.size(); i++) {
                if (flag.equals(admins.get(i).getUsername())) {
                    admins.get(i).setPassword(in);
                    break;
                }
            }

        }
    }

    /**
     * updateBookInformation method is used to edit book information admin can
     * edit book name, book category, book author, book publication year book
     * isbn
     */
    public void updateBookInformation() {
        int choice, bID, in1;
        String in;
        if (books.size() == 0) {
            System.out.println("No books to update.");
            return;
        } else {
            System.out.print("Enter book ID : ");
            bID = getValidInt();
            while (bID <= 0 || bID > books.size()) {
                System.out.println("No book with this ID");
                bID = getValidInt();
            }
            System.out.println("1 - Update book name");
            System.out.println("2 - Update book category");
            System.out.println("3 - Update book author");
            System.out.println("4 - Update book publication year");
            System.out.println("5 - Update book ISBN");
            choice = getValidInt();
            while (choice < 1 || choice > 5) {
                System.out.println("Invalid choice");
                choice = getValidInt();
            }
            if (choice == 1) {
                System.out.print("Enter new name : ");
                in = input.next();
                books.get(bID - 1).setName(in);
            } else if (choice == 2) {
                System.out.print("Enter new category : ");
                in = input.next();
                books.get(bID - 1).setCategory(in);
            } else if (choice == 3) {
                System.out.print("Enter new author name : ");
                in = input.next();
                books.get(bID - 1).setAuthor(in);
            } else if (choice == 4) {
                System.out.print("Enter new publication year : ");
                in1 = getValidInt();
                books.get(bID - 1).setPyear(in1);

            } else {
                System.out.print("Enter new ISBN : ");
                in1 = getValidInt();
                books.get(bID - 1).setIsbn(in1);
            }
        }
    }

    /**
     * addNewBook method is used to add new book and store it in books arrayList
     */
    public void addNewBook() {
        Book ob = new Book();
        ob.setData(books.size() + 1);
        books.add(ob);
        System.out.println("Book added succefully");
    }

    /**
     * showAllBooks method is used to print all books
     */
    public void showAllBooks() {
        if (books.size() == 0) {
            System.out.println("No books.");
            return;
        } else {
            for (int i = 0; i < books.size(); i++) {
                System.out.print(books.get(i).toString());
                System.out.println("________________________________________________");
            }
        }
    }

}
