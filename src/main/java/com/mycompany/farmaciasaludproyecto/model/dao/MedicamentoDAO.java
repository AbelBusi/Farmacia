package com.mycompany.farmaciasaludproyecto.model.dao;
import com.mycompany.farmaciasaludproyecto.model.entity.Medicamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniela
 */
public class MedicamentoDAO {
       public void insertarMedicamento(Medicamento medicamento) throws SQLException {
        String sql = "INSERT INTO Medicamento (nombre, descripcion, precio, stock, fechaVencimiento, id_tipo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
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
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
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
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
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
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
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
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}
