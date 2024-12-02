/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.farmaciasaludproyecto.model.dao;

import com.mycompany.farmaciasaludproyecto.model.entity.Venta;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;

/**
 *
 * @author cesar
 */
public class VentaDAO {

    public boolean guardarVenta(Venta venta) {
        String sql = "INSERT INTO venta (id_cliente, id_vendedor, id_descuento, total) VALUES (?, ?, ?, ?)";
        try (
                Connection connection = Conexion.conectar(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            // Establecer los parámetros de la consulta SQL
            stmt.setInt(1, venta.getId_cliente());
            stmt.setInt(2, venta.getId_vendedor());
            stmt.setInt(3, venta.getId_descuento());
            stmt.setBigDecimal(4, venta.getTotal());

            // Ejecutar la inserción
            int filasAfectadas = stmt.executeUpdate();

            return filasAfectadas > 0; // Retorna true si se insertaron filas en la base de datos
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int obtenerIdPorNombre(String nombre) {
        int idVendedor = -1; // Valor por defecto si no se encuentra el vendedor
        String query = "SELECT id_vendedor FROM Vendedor WHERE nombres = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nombre); // Reemplaza el placeholder con el nombre

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    idVendedor = rs.getInt("id_vendedor"); // Obtén el id_vendedor
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return idVendedor;

    }
}
