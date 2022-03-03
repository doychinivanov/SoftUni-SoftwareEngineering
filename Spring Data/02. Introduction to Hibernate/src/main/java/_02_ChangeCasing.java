import db_config.EntityManagerCreator;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class _02_ChangeCasing {
    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerCreator.create();

        entityManager.getTransaction().begin();;

        List<Town> towns = entityManager
                .createQuery("SELECT t FROM Town t", Town.class)
                .getResultList();

        for (Town town : towns) {
            String name = town.getName();

            if (name.length() <= 5) {
                String upperCaseName = name.toUpperCase();
                town.setName(upperCaseName);

                entityManager.persist(town);
            }
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
