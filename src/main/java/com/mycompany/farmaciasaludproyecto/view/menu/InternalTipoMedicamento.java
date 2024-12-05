package com.mycompany.farmaciasaludproyecto.view.menu;

import com.mycompany.farmaciasaludproyecto.model.dao.Conexion;
import com.mycompany.farmaciasaludproyecto.model.entity.TipoMedicamento;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author cesar
 */
public class InternalTipoMedicamento extends javax.swing.JInternalFrame {

    private static List<TipoMedicamento> tiposMedicamentos = new ArrayList<>();
    private static int contadorId = 1;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    public InternalTipoMedicamento() {
        initComponents();
        this.setSize(new Dimension(400, 232));
        this.setTitle("Nueva categoria");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        labelDescripcion1 = new javax.swing.JLabel();
        txtDescripcion1 = new javax.swing.JTextField();
        labelTitulo = new javax.swing.JLabel();
        labelDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        labelWalppaper = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelDescripcion1.setBackground(new java.awt.Color(255, 255, 255));
        labelDescripcion1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelDescripcion1.setForeground(new java.awt.Color(0, 0, 0));
        labelDescripcion1.setText("Nombre:");
        labelDescripcion1.setOpaque(true);
        getContentPane().add(labelDescripcion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, 20));

        txtDescripcion1.setBackground(new java.awt.Color(255, 255, 255));
        txtDescripcion1.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtDescripcion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 150, -1));

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(0, 0, 0));
        labelTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicamento (1).png"))); // NOI18N
        labelTitulo.setText("Tipo de medicamento");
        labelTitulo.setOpaque(true);
        getContentPane().add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        labelDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        labelDescripcion.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        labelDescripcion.setText("Descripcion:");
        labelDescripcion.setOpaque(true);
        getContentPane().add(labelDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 30));

        txtDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 150, -1));

        botonGuardar.setBackground(new java.awt.Color(51, 255, 102));
        botonGuardar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        botonGuardar.setForeground(new java.awt.Color(0, 0, 0));
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guardar-datos.png"))); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(botonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 140, 50));

        labelWalppaper.setForeground(new java.awt.Color(255, 255, 255));
        labelWalppaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/5026430 (1).jpg"))); // NOI18N
        getContentPane().add(labelWalppaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed

        String nombre = txtDescripcion1.getText().trim();
        String descripcion = txtDescripcion.getText().trim();

        if (nombre.isEmpty() || descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben ser llenados", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Insertar el nuevo tipo de medicamento en la base de datos
            String sql = "INSERT INTO TipoMedicamento (nombre, descripcion) VALUES (?, ?)";
            try (Connection conn = Conexion.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, nombre);
                ps.setString(2, descripcion);

                int filasInsertadas = ps.executeUpdate();
                if (filasInsertadas > 0) {
                    JOptionPane.showMessageDialog(this, "Tipo de medicamento guardado exitosamente", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    txtDescripcion1.setText("");
                    txtDescripcion.setText("");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar el tipo de medicamento: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_botonGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelDescripcion1;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelWalppaper;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDescripcion1;
    // End of variables declaration//GEN-END:variables
}
