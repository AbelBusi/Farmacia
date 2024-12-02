package com.mycompany.farmaciasaludproyecto.model.dao;

import com.mycompany.farmaciasaludproyecto.model.entity.Descuento;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Daniela
 */
public class DescuentoDAO {

    public void insertarDescuento(Descuento descuento) throws SQLException {
        String sql = "INSERT INTO Descuento (nombre, total) VALUES (?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, descuento.getNombre());
            stmt.setDouble(2, descuento.getTotal());
            stmt.executeUpdate();
        }
    }

    public Descuento obtenerDescuento(int id) throws SQLException {
        String sql = "SELECT * FROM Descuento WHERE id_descuento = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
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
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
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
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, descuento.getNombre());
            stmt.setDouble(2, descuento.getTotal());
            stmt.setInt(3, descuento.getId_descuento());
            stmt.executeUpdate();
        }
    }

    public void eliminarDescuento(int id) throws SQLException {
        String sql = "DELETE FROM Descuento WHERE id_descuento = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public LinkedList<String> obtenerNombresDescuentos() {
        LinkedList<String> nombresDescuentos = new LinkedList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Conexion.conectar();
            String sql = "SELECT nombre FROM Descuento";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                nombresDescuentos.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return nombresDescuentos;
    }

    public Descuento obtenerDescuentoPorNombre(String nombre) throws SQLException {
        String sql = "SELECT * FROM Descuento WHERE nombre LIKE ?";
        try (
                Connection connection = Conexion.conectar(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%" + nombre + "%");
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Descuento(
                        rs.getInt("id_descuento"),
                        rs.getString("nombre"),
                        rs.getDouble("total")
                );
            }
        }
        return null; // Si no se encuentra
    }

    public int obtenerIdPorNombre(String nombre) {
        int idDescuento = -1; // Valor predeterminado si no se encuentra el descuento
        String query = "SELECT id_descuento FROM Descuento WHERE nombre = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nombre); // Reemplaza el placeholder con el nombre

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    idDescuento = rs.getInt("id_descuento"); // Obtén el id_descuento
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return idDescuento;
    }
    
    public LinkedList<Descuento> obtenerDescuentos() {
    LinkedList<Descuento> listaDescuentos = new LinkedList<>();
    String sql = "SELECT * FROM Descuento";

    try (Connection con = Conexion.conectar();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            int id = rs.getInt("id_descuento");
            String nombre = rs.getString("nombre");
            double total = rs.getDouble("total");

            listaDescuentos.add(new Descuento(id, nombre, total));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return listaDescuentos;
}

}
