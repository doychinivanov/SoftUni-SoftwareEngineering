import db_config.EntityManagerCreator;
import entities.Project;

import javax.persistence.EntityManager;
import java.util.Comparator;
import java.util.List;

public class _09_Latest10Projects {
    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerCreator.create();
        entityManager.getTransaction().begin();

        List<Project> projects = entityManager.createQuery("SELECT p FROM Project p" +
                        " ORDER BY p.startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList();

        StringBuilder output = new StringBuilder();
        projects
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> output.append(p.toString()));

        System.out.println(output);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
