package Logic;

import Models.Author;
import Models.Book;
import Models.Loan;
import Models.User;
import org.hibernate.engine.spi.NamedSQLQueryDefinitionBuilder;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MonsterQuery {
    private String userFirstName;
    private String userLastName;
    private String borrowed_from;
    private String borrowed_to;
    private String returned_form;
    private String returned_to;
    private String title;
    private String authorFirstName;
    private String authorLastName;

    List<Object[]> result;

    public void performQuery() {
        EntityManager em = MyEntityManager.getInstance();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = cb.createQuery(Object[].class);
        Root<User> u = q.from(User.class);
        Join<User, Loan> l = u.join("loans");
        Join<Loan, Book> b = l.join("book");
        Join<Book, Author> a = b.join("author");

        List<Predicate> conditions = new ArrayList();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        if (userFirstName != null && !userFirstName.equals("")){
            conditions.add(cb.equal(u.get("firstName"), userFirstName));
        };
        if (userLastName != null && !userLastName.equals("")){
            conditions.add(cb.equal(u.get("lastName"), userLastName));
        };
        if (borrowed_from != null && !borrowed_from.equals("")){
            try {
                conditions.add(cb.greaterThan(l.get("borrowed_at"), formatter.parse(borrowed_from)));
            } catch (ParseException e) {
                borrowed_from = null;
            }
        };
        if (borrowed_to != null && !borrowed_to.equals("")){
            try {
                conditions.add(cb.lessThan(l.get("borrowed_at"), formatter.parse(borrowed_to)));
            } catch (ParseException e) {
                borrowed_to = null;
            }
        };
        if (returned_form != null && !returned_form.equals("")){
            try {
                conditions.add(cb.greaterThan(l.get("returned_at"), formatter.parse(returned_form)));
            } catch (ParseException e) {
                returned_form = null;
            }
        };
        if (returned_to != null && !returned_to.equals("")){
            try {
                conditions.add(cb.lessThan(l.get("returned_at"), formatter.parse(returned_to)));
            } catch (ParseException e) {
                returned_to = null;
            }
        };
        if (title != null && !title.equals("")){
            conditions.add(cb.equal(b.get("title"), title));
        };
        if (authorFirstName != null && !authorFirstName.equals("")){
            conditions.add(cb.equal(a.get("authorFirstName"), authorFirstName));
        };
        if (authorLastName != null && !authorLastName.equals("")){
            conditions.add(cb.equal(a.get("authorLastName"), authorLastName));
        };

        CriteriaQuery<Object[]> query = q.multiselect(u, a, b, l).where(conditions.toArray(new Predicate[]{}));
        List<Object[]> resultList = em.createQuery(query).getResultList();
        result = resultList;
    }

    public List<Object[]> getResult() {
        return result;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getBorrowed_from() {
        return borrowed_from;
    }

    public void setBorrowed_from(String borrowed_from) {
        this.borrowed_from = borrowed_from;
    }

    public String getBorrowed_to() {
        return borrowed_to;
    }

    public void setBorrowed_to(String borrowed_to) {
        this.borrowed_to = borrowed_to;
    }

    public String getReturned_form() {
        return returned_form;
    }

    public void setReturned_form(String returned_form) {
        this.returned_form = returned_form;
    }

    public String getReturned_to() {
        return returned_to;
    }

    public void setReturned_to(String returned_to) {
        this.returned_to = returned_to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }
}
