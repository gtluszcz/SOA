package Models;


public class Book {
    private String title;
    private String author;
    private String genre;
    private Double price;
    private Double displayedPrice;
    private String currency;
    private String displayedCurrency;
    private Integer pages;
    private Boolean selected = false;

    public Book(String title, String author, String genre, Double price, String currency, Integer pages) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.currency = currency;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public Double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public Integer getPages() {
        return pages;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Double getDisplayedPrice() {
        return displayedPrice;
    }

    public void setDisplayedPrice(Double displayedPrice) {
        this.displayedPrice = displayedPrice;
    }

    public String getDisplayedCurrency() {
        return displayedCurrency;
    }

    public void setDisplayedCurrency(String displayedCurrency) {
        this.displayedCurrency = displayedCurrency;
    }
}
