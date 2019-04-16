package Models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class BookList {
    private EntityManager em;

    public BookList(){
        Book book = new Book("tytul","name", "surname",  4, 123, "1992");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        this.em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
    }

    public List<Book> getBooks() {
      return em.createQuery("SELECT b FROM Book b").getResultList();
    }

    public void removeBook(Book book) {
        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();
    }

    public void updateBook(Book book){
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
    }

}
