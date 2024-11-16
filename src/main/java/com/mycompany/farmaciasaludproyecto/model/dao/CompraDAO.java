package com.mycompany.farmaciasaludproyecto.model.dao;
import com.mycompany.farmaciasaludproyecto.model.entity.Compra;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniela
 */
public class CompraDAO {
       public void insertarCompra(Compra compra) throws SQLException {
        String sql = "INSERT INTO Compra (id_proveedor, total, fechaCompra, vigente) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, compra.getId_proveedor());
            stmt.setBigDecimal(2, compra.getTotal());
            stmt.setDate(3, compra.getFechaCompra());
            stmt.setBoolean(4, compra.isVigente());
            stmt.executeUpdate();
        }
    }

    public Compra obtenerCompra(int id) throws SQLException {
        String sql = "SELECT * FROM Compra WHERE id_compra = ?";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Compra(
                    rs.getInt("id_compra"),
                    rs.getInt("id_proveedor"),
                    rs.getBigDecimal("total"),
                    rs.getDate("fechaCompra"),
                    rs.getBoolean("vigente")
                );
            }
        }
        return null;
    }

    public List<Compra> obtenerTodasLasCompras() throws SQLException {
        List<Compra> compras = new ArrayList<>();
        String sql = "SELECT * FROM Compra";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                compras.add(new Compra(
                    rs.getInt("id_compra"),
                    rs.getInt("id_proveedor"),
                    rs.getBigDecimal("total"),
                    rs.getDate("fechaCompra"),
                    rs.getBoolean("vigente")
                ));
            }
        }
        return compras;
    }

    public void actualizarCompra(Compra compra) throws SQLException {
        String sql = "UPDATE Compra SET id_proveedor = ?, total = ?, fechaCompra = ?, vigente = ? WHERE id_compra = ?";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, compra.getId_proveedor());
            stmt.setBigDecimal(2, compra.getTotal());
            stmt.setDate(3, compra.getFechaCompra());
            stmt.setBoolean(4, compra.isVigente());
            stmt.setInt(5, compra.getId_compra());
            stmt.executeUpdate();
        }
    }

    public void eliminarCompra(int id) throws SQLException {
        String sql = "DELETE FROM Compra WHERE id_compra = ?";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
