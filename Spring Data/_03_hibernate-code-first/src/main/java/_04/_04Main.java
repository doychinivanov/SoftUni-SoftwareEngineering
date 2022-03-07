package _04;

import _04.entities.Diagnose;
import _04.entities.Patient;
import _04.entities.Visitation;
import db_config.EntityManagerCreator;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class _04Main {
    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerCreator.create();
        entityManager.getTransaction().begin();

        Patient patient = new Patient("Ivan", "Ivanov", "Sofia", "test@abv.bg", LocalDate.now(), "asdqwddgfdh", true);
        Diagnose diagnose = new Diagnose("covid19", "Patient is getting better", patient);
        Visitation visitation = new Visitation(LocalDate.now(), "This is a comment", patient);

        entityManager.persist(patient);
        entityManager.persist(diagnose);
        entityManager.persist(visitation);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
