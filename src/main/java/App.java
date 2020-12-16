import com.google.gson.Gson;
import dao.Sql2oPatient;
import model.Patient;
import org.sql2o.Sql2o;

import java.sql.Connection;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);
        Sql2oPatient patientDao;
        Connection con;
        Gson gson;
        gson = new Gson();
//        String connectionString = "jdbc:postgresql://ec2-52-87-135-240.compute-1.amazonaws.com:5432/d3sdho8ddmto6a"; //!
//        Sql2o sql2o = new Sql2o(connectionString, "ohlvhpjepxptuv", "46a1c76b534693759c7d10399418293ba738184be80a5377acbed0f37d1920fd"); //!
        Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/patients", "moringa", "Emmanuel1738");
        patientDao = new Sql2oPatient(sql2o);

        get("patients", "application/json", (req, res) -> {
            res.type("application/json");
            System.out.println(patientDao.getall());
            if(patientDao.getall().size() > 0){
                return gson.toJson(
                        patientDao.getall());
            }
            else {
                return "{\"message\":\"I'm sorry, but no patients are currently available in the database.\"}";
            }
        });

        post ("patients/new", "application/json", (request, response) -> {
            Patient patient = gson.fromJson(request.body(), Patient.class);
            patientDao.add(patient);
            response.status(201);
            response.type("application/json");
            return  gson.toJson(patient);
        });

    }
}
