package Models;

import java.util.ArrayList;

public class BookList {
    private ArrayList<Book> books = new ArrayList<>();

    public BookList(){
        books.add(new Book("tytul","name", "surname",  4.99, 123, "1992"));
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(Book newBook){
        books.add(newBook);
    }

}
