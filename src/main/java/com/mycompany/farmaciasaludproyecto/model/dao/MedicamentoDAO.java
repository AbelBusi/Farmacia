package com.mycompany.farmaciasaludproyecto.model.dao;

import com.mycompany.farmaciasaludproyecto.model.entity.Descuento;
import com.mycompany.farmaciasaludproyecto.model.entity.Medicamento;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Daniela
 */
public class MedicamentoDAO {

    public void insertarMedicamento(Medicamento medicamento) throws SQLException {
        String sql = "INSERT INTO Medicamento (nombre, descripcion, precio, stock, fechaVencimiento, id_tipo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medicamento.getNombre());
            stmt.setString(2, medicamento.getDescripcion());
            stmt.setBigDecimal(3, medicamento.getPrecio());
            stmt.setInt(4, medicamento.getStock());
            stmt.setDate(5, medicamento.getFechaVencimiento());
            stmt.setInt(6, medicamento.getId_tipo());
            stmt.executeUpdate();
        }
    }

    public Medicamento obtenerMedicamento(int id) throws SQLException {
        String sql = "SELECT * FROM Medicamento WHERE id_medicamento = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Medicamento(
                        rs.getInt("id_medicamento"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getBigDecimal("precio"),
                        rs.getInt("stock"),
                        rs.getDate("fechaVencimiento"),
                        rs.getInt("id_tipo")
                );
            }
        }
        return null;
    }

    public List<Medicamento> obtenerTodosLosMedicamentos() throws SQLException {
        List<Medicamento> medicamentos = new ArrayList<>();
        String sql = "SELECT * FROM Medicamento";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                medicamentos.add(new Medicamento(
                        rs.getInt("id_medicamento"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getBigDecimal("precio"),
                        rs.getInt("stock"),
                        rs.getDate("fechaVencimiento"),
                        rs.getInt("id_tipo")
                ));
            }
        }
        return medicamentos;
    }

    public void actualizarMedicamento(Medicamento medicamento) throws SQLException {
        String sql = "UPDATE Medicamento SET nombre = ?, descripcion = ?, precio = ?, stock = ?, fechaVencimiento = ?, id_tipo = ? WHERE id_medicamento = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medicamento.getNombre());
            stmt.setString(2, medicamento.getDescripcion());
            stmt.setBigDecimal(3, medicamento.getPrecio());
            stmt.setInt(4, medicamento.getStock());
            stmt.setDate(5, medicamento.getFechaVencimiento());
            stmt.setInt(6, medicamento.getId_tipo());
            stmt.setInt(7, medicamento.getId_medicamento());
            stmt.executeUpdate();
        }
    }

    public void eliminarMedicamento(int id) throws SQLException {
        String sql = "DELETE FROM Medicamento WHERE id_medicamento = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public LinkedList<Medicamento> obtenerMedicamentos() throws SQLException {
        LinkedList<Medicamento> listaMedicamentos = new LinkedList<>();
        String query = "SELECT * FROM Medicamento";  // Consulta SQL para obtener todos los medicamentos

        try (Connection connection = Conexion.conectar(); Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id_medicamento = rs.getInt("id_medicamento");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                BigDecimal precio = rs.getBigDecimal("precio");
                int stock = rs.getInt("stock");
                Date fechaVencimiento = rs.getDate("fechaVencimiento");
                int id_tipo = rs.getInt("id_tipo");

                // Crear el objeto Medicamento y añadirlo a la lista
                Medicamento medicamento = new Medicamento(id_medicamento, nombre, descripcion, precio,
                        stock, fechaVencimiento, id_tipo);
                listaMedicamentos.add(medicamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaMedicamentos;
    }

    public LinkedList<String> obtenerNombresMedicamentos() {
        LinkedList<String> nombresMedicamentos = new LinkedList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Conexion.conectar();
            String sql = "SELECT nombre FROM Medicamento";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                nombresMedicamentos.add(rs.getString("nombre"));
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

        return nombresMedicamentos;
    }

    public Medicamento obtenerMedicamentoPorNombre(String nombre) {
        Medicamento medicamento = null;
        try {
            String sql = "SELECT id_medicamento, nombre, descripcion, precio, stock, fechaVencimiento, id_tipo "
                    + "FROM Medicamento WHERE nombre = ?";
            PreparedStatement ps = Conexion.conectar().prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                medicamento = new Medicamento();
                medicamento.setId_medicamento(rs.getInt("id_medicamento"));
                medicamento.setNombre(rs.getString("nombre"));
                medicamento.setDescripcion(rs.getString("descripcion"));
                medicamento.setPrecio(rs.getBigDecimal("precio"));
                medicamento.setStock(rs.getInt("stock"));
                medicamento.setFechaVencimiento(rs.getDate("fechaVencimiento"));
                medicamento.setId_tipo(rs.getInt("id_tipo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicamento;
    }

}
