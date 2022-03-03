import db_config.EntityManagerCreator;
import entities.Employee;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class _11_EmployeesFirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pattern = reader.readLine();

        EntityManager entityManager = EntityManagerCreator.create();
        entityManager.getTransaction().begin();

        List<Employee> employees = entityManager.createQuery("FROM Employee e" +
                " WHERE e.firstName LIKE :pattern", Employee.class)
                .setParameter("pattern", pattern + "%")
                .getResultList();

        StringBuilder result = new StringBuilder();

        employees.forEach(e -> {
            result
                    .append(e.getFirstName()).append(" ")
                    .append(e.getLastName()).append(" - ")
                    .append(e.getJobTitle()).append(" - ")
                    .append("($")
                    .append(String.format("%.2f", e.getSalary()))
                    .append(")")
                    .append(System.lineSeparator());
        });

        System.out.println(result);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
