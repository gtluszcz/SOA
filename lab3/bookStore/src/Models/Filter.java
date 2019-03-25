package Models;

import com.sun.tools.javah.Gen;

public class Filter {
    private String title = null;
    private String author = null;
    private String genre = null;
    private Double priceLow = 0.0;
    private Double priceHigh = Double.MAX_VALUE;
    private String currency = null;
    private Integer pagesLow = 0;
    private Integer pagesHigh = Integer.MAX_VALUE;
    private String currencyToDisplay = "Original";


    public Boolean accept(Book book){
        if (title != null && !book.getTitle().equals(title)) return false;
        if (author != null && !book.getAuthor().equals(author)) return false;
        if (genre != null && !book.getGenre().equals(genre)) return false;
        if (priceLow != null && book.getPrice() < priceLow) return false;
        if (priceHigh != null && book.getPrice() > priceHigh) return false;
        if (currency != null && !book.getCurrency().equals(currency)) return false;
        if (pagesLow != null && book.getPages() < pagesLow) return false;
        if (pagesHigh != null && book.getPages() > pagesHigh) return false;
        return true;
    }

    public void setTitle(String title) {
        if (title.isEmpty()) {
            this.title = null;
            return;
        }
        this.title = title;
    }

    public void setAuthor(String author) {
        if (author.isEmpty()) {
            this.author = null;
            return;
        }
        this.author = author;
    }

    public void setGenre(String genre) {
        if (genre.equals(Genre.ALL)) {
            this.genre = null;
            return;
        }
        this.genre = genre;
    }

    public void setPriceLow(Double priceLow) {
        this.priceLow = priceLow;
    }

    public void setPriceHigh(Double priceHigh) {
        this.priceHigh = priceHigh;
    }

    public void setCurrency(String currency) {
        if (currency.equals(Currency.ALL)) {
            this.currency = null;
            return;
        }
        this.currency = currency;
    }

    public void setPagesLow(Integer pagesLow) {
        this.pagesLow = pagesLow;
    }

    public void setPagesHigh(Integer pagesHigh) {
        this.pagesHigh = pagesHigh;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getGenre() {
        return this.genre;
    }

    public Double getPriceLow() {
        return this.priceLow;
    }

    public Double getPriceHigh() {
        return this.priceHigh;
    }

    public String getCurrency() {
        return this.currency;
    }

    public Integer getPagesLow() {
        return this.pagesLow;
    }

    public Integer getPagesHigh() {
        return this.pagesHigh;
    }

    public String getCurrencyToDisplay() {
        return currencyToDisplay;
    }

    public void setCurrencyToDisplay(String currencyToDisplay) {
        this.currencyToDisplay = currencyToDisplay;
    }
}
