package main.java.com.pfm.services;

import main.java.com.pfm.database.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudService {
    // Metodo para crear usuario
    public void createUser(String nombre, String correo, String contrasena) {
        String query = "INSERT INTO usuario (nombre, correo, contrasena) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nombre);       // parametro nombre
            stmt.setString(2, correo);      // parametro email
            stmt.setString(3, contrasena);   // parametro contraseña
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo de consulta por ID
    public void getUser(int usuarioId) {
        String query = "SELECT * FROM usuario WHERE id = ?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Usuario: " + rs.getString("nombre") + ", correo: " + rs.getString("correo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para actualizar usuario
    public void updateUser(int usuarioId, String newNombre, String newCorreo, String newContrasena) {
        String query = "UPDATE users SET nombre = ?, Correo = ?, contrasena = ? WHERE id = ?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newNombre);
            stmt.setString(2, newCorreo);
            stmt.setString(3, newContrasena);
            stmt.setInt(4, usuarioId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para eliminar usuario
    public void deleteUser(int usuarioId) {
        String query = "DELETE FROM usuario WHERE id = ?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, usuarioId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
