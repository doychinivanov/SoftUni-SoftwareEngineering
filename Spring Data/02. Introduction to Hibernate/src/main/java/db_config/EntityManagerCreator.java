package db_config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerCreator {

    public static EntityManager create() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");

        return factory.createEntityManager();
    }
}
