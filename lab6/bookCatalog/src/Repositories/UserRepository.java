package Repositories;

import Logic.MyEntityManager;
import Models.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserRepository {
    public List<User> getUsers() {
        EntityManager em = MyEntityManager.getInstance();
        return em.createQuery("SELECT b FROM User b").getResultList();
    }

    public void removeUser(User user) {
        EntityManager em = MyEntityManager.getInstance();
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }

    public void addUser() {
        User user = new User("","");
        updateUser(user);
    }

    public void updateUser(User user){
        EntityManager em = MyEntityManager.getInstance();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }
}
