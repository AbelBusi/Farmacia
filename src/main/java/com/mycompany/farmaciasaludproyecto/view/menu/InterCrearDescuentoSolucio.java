/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.farmaciasaludproyecto.view.menu;

import com.mycompany.farmaciasaludproyecto.model.dao.DescuentoDAO;
import com.mycompany.farmaciasaludproyecto.model.entity.Descuento;
import java.awt.Dimension;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author cesar
 */
public class InterCrearDescuentoSolucio extends javax.swing.JInternalFrame {

    /**
     * Creates new form InterCrearDescuentoSolucion
     */
    //variables
    int idProducto = 0;
    int cantidad = 0;
    DescuentoDAO descuentoDAO;

    public InterCrearDescuentoSolucio() {
        initComponents();
        setTitle("Crear descuento");
        setSize(new Dimension(400, 300));
        descuentoDAO = new DescuentoDAO();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_cantidad_actual = new javax.swing.JTextField();
        txt_cantidad_nueva = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel_wallpaper = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/etiqueta.png"))); // NOI18N
        jLabel1.setText("Crear descuento");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 210, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cambio-de-divisas.png"))); // NOI18N
        jLabel4.setText("Total:");
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 110, -1));

        txt_cantidad_actual.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txt_cantidad_actual, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 170, -1));

        txt_cantidad_nueva.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txt_cantidad_nueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 170, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventas (1).png"))); // NOI18N
        jLabel3.setText("Nombre:");
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 110, -1));

        jButton1.setBackground(new java.awt.Color(0, 255, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compra-en-linea.png"))); // NOI18N
        jButton1.setText("Crear descuento");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 200, 50));

        jLabel_wallpaper.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_wallpaper.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ejemplo_definir_descuento_con_cupones_de_descuento (1).jpg"))); // NOI18N
        jLabel_wallpaper.setOpaque(true);
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // Validar los datos ingresados
        String nombre = txt_cantidad_actual.getText().trim();
        String totalStr = txt_cantidad_nueva.getText().trim();

        if (nombre.isEmpty() || totalStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double total;
        try {
            total = Double.parseDouble(totalStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un valor numérico para el total.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear el descuento
        Descuento descuento = new Descuento(0, nombre, total);
        try {
            descuentoDAO.insertarDescuento(descuento);
            JOptionPane.showMessageDialog(this, "Descuento creado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
            txt_cantidad_actual.setText("");
            txt_cantidad_nueva.setText("");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al crear el descuento: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JTextField txt_cantidad_actual;
    private javax.swing.JTextField txt_cantidad_nueva;
    // End of variables declaration//GEN-END:variables
}
