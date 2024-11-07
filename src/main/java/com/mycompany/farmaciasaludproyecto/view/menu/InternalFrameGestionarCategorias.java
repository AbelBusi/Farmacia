package com.mycompany.farmaciasaludproyecto.view.menu;

/**
 *
 * @author cesar
 */
public class InternalFrameGestionarCategorias extends javax.swing.JInternalFrame {


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAdministrar = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        botonEliminar = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        labelTituloDescripcion = new javax.swing.JLabel();
        txtBuscarDescripcion = new javax.swing.JTextField();
        labelPrincipalWallpaper = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitulo.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        labelTitulo.setText("Administrar  Categorias");
        getContentPane().add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 200, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblAdministrar.setBackground(new java.awt.Color(255, 255, 255));
        tblAdministrar.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblAdministrar);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 160));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 350, 160));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonEliminar.setBackground(new java.awt.Color(204, 0, 0));
        botonEliminar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        botonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(botonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 90, -1));

        botonActualizar.setBackground(new java.awt.Color(0, 204, 51));
        botonActualizar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        botonActualizar.setForeground(new java.awt.Color(255, 255, 255));
        botonActualizar.setText("Actualizar");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(botonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 160, 90));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTituloDescripcion.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labelTituloDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        labelTituloDescripcion.setText("Buscar Descripcion: ");
        jPanel3.add(labelTituloDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtBuscarDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscarDescripcion.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtBuscarDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscarDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarDescripcionActionPerformed(evt);
            }
        });
        jPanel3.add(txtBuscarDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 140, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 170, 90));

        labelPrincipalWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo2.jpg"))); // NOI18N
        getContentPane().add(labelPrincipalWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 380));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarDescripcionActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        // TODO add your handling code here:
        

    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_botonEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelPrincipalWallpaper;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelTituloDescripcion;
    public static javax.swing.JTable tblAdministrar;
    private javax.swing.JTextField txtBuscarDescripcion;
    // End of variables declaration//GEN-END:variables

}
