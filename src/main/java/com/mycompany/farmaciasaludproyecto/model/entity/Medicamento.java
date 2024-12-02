/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.farmaciasaludproyecto.model.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Comparator;

/**
 *
 * @author Daniela
 */
public class Medicamento implements Comparable<Medicamento>{
    private int id_medicamento;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private int stock;
    private Date fechaVencimiento;
    private int id_tipo;

    public Medicamento(int id_medicamento, String nombre, String descripcion, BigDecimal precio, int stock, Date fechaVencimiento, int id_tipo) {
        this.id_medicamento = id_medicamento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.fechaVencimiento = fechaVencimiento;
        this.id_tipo = id_tipo;
    }

    public Medicamento() {
    }
    
    

    public int getId_medicamento() {
        return id_medicamento;
    }

    public void setId_medicamento(int id_medicamento) {
        this.id_medicamento = id_medicamento;
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

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    @Override
    public int compareTo(Medicamento o) {
        return Comparator.comparing(Medicamento::getNombre).
                thenComparing(Medicamento::getNombre).compare(this, o); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Object[] convertirObj (int n){
    
        Object[] fila = {id_medicamento,nombre,descripcion,precio,stock,fechaVencimiento,id_tipo};
        return fila;
        
    }
    
    public Object[] convertir (){
    
        Object[] fila = {id_medicamento,nombre,descripcion,precio,stock,fechaVencimiento,id_tipo};
        return fila;
        
    }

    
    
}
