/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.farmaciasaludproyecto.view.menu;

import com.mycompany.farmaciasaludproyecto.model.dao.Conexion;
import com.mycompany.farmaciasaludproyecto.model.dao.TipoMedicamentoDAO;
import com.mycompany.farmaciasaludproyecto.model.entity.TipoMedicamento;
import static com.mycompany.farmaciasaludproyecto.view.menu.InterListaTipoMedicamentos.jTable_ListaTipoMedicamentos;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cesar
 */
public class InternalTipoMedicamentoSolucion extends javax.swing.JInternalFrame {

    private String[] Cabeceras = {"ID Tipo", "Nombre", "Descripción"};
    private DefaultTableModel DTM;
    private TipoMedicamentoDAO tipoMedicamentoDao = new TipoMedicamentoDAO();
    private LinkedList<TipoMedicamento> LI_tipoMedicamento = new LinkedList<>();

    public void MostrarJTable() {
        DTM = new DefaultTableModel(null, Cabeceras);
        int n = 0;

        // Filtramos solo los registros activos
        for (TipoMedicamento tipo : LI_tipoMedicamento) {
            if (tipo.getEstado() == true) { // Asegúrate de que el método getEstado() existe en TipoMedicamento
                n++;
                DTM.addRow(tipo.convertirObj(n)); // Añade solo los activos a la tabla
            }// Añade solo los activos a la tabla
        }
        jTable_productos.setModel(DTM);
    }

    private void cambiarEstado(int idTipo) {
        // Supón que `TipoMedicamentoDao` es una clase que maneja la persistencia
        TipoMedicamento tipo = tipoMedicamentoDao.obtenerPorId(idTipo);
        if (tipo != null) {
            tipo.setEstado(!tipo.getEstado()); // Cambia el estado (activo/inactivo)
            tipoMedicamentoDao.actualizar(tipo); // Actualiza el estado en la base de datos
            MostrarJTable(); // Refresca la tabla para mostrar el nuevo estado
        }
    }

    private LinkedList<TipoMedicamento> buscarPorNombreParcial(String nombreParcial) {
        // Ordenamos la LinkedList por nombre antes de realizar la búsqueda
        LI_tipoMedicamento.sort(Comparator.comparing(TipoMedicamento::getNombre, String.CASE_INSENSITIVE_ORDER));

        LinkedList<TipoMedicamento> resultados = new LinkedList<>();
        int inicio = 0;
        int fin = LI_tipoMedicamento.size() - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            TipoMedicamento tipo = LI_tipoMedicamento.get(medio);

            if (tipo.getNombre().toLowerCase().startsWith(nombreParcial.toLowerCase())) {
                // Si encuentra coincidencia, agrega este y busca elementos similares
                resultados.add(tipo);

                // Verificar hacia atrás
                for (int i = medio - 1; i >= 0; i--) {
                    if (LI_tipoMedicamento.get(i).getNombre().toLowerCase().startsWith(nombreParcial.toLowerCase())) {
                        resultados.addFirst(LI_tipoMedicamento.get(i));
                    } else {
                        break;
                    }
                }

                // Verificar hacia adelante
                for (int i = medio + 1; i < LI_tipoMedicamento.size(); i++) {
                    if (LI_tipoMedicamento.get(i).getNombre().toLowerCase().startsWith(nombreParcial.toLowerCase())) {
                        resultados.addLast(LI_tipoMedicamento.get(i));
                    } else {
                        break;
                    }
                }

                break; // Salimos del bucle porque ya encontramos todas las coincidencias
            } else if (tipo.getNombre().compareToIgnoreCase(nombreParcial) < 0) {
                inicio = medio + 1; // Buscar en la mitad derecha
            } else {
                fin = medio - 1; // Buscar en la mitad izquierda
            }
        }

        return resultados;
    }

    public InternalTipoMedicamentoSolucion() {
        initComponents();
        this.setSize(new Dimension(788, 542));
        LI_tipoMedicamento = tipoMedicamentoDao.obtenerLosTipos(); // Obtiene todos los tipos de medicamento
        MostrarJTable();
        jTable_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTiposMedicamentoMouseClicked(evt);
            }
        });

    }

    private void tablaTiposMedicamentoMouseClicked(java.awt.event.MouseEvent evt) {
        int filaSeleccionada = jTable_productos.getSelectedRow();
        if (filaSeleccionada != -1) { // Verifica si hay una fila seleccionada
            // Obtén el valor de las columnas por índice
            String nombre = jTable_productos.getValueAt(filaSeleccionada, 1).toString(); // Columna 1: nombre
            String descripcion = jTable_productos.getValueAt(filaSeleccionada, 2).toString(); // Columna 2: descripcion

            // Muestra los valores en los campos de texto
            txt_nombre1.setText(nombre);
            jTextArea1.setText(descripcion);
        }
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
        jPanel2 = new javax.swing.JPanel();
        jButton_eliminar = new javax.swing.JButton();
        jButton_actualizar1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        txt_buscar = new javax.swing.JTextField();
        jButton_ordenarAZ = new javax.swing.JButton();
        jButton_buscar1 = new javax.swing.JButton();
        jButton_ordenarAZ4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_nombre1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel_wallpaper = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicamento (1).png"))); // NOI18N
        jLabel1.setText("Tipo de medicamentos");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 250, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_eliminar.setBackground(new java.awt.Color(255, 51, 51));
        jButton_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eliminar.png"))); // NOI18N
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 130, -1));

        jButton_actualizar1.setBackground(new java.awt.Color(51, 204, 0));
        jButton_actualizar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_actualizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medico.png"))); // NOI18N
        jButton_actualizar1.setText("Actualizar");
        jButton_actualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizar1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_actualizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 170, 330));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 510, 220));

        txt_buscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });
        jPanel1.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 170, 30));

        jButton_ordenarAZ.setBackground(new java.awt.Color(204, 255, 153));
        jButton_ordenarAZ.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_ordenarAZ.setText("A- Z");
        jButton_ordenarAZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ordenarAZActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_ordenarAZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 80, -1));

        jButton_buscar1.setBackground(new java.awt.Color(51, 204, 0));
        jButton_buscar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_buscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/investigar.png"))); // NOI18N
        jButton_buscar1.setText("Buscar");
        jButton_buscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscar1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_buscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 120, 30));

        jButton_ordenarAZ4.setBackground(new java.awt.Color(204, 255, 153));
        jButton_ordenarAZ4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_ordenarAZ4.setText("Z- A");
        jButton_ordenarAZ4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ordenarAZ4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_ordenarAZ4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 80, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Orden");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 90, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 550, 330));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Descripcion:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 90, -1));

        txt_nombre1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nombre1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(txt_nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 90, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 320, 60));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 550, 120));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Salud-10.jpg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed

        int filaSeleccionada = jTable_productos.getSelectedRow();
        if (filaSeleccionada != -1) { // Si hay una fila seleccionada
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de desactivar este registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                int idTipo = Integer.parseInt(jTable_productos.getValueAt(filaSeleccionada, 0).toString()); // Columna 0: id_tipo

                // Conectar a la base de datos y ejecutar el UPDATE
                String sql = "UPDATE TipoMedicamento SET estado = 0 WHERE id_tipo = ?"; // Cambiar el estado a 0
                try (Connection conn = Conexion.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setInt(1, idTipo); // Establecer el valor del parámetro en el PreparedStatement
                    int filasActualizadas = ps.executeUpdate(); // Ejecutar la actualización

                    if (filasActualizadas > 0) {
                        JOptionPane.showMessageDialog(this, "Registro desactivado exitosamente.");
                        MostrarJTable(); // Refrescar la tabla
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo desactivar el registro.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error al desactivar el registro.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un registro para desactivar.");
        }

    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void jButton_actualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizar1ActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = jTable_productos.getSelectedRow();

        if (filaSeleccionada != -1) { // Verificar si hay una fila seleccionada
            // Obtener el ID del tipo de medicamento desde la tabla
            int idTipo = Integer.parseInt(jTable_productos.getValueAt(filaSeleccionada, 0).toString());

            // Obtener los valores editados desde los campos de texto
            String nuevoNombre = txt_nombre1.getText().trim();
            String nuevaDescripcion = jTextArea1.getText().trim();

            // Validar que los campos no estén vacíos
            if (nuevoNombre.isEmpty() || nuevaDescripcion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Crear un objeto del tipo con los nuevos datos
            TipoMedicamento tipoActualizado = new TipoMedicamento();
            tipoActualizado.setId_tipo(idTipo);
            tipoActualizado.setNombre(nuevoNombre);
            tipoActualizado.setDescripcion(nuevaDescripcion);

            // Llamar al DAO para actualizar los datos en la base de datos
            boolean actualizado = tipoMedicamentoDao.actualizarP(tipoActualizado);
            if (actualizado) {
                JOptionPane.showMessageDialog(this, "¡Registro actualizado exitosamente!");

                // Refrescar la tabla
                LI_tipoMedicamento = tipoMedicamentoDao.obtenerLosTipos(); // Actualizar la lista
                MostrarJTable();
            } else {
                JOptionPane.showMessageDialog(this, "Hubo un error al actualizar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para actualizar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButton_actualizar1ActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void jButton_ordenarAZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ordenarAZActionPerformed
        // TODO add your handling code here:
        Collections.sort(LI_tipoMedicamento, (t1, t2) -> t1.getNombre().compareToIgnoreCase(t2.getNombre()));
        MostrarJTable();
    }//GEN-LAST:event_jButton_ordenarAZActionPerformed

    private void jButton_buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscar1ActionPerformed

        String nombreBuscado = txt_buscar.getText().trim();

        if (nombreBuscado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un nombre o parte del nombre para buscar.");
            return;
        }

        LinkedList<TipoMedicamento> resultados = buscarPorNombreParcial(nombreBuscado);

        if (!resultados.isEmpty()) {
            // Actualizamos la tabla con las coincidencias encontradas
            DTM = new DefaultTableModel(null, Cabeceras);
            int n = 0;
            for (TipoMedicamento tipo : resultados) {
                n++;
                DTM.addRow(tipo.convertirObj(n));
            }
            jTable_productos.setModel(DTM);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron coincidencias para el nombre ingresado.");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_buscar1ActionPerformed

    private void jButton_ordenarAZ4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ordenarAZ4ActionPerformed
        // TODO add your handling code here:
        Collections.sort(LI_tipoMedicamento, (t1, t2) -> t2.getNombre().compareToIgnoreCase(t1.getNombre()));
        MostrarJTable();

    }//GEN-LAST:event_jButton_ordenarAZ4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar1;
    private javax.swing.JButton jButton_buscar1;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JButton jButton_ordenarAZ;
    private javax.swing.JButton jButton_ordenarAZ4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_nombre1;
    // End of variables declaration//GEN-END:variables
}
