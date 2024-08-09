package Dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {

    private static final Logger logger = Logger.getLogger(BD.class);

    private static final String SQL_DROP_CREATE_ODONTOLOGOS =
            "DROP TABLE IF EXISTS ODONTOLOGOS; " +
                    "CREATE TABLE ODONTOLOGOS (" +
                    "ID INT AUTO_INCREMENT PRIMARY KEY, " +
                    "MATRICULA VARCHAR(20) NOT NULL, " +
                    "NOMBRE VARCHAR(50) NOT NULL, " +
                    "APELLIDO VARCHAR(50) NOT NULL" +
                    ");";

    private static final String SQL_INSERT_PRUEBA =
            "INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES " +
                    "('1234', 'Juan', 'Pérez'), " +
                    "('5678', 'María', 'Gómez');";

    public static void crearTablas() {
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();

            statement.execute(SQL_DROP_CREATE_ODONTOLOGOS);
            statement.execute(SQL_INSERT_PRUEBA);

            logger.info("Tablas creadas y datos de prueba insertados con éxito.");
        } catch (Exception e) {
            logger.error("Error inesperado al crear las tablas: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    logger.error("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:mem:~/ClinicaOdontologicaC2", "sa", "sa");
    }
}

