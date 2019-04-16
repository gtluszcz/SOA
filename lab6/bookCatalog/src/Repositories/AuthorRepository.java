package Repositories;

import Logic.MyEntityManager;
import Models.Author;

import javax.persistence.EntityManager;
import java.util.List;

public class AuthorRepository {
    public List<Author> getAuthors() {
        EntityManager em = MyEntityManager.getInstance();
        return em.createQuery("SELECT b FROM Author b").getResultList();
    }

    public void removeAuthor(Author author) {
        EntityManager em = MyEntityManager.getInstance();
        em.getTransaction().begin();
        em.remove(author);
        em.getTransaction().commit();
    }

    public void addAuthor(){
        Author author = new Author("","");
        updateAuthor(author);
    }
    public void updateAuthor(Author author){
        EntityManager em = MyEntityManager.getInstance();
        em.getTransaction().begin();
        em.persist(author);
        em.getTransaction().commit();
    }
}
