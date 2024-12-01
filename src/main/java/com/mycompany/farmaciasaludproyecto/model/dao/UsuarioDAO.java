package com.mycompany.farmaciasaludproyecto.model.dao;

import com.mycompany.farmaciasaludproyecto.model.entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author cesar
 */
public class UsuarioDAO {

    public boolean dniExiste(String dni) {
        
        String sql = "SELECT COUNT(*) FROM Vendedor WHERE dni = ?";

        try (
                Connection cn = Conexion.conectar();
                PreparedStatement stmt = cn.prepareStatement(sql)
                
                ) {

            stmt.setString(1, dni);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0; 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        
        }

        return false;
    }
    
    public boolean verificarCredenciales(String correo, String clave) {
        String sql = "SELECT clave FROM Usuario WHERE correo = ?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, correo);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String hashedPassword = rs.getString("clave");
                    return BCrypt.checkpw(clave, hashedPassword); // Comparar contraseña
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public boolean agregarUsuario(Usuario usuario) {
        String sql = """
            INSERT INTO Usuario (nombres, apellidos, dni, telefono, correo, clave, estado, rol, id_vendedor)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Encriptar la contraseña antes de almacenarla
            String hashedPassword = BCrypt.hashpw(usuario.getClave(), BCrypt.gensalt());

            stmt.setString(1, usuario.getNombres());
            stmt.setString(2, usuario.getApellidos());
            stmt.setString(3, usuario.getDni());
            stmt.setString(4, usuario.getTelefono());
            stmt.setString(5, usuario.getCorreo());
            stmt.setString(6, hashedPassword); // Contraseña encriptada
            stmt.setInt(7, usuario.getEstado());
            stmt.setString(8, usuario.getRol());
            stmt.setInt(9, usuario.getId_vendedor());

            return stmt.executeUpdate() > 0; // Devuelve true si se inserta al menos una fila
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
