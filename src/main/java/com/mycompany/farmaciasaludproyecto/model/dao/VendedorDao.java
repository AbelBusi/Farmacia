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

/**
 *
 * @author cesar
 */
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
                vendedor.setVigente(rs.getBoolean("estado")); // Ahora es boolean
                vendedores.add(vendedor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vendedores;
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
