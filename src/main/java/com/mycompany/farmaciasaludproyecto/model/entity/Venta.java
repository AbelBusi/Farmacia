/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.farmaciasaludproyecto.model.entity;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Daniela
 */
public class Venta implements Comparable<Venta>{
     private int id_venta;
    private int id_cliente; 
    private int id_vendedor; 
    private int id_descuento; 
    private BigDecimal total;
    private Date fechaVenta;
    private boolean vigente;

    public Venta( int id_cliente, int id_vendedor, int id_descuento, BigDecimal total) {
        this.id_cliente = id_cliente;
        this.id_vendedor = id_vendedor;
        this.id_descuento = id_descuento;
        this.total = total;

    }

    public Venta(int id_cliente, int id_vendedor, int id_descuento, BigDecimal total, Date fechaVenta, boolean vigente) {
        this.id_cliente = id_cliente;
        this.id_vendedor = id_vendedor;
        this.id_descuento = id_descuento;
        this.total = total;
        this.fechaVenta = fechaVenta;
        this.vigente = vigente;
    }
    
    

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public int getId_descuento() {
        return id_descuento;
    }

    public void setId_descuento(int id_descuento) {
        this.id_descuento = id_descuento;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    
    

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    @Override
    public int compareTo(Venta o) {
        return Comparator.comparing(Venta::getFechaVenta).
                thenComparing(Venta::getFechaVenta).compare(this, o); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Object[] convertir (){
    
        Object[] fila = {id_venta,id_cliente,id_vendedor,id_descuento,total,fechaVenta,vigente};
        return fila;
        
    }
    
}
