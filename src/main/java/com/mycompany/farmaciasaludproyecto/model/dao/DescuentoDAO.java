package com.mycompany.farmaciasaludproyecto.model.dao;

import com.mycompany.farmaciasaludproyecto.model.entity.Descuento;
import static com.mycompany.farmaciasaludproyecto.view.menu.InterRegistrarVenta.jTable_productos;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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

        try (Connection con = Conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id_descuento");
                String nombre = rs.getString("nombre");
                double total = rs.getDouble("total");
                boolean estado =rs.getBoolean("estado");

                listaDescuentos.add(new Descuento(id, nombre, total,estado));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDescuentos;
    }

    private void cargarDescuentos() {
        // SQL para obtener los descuentos con estado = 1
        String sql = "SELECT id_descuento, nombre, total FROM Descuento WHERE estado = 1";

        // Variables para manejar la conexión
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            // Conexión a la base de datos
            conn = Conexion.conectar(); // Asegúrate de tener tu clase Conexion configurada
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            // Limpiar el JTable
            DefaultTableModel modelo = (DefaultTableModel) jTable_productos.getModel();
            modelo.setRowCount(0); // Elimina las filas previas

            // Iterar sobre los resultados y agregar las filas al JTable
            while (rs.next()) {
                Object[] fila = new Object[3];
                fila[0] = rs.getInt("id_descuento");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getBigDecimal("total");

                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los descuentos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public boolean actualizarDescuentop(Descuento descuento) {
        String query = "UPDATE Descuento SET estado = 1 WHERE id_descuento = ?";
        try (Connection connection = Conexion.conectar(); PreparedStatement pst = connection.prepareStatement(query)) {

            // Establecer los parámetros de la consulta
            pst.setInt(1, descuento.getId_descuento());  // Establecer el ID del descuento

            int filasAfectadas = pst.executeUpdate();  // Ejecutar la actualización

            return filasAfectadas > 0;  // Retornar true si se actualizó correctamente
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;  // En caso de error, retornar false
        }
    }

    public boolean eliminarDescuentoP(int idDescuento) {
        String query = "UPDATE Descuento SET estado = 0 WHERE id_descuento = ?";
        try (Connection connection = Conexion.conectar(); PreparedStatement pst = connection.prepareStatement(query)) {

            // Establecer el ID del descuento
            pst.setInt(1, idDescuento);

            int filasAfectadas = pst.executeUpdate();  // Ejecutar la actualización

            return filasAfectadas > 0;  // Retornar true si se actualizó correctamente
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;  // En caso de error, retornar false
        }
    }
    
    public boolean actualizarDescuentoP(Descuento descuento) {
    String query = "UPDATE Descuento SET nombre = ?, total = ? WHERE id_descuento = ?";
    try (Connection connection = Conexion.conectar(); PreparedStatement pst = connection.prepareStatement(query)) {
        
        // Establecer los parámetros de la consulta
        pst.setString(1, descuento.getNombre());
        pst.setDouble(2, descuento.getTotal());
        pst.setInt(3, descuento.getId_descuento());
        
        int filasAfectadas = pst.executeUpdate();  // Ejecutar la actualización
        
        return filasAfectadas > 0;  // Retornar true si se actualizó correctamente
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;  // En caso de error, retornar false
    }
}


}
