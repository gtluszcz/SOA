package Beans;

import Models.*;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;


@ManagedBean(name = "Search")
@SessionScoped
public class SearchBean {

        private BookList bookList = new BookList();
        private Filter filter = new Filter();
        private ShowList showList = new ShowList();
        private Integer totalSum = 0;
        private Double totalPrice = 0.0;

        public ArrayList<Book> getSearchResults(){
            System.out.println(filter);
            return bookList.getFiltered(filter);
        }

        public void sumUp() {
            this.totalPrice = bookList.totalPrice(filter);
            this.totalSum = bookList.totalSum(filter);
        }

        public Filter getFilter(){
            return filter;
        }

        public ShowList getShowList() {
            return showList;
        }

        public BookList getBookList() {
            return bookList;
        }

    public Integer getTotalSum() {
        return totalSum;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }
}
