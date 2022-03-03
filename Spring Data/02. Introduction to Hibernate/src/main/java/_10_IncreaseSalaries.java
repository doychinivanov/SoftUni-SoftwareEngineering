import db_config.EntityManagerCreator;
import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

public class _10_IncreaseSalaries {
    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerCreator.create();
        entityManager.getTransaction().begin();

        String[] departmentNames = {"Engineering", "Tool Design", "Marketing", "Information Services"};

        List<Department> departTargets = entityManager.createQuery("FROM Department d" +
                " WHERE d.name IN :departmentNames", Department.class).setParameter("departmentNames", Arrays.stream(departmentNames).toList()).getResultList();

        entityManager.createQuery("UPDATE Employee e" +
                        " SET e.salary = e.salary * 1.12" +
                        " WHERE e.department IN :departments")
                .setParameter("departments", departTargets)
                .executeUpdate();

        List<Employee> employees = entityManager.createQuery("FROM Employee e" +
                " WHERE e.department IN :departments", Employee.class).setParameter("departments", departTargets).getResultList();


        StringBuilder result = new StringBuilder();

        employees.forEach(e -> {
            result
                    .append(e.getFirstName()).append(" ")
                    .append(e.getLastName())
                    .append(" ($")
                    .append(String.format("%.2f", e.getSalary()))
                    .append(")")
                    .append(System.lineSeparator());
        });
        System.out.println(result);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
