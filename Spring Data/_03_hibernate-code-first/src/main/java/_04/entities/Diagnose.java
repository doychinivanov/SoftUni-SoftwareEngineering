package _04.entities;

import javax.persistence.*;
import javax.persistence.GenerationType;


@Entity(name = "_04_diagnoses")
public class Diagnose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    private String comments;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_diagnoses", referencedColumnName = "id")
    private Patient patient;

    public Diagnose() {}

    public Diagnose(String name, String comments, Patient patient) {
        this.name = name;
        this.comments = comments;
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
