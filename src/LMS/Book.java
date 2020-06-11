package LMS;

/**
 * Book class is used to do all book operation
 */
import static LMS.Control.getValidInt;
import java.util.Scanner;

/**
 *
 * @author AbdUlRahman Shawareb
 */
public class Book {

    /**
     * book name
     */
    private String name;
    /**
     * book category
     */
    private String category;
    /**
     * book author
     */
    private String author;
    /**
     * book publication year
     */
    private int pyear;
    /**
     * book isbn
     */
    private int isbn;
    /**
     * book ID
     */
    private int id;
    /**
     * Scanner to take input
     */
    private Scanner input;

    /**
     * defualt constructor
     */
    public Book() {
        input = new Scanner(System.in);
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
     * method to set category
     *
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * method to set author
     *
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * method to set pyear
     *
     * @param pyear
     */
    public void setPyear(int pyear) {
        this.pyear = pyear;
    }

    /**
     * method to set isbn
     *
     * @param isbn
     */
    public void setIsbn(int isbn) {
        this.isbn = isbn;
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
     * method to return category
     *
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * method to return author
     *
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * method to return pyear
     *
     * @return pyear
     */
    public int getPyear() {
        return pyear;
    }

    /**
     * method to return isbn
     *
     * @return isbn
     */
    public int getIsbn() {
        return isbn;
    }

    /**
     * method to return id
     *
     * @return
     */
    public int getID() {
        return id;
    }

    /**
     * setData method is used to take all book data from the user take id
     * parameter to set book id
     *
     * @param id
     */
    public void setData(int id) {
        String in;
        int in1;
        System.out.print("Name : ");
        in = input.next();
        this.name = in;
        System.out.print("Category : ");
        in = input.next();
        this.category = in;
        System.out.print("Author : ");
        in = input.next();
        this.author = in;
        System.out.print("Publication year : ");
        in1 = getValidInt();
        this.pyear = in1;
        System.out.print("ISBN : ");
        in1 = getValidInt();
        this.isbn = in1;
        this.id = id;
    }

    /**
     * toString method is used to return string conatin all book information
     *
     * @return re
     */
    @Override
    public String toString() {
        String re = "";
        re += "Book ID : " + getID() + "\n";
        re += "Book name : " + getName() + "\n";
        re += "Book category : " + getCategory() + "\n";
        re += "Book author : " + getAuthor() + "\n";
        re += "Book publication year : " + getPyear() + "\n";
        re += "Book ISBN : " + getIsbn() + "\n";
        return re;
    }

}
