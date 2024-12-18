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
public class Empresa implements Comparable<Empresa>{
     private int id_empresa;
    private String nombres;
    private String sucursal;
    private String ruc;
    private String direccion;

    public Empresa(int id_empresa, String nombres, String sucursal, String ruc, String direccion) {
        this.id_empresa = id_empresa;
        this.nombres = nombres;
        this.sucursal = sucursal;
        this.ruc = ruc;
        this.direccion = direccion;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int compareTo(Empresa o) {
        return Comparator.comparing(Empresa::getNombres).
                thenComparing(Empresa::getNombres).compare(this, o); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Object[] convertir (){
        
        Object[] fila = {id_empresa,nombres,sucursal,ruc,direccion};
        return fila;
        
    }
    
}
