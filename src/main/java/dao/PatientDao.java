package dao;

import model.Patient;

import java.util.List;

public interface PatientDao {

    void add(Patient patient);
    List<Patient>getall();
    void deleteById(int id);
    void clearAll();

}
