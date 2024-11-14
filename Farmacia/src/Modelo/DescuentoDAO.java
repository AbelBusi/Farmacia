/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Daniela
 */
public class DescuentoDAO {
     public void insertarDescuento(Descuento descuento) throws SQLException {
        String sql = "INSERT INTO Descuento (nombre, total) VALUES (?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, descuento.getNombre());
            stmt.setDouble(2, descuento.getTotal());
            stmt.executeUpdate();
        }
    }


    public Descuento obtenerDescuento(int id) throws SQLException {
        String sql = "SELECT * FROM Descuento WHERE id_descuento = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Descuento(
                    rs.getInt("id_descuento"),
                    rs.getString("nombre"),
                    rs.getDouble("total")
                );
            }
        }
        return null;
    }

    
    public List<Descuento> obtenerTodosLosDescuentos() throws SQLException {
        List<Descuento> descuentos = new ArrayList<>();
        String sql = "SELECT * FROM Descuento";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                descuentos.add(new Descuento(
                    rs.getInt("id_descuento"),
                    rs.getString("nombre"),
                    rs.getDouble("total")
                ));
            }
        }
        return descuentos;
    }

   
    public void actualizarDescuento(Descuento descuento) throws SQLException {
        String sql = "UPDATE Descuento SET nombre = ?, total = ? WHERE id_descuento = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, descuento.getNombre());
            stmt.setDouble(2, descuento.getTotal());
            stmt.setInt(3, descuento.getId_descuento());
            stmt.executeUpdate();
        }
    }

   
    public void eliminarDescuento(int id) throws SQLException {
        String sql = "DELETE FROM Descuento WHERE id_descuento = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
