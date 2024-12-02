package com.mycompany.farmaciasaludproyecto.view.menu;

import com.mycompany.farmaciasaludproyecto.model.dao.ProveedorDAO;
import com.mycompany.farmaciasaludproyecto.model.entity.Proveedor;
import java.awt.Component;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class InterGestionarProveedores extends javax.swing.JInternalFrame {
    ProveedorDAO daoProveedor = new ProveedorDAO();
    DefaultTableModel modeloProveedor = new DefaultTableModel();
    
    public InterGestionarProveedores(){
        initComponents();
        listarProveedor(TablaProveedor);
        this.setSize(new Dimension(788, 533));
        listarProveedor(TablaProveedor);
        TablaProveedor.setModel(modeloProveedor);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProveedor = new javax.swing.JTable();
        txt_buscar = new javax.swing.JTextField();
        jButton_ordenarAZ = new javax.swing.JButton();
        jButton_buscar1 = new javax.swing.JButton();
        jButton_ordenarAZ4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnEliminarProveedor = new javax.swing.JButton();
        btnEditarProveedor1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        txt_contacto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        btnguardarProve = new javax.swing.JButton();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mensajero.png"))); // NOI18N
        jLabel1.setText("Proveedores");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 150, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "CONTACTO", "TELEFONO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaProveedor);
        if (TablaProveedor.getColumnModel().getColumnCount() > 0) {
            TablaProveedor.getColumnModel().getColumn(0).setMinWidth(0);
            TablaProveedor.getColumnModel().getColumn(0).setMaxWidth(0);
        }

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
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Orden");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 90, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 550, 330));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminarProveedor.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminarProveedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eliminar.png"))); // NOI18N
        btnEliminarProveedor.setText("Eliminar");
        btnEliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProveedorActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 130, -1));

        btnEditarProveedor1.setBackground(new java.awt.Color(51, 204, 0));
        btnEditarProveedor1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEditarProveedor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medico.png"))); // NOI18N
        btnEditarProveedor1.setText("Actualizar");
        btnEditarProveedor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProveedor1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditarProveedor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 130, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 170, 330));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Telefono:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 90, -1));

        txt_telefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_telefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 150, -1));

        txt_contacto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_contacto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(txt_contacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 150, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Contacto:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 90, -1));

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 150, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Id");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 0, -1));

        txt_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_id.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 0, -1));

        btnguardarProve.setBackground(new java.awt.Color(51, 204, 0));
        btnguardarProve.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnguardarProve.setText("Guardar");
        btnguardarProve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarProveActionPerformed(evt);
            }
        });
        jPanel3.add(btnguardarProve, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 130, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 550, 100));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salud-viajes-1.jpg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ordenarAZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ordenarAZActionPerformed

    }//GEN-LAST:event_jButton_ordenarAZActionPerformed

    private void btnEliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProveedorActionPerformed
        eliminarProveedor();
        limpiarTabla();
        listarProveedor(TablaProveedor);
    }//GEN-LAST:event_btnEliminarProveedorActionPerformed

    private void btnguardarProveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarProveActionPerformed
        actualizarProveedor();
        Limpiar();
        listarProveedor(TablaProveedor);
    }//GEN-LAST:event_btnguardarProveActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void jButton_buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_buscar1ActionPerformed

    private void jButton_ordenarAZ4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ordenarAZ4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ordenarAZ4ActionPerformed

    private void btnEditarProveedor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProveedor1ActionPerformed
        int filaSeleccionada = TablaProveedor.getSelectedRow();
        if (filaSeleccionada == -1) {
        javax.swing.JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        } else {
        int id_proveedor = Integer.parseInt(TablaProveedor.getValueAt(filaSeleccionada, 0).toString());

        Proveedor prove = daoProveedor.leerProveedor(id_proveedor);
        if (prove != null) {
            
            txt_id.setText(Integer.toString(prove.getId_proveedor()));
            txt_nombre.setText(prove.getNombre());
            txt_contacto.setText(prove.getContacto());
            txt_telefono.setText(prove.getTelefono());
            
        }
    }
    }//GEN-LAST:event_btnEditarProveedor1ActionPerformed
    
    public void actualizarProveedor() {
        Proveedor prove = new Proveedor();
        String nomprove = txt_nombre.getText();
        String contaprove = txt_contacto.getText();
        String telefprove = txt_telefono.getText();
        int idprove = Integer.parseInt(txt_id.getText());
        prove.setNombre(nomprove);
        prove.setContacto(contaprove);
        prove.setTelefono(telefprove);
        prove.setId_proveedor(idprove);
        int r = daoProveedor.actualizarProveedor(prove);
        if (r == 1) {
            javax.swing.JOptionPane.showMessageDialog(null, "Proveedor Actualizado con éxito");
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al actualizar Proveedor");
        }
    }
    
    private void limpiarTabla() {
    while (modeloProveedor.getRowCount() > 0) {
        modeloProveedor.removeRow(0);
    }
}

    public void eliminarProveedor() {
    int filaUsuario = TablaProveedor.getSelectedRow();
    
    if (filaUsuario == -1) {
        javax.swing.JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
    } else {
        int id = Integer.parseInt(TablaProveedor.getValueAt(filaUsuario, 0).toString());
        int confirmacion = javax.swing.JOptionPane.showConfirmDialog(
                null, 
                "¿Está seguro que quiere eliminar al Proveedor?", 
                "Confirmación de eliminación", 
                javax.swing.JOptionPane.YES_NO_OPTION
        );
        if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
            daoProveedor.eliminarProveedor(id);
            javax.swing.JOptionPane.showMessageDialog(null, "Proveedor Eliminado con Éxito");
        }
    }
}

    public void listarProveedor(JTable tabla) {
        modeloProveedor.setRowCount(0);
        modeloProveedor = (DefaultTableModel) tabla.getModel();
        List<Proveedor> listaProveedor = daoProveedor.listarProveedor();
        Object[] object = new Object[4];

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        int columnCount = tabla.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        for (int i = 0; i < listaProveedor.size(); i++) {
            object[0] = listaProveedor.get(i).getId_proveedor();
            object[1] = listaProveedor.get(i).getNombre();
            object[2] = listaProveedor.get(i).getContacto();
            object[3] = listaProveedor.get(i).getTelefono();
            modeloProveedor.addRow(object);
        }
        TablaProveedor.setModel(modeloProveedor);
        TableColumnModel columnModel = tabla.getColumnModel();
        
        int anchoNombre = calcularAnchoMaximoContenido(tabla, 1);
        columnModel.getColumn(1).setPreferredWidth(anchoNombre);
        
        int anchoContacto = calcularAnchoMaximoContenido(tabla, 2); 
        columnModel.getColumn(2).setPreferredWidth(anchoContacto);
        
    }

    private int calcularAnchoMaximoContenido(JTable tabla, int indiceColumna) {
        int anchoMaximo = 0;
        TableColumn columna = tabla.getColumnModel().getColumn(indiceColumna);
        TableCellRenderer renderer = columna.getHeaderRenderer();
        if (renderer == null) {
            renderer = tabla.getTableHeader().getDefaultRenderer();
        }
        Component comp = renderer.getTableCellRendererComponent(tabla, columna.getHeaderValue(), false, false, 0, 0);
        anchoMaximo = comp.getPreferredSize().width;

        for (int fila = 0; fila < tabla.getRowCount(); fila++) {
            renderer = tabla.getCellRenderer(fila, indiceColumna);
            comp = renderer.getTableCellRendererComponent(tabla, tabla.getValueAt(fila, indiceColumna), false, false, fila, indiceColumna);
            anchoMaximo = Math.max(anchoMaximo, comp.getPreferredSize().width);
        }

        return anchoMaximo;
    }
    private void Limpiar() {
        txt_id.setText("");
        txt_nombre.setText("");
        txt_contacto.setText("");
        txt_telefono.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable TablaProveedor;
    private javax.swing.JButton btnEditarProveedor1;
    private javax.swing.JButton btnEliminarProveedor;
    private javax.swing.JButton btnguardarProve;
    private javax.swing.JButton jButton_buscar1;
    private javax.swing.JButton jButton_ordenarAZ;
    private javax.swing.JButton jButton_ordenarAZ4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_contacto;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables

}
