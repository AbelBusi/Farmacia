/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.farmaciasaludproyecto.model.entity;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author Daniela
 */
public class Compra {
     private int id_compra;
    private int id_proveedor; 
    private BigDecimal total;
    private Date fechaCompra;
    private boolean vigente;

    public Compra(int id_compra, int id_proveedor, BigDecimal total, Date fechaCompra, boolean vigente) {
        this.id_compra = id_compra;
        this.id_proveedor = id_proveedor;
        this.total = total;
        this.fechaCompra = fechaCompra;
        this.vigente = vigente;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

  
}
