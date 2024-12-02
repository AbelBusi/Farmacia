/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.farmaciasaludproyecto.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author cesar
 */
public class DevolucionDAO {

    public void crearDevolucion(int idVenta, String motivo) {
        // Usar una conexión a la base de datos para insertar la devolución
        String query = "INSERT INTO Devolucion (id_venta, motivo,  vigente) VALUES (?, ?,  ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, idVenta);
            ps.setString(2, motivo);
            ps.setBoolean(4, true);  // La devolución está vigente al crearla
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
