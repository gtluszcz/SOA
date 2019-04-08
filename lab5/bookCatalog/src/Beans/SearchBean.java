package Beans;

import Models.*;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;


@ManagedBean(name = "Search")
@ApplicationScoped
public class SearchBean {

    private BookList bookList = new BookList();

    public List<Book> getSearchResults() {
        return bookList.getBooks();
    }

    public void addBook() {
        Book book = new Book("","","",0,0,"");
        bookList.addBook(book);
    }

    public void removeBook(Book book) {
        bookList.removeBook(book);
    }

    public void updateBook(Book book) {
        bookList.updateBook(book);
    }
}
