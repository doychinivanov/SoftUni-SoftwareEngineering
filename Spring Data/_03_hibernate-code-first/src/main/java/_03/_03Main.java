package _03;

import db_config.EntityManagerCreator;

import javax.persistence.EntityManager;

public class _03Main {
    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerCreator.create();
        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
