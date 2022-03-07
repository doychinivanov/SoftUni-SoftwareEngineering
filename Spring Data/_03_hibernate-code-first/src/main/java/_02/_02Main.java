package _02;

import _02.entities.Customer;
import _02.entities.Product;
import _02.entities.Sale;
import _02.entities.StoreLocation;
import db_config.EntityManagerCreator;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class _02Main {
    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerCreator.create();
        entityManager.getTransaction().begin();

        Product product = new Product("some_name", 123, BigDecimal.TEN);
        Customer customer = new Customer("Ivan", "example@abv.bg", "666");
        StoreLocation location = new StoreLocation("random");
        Sale sale = new Sale(product, customer, location);

        entityManager.persist(product);
        entityManager.persist(customer);
        entityManager.persist(location);
        entityManager.persist(sale);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
