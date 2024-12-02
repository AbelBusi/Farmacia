/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.farmaciasaludproyecto.model.dao;
import com.mycompany.farmaciasaludproyecto.model.entity.Proveedor;
import java.sql.*;
import java.util.LinkedList;
/**
 *
 * @author Daniela
 */
public class ProveedorDAO {
      public int agregarProveedor(Proveedor prove) {
        String sql = "INSERT INTO Proveedor (nombre, contacto, telefono) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, prove.getNombre());
            stmt.setString(2, prove.getContacto());
            stmt.setString(3, prove.getTelefono());
            stmt.executeUpdate();
            return 1;
        }catch (Exception e) {
            e.printStackTrace();  
            return 0;  
        }
    }

    public Proveedor leerProveedor(int id_proveedor) {
        Proveedor prove = null;
        String sql = "SELECT * FROM Proveedor WHERE id_proveedor = ?";
        try (Connection conn = Conexion.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id_proveedor);  
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                        prove = new Proveedor();
                        prove.setId_proveedor(rs.getInt("id_proveedor"));
                        prove.setNombre(rs.getString("nombre"));
                        prove.setContacto(rs.getString("contacto"));
                        prove.setTelefono(rs.getString("telefono"));
                     }
        }
    } catch (Exception e) {
        e.printStackTrace();  
    }
    return prove;  
   } 

    public LinkedList<Proveedor> listarProveedor() {
        LinkedList<Proveedor> datosProveedor = new LinkedList<>();
        String sql = "SELECT * FROM Proveedor";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Proveedor prove = new Proveedor();
                prove.setId_proveedor(rs.getInt("id_proveedor"));
                prove.setNombre(rs.getString("nombre"));
                prove.setContacto(rs.getString("contacto"));
                prove.setTelefono(rs.getString("telefono"));
                
                datosProveedor.add(prove);
            }
        }catch (Exception e) {
            e.printStackTrace(); 
        }
        return datosProveedor;
    }

    public int actualizarProveedor(Proveedor prove) {
        int resultado = 0;
        String sql = "UPDATE Proveedor SET nombre = ?, contacto = ?, telefono = ? WHERE id_proveedor = ?";
        try (Connection conn = Conexion.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, prove.getNombre());
            stmt.setString(2, prove.getContacto());
            stmt.setString(3, prove.getTelefono());
            stmt.setInt(4, prove.getId_proveedor());
            resultado = stmt.executeUpdate();
            if(resultado == 1){
                    return 1;
                }else{
                    return 0;
                }
        } catch (Exception e) {
            e.printStackTrace();  
        }

        return resultado; 
    }

    public void eliminarProveedor(int id_prove) {
        String sql = "DELETE FROM Proveedor WHERE id_proveedor = ?";
        try (Connection conn = Conexion.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id_prove);
        
        int filasAfectadas = stmt.executeUpdate();
        
        if (filasAfectadas > 0) {
            System.out.println("Proveedor eliminado correctamente.");
        } else {
            System.out.println("No se encontró el Proveedor.");
        }
    } catch (Exception e) {
        e.printStackTrace();  
    }
    }
}
