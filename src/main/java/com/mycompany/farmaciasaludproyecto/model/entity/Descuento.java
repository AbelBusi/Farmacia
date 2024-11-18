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
public class Descuento implements Comparable<Descuento>{
     private int id_descuento;
    private String nombre;
    private double total;

    public Descuento(int id_descuento, String nombre, double total) {
        this.id_descuento = id_descuento;
        this.nombre = nombre;
        this.total = total;
    }

    public int getId_descuento() {
        return id_descuento;
    }

    public void setId_descuento(int id_descuento) {
        this.id_descuento = id_descuento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public int compareTo(Descuento o) {
        return Comparator.comparing(Descuento::getTotal).
                thenComparing(Descuento::getTotal).compare(this, o); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Object[] convertir (){
        Object[] fila = {nombre,total};
        return fila;
        
    }
    
}
