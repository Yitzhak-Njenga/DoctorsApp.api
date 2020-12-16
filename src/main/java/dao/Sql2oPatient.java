package dao;

import model.Patient;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oPatient implements PatientDao {
    private final Sql2o sql2o;

    public Sql2oPatient(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Patient patient) {


        String sql = "INSERT INTO patient(name, gender, illness, age) VALUES(:name, :gender, :illness, :age);";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(patient)
                    .executeUpdate()
                    .getKey();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public List<Patient> getall() {
        try (Connection connection = sql2o.open()){
                String sql = "SELECT * FROM patient";
                return connection.createQuery(sql).executeAndFetch(Patient.class);
            }
        }


    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }
}
