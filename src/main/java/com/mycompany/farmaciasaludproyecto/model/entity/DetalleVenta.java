/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.farmaciasaludproyecto.model.entity;

/**
 *
 * @author Daniela
 */
public class DetalleVenta {
     private int id_detalleVenta;
    private int id_venta; 
    private int id_medicamento; 
    private int cantidadVendida;
    private double precioMedicamento;
    private double totalVendido;

    public DetalleVenta(int id_detalleVenta, int id_venta, int id_medicamento, int cantidadVendida, double precioMedicamento, double totalVendido) {
        this.id_detalleVenta = id_detalleVenta;
        this.id_venta = id_venta;
        this.id_medicamento = id_medicamento;
        this.cantidadVendida = cantidadVendida;
        this.precioMedicamento = precioMedicamento;
        this.totalVendido = totalVendido;
    }

    public int getId_detalleVenta() {
        return id_detalleVenta;
    }

    public void setId_detalleVenta(int id_detalleVenta) {
        this.id_detalleVenta = id_detalleVenta;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_medicamento() {
        return id_medicamento;
    }

    public void setId_medicamento(int id_medicamento) {
        this.id_medicamento = id_medicamento;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public double getPrecioMedicamento() {
        return precioMedicamento;
    }

    public void setPrecioMedicamento(double precioMedicamento) {
        this.precioMedicamento = precioMedicamento;
    }

    public double getTotalVendido() {
        return totalVendido;
    }

    public void setTotalVendido(double totalVendido) {
        this.totalVendido = totalVendido;
    }
    
    
}
