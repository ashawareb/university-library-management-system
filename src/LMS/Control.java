package LMS;

/**
 * Control class is used to connect all classes together and do show the main
 * pages
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author AbdUlRahman Shawareb
 */
public class Control {

    /**
     * Variable to set default admin
     */
    private Admin intial;
    /**
     * ArrayList to store all admins
     */
    public static ArrayList<Admin> admins = new ArrayList<Admin>();
    /**
     * ArrayList to store all students
     */
    public static ArrayList<Student> students = new ArrayList<Student>();
    /**
     * ArrayList to store all books
     */
    public static ArrayList<Book> books = new ArrayList<Book>();
    /**
     * Scanner to take input
     */
    public static Scanner input;

    /**
     * Default constructor for initializing the admin attribute
     */
    public Control() {
        input = new Scanner(System.in);
        intial = new Admin();
        intial.intial();
        admins.add(intial);
    }

    /**
     * getValidInt method is used to ensure the entered input is integer
     *
     * @return integer
     */
    public static int getValidInt() {
        boolean flag = false;
        int choice = 0;
        do {
            flag = false;
            try {
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                flag = true;
                System.out.println("Invalid digit, please enter input again : ");
            }
            input.nextLine();
        } while (flag);
        return choice;
    }

    /**
     * mainPage method is used to show the main page of the program when it
     * starts and show the user two options log in and sign up. if the user
     * chose sign up then the mainPage method call signUp method if the use
     * chose to log in then the mainPage method call logIn method
     */
    public static void mainPage() {
        int choice = 0;
        System.out.println("Welcome to the library mangement system : ");
        System.out.println("\t1 - Sign Up");
        System.out.println("\t2 - Log In");
        System.out.println("Enter your choice : ");
        choice = getValidInt();
        while (choice < 1 || choice > 2) {
            System.out.println("Invalid input");
            choice = getValidInt();
        }
        if (choice == 1) {
            signUp();
        } else {
            logIn();
        }
    }

    /**
     * signUp method is used to sign up new user as a student and save the new
     * user in students arrayList if the entered username is already exist then
     * the program keep asking for valid username if the entered email is
     * already exist then the program keep asking for valid email then back to
     * the main page of the program
     */
    public static void signUp() {
        String in;
        Student ob = new Student();
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
        in = input.next();    //We need to check email format
        while (chStdEmail(in) || chAdminEmail(in)) {
            System.out.print("\tthis email already exists, please enter another one : ");
            in = input.next();
        }
        ob.setEmail(in);
        System.out.print("Password : ");
        in = input.next();
        ob.setPassword(in);
        students.add(ob);
        System.out.println("Sign up successfully");
        mainPage();
    }

    /**
     * logIn method is used to log in for existed account whether student or
     * admin it takes username and password and check them if username and
     * passowrd are correct if the user is student then it calls student main
     * page if the user is admin then it calls admin main page
     */
    public static void logIn() {
        String uname, pass;
        System.out.print("Username : ");
        uname = input.next();
        System.out.print("Password : ");
        pass = input.next();
        while (!chLoginInStd(uname, pass) && !chLoginAdmin(uname, pass)) {
            System.out.println("Wrong username or password");
            System.out.print("Username : ");
            uname = input.next();
            System.out.print("Password : ");
            pass = input.next();
        }
        if (chLoginInStd(uname, pass)) {
            for (int i = 0; i < students.size(); i++) {
                if (uname.equals(students.get(i).getUsername())) {
                    students.get(i).stdMainPage();
                    break;
                }
            }
        } else {
            for (int i = 0; i < admins.size(); i++) {
                if (uname.equals(admins.get(i).getUsername())) {
                    admins.get(i).adminMainPage();
                    break;
                }
            }
        }
    }

    /**
     * chStdUsername method is used to check if the username exists in students
     * arrayList
     *
     * @param username
     * @return true if username exists or false if username does not exist.
     */
    public static boolean chStdUsername(String username) {
        for (int i = 0; i < students.size(); i++) {
            if (username.equals(students.get(i).getUsername())) {
                return true;
            }
        }
        return false;
    }

    /**
     * chStdEmail method is used to check if the entered email exists in student
     * arrayList
     *
     * @param email
     * @return true if the email exists, false if the email does not exist.
     */
    public static boolean chStdEmail(String email) {
        for (int i = 0; i < students.size(); i++) {
            if (email.equals(students.get(i).getEmail())) {
                return true;
            }
        }
        return false;
    }

    /**
     * chAdminUsername method is used to check if the username exists in admins
     * arrayList
     *
     * @param uname
     * @return true if the username exists, false if the username does not
     * exist.
     */
    public static boolean chAdminUsername(String uname) {
        for (int i = 0; i < admins.size(); i++) {
            if (uname.equals(admins.get(i).getUsername())) {
                return true;
            }
        }
        return false;
    }

    /**
     * chAdminEmail method is used to check if the email exist in admins
     * arrayList
     *
     * @param email
     * @return true if the email exists in admins arrayList, false if the email
     * does not exist in admins arrayList
     */
    public static boolean chAdminEmail(String email) {
        for (int i = 0; i < admins.size(); i++) {
            if (email.equals(admins.get(i).getEmail())) {
                return true;
            }
        }
        return false;
    }

    /**
     * chLoginInStd method is used to check first if the username exists in
     * students arrayList then if the username exists it checks if the password
     * is correct or not
     *
     * @param uname
     * @param pass
     * @return true if the username exists in students arrayList and password is
     * correct,false if the username does not exist in student arrayList or
     * password is not correct
     */
    public static boolean chLoginInStd(String uname, String pass) {
        for (int i = 0; i < students.size(); i++) {
            if (uname.equals(students.get(i).getUsername())) {
                if (pass.equals(students.get(i).getPassword())) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * chLoginAdmin method is used to check if the username exists in admins
     * arrayList if the username exists in admins arrayList it checks if the
     * password correct
     *
     * @param uname
     * @param pass
     * @return true if the username exists in admins arrayList and password
     * correct, false if the username does not exists or password is not
     * correct.
     */
    public static boolean chLoginAdmin(String uname, String pass) {
        for (int i = 0; i < admins.size(); i++) {
            if (uname.equals(admins.get(i).getUsername())) {
                if (pass.equals(admins.get(i).getPassword())) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

}
