/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.farmaciasaludproyecto.model.entity;

/**
 *
 * @author Daniela
 */
public class Proveedor {
    private int id_proveedor;
    private String nombre;
    private String contacto;
    private String telefono;

    public Proveedor(int id_proveedor, String nombre, String contacto, String telefono) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.contacto = contacto;
        this.telefono = telefono;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}