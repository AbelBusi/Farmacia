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
public class DetalleCompraDAO {
      public void insertarDetalleCompra(DetalleCompra detalleCompra) throws SQLException {
        String sql = "INSERT INTO detalleCompra (id_compra, id_medicamento, stock, precioUnitario) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, detalleCompra.getId_compra());
            stmt.setInt(2, detalleCompra.getId_medicamento());
            stmt.setInt(3, detalleCompra.getStock());
            stmt.setBigDecimal(4, detalleCompra.getPrecioUnitario());
            stmt.executeUpdate();
        }
    }

    public DetalleCompra obtenerDetalleCompra(int id) throws SQLException {
        String sql = "SELECT * FROM detalleCompra WHERE id_detalleCompra = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new DetalleCompra(
                    rs.getInt("id_detalleCompra"),
                    rs.getInt("id_compra"),
                    rs.getInt("id_medicamento"),
                    rs.getInt("stock"),
                    rs.getBigDecimal("precioUnitario")
                );
            }
        }
        return null;
    }

    public List<DetalleCompra> obtenerTodosLosDetallesCompra() throws SQLException {
        List<DetalleCompra> detallesCompra = new ArrayList<>();
        String sql = "SELECT * FROM detalleCompra";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                detallesCompra.add(new DetalleCompra(
                    rs.getInt("id_detalleCompra"),
                    rs.getInt("id_compra"),
                    rs.getInt("id_medicamento"),
                    rs.getInt("stock"),
                    rs.getBigDecimal("precioUnitario")
                ));
            }
        }
        return detallesCompra;
    }

    public void actualizarDetalleCompra(DetalleCompra detalleCompra) throws SQLException {
        String sql = "UPDATE detalleCompra SET id_compra = ?, id_medicamento = ?, stock = ?, precioUnitario = ? WHERE id_detalleCompra = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, detalleCompra.getId_compra());
            stmt.setInt(2, detalleCompra.getId_medicamento());
            stmt.setInt(3, detalleCompra.getStock());
            stmt.setBigDecimal(4, detalleCompra.getPrecioUnitario());
            stmt.setInt(5, detalleCompra.getId_detalleCompra());
            stmt.executeUpdate();
        }
    }

    public void eliminarDetalleCompra(int id) throws SQLException {
        String sql = "DELETE FROM detalleCompra WHERE id_detalleCompra = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
