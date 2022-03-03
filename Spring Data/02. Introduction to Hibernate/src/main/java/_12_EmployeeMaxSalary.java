import db_config.EntityManagerCreator;
import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

public class _12_EmployeeMaxSalary {
    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerCreator.create();
        entityManager.getTransaction().begin();

        List<Department> departments = entityManager.createQuery("SELECT d FROM Department d", Department.class).getResultList();

        StringBuilder result = new StringBuilder();
        departments.forEach(d -> {
            DecimalFormat df = new DecimalFormat("####.00");
            BigDecimal max = Collections.max(d.getEmployees().stream().map(Employee::getSalary).toList());


            if(max.compareTo(BigDecimal.valueOf(30000)) < 0 || max.compareTo(BigDecimal.valueOf(70000)) > 0) {
                result.append(d.getName()).append(" ").append(df.format(max)).append(System.lineSeparator());
            }
        });

        System.out.println(result);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
