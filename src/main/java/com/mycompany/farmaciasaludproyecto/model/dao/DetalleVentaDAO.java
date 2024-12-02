package com.mycompany.farmaciasaludproyecto.model.dao;

import com.mycompany.farmaciasaludproyecto.model.entity.DetalleVenta;
import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Daniela
 */
public class DetalleVentaDAO {

    public void insertarDetalleVenta(DetalleVenta detalleVenta) throws SQLException {
        String sql = "INSERT INTO DetalleVenta (id_venta, id_medicamento, cantidadVendida, precioMedicamento, TotalVendido) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, detalleVenta.getId_venta());
            stmt.setInt(2, detalleVenta.getId_medicamento());
            stmt.setInt(3, detalleVenta.getCantidadVendida());
            stmt.setBigDecimal(4, detalleVenta.getPrecioMedicamento());
            stmt.setBigDecimal(5, detalleVenta.getTotalVendido());
            stmt.executeUpdate();
        }
    }

    public DetalleVenta obtenerDetalleVenta(int id) throws SQLException {
        String sql = "SELECT * FROM DetalleVenta WHERE id_detalleVenta = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new DetalleVenta(
                        rs.getInt("id_detalleVenta"),
                        rs.getInt("id_venta"),
                        rs.getInt("id_medicamento"),
                        rs.getInt("cantidadVendida"),
                        rs.getBigDecimal("precioMedicamento"),
                        rs.getBigDecimal("TotalVendido")
                );
            }
        }
        return null;
    }

    public List<DetalleVenta> obtenerDetallesVenta(int idVenta) throws SQLException {
        List<DetalleVenta> detalles = new ArrayList<>();
        String sql = "SELECT * FROM DetalleVenta WHERE id_venta = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idVenta);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                detalles.add(new DetalleVenta(
                        rs.getInt("id_detalleVenta"),
                        rs.getInt("id_venta"),
                        rs.getInt("id_medicamento"),
                        rs.getInt("cantidadVendida"),
                        rs.getBigDecimal("precioMedicamento"),
                        rs.getBigDecimal("TotalVendido")
                ));
            }
        }
        return detalles;
    }

    public void actualizarDetalleVenta(DetalleVenta detalleVenta) throws SQLException {
        String sql = "UPDATE DetalleVenta SET cantidadVendida = ?, precioMedicamento = ?, TotalVendido = ? WHERE id_detalleVenta = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, detalleVenta.getCantidadVendida());
            stmt.setBigDecimal(2, detalleVenta.getPrecioMedicamento());
            stmt.setBigDecimal(3, detalleVenta.getTotalVendido());
            stmt.setInt(4, detalleVenta.getId_detalleVenta());
            stmt.executeUpdate();
        }
    }

    public void eliminarDetalleVenta(int id) throws SQLException {
        String sql = "DELETE FROM DetalleVenta WHERE id_detalleVenta = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public boolean registrarDetalleVenta(DetalleVenta detalle) {
        String queryDetalleVenta = "INSERT INTO DetalleVenta (id_venta, id_medicamento, cantidadVendida, precioMedicamento, TotalVendido) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(queryDetalleVenta)) {
            stmt.setInt(1, detalle.getId_venta());
            stmt.setInt(2, detalle.getId_medicamento());
            stmt.setInt(3, detalle.getCantidadVendida());
            stmt.setBigDecimal(4, detalle.getPrecioMedicamento());
            stmt.setBigDecimal(5, detalle.getTotalVendido());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
