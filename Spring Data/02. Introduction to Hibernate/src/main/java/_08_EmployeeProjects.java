import db_config.EntityManagerCreator;
import entities.Employee;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _08_EmployeeProjects {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int _id = Integer.parseInt(reader.readLine());

        EntityManager entityManager = EntityManagerCreator.create();
        entityManager.getTransaction().begin();

        Employee employee = entityManager
                .createQuery("SELECT e" +
                        " FROM Employee e" +
                        " WHERE e.id = :_id", Employee.class)
                .setParameter("_id", _id)
                .getSingleResult();

        System.out.println(employee);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
