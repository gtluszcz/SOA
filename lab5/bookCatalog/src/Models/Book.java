package Models;


import javax.persistence.*;

@Entity
@Table( name="books" )
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name="id", nullable=false)
    private int id;
    @Column(name="title")
    private String title;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="price")
    private Integer price;
    @Column(name="ISBN")
    private Integer ISBN;
    @Column(name="releaseDate")
    private String releaseDate;

    public Book() {
        super();
    }

    public Book(String title, String name, String surname, Integer price, Integer ISBN, String releaseDate) {
        super();
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


    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
