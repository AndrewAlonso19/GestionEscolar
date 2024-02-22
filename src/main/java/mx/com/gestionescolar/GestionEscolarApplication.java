package mx.com.gestionescolar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionEscolarApplication {

    public static void main(String[] args) {

        SpringApplication.run(GestionEscolarApplication.class, args);
        String jdbcUrl = "jdbc:mysql://localhost:3306/GestionEscolar2";
        String usuario = "root";
        String contraseña = "";

        try {
            Connection conexion = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
            System.out.println("Conexión exitosa a la base de datos.");

            conexion.close();
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

}
