package Models;


import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "borrowed_at", nullable = false)
    private Date borrowed_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "returned_at")
    private Date returned_at;

    public Loan(){
        borrowed_at = new Date();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getBorrowed_at() {
        if (borrowed_at == null) return null;
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
        return dt1.format(borrowed_at);
    }

    public void setBorrowed_at(Date from) {
        this.borrowed_at = from;
    }

    public String getReturned_at() {
        if (returned_at == null) return null;
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
        return dt1.format(returned_at);
    }

    public void setReturned_at(Date to) {
        this.returned_at = to;
    }
}
