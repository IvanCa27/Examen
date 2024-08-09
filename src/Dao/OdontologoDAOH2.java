package Dao;

import Model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements iDao<Odontologo> {

    private static final Logger logger = Logger.getLogger(OdontologoDAOH2.class);
    private static final String DB_URL = "jdbc:h2:mem:~/ClinicaOdontologicaC2;DB_CLOSE_DELAY=-1";


    @Override
    public void guardar(Odontologo odontologo) {
        try (Connection connection = DriverManager.getConnection(DB_URL, "sa", "sa")) {
            String query = "INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, odontologo.getMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.executeUpdate();
            logger.info("Odontólogo guardado: " + odontologo);
        } catch (Exception e) {
            logger.error("Error al guardar odontólogo: " + e.getMessage());
        }
    }

    @Override
    public List<Odontologo> listarTodos() {
        List<Odontologo> odontologos = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, "sa", "sa")) {
            String query = "SELECT * FROM ODONTOLOGOS";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String matricula = resultSet.getString("MATRICULA");
                String nombre = resultSet.getString("NOMBRE");
                String apellido = resultSet.getString("APELLIDO");
                Odontologo odontologo = new Odontologo(id, matricula, nombre, apellido);
                odontologos.add(odontologo);
            }
            logger.info("Lista de todos los odontólogos: " + odontologos);
        } catch (Exception e) {
            logger.error("Error al listar odontólogos: " + e.getMessage());
        }
        return odontologos;
    }
}
