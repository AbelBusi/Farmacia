/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.farmaciasaludproyecto.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author cesar
 */
public class VendedorDao {
    
    
    public boolean dniExiste(String dni) {
        String sql = "SELECT COUNT(*) FROM Vendedor WHERE dni = ?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

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

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

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
    
}
