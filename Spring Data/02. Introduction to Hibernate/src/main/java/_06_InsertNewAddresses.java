import db_config.EntityManagerCreator;
import entities.Address;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _06_InsertNewAddresses {
    private static final String newAddress = "Vitoshka 15";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String employeeLastName = reader.readLine();

        EntityManager entityManager = EntityManagerCreator.create();
        entityManager.getTransaction().begin();

        Address address = new Address();
        address.setText(newAddress);
        entityManager.persist(address);

        entityManager.createQuery("UPDATE Employee e" +
                " SET e.address = :address" +
                " WHERE e.lastName = :lastName")
                .setParameter("address", address)
                .setParameter("lastName", employeeLastName)
                .executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
