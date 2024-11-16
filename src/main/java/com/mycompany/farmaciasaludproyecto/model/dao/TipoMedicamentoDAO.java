package com.mycompany.farmaciasaludproyecto.model.dao;
import com.mycompany.farmaciasaludproyecto.model.entity.TipoMedicamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniela
 */
public class TipoMedicamentoDAO {
     public void insertarTipoMedicamento(TipoMedicamento tipoMedicamento) throws SQLException {
        String sql = "INSERT INTO TipoMedicamento (nombre, descripcion) VALUES (?, ?)";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tipoMedicamento.getNombre());
            stmt.setString(2, tipoMedicamento.getDescripcion());
            stmt.executeUpdate();
        }
    }

    public TipoMedicamento obtenerTipoMedicamento(int id) throws SQLException {
        String sql = "SELECT * FROM TipoMedicamento WHERE id_tipo = ?";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new TipoMedicamento(
                    rs.getInt("id_tipo"),
                    rs.getString("nombre"),
                    rs.getString("descripcion")
                );
            }
        }
        return null;
    }

    public List<TipoMedicamento> obtenerTodosLosTipos() throws SQLException {
        List<TipoMedicamento> tipos = new ArrayList<>();
        String sql = "SELECT * FROM TipoMedicamento";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                tipos.add(new TipoMedicamento(
                    rs.getInt("id_tipo"),
                    rs.getString("nombre"),
                    rs.getString("descripcion")
                ));
            }
        }
        return tipos;
    }

    public void actualizarTipoMedicamento(TipoMedicamento tipoMedicamento) throws SQLException {
        String sql = "UPDATE TipoMedicamento SET nombre = ?, descripcion = ? WHERE id_tipo = ?";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tipoMedicamento.getNombre());
            stmt.setString(2, tipoMedicamento.getDescripcion());
            stmt.setInt(3, tipoMedicamento.getId_tipo());
            stmt.executeUpdate();
        }
    }

    public void eliminarTipoMedicamento(int id) throws SQLException {
        String sql = "DELETE FROM TipoMedicamento WHERE id_tipo = ?";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
