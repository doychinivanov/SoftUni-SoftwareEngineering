import db_config.EntityManagerCreator;
import entities.Address;

import javax.persistence.EntityManager;
import java.util.List;

public class _07_AddressesEmployeesCount {
    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerCreator.create();
        entityManager.getTransaction().begin();

        List<Address> addresses = entityManager
                .createQuery("SELECT a FROM Address a" +
                        " ORDER BY a.employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultList();


        StringBuilder result = new StringBuilder();

        addresses.forEach(a -> result.append(a.toString()).append(System.lineSeparator()));
        System.out.println(result);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
