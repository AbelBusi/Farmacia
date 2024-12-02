/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.farmaciasaludproyecto.model.dao;

import com.mycompany.farmaciasaludproyecto.model.entity.Devolucion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

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
            ps.setBoolean(3, true);  // La devolución está vigente al crearla
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     public LinkedList<Devolucion> obtenerDevoluciones() {
        LinkedList<Devolucion> listaDevoluciones = new LinkedList<>();
        String query = "SELECT id_devolucion, id_venta, motivo,fechaReclamo, vigente FROM Devolucion";

        try (Connection conn = Conexion.conectar(); 
             PreparedStatement ps = conn.prepareStatement(query); 
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Devolucion devolucion = new Devolucion();
                devolucion.setId_devolucion(rs.getInt("id_devolucion"));
                devolucion.setId_venta(rs.getInt("id_venta"));
                devolucion.setMotivo(rs.getString("motivo"));
                devolucion.setFechaRechazo(rs.getDate("fechaReclamo"));
                devolucion.setVigente(rs.getBoolean("vigente"));
                listaDevoluciones.add(devolucion);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDevoluciones;
    }

}
