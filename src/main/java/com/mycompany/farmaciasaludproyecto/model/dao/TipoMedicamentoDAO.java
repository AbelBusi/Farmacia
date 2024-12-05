package com.mycompany.farmaciasaludproyecto.model.dao;

import com.mycompany.farmaciasaludproyecto.model.entity.TipoMedicamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Daniela
 */
public class TipoMedicamentoDAO {

    public void insertarTipoMedicamento(TipoMedicamento tipoMedicamento) throws SQLException {
        String sql = "INSERT INTO TipoMedicamento (nombre, descripcion) VALUES (?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tipoMedicamento.getNombre());
            stmt.setString(2, tipoMedicamento.getDescripcion());
            stmt.executeUpdate();
        }
    }

    public TipoMedicamento obtenerTipoMedicamento(int id) throws SQLException {
        String sql = "SELECT * FROM TipoMedicamento WHERE id_tipo = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
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
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
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
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tipoMedicamento.getNombre());
            stmt.setString(2, tipoMedicamento.getDescripcion());
            stmt.setInt(3, tipoMedicamento.getId_tipo());
            stmt.executeUpdate();
        }
    }

    public void eliminarTipoMedicamento(int id) throws SQLException {
        String sql = "DELETE FROM TipoMedicamento WHERE id_tipo = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public LinkedList<TipoMedicamento> obtenerLosTipos() {
        LinkedList<TipoMedicamento> tipos = new LinkedList<>();
        String query = "SELECT * FROM TipoMedicamento";

        try (Connection con = Conexion.conectar(); PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int idTipo = rs.getInt("id_tipo");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                boolean estado = rs.getBoolean("estado");
                tipos.add(new TipoMedicamento(idTipo, nombre, descripcion,estado));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipos;
    }

    public TipoMedicamento obtenerPorId(int idTipo) {
        TipoMedicamento tipo = null;
        try {
            // Supón que tienes un EntityManager o una conexión a la base de datos
            Connection connection = Conexion.conectar();
            String sql = "SELECT * FROM tipoMedicamento WHERE id_tipo = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idTipo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                tipo = new TipoMedicamento();
                tipo.setId_tipo(rs.getInt("id_tipo"));
                tipo.setNombre(rs.getString("nombre"));
                tipo.setEstado(rs.getBoolean("activo"));
                // Setea otros atributos de tipo Medicamento si es necesario
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipo;
    }

    public void actualizar(TipoMedicamento tipo) {
        try {
            String sql = "UPDATE tipo_medicamento SET activo = ? WHERE id_tipo = ?";
            Connection connection = Conexion.conectar();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setBoolean(1, tipo.getEstado());
            stmt.setInt(2, tipo.getId_tipo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean actualizarP(TipoMedicamento tipoMedicamento) {
    String sql = "UPDATE tipoMedicamento SET nombre = ?, descripcion = ? WHERE id_tipo = ?";
    try (Connection conn = Conexion.conectar(); 
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, tipoMedicamento.getNombre());
        pstmt.setString(2, tipoMedicamento.getDescripcion());
        pstmt.setInt(3, tipoMedicamento.getId_tipo());
        return pstmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

}
