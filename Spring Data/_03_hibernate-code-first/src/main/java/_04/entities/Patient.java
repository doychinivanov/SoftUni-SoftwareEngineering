package _04.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "_04_patients")
public class Patient extends Person {

    @Column(unique = true)
    private String picture;

    @Column(name = "has_insurance")
    private boolean hasInsurance;

    @OneToMany(targetEntity = Diagnose.class, mappedBy = "patient")
    private Set<Diagnose> diagnoses;

    public Patient () {
        super();
    }

    public Patient(String firstName, String lastName, String address, String email, LocalDate birthDate, String picture, boolean hasInsurance) {
        super(firstName, lastName, address, email, birthDate);
        this.picture = picture;
        this.hasInsurance = hasInsurance;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }
}
