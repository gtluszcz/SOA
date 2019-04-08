package Beans;

import Models.*;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;


@ManagedBean(name = "Search")
@SessionScoped
public class SearchBean {

        private BookList bookList = new BookList();

        public ArrayList<Book> getSearchResults(){
            return bookList.getBooks();
        }
}
