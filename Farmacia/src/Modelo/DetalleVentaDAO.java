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
public class DetalleVentaDAO {
     public void insertarDetalleVenta(DetalleVenta detalleVenta) throws SQLException {
        String sql = "INSERT INTO DetalleVenta (id_venta, id_medicamento, cantidadVendida, precioMedicamento, TotalVendido) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, detalleVenta.getId_venta());
            stmt.setInt(2, detalleVenta.getId_medicamento());
            stmt.setInt(3, detalleVenta.getCantidadVendida());
            stmt.setDouble(4, detalleVenta.getPrecioMedicamento());
            stmt.setDouble(5, detalleVenta.getTotalVendido());
            stmt.executeUpdate();
        }
    }

  
    public DetalleVenta obtenerDetalleVenta(int id) throws SQLException {
        String sql = "SELECT * FROM DetalleVenta WHERE id_detalleVenta = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new DetalleVenta(
                    rs.getInt("id_detalleVenta"),
                    rs.getInt("id_venta"),
                    rs.getInt("id_medicamento"),
                    rs.getInt("cantidadVendida"),
                    rs.getDouble("precioMedicamento"),
                    rs.getDouble("TotalVendido")
                );
            }
        }
        return null;
    }

   
    public List<DetalleVenta> obtenerDetallesVenta(int idVenta) throws SQLException {
        List<DetalleVenta> detalles = new ArrayList<>();
        String sql = "SELECT * FROM DetalleVenta WHERE id_venta = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idVenta);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                detalles.add(new DetalleVenta(
                    rs.getInt("id_detalleVenta"),
                    rs.getInt("id_venta"),
                    rs.getInt("id_medicamento"),
                    rs.getInt("cantidadVendida"),
                    rs.getDouble("precioMedicamento"),
                    rs.getDouble("TotalVendido")
                ));
            }
        }
        return detalles;
    }


    public void actualizarDetalleVenta(DetalleVenta detalleVenta) throws SQLException {
        String sql = "UPDATE DetalleVenta SET cantidadVendida = ?, precioMedicamento = ?, TotalVendido = ? WHERE id_detalleVenta = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, detalleVenta.getCantidadVendida());
            stmt.setDouble(2, detalleVenta.getPrecioMedicamento());
            stmt.setDouble(3, detalleVenta.getTotalVendido());
            stmt.setInt(4, detalleVenta.getId_detalleVenta());
            stmt.executeUpdate();
        }
    }

   
    public void eliminarDetalleVenta(int id) throws SQLException {
        String sql = "DELETE FROM DetalleVenta WHERE id_detalleVenta = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
