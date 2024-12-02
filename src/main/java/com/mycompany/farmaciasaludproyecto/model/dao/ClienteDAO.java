package com.mycompany.farmaciasaludproyecto.model.dao;

import com.mycompany.farmaciasaludproyecto.model.entity.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ClienteDAO {

    public void insertarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Cliente (nombres, apellidos, dni, direccion, telefono) VALUES (?, ?, ?, ?, ?)";

        try (
                Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombres());
            stmt.setString(2, cliente.getApellidos());
            stmt.setString(3, cliente.getDni());
            stmt.setString(4, cliente.getDireccion());
            stmt.setString(5, cliente.getTelefono());
            stmt.executeUpdate();

        }
    }

    public Cliente obtenerCliente(int id) throws SQLException {
        String sql = "SELECT * FROM Cliente WHERE id_cliente = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("dni"),
                        rs.getString("direccion"),
                        rs.getString("telefono")
                );
            }
        }
        return null;
    }

    public List<Cliente> obtenerTodosLosClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                clientes.add(new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("dni"),
                        rs.getString("direccion"),
                        rs.getString("telefono")
                ));
            }
        }
        return clientes;
    }

    public void actualizarCliente(Cliente cliente) throws SQLException {
        String sql = "UPDATE Cliente SET nombres = ?, apellidos = ?, dni = ?, direccion = ?, telefono = ? WHERE id_cliente = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombres());
            stmt.setString(2, cliente.getApellidos());
            stmt.setString(3, cliente.getDni());
            stmt.setString(4, cliente.getDireccion());
            stmt.setString(5, cliente.getTelefono());
            stmt.setInt(6, cliente.getId_cliente());
            stmt.executeUpdate();
        }
    }

    public void eliminarCliente(int id) throws SQLException {
        String sql = "DELETE FROM Cliente WHERE id_cliente = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public boolean guardarCliente(Cliente cliente) {
        String sql = "INSERT INTO Cliente (nombres, apellidos, dni, direccion, telefono) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cliente.getNombres());
            ps.setString(2, cliente.getApellidos());
            ps.setString(3, cliente.getDni());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getTelefono());

            return ps.executeUpdate() > 0; // Devuelve true si se insertó correctamente
        } catch (SQLException e) {
            System.err.println("Error al guardar cliente: " + e.getMessage());
            return false;
        }
    }

    public LinkedList<Cliente> obtenerLosClientes() {
        LinkedList<Cliente> listaClientes = new LinkedList<>();
        String sql = "SELECT * FROM Cliente";
        try (Connection con = Conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNombres(rs.getString("nombres"));
                cliente.setApellidos(rs.getString("apellidos"));
                cliente.setDni(rs.getString("dni"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getString("telefono"));
                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener clientes: " + e.getMessage());
        }
        return listaClientes;
    }

    public LinkedList<String> obtenerNombresClientes() {
        LinkedList<String> nombresClientes = new LinkedList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Conexion.conectar();
            String sql = "SELECT nombres FROM Cliente";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                nombresClientes.add(rs.getString("nombres"));
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

        return nombresClientes;
    }

    public int obtenerIdPorNombre(String nombre) {
        int idCliente = -1; // Valor por defecto si no se encuentra el cliente
        String query = "SELECT id_cliente FROM Cliente WHERE nombres = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nombre); // Reemplaza el placeholder con el nombre

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    idCliente = rs.getInt("id_cliente"); // Obtén el id_cliente
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return idCliente;
    }
}
