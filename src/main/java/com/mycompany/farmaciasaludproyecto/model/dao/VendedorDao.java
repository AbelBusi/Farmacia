/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.farmaciasaludproyecto.model.dao;

import com.mycompany.farmaciasaludproyecto.model.entity.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class VendedorDao {

    public LinkedList<Vendedor> obtenerTodosLosVendedores() {
        LinkedList<Vendedor> vendedores = new LinkedList<>();
        String sql = "SELECT nombres, apellidos, telefono, estado FROM Usuario WHERE rol = 'vendedor'";

        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Vendedor vendedor = new Vendedor();
                vendedor.setNombres(rs.getString("nombres"));
                vendedor.setApellidos(rs.getString("apellidos"));
                vendedor.setTelefono(rs.getString("telefono"));
                vendedor.setEstado(rs.getBoolean("estado")); // Ahora es boolean
                vendedores.add(vendedor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vendedores;
    }

    public LinkedList<Vendedor> listarVendedor() {
        LinkedList<Vendedor> datosVendedor = new LinkedList<>();
        String sql = "SELECT * FROM vendedor WHERE estado = TRUE";

        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Vendedor vend = new Vendedor();
                vend.setId_vendedor(rs.getInt("id_vendedor"));
                vend.setNombres(rs.getString("nombres"));
                vend.setApellidos(rs.getString("apellidos"));
                vend.setDni(rs.getString("dni"));
                vend.setTelefono(rs.getString("telefono"));
                vend.setCorreo(rs.getString("correo"));
                vend.setEstado(rs.getBoolean("estado"));

                datosVendedor.add(vend);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datosVendedor;
    }

    public int agregarVend(Vendedor vend) {
        String sql = "INSERT INTO vendedor (nombres, apellidos, dni, telefono, correo) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, vend.getNombres());
            stmt.setString(2, vend.getApellidos());
            stmt.setString(3, vend.getDni());
            stmt.setString(4, vend.getTelefono());
            stmt.setString(5, vend.getCorreo());
            stmt.executeUpdate();
            return 1;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Vendedor leerVendedor(int id_vendedor) {
        Vendedor vend = null;
        String sql = "SELECT * FROM vendedor WHERE id_vendedor = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_vendedor);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    vend = new Vendedor();
                    vend.setId_vendedor(rs.getInt("id_vendedor"));
                    vend.setNombres(rs.getString("nombres"));
                    vend.setApellidos(rs.getString("apellidos"));
                    vend.setDni(rs.getString("dni"));
                    vend.setTelefono(rs.getString("telefono"));
                    vend.setCorreo(rs.getString("correo"));
                    vend.setEstado(rs.getBoolean("estado"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vend;
    }

    public int actualizarVendedor(Vendedor vend) {
        int resultado = 0;
        String sql = "UPDATE vendedor SET nombres = ?, apellidos = ?, dni = ?, telefono = ?, correo = ?, estado = ? "
                + "WHERE id_vendedor = ?";

        try (
                Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, vend.getNombres());
            stmt.setString(2, vend.getApellidos());
            stmt.setString(3, vend.getDni());
            stmt.setString(4, vend.getTelefono());
            stmt.setString(5, vend.getCorreo());
            stmt.setBoolean(6, vend.isEstado());
            stmt.setInt(7, vend.getId_vendedor());

            resultado = stmt.executeUpdate();
            if (resultado == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }

    public void deleteVendedor(int id_vend) {
        String sql = "UPDATE Vendedor SET estado = FALSE WHERE id_vendedor = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id_vend);

            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Vendedor eliminado correctamente.");
            } else {
                System.out.println("No se encontró el vendedor.");
            }
        } catch (Exception e) {
            e.printStackTrace();  // Muestra el error completo en caso de excepción
        }

    }

    public boolean dniExiste(String dni) {
        String sql = "SELECT COUNT(*) FROM Vendedor WHERE dni = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dni);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0; // Devuelve true si hay al menos un registro
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public int obtenerIdPorDni(String dni) {
        String sql = "SELECT id_vendedor FROM Vendedor WHERE dni = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dni);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id_vendedor");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1; // Si no se encuentra el vendedor
    }

    public LinkedList<String> obtenerNombreVendedor() {
        LinkedList<String> nombresVendedores = new LinkedList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Conexion.conectar();
            String sql = "SELECT nombres FROM Vendedor";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                nombresVendedores.add(rs.getString("nombres"));
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

        return nombresVendedores;
    }

}
