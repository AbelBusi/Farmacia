package com.mycompany.farmaciasaludproyecto.view.menu;

import com.mycompany.farmaciasaludproyecto.model.dao.VendedorDao;
import com.mycompany.farmaciasaludproyecto.model.entity.Vendedor;
import java.awt.Component;
import java.awt.Dimension;
import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class InterGestionarVendedor extends javax.swing.JInternalFrame {
    VendedorDao daoVendedor = new VendedorDao();
    DefaultTableModel modeloVendedor = new DefaultTableModel();

    public InterGestionarVendedor(){
        initComponents();
        listarVendedor(TablaVendedor);
        this.setSize(new Dimension(943, 533));
        listarVendedor(TablaVendedor);
        TablaVendedor.setModel(modeloVendedor);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaVendedor = new javax.swing.JTable();
        txt_buscar = new javax.swing.JTextField();
        jButton_ordenarAZ = new javax.swing.JButton();
        jButton_buscar1 = new javax.swing.JButton();
        jButton_ordenarAZ1 = new javax.swing.JButton();
        jButton_ordenarAZ2 = new javax.swing.JButton();
        jButton_ordenarAZ3 = new javax.swing.JButton();
        jButton_ordenarAZ4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnEliminarVendedor = new javax.swing.JButton();
        btnEditarVendedor = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_dni = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        chkActivoEmpleado = new javax.swing.JCheckBox();
        btnguardarV = new javax.swing.JButton();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/operador.png"))); // NOI18N
        jLabel1.setText("Vendedor");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 150, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaVendedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "APELLIDO", "DNI", "TELEFONO", "CORREO", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaVendedor);
        if (TablaVendedor.getColumnModel().getColumnCount() > 0) {
            TablaVendedor.getColumnModel().getColumn(0).setMinWidth(0);
            TablaVendedor.getColumnModel().getColumn(0).setMaxWidth(0);
            TablaVendedor.getColumnModel().getColumn(6).setMinWidth(0);
            TablaVendedor.getColumnModel().getColumn(6).setMaxWidth(0);
        }

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
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Orden");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 90, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 730, 330));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminarVendedor.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminarVendedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminarVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eliminar.png"))); // NOI18N
        btnEliminarVendedor.setText("Eliminar");
        btnEliminarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVendedorActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminarVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 130, -1));

        btnEditarVendedor.setBackground(new java.awt.Color(51, 204, 0));
        btnEditarVendedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEditarVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medico.png"))); // NOI18N
        btnEditarVendedor.setText("Actulizar");
        btnEditarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarVendedorActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditarVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 130, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 170, 330));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Apellidos:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Correo:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 90, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Estado");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 0, 10));

        txt_dni.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_dni.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(txt_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 170, -1));

        txt_telefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_telefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 170, -1));

        txt_apellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_apellido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 43, 170, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Dni:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 90, -1));

        txt_correo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_correo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 170, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Id");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 0, 0));

        txt_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_id.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 0, 0));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Telefono:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 90, -1));

        chkActivoEmpleado.setText("Activo");
        jPanel3.add(chkActivoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, 0, 10));

        btnguardarV.setBackground(new java.awt.Color(51, 204, 0));
        btnguardarV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnguardarV.setText("Guardar");
        btnguardarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarVActionPerformed(evt);
            }
        });
        jPanel3.add(btnguardarV, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 50, 130, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 910, 100));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/female-research-scientist-with-bioengineer-working-on-a-personal-picture-id1309776504-1 (1).jpg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ordenarAZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ordenarAZActionPerformed

    }//GEN-LAST:event_jButton_ordenarAZActionPerformed

    private void btnEliminarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVendedorActionPerformed
        deleteVendedor();
        limpiarTabla();
        listarVendedor(TablaVendedor);
    }//GEN-LAST:event_btnEliminarVendedorActionPerformed

    private void btnguardarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarVActionPerformed
        // TODO add your handling code here:
        actualizarVendedor();
        Limpiar();
        listarVendedor(TablaVendedor);
    }//GEN-LAST:event_btnguardarVActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void jButton_buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_buscar1ActionPerformed

    private void jButton_ordenarAZ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ordenarAZ1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ordenarAZ1ActionPerformed

    private void jButton_ordenarAZ2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ordenarAZ2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ordenarAZ2ActionPerformed

    private void jButton_ordenarAZ3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ordenarAZ3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ordenarAZ3ActionPerformed

    private void jButton_ordenarAZ4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ordenarAZ4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ordenarAZ4ActionPerformed

    private void btnEditarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarVendedorActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = TablaVendedor.getSelectedRow();
        if (filaSeleccionada == -1) {
        javax.swing.JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        } else {
        int id_vendedor = Integer.parseInt(TablaVendedor.getValueAt(filaSeleccionada, 0).toString());

        Vendedor vend = daoVendedor.leerVendedor(id_vendedor);
        if (vend != null) {
            
            txt_id.setText(Integer.toString(vend.getId_vendedor()));
            txt_nombre.setText(vend.getNombres());
            txt_apellido.setText(vend.getApellidos());
            txt_dni.setText(vend.getDni());
            txt_telefono.setText(vend.getTelefono());
            txt_correo.setText(vend.getCorreo());
            chkActivoEmpleado.setSelected(vend.isEstado());
        }
    }
    }//GEN-LAST:event_btnEditarVendedorActionPerformed
    
    public void actualizarVendedor() {
        Vendedor vend = new Vendedor();
        String nomvend = txt_nombre.getText();
        String apevend = txt_apellido.getText();
        String dniven = txt_dni.getText();
        String telefven = txt_telefono.getText();
        String correoven = txt_correo.getText();
        boolean estdven = chkActivoEmpleado.isSelected();
        int idVend = Integer.parseInt(txt_id.getText());
        vend.setNombres(nomvend);
        vend.setApellidos(apevend);
        vend.setDni(dniven);
        vend.setTelefono(telefven);
        vend.setCorreo(correoven);
        vend.setEstado(estdven);
        vend.setId_vendedor(idVend);
        int r = daoVendedor.actualizarVendedor(vend);
        if (r == 1) {
            javax.swing.JOptionPane.showMessageDialog(null, "Vendedor Actualizado con éxito");
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al actualizar Vendedor");
        }
    }
    
    private void limpiarTabla() {
    while (modeloVendedor.getRowCount() > 0) {
        modeloVendedor.removeRow(0);
    }
}

    public void deleteVendedor() {
    int filaUsuario = TablaVendedor.getSelectedRow();
    
    if (filaUsuario == -1) {
        javax.swing.JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
    } else {
        int id = Integer.parseInt(TablaVendedor.getValueAt(filaUsuario, 0).toString());
        int confirmacion = javax.swing.JOptionPane.showConfirmDialog(
                null, 
                "¿Está seguro que quiere eliminar al Vendedor?", 
                "Confirmación de eliminación", 
                javax.swing.JOptionPane.YES_NO_OPTION
        );
        if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
            daoVendedor.deleteVendedor(id);
            javax.swing.JOptionPane.showMessageDialog(null, "Usuario Eliminado con Éxito");
        }
    }
}

    public void listarVendedor(JTable tabla) {
        modeloVendedor.setRowCount(0);
        modeloVendedor = (DefaultTableModel) tabla.getModel();
        LinkedList<Vendedor> listaVendedor = daoVendedor.listarVendedor();
        Object[] object = new Object[7];

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        int columnCount = tabla.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        for (int i = 0; i < listaVendedor.size(); i++) {
            object[0] = listaVendedor.get(i).getId_vendedor();
            object[1] = listaVendedor.get(i).getNombres();
            object[2] = listaVendedor.get(i).getApellidos();
            object[3] = listaVendedor.get(i).getDni();
            object[4] = listaVendedor.get(i).getTelefono();
            object[5] = listaVendedor.get(i).getCorreo();
            object[6] = listaVendedor.get(i).isEstado();
            if (listaVendedor.get(i).isEstado()) {
                object[6] = "Activo";
            } else {
                object[6] = "Inactivo";
            }
            
            modeloVendedor.addRow(object);
        }
        TablaVendedor.setModel(modeloVendedor);
        TableColumnModel columnModel = tabla.getColumnModel();
        
        int anchoApellido = calcularAnchoMaximoContenido(tabla, 2);
        columnModel.getColumn(2).setPreferredWidth(anchoApellido);
        
        int anchoCorreo = calcularAnchoMaximoContenido(tabla, 5); 
        columnModel.getColumn(5).setPreferredWidth(anchoCorreo);
        
        int anchoEstado = calcularAnchoMaximoContenido(tabla, 6);
        columnModel.getColumn(6).setPreferredWidth(anchoEstado);
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
        txt_apellido.setText("");
        txt_dni.setText("");
        txt_correo.setText("");
        txt_telefono.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable TablaVendedor;
    private javax.swing.JButton btnEditarVendedor;
    private javax.swing.JButton btnEliminarVendedor;
    private javax.swing.JButton btnguardarV;
    private javax.swing.JCheckBox chkActivoEmpleado;
    private javax.swing.JButton jButton_buscar1;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_dni;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables

}
