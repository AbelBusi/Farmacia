/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Daniela
 */
public class ProveedorDAO {
      public void insertarProveedor(Proveedor proveedor) throws SQLException {
        String sql = "INSERT INTO Proveedor (nombre, contacto, telefono) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, proveedor.getNombre());
            stmt.setString(2, proveedor.getContacto());
            stmt.setString(3, proveedor.getTelefono());
            stmt.executeUpdate();
        }
    }

    public Proveedor obtenerProveedor(int id) throws SQLException {
        String sql = "SELECT * FROM Proveedor WHERE id_proveedor = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Proveedor(
                    rs.getInt("id_proveedor"),
                    rs.getString("nombre"),
                    rs.getString("contacto"),
                    rs.getString("telefono")
                );
            }
        }
        return null;
    }

    public List<Proveedor> obtenerTodosLosProveedores() throws SQLException {
        List<Proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM Proveedor";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                proveedores.add(new Proveedor(
                    rs.getInt("id_proveedor"),
                    rs.getString("nombre"),
                    rs.getString("contacto"),
                    rs.getString("telefono")
                ));
            }
        }
        return proveedores;
    }

    public void actualizarProveedor(Proveedor proveedor) throws SQLException {
        String sql = "UPDATE Proveedor SET nombre = ?, contacto = ?, telefono = ? WHERE id_proveedor = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, proveedor.getNombre());
            stmt.setString(2, proveedor.getContacto());
            stmt.setString(3, proveedor.getTelefono());
            stmt.setInt(4, proveedor.getId_proveedor());
            stmt.executeUpdate();
        }
    }

    public void eliminarProveedor(int id) throws SQLException {
        String sql = "DELETE FROM Proveedor WHERE id_proveedor = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
