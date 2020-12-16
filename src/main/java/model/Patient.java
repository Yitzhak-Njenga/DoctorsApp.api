package model;

import java.util.Objects;

public class Patient {
    String name, gender, illness;
    int age, id;

    public Patient(String name, String gender, String illness, int age, int id) {
        this.name = name;
        this.gender = gender;
        this.illness = illness;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return age == patient.age &&
                id == patient.id &&
                Objects.equals(name, patient.name) &&
                Objects.equals(gender, patient.gender) &&
                Objects.equals(illness, patient.illness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, illness, age, id);
    }
}
