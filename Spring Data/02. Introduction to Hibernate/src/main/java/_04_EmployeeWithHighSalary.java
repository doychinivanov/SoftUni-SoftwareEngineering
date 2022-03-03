import db_config.EntityManagerCreator;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class _04_EmployeeWithHighSalary {
    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerCreator.create();
        entityManager.getTransaction().begin();

        List<String> names = entityManager.createQuery("" +
                        "SELECT e.firstName FROM Employee e" +
                        " WHERE e.salary > 50000", String.class)
                .getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println(String.join(System.lineSeparator(), names));
    }
}
