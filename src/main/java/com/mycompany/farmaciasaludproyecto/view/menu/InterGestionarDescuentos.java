package com.mycompany.farmaciasaludproyecto.view.menu;

import com.mycompany.farmaciasaludproyecto.model.dao.Conexion;
import com.mycompany.farmaciasaludproyecto.model.dao.DescuentoDAO;
import com.mycompany.farmaciasaludproyecto.model.entity.Descuento;
import java.awt.Dimension;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ediso
 */
public class InterGestionarDescuentos extends javax.swing.JInternalFrame {

    String[] Cabeceras = {"ID Descuento", "Nombre", "Total", "estado"};
    DefaultTableModel DTM;
    DescuentoDAO descuentoDao = new DescuentoDAO();
    LinkedList<Descuento> LI_descuento = new LinkedList<>();

    public void MostrarJTable() {
        DTM = new DefaultTableModel(null, Cabeceras);
        int n = 0;

        for (Descuento D : LI_descuento) {
            if (D.getEstado() == false) {
                n++;
                DTM.addRow(D.convertirObj(n));  // Asegúrate de que el método convertir devuelva los valores correctos

            }
        }
        jTable_productos.setModel(DTM);  // Asegúrate de que jTable_productos está bien declarado
    }

    public InterGestionarDescuentos() {
        initComponents();
        this.setSize(new Dimension(788, 533));
        LI_descuento = descuentoDao.obtenerDescuentos();  // Esto debería devolver una lista de descuentos
        MostrarJTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        txt_buscar = new javax.swing.JTextField();
        jButton_ordenarAZ = new javax.swing.JButton();
        jButton_buscar1 = new javax.swing.JButton();
        jButton_ordenarAZ1 = new javax.swing.JButton();
        jButton_ordenarAZ4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton_eliminar = new javax.swing.JButton();
        jButton_actualizar1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_precio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/etiqueta.png"))); // NOI18N
        jLabel1.setText("Descuento");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 150, 40));

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
        jTable_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_productosMouseClicked(evt);
            }
        });
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

        jButton_ordenarAZ1.setBackground(new java.awt.Color(204, 255, 153));
        jButton_ordenarAZ1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_ordenarAZ1.setText("Precio Asc");
        jButton_ordenarAZ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ordenarAZ1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_ordenarAZ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 100, -1));

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
        jPanel3.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 90, -1));

        txt_precio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_precio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 170, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Total");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 90, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 550, 100));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen-41-1024x512 (1).png"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ordenarAZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ordenarAZActionPerformed
        Collections.sort(LI_descuento, Comparator.comparing(Descuento::getNombre));
        MostrarJTable();

    }//GEN-LAST:event_jButton_ordenarAZActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
        int filaSeleccionada = jTable_productos.getSelectedRow();
        DescuentoDAO dao = new DescuentoDAO();

        if (filaSeleccionada != -1) {
            // Obtener el ID del descuento seleccionado desde la primera columna (índice 0)
            Object valorID = jTable_productos.getValueAt(filaSeleccionada, 0);

            // Verifica si el valor es un Integer
            if (valorID instanceof Integer) {
                int idDescuento = (int) valorID;  // Convertir el valor a entero

                // Llamar al método eliminarDescuentoP
                if (dao.eliminarDescuentoP(idDescuento)) {
                    JOptionPane.showMessageDialog(null, "Descuento eliminado correctamente");
                    MostrarJTable();  // Recargar la lista de descuentos
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el descuento");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El ID del descuento no es válido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un descuento para eliminar");
        }
    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void jButton_actualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizar1ActionPerformed

        // Obtener los valores de los JTextField
        String nombre = txt_nombre.getText().trim();
        String precioStr = txt_precio.getText().trim();

        // Validar que los campos no estén vacíos
        if (nombre.isEmpty() || precioStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
            return;  // Salir del método si hay campos vacíos
        }

        // Intentar convertir el precio a un número
        Double total = null;
        try {
            total = Double.parseDouble(precioStr);  // Convertir el precio a Double
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El precio debe ser un número válido.");
            return;  // Salir del método si el precio no es válido
        }

        // Obtener el ID del descuento (esto asumiendo que tienes el ID de algún modo)
        int filaSeleccionada = jTable_productos.getSelectedRow();
        if (filaSeleccionada != -1) {
            int idDescuento = (int) jTable_productos.getValueAt(filaSeleccionada, 0);  // Columna del ID

            // Crear el objeto Descuento con los nuevos datos
            Descuento descuento = new Descuento(idDescuento, nombre, total);

            // Llamar al método de actualización en el DAO
            DescuentoDAO dao = new DescuentoDAO();
            if (dao.actualizarDescuentoP(descuento)) {
                MostrarJTable();
                JOptionPane.showMessageDialog(null, "Descuento actualizado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar el descuento");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un descuento para actualizar");
        }
    }//GEN-LAST:event_jButton_actualizar1ActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void jButton_buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscar1ActionPerformed

        String criterio = txt_buscar.getText().trim();
        if (criterio.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingresa un nombre para buscar.");
        } else {
            buscarDescuentoBinario(criterio);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_buscar1ActionPerformed

    private void jButton_ordenarAZ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ordenarAZ1ActionPerformed
        // TODO add your handling code here:
        Collections.sort(LI_descuento, Comparator.comparing(Descuento::getTotal));
        MostrarJTable();
    }//GEN-LAST:event_jButton_ordenarAZ1ActionPerformed

    private void buscarDescuentoBinario(String criterio) {
        // Aseguramos que la lista esté ordenada antes de realizar la búsqueda binaria.
        Collections.sort(LI_descuento, Comparator.comparing(Descuento::getNombre));

        int indice = busquedaBinaria(LI_descuento, criterio);

        if (indice == -1) {
            JOptionPane.showMessageDialog(null, "Descuento no encontrado.");
        } else {
            // Si el índice es válido, mostramos el descuento encontrado.
            Descuento descuentoEncontrado = LI_descuento.get(indice);
            JOptionPane.showMessageDialog(null, "Descuento encontrado: " + descuentoEncontrado.getNombre()
                    + " - Total: " + descuentoEncontrado.getTotal());
        }
    }

    private int busquedaBinaria(LinkedList<Descuento> lista, String criterio) {
        int inicio = 0;
        int fin = lista.size() - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Descuento descuentoMedio = lista.get(medio);

            int comparacion = descuentoMedio.getNombre().compareToIgnoreCase(criterio);

            if (comparacion == 0) {
                // Si encontramos el descuento, retornamos el índice.
                return medio;
            } else if (comparacion < 0) {
                // Si el criterio es mayor que el nombre en el medio, buscamos en la mitad derecha.
                inicio = medio + 1;
            } else {
                // Si el criterio es menor que el nombre en el medio, buscamos en la mitad izquierda.
                fin = medio - 1;
            }
        }
        // Si no encontramos el descuento, retornamos -1.
        return -1;
    }


    private void jButton_ordenarAZ4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ordenarAZ4ActionPerformed
        // TODO add your handling code here:
        Collections.sort(LI_descuento, Comparator.comparing(Descuento::getNombre).reversed());
        MostrarJTable();
    }//GEN-LAST:event_jButton_ordenarAZ4ActionPerformed

    private void jTable_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_productosMouseClicked
        // Obtener la fila seleccionada
        int filaSeleccionada = jTable_productos.getSelectedRow();

        // Verificar si no se ha seleccionado una fila válida (es decir, fila no nula y no vacía)
        if (filaSeleccionada != -1) {  // La fila seleccionada debe ser válida
            // Obtener los valores de la fila seleccionada
            String nombre = (String) jTable_productos.getValueAt(filaSeleccionada, 1);  // Columna del nombre
            Double total = (Double) jTable_productos.getValueAt(filaSeleccionada, 2);  // Columna del total

            // Verificar si los datos obtenidos son válidos
            if (nombre != null && !nombre.isEmpty() && total != null) {
                // Mostrar los valores en los JTextField
                txt_nombre.setText(nombre);
                txt_precio.setText(total.toString());
            } else {
                JOptionPane.showMessageDialog(null, "La fila seleccionada está vacía o tiene datos inválidos.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila válida.");
        }
    }//GEN-LAST:event_jTable_productosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar1;
    private javax.swing.JButton jButton_buscar1;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JButton jButton_ordenarAZ;
    private javax.swing.JButton jButton_ordenarAZ1;
    private javax.swing.JButton jButton_ordenarAZ4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables

}
