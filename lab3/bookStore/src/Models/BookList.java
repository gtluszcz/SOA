package Models;

import java.util.ArrayList;
import java.util.HashMap;

public class BookList {
    private ArrayList<Book> books = new ArrayList<>();

    public BookList(){
        books.add(new Book("tytul","author", Genre.FANTASY, 4.99, Currency.USD, 123));
        books.add(new Book("tytul","author", Genre.ROMANCE, 3.99, Currency.EUR, 234));
        books.add(new Book("tytul","author", Genre.MYSTERY, 2.99, Currency.PLN, 103));
        books.add(new Book("tytul","author", Genre.THRILLER, 4.99, Currency.EUR, 156));
    }

    public void addBook(Book newBook){
        books.add(newBook);
    }

    private ArrayList<Book> getRightCurrency(String currency){
        if (currency.equals("Original")){
            for(Book book : books){
                String bookCurrency = book.getCurrency();
                Double price = book.getPrice();
                book.setDisplayedPrice(price);
                book.setDisplayedCurrency(bookCurrency);
            }
            return books;
        } else {
            for(Book book : books){
                Double newPrice = Currency.getPriceInPLN(book);
                book.setDisplayedCurrency(Currency.PLN);
                book.setDisplayedPrice(newPrice);
            }
            return books;
        }
    }



    public ArrayList<Book> getFiltered(Filter f){
        ArrayList<Book> booksToReturn = new ArrayList<>();
        for(Book book : getRightCurrency(f.getCurrencyToDisplay())){
            if (f.accept(book)){
                booksToReturn.add(book);
            }
        }
        return booksToReturn;
    }

    public Integer totalSum(Filter f) {
        Integer sum = 0;
        for(Book book : getRightCurrency(Currency.PLN)){
            if (book.getSelected()){
                sum += 1;
            }
        }
        return sum;
    }

    public Double totalPrice(Filter f) {
        Double sumPrice = 0.0;
        for(Book book : getRightCurrency(Currency.PLN)){
            if (book.getSelected()){
                sumPrice += Currency.getPriceInPLN(book);

            }
        }
        return sumPrice;
    }

}
