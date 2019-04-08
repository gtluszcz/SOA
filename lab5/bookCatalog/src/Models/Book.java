package Models;


public class Book {
    private String title;
    private String name;
    private String surname;
    private Double price;
    private Integer ISBN;
    private String releaseDate;

    public Book(String title, String name, String surname, Double price, Integer ISBN, String releaseDate) {
        this.title = title;
        this.name = name;
        this.surname = surname;
        this.price = price;
        this.ISBN = ISBN;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getISBN() {
        return ISBN;
    }

    public void setISBN(Integer ISBN) {
        this.ISBN = ISBN;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
