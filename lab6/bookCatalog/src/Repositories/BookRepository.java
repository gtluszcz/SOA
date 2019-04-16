package Repositories;

import Logic.MyEntityManager;
import Models.Author;
import Models.Book;

import javax.persistence.EntityManager;
import java.util.List;

public class BookRepository {
    public List<Book> getBooks() {
        EntityManager em = MyEntityManager.getInstance();
        System.out.println("FETCH");
        return em.createQuery("SELECT b FROM Book b").getResultList();
    }

    public void removeBook(Book book) {
        EntityManager em = MyEntityManager.getInstance();
        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();
        em.clear();
    }

    public void addBook(Author author){
        Book book = new Book("");
        book.setAuthor(author);
        updateBook(book);
    }

    public void updateBook(Book book){
        EntityManager em = MyEntityManager.getInstance();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        em.clear();
    }
}
