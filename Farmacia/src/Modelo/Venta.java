/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Daniela
 */
public class Venta {
     private int id_venta;
    private int id_cliente; 
    private int id_vendedor; 
    private int id_descuento; 
    private double total;
    private String fechaVenta;
    private boolean vigente;

    public Venta(int id_venta, int id_cliente, int id_vendedor, int id_descuento, double total, String fechaVenta, boolean vigente) {
        this.id_venta = id_venta;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }
    
}