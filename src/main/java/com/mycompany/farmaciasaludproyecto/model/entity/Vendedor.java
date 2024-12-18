/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.farmaciasaludproyecto.model.entity;

import java.util.Comparator;

/**
 *
 * @author Daniela
 */
public class Vendedor implements Comparable<Vendedor>{
    private int id_vendedor;
    private String nombres;
    private String apellidos;
    private String dni;
    private String telefono;
    private String correo;
    private boolean estado;
    private int id_usuario;

    public Vendedor(int id_vendedor, String nombres, String apellidos, String dni, String telefono, String correo, boolean estado, int id_usuario) {
        this.id_vendedor = id_vendedor;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.correo = correo;
        this.estado = estado;
        this.id_usuario = id_usuario;
    }

    public Vendedor() {
    }
    
    

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }


    @Override
    public int compareTo(Vendedor o) {
        return Comparator.comparing(Vendedor::getNombres).
                thenComparing(Vendedor::getNombres).compare(this, o); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Object[] convertir (int Num){
    
        return new Object[]{
            nombres,
            apellidos,
            telefono,
            (estado? "Activo" : "Inactivo")
        };
        
    }
    
}
