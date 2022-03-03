import db_config.EntityManagerCreator;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _03_ContainsEmployee {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EntityManager entityManager = EntityManagerCreator.create();
        entityManager.getTransaction().begin();

        String[] employeeData = reader.readLine().split("\\s+");
        String firstName = employeeData[0];
        String lastName = employeeData[1];

        Long employeeCount = entityManager
                .createQuery("SELECT COUNT(e) FROM Employee e" +
                        " WHERE e.firstName = :first_name" +
                        " AND e.lastName = :last_name", Long.class)
                .setParameter("first_name", firstName)
                .setParameter("last_name", lastName)
                .getSingleResult();

        entityManager.getTransaction().commit();
        entityManager.close();

        if (employeeCount > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
