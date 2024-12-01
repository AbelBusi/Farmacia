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
public class TipoMedicamento implements Comparable<TipoMedicamento> {

    private int id_tipo;
    private String nombre;
    private String descripcion;
    
    public TipoMedicamento(int id_tipo, String nombre, String descripcion) {
        this.id_tipo = id_tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public int getId_tipo() {
        return id_tipo;
    }
    
    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public int compareTo(TipoMedicamento o) {
        return Comparator.comparing(TipoMedicamento::getNombre).
                thenComparing(TipoMedicamento::getNombre).compare(this, o); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Object[] convertir (){
        
        Object[] fila = {id_tipo,nombre,descripcion};
        
        return fila;
        
    }
    
        public Object[] convertirObj (int n){
        
        Object[] fila = {id_tipo,nombre,descripcion};
        
        return fila;
        
    }
    
}
