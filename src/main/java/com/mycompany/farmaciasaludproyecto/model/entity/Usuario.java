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
public class Usuario implements Comparable<Usuario>{
     private int id_usuario;
    private String nombres;
    private String apellidos;
    private String dni;
    private String telefono;
    private String correo;
    private String clave;
    private int estado;
    private String rol;
    private int id_vendedor;

    public Usuario(int id_usuario, String nombres, String apellidos, String dni, String telefono, String correo, String clave, int estado, String rol, int id_vendedor) {
        this.id_usuario = id_usuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.correo = correo;
        this.clave = clave;
        this.estado = estado;
        this.rol=rol;
        this.id_vendedor= id_vendedor;
    }

    public Usuario() {
    }
    
    
    
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }



    @Override
    public int compareTo(Usuario o) {
        return Comparator.comparing(Usuario::getNombres).
                thenComparing(Usuario::getNombres).compare(this, o); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Object[] convertir (){
    
        Object[] fila = {id_usuario,nombres,apellidos,dni,telefono,correo,clave,estado,rol,id_vendedor};
        return fila;
        
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
}
