package Logic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyEntityManager {
    private static EntityManager manager;
    private MyEntityManager(){}

    public static EntityManager getInstance(){
        if (manager == null){
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
            manager = factory.createEntityManager();
        }
        return manager;
    }
}
