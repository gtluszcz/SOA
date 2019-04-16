package Repositories;

import Logic.MyEntityManager;
import Models.Book;
import Models.Loan;
import Models.User;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

public class LoanRepository {
    public List<Loan> getLoans() {
        EntityManager em = MyEntityManager.getInstance();
        return em.createQuery("SELECT b FROM Loan b").getResultList();
    }

    public void removeLoan(Loan loan) {
        EntityManager em = MyEntityManager.getInstance();
        em.getTransaction().begin();
        em.remove(loan);
        em.getTransaction().commit();
        em.clear();
    }

    public void returnLoan(Loan loan) {
        EntityManager em = MyEntityManager.getInstance();
        em.getTransaction().begin();
        loan.setReturned_at(new Date());
        em.persist(loan);
        em.getTransaction().commit();
    }

    public void addLoan(User user, Book book) {
        Loan loan = new Loan();
        loan.setUser(user);
        loan.setBook(book);
        updateLoan(loan);
    }


    public void updateLoan(Loan loan){
        EntityManager em = MyEntityManager.getInstance();
        em.getTransaction().begin();
        em.persist(loan);
        em.getTransaction().commit();
        em.clear();
    }
}
