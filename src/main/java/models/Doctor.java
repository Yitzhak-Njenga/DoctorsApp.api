package models;

import java.util.Objects;

public class Doctor {
    private int id;
    private String name;
    private int age;
    private String specialist;

    public Doctor(String name, int age, String specialist) {
        this.name = name;
        this.age = age;
        this.specialist = specialist;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return id == doctor.id &&
                age == doctor.age &&
                Objects.equals(name, doctor.name) &&
                Objects.equals(specialist, doctor.specialist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, specialist);
    }
}
