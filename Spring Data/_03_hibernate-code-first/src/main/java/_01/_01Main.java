package _01;

import db_config.EntityManagerCreator;

import javax.persistence.EntityManager;

public class _01Main {

    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerCreator.create();
        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
