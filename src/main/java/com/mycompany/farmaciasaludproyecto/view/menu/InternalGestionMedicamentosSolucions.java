package com.mycompany.farmaciasaludproyecto.view.menu;

import com.mycompany.farmaciasaludproyecto.model.dao.Conexion;
import com.mycompany.farmaciasaludproyecto.model.dao.MedicamentoDAO;
import com.mycompany.farmaciasaludproyecto.model.entity.Medicamento;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cesar
 */
public class InternalGestionMedicamentosSolucions extends javax.swing.JInternalFrame {

    private String[] Cabeceras = {"ID", "Nombre", "Descripción", "Precio", "Stock", "Fecha Vencimiento", "Tipo"};
    private DefaultTableModel DTM;
    private MedicamentoDAO medicamentoDao = new MedicamentoDAO();
    private LinkedList<Medicamento> LI_Medicamento = new LinkedList<>();

    public void MostrarJTable() {
        DTM = new DefaultTableModel(null, Cabeceras);
        for (Medicamento medicamento : LI_Medicamento) {
            DTM.addRow(medicamento.convertir());
        }
        jTable_medicamentos.setModel(DTM);
    }

    public InternalGestionMedicamentosSolucions() {
        initComponents();
        this.setSize(new Dimension(941, 532));
        LI_Medicamento = medicamentoDao.obtenerMedicamentosP();
        MostrarJTable();

        // Agrega un evento de escucha para capturar la fila seleccionada
        jTable_medicamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jTable_medicamentos.getSelectedRow();
                if (row != -1) {
                    // Obtenemos los valores de la fila seleccionada
                    String nombre = jTable_medicamentos.getValueAt(row, 1).toString(); // Columna 1: nombre
                    String precio = jTable_medicamentos.getValueAt(row, 3).toString(); // Columna 2: precio
                    String cantidad = jTable_medicamentos.getValueAt(row, 4).toString(); // Columna 3: cantidad
                    String descripcion = jTable_medicamentos.getValueAt(row, 2).toString(); // Columna 4: descripcion

                    // Mostramos los valores en los JTextField
                    txt_nombre.setText(nombre);
                    txt_precio.setText(precio);
                    txt_cantidad.setText(cantidad);
                    txt_descripcion.setText(descripcion);
                }
            }
        });

        jButton_actualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // Obtener los valores de los JTextField
                String nombre = txt_nombre.getText();
                String precio = txt_precio.getText();
                String cantidad = txt_cantidad.getText();
                String descripcion = txt_descripcion.getText();

                // Obtenemos el ID de la fila seleccionada
                int row = jTable_medicamentos.getSelectedRow();
                if (row != -1) {
                    int id = Integer.parseInt(jTable_medicamentos.getValueAt(row, 0).toString()); // Suponiendo que la primera columna es el ID

                    // Actualizamos la base de datos
                    medicamentoDao.actualizarEnBaseDeDatos(id, nombre, precio, cantidad, descripcion);

                    // Actualizamos la JTable
                    jTable_medicamentos.setValueAt(nombre, row, 1);
                    jTable_medicamentos.setValueAt(precio, row, 3);
                    jTable_medicamentos.setValueAt(cantidad, row, 4);
                    jTable_medicamentos.setValueAt(descripcion, row, 2);
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila primero.");
                }
            }
        });

    }

    private void buscarMedicamento(String criterio) {
        // Convertir el criterio a minúsculas para hacerlo sensible a las primeras letras
        String criterioMin = criterio.toLowerCase();

        // Filtrar la lista de medicamentos según el criterio
        List<Medicamento> resultados = LI_Medicamento.stream()
                .filter(m -> m.getNombre().toLowerCase().startsWith(criterioMin))
                .toList();

        // Actualizar el JTable con los resultados
        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron medicamentos.");
        } else {
            DefaultTableModel modelo = new DefaultTableModel(null, Cabeceras);
            for (Medicamento medicamento : resultados) {
                modelo.addRow(medicamento.convertir());
            }
            jTable_medicamentos.setModel(modelo);
        }
    }

    private int busquedaBinaria(LinkedList<Medicamento> lista, String criterio) {
        int inicio = 0;
        int fin = lista.size() - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Medicamento medicamentoMedio = lista.get(medio);

            int comparacion = medicamentoMedio.getNombre().compareToIgnoreCase(criterio);

            if (comparacion == 0) {
                return medio;
            } else if (comparacion < 0) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
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
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton_eliminar = new javax.swing.JButton();
        jButton_actualizar1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_medicamentos = new javax.swing.JTable();
        txt_buscar = new javax.swing.JTextField();
        jButton_ordenarAZ = new javax.swing.JButton();
        jButton_buscar1 = new javax.swing.JButton();
        jButton_ordenarAZ1 = new javax.swing.JButton();
        jButton_ordenarAZ2 = new javax.swing.JButton();
        jButton_ordenarAZ3 = new javax.swing.JButton();
        jButton_ordenarAZ4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicamento (1).png"))); // NOI18N
        jLabel1.setText("Medicamentos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, -1, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Stock");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Descripcion:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 90, -1));

        txt_precio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_precio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 170, -1));

        txt_descripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_descripcion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 170, -1));

        txt_cantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_cantidad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 43, 170, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Precio:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 90, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 910, 100));

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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 170, 330));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_medicamentos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_medicamentos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 710, 220));

        txt_buscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });
        jPanel1.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 170, 30));

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
        jPanel1.add(jButton_buscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 120, 30));

        jButton_ordenarAZ1.setBackground(new java.awt.Color(204, 255, 153));
        jButton_ordenarAZ1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_ordenarAZ1.setText("Precio Asc");
        jButton_ordenarAZ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ordenarAZ1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_ordenarAZ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, 100, -1));

        jButton_ordenarAZ2.setBackground(new java.awt.Color(204, 255, 153));
        jButton_ordenarAZ2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_ordenarAZ2.setText("Fecha Desc");
        jButton_ordenarAZ2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ordenarAZ2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_ordenarAZ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 90, -1));

        jButton_ordenarAZ3.setBackground(new java.awt.Color(204, 255, 153));
        jButton_ordenarAZ3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_ordenarAZ3.setText("Fecha Asc");
        jButton_ordenarAZ3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ordenarAZ3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_ordenarAZ3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 100, -1));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 730, 330));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pastillas.jpeg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
        // TODO add your handling code here:

        int selectedRow = jTable_medicamentos.getSelectedRow(); // Obtener fila seleccionada

        if (selectedRow != -1) { // Verificar que hay una fila seleccionada
            int idMedicamento = Integer.parseInt(jTable_medicamentos.getValueAt(selectedRow, 0).toString());

            // Depuración: Mostrar el ID seleccionado
            System.out.println("ID seleccionado: " + idMedicamento);

            // Cambiar el estado del medicamento a 0 (desactivar)
            boolean eliminado = medicamentoDao.desactivarMedicamento(idMedicamento);

            if (eliminado) {
                // Actualizar la lista de medicamentos activos
                LI_Medicamento = medicamentoDao.obtenerMedicamentosActivos();
                MostrarJTable(); // Refrescar la tabla
                JOptionPane.showMessageDialog(this, "Medicamento eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar el medicamento.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un medicamento.");
        }

    }//GEN-LAST:event_jButton_eliminarActionPerformed

    public void CargarMedicamentosActivos() {
        LI_Medicamento = medicamentoDao.obtenerMedicamentosActivos(); // Cargar solo activos
        MostrarJTable(); // Mostrar en la tabla
    }


    private void jButton_actualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_actualizar1ActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void jButton_ordenarAZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ordenarAZActionPerformed
        Collections.sort(LI_Medicamento, Comparator.comparing(Medicamento::getNombre));
        MostrarJTable();    // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ordenarAZActionPerformed

    private void cambiarEstadoMedicamento(int idMedicamento, int nuevoEstado) {
        Conexion con = new Conexion();
        try (Connection connection = con.conectar()) {
            String query = "UPDATE Medicamento SET estado = ? WHERE id_medicamento = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, nuevoEstado); // Nuevo estado (0 para inactivo)
            statement.setInt(2, idMedicamento); // ID del medicamento
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el estado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jButton_buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscar1ActionPerformed
        // TODO add your handling code here:
        String criterio = txt_buscar.getText().trim();
        if (!criterio.isEmpty()) {
            buscarMedicamento(criterio);
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un medicamento para buscar.");
        }
    }//GEN-LAST:event_jButton_buscar1ActionPerformed

    private void jButton_ordenarAZ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ordenarAZ1ActionPerformed

        Collections.sort(LI_Medicamento, Comparator.comparing(Medicamento::getPrecio));
        MostrarJTable();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ordenarAZ1ActionPerformed

    private void jButton_ordenarAZ2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ordenarAZ2ActionPerformed

        Collections.sort(LI_Medicamento, Comparator.comparing(Medicamento::getFechaVencimiento).reversed());
        MostrarJTable();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ordenarAZ2ActionPerformed

    private void jButton_ordenarAZ3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ordenarAZ3ActionPerformed

        Collections.sort(LI_Medicamento, Comparator.comparing(Medicamento::getFechaVencimiento));
        MostrarJTable();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ordenarAZ3ActionPerformed

    private void jButton_ordenarAZ4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ordenarAZ4ActionPerformed

        Collections.sort(LI_Medicamento, Comparator.comparing(Medicamento::getNombre).reversed());
        MostrarJTable();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ordenarAZ4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar1;
    private javax.swing.JButton jButton_buscar1;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JButton jButton_ordenarAZ;
    private javax.swing.JButton jButton_ordenarAZ1;
    private javax.swing.JButton jButton_ordenarAZ2;
    private javax.swing.JButton jButton_ordenarAZ3;
    private javax.swing.JButton jButton_ordenarAZ4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_medicamentos;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}
