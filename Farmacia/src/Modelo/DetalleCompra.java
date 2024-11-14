/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.math.BigDecimal;

/**
 *
 * @author Daniela
 */
public class DetalleCompra {
      private int id_detalleCompra;
    private int id_compra;
    private int id_medicamento; 
    private int stock;
    private BigDecimal precioUnitario;

    public DetalleCompra(int id_detalleCompra, int id_compra, int id_medicamento, int stock, BigDecimal precioUnitario) {
        this.id_detalleCompra = id_detalleCompra;
        this.id_compra = id_compra;
        this.id_medicamento = id_medicamento;
        this.stock = stock;
        this.precioUnitario = precioUnitario;
    }

    public int getId_detalleCompra() {
        return id_detalleCompra;
    }

    public void setId_detalleCompra(int id_detalleCompra) {
        this.id_detalleCompra = id_detalleCompra;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_medicamento() {
        return id_medicamento;
    }

    public void setId_medicamento(int id_medicamento) {
        this.id_medicamento = id_medicamento;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    
    
}
