import db_config.EntityManagerCreator;
import entities.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public class _05_EmployeesFromDepartment {
    private static final String targetDepartment = "Research and Development";

    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerCreator.create();
        entityManager.getTransaction().begin();

        List<Employee> employees = entityManager
                .createQuery("SELECT e FROM Employee e" +
                        " WHERE e.department.name = :departmentName" +
                        " ORDER BY e.salary, e.id", Employee.class)
                .setParameter("departmentName", targetDepartment)
                .getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        StringBuilder result = new StringBuilder();

        employees.forEach(e -> {
            result.append(
                    String.format("%s %s from %s - $%.2f",
                    e.getFirstName(), e.getLastName(), targetDepartment, e.getSalary()))
                    .append(System.lineSeparator());
        });

        System.out.println(result);
    }
}
