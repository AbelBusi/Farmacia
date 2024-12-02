/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.farmaciasaludproyecto.model.entity;

import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Daniela
 */
public class Devolucion implements Comparable<Devolucion>{
     private int id_devolucion;
    private int id_venta; 
    private String motivo;
    private Date fechaRechazo;
    private boolean vigente;

    public Devolucion(int id_devolucion, int id_venta, String motivo, Date fechaRechazo, boolean vigente) {
        this.id_devolucion = id_devolucion;
        this.id_venta = id_venta;
        this.motivo = motivo;
        this.fechaRechazo = fechaRechazo;
        this.vigente = vigente;
    }

    public Devolucion(int id_venta, String motivo, Date fechaRechazo, boolean vigente) {
        this.id_venta = id_venta;
        this.motivo = motivo;
        this.fechaRechazo = fechaRechazo;
        this.vigente = vigente;
    }

    public Devolucion() {
    }
    
    
    
    

    public int getId_devolucion() {
        return id_devolucion;
    }

    public void setId_devolucion(int id_devolucion) {
        this.id_devolucion = id_devolucion;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFechaRechazo() {
        return fechaRechazo;
    }

    public void setFechaRechazo(Date fechaRechazo) {
        this.fechaRechazo = fechaRechazo;
    }


    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    @Override
    public int compareTo(Devolucion o) {
        return Comparator.comparing(Devolucion::getFechaRechazo).
                thenComparing(Devolucion::getFechaRechazo).compare(this, o); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Object[] convertir (){
    
        Object[] fila = {id_devolucion,id_venta,motivo,fechaRechazo,vigente};
        return  fila;
        
    }
    

}
