package com.mycompany.farmaciasaludproyecto.model.dao;

import com.mycompany.farmaciasaludproyecto.model.entity.Descuento;
import com.mycompany.farmaciasaludproyecto.model.entity.Medicamento;
import com.mycompany.farmaciasaludproyecto.model.entity.TipoMedicamento;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

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

    public LinkedList<Medicamento> obtenerMedicamentosP() {
        LinkedList<Medicamento> lista = new LinkedList<>();
        try (Connection conexion = Conexion.conectar(); PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM Medicamento")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Medicamento medicamento = new Medicamento();
                medicamento.setId_medicamento(rs.getInt("id_medicamento"));
                medicamento.setNombre(rs.getString("nombre"));
                medicamento.setDescripcion(rs.getString("descripcion"));
                medicamento.setPrecio(rs.getBigDecimal("precio"));
                medicamento.setStock(rs.getInt("stock"));
                medicamento.setFechaVencimiento(rs.getDate("fechaVencimiento"));
                medicamento.setId_tipo(rs.getInt("id_tipo")); // Puedes usar un JOIN para obtener el nombre del tipo
                lista.add(medicamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;

    }

    public LinkedList<Medicamento> obtenerMedicamentosActivos() {
        LinkedList<Medicamento> lista = new LinkedList<>();
        Conexion con = new Conexion();

        try (Connection connection = con.conectar()) {
            String query = "SELECT * FROM Medicamento WHERE estado = 1";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Medicamento medicamento = new Medicamento(
                        resultSet.getInt("id_medicamento"),
                        resultSet.getString("nombre"),
                        resultSet.getString("descripcion"),
                        resultSet.getBigDecimal("precio"),
                        resultSet.getInt("stock"),
                        resultSet.getDate("fechaVencimiento"),
                        resultSet.getInt("id_tipo"),
                        resultSet.getBoolean("estado") // Asegúrate de tener este campo en tu clase
                );
                lista.add(medicamento);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener medicamentos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public boolean desactivarMedicamento(int idMedicamento) {
        String sql = "UPDATE Medicamento SET estado = 0 WHERE id_medicamento = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idMedicamento); // Asignar el ID al parámetro
            int rowsAffected = stmt.executeUpdate();

            // Depuración: Mostrar filas afectadas
            System.out.println("Filas afectadas: " + rowsAffected);

            return rowsAffected > 0; // Retorna true si se actualizó alguna fila
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void cambiarEstado(int idMedicamento, int nuevoEstado) {
        Conexion con = new Conexion();
        String query = "UPDATE Medicamentos SET estado = ? WHERE id_medicamento = ?";

        try (
                Connection connection = con.conectar()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, nuevoEstado);
            statement.setInt(2, idMedicamento);
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cambiar el estado del medicamento: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarEnBaseDeDatos(int id, String nombre, String precio, String cantidad, String descripcion) {
        String sql = "UPDATE medicamento SET nombre = ?, precio = ?, stock = ?, descripcion = ? WHERE id_medicamento = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, precio);
            ps.setString(3, cantidad);
            ps.setString(4, descripcion);
            ps.setInt(5, id);

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el registro.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.getMessage());
        }
    }


}
