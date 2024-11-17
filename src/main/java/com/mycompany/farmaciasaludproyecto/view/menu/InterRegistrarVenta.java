package com.mycompany.farmaciasaludproyecto.view.menu;

import java.awt.Dimension;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class InterRegistrarVenta extends javax.swing.JInternalFrame {

    public InterRegistrarVenta() {
        initComponents();
        this.setSize(new Dimension(800, 600));
        this.setTitle("Facturacion");

        //insertar imagen en nuestro JLabel
        ImageIcon wallpaper = new ImageIcon("src/img/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(800, 600, WIDTH));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();

    }

    //iniciar tabla productos
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox_cliente = new javax.swing.JComboBox<>();
        jComboBox_producto = new javax.swing.JComboBox<>();
        txt_cliente_buscar = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        jButton_busca_cliente = new javax.swing.JButton();
        txt_cantidad1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBox_producto1 = new javax.swing.JComboBox<>();
        jButton_AgregarMedicamento = new javax.swing.JButton();
        jButton_RegistrarVenta1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        jButton_añadir_producto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_subtotal = new javax.swing.JTextField();
        txt_descuento = new javax.swing.JTextField();
        txt_iva = new javax.swing.JTextField();
        txt_total_pagar = new javax.swing.JTextField();
        txt_efectivo = new javax.swing.JTextField();
        txt_cambio = new javax.swing.JTextField();
        jButton_calcular_cambio = new javax.swing.JButton();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventas.png"))); // NOI18N
        jLabel1.setText("VENTA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 80, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("MEDICAMENTO:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 120, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Descuento:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 80, -1));

        jComboBox_cliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione cliente:", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 170, -1));

        jComboBox_producto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar descuento:", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 170, -1));

        txt_cliente_buscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_cliente_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 200, -1));

        txt_cantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 170, -1));

        jButton_busca_cliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_busca_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/audiencia.png"))); // NOI18N
        jButton_busca_cliente.setText("Buscar Cliente");
        jButton_busca_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_busca_clienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_busca_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 170, -1));

        txt_cantidad1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_cantidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 200, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Cantidad:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 80, -1));

        jComboBox_producto1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_producto1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione medicamento:", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_producto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 170, -1));

        jButton_AgregarMedicamento.setBackground(new java.awt.Color(51, 255, 255));
        jButton_AgregarMedicamento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_AgregarMedicamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicamento (1).png"))); // NOI18N
        jButton_AgregarMedicamento.setText("AGREGAR MEDICAMENTO");
        jButton_AgregarMedicamento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_AgregarMedicamento.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_AgregarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AgregarMedicamentoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_AgregarMedicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 390, 70));

        jButton_RegistrarVenta1.setBackground(new java.awt.Color(51, 255, 255));
        jButton_RegistrarVenta1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_RegistrarVenta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/verificar (1).png"))); // NOI18N
        jButton_RegistrarVenta1.setText("Registrar Venta");
        jButton_RegistrarVenta1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_RegistrarVenta1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_RegistrarVenta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarVenta1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RegistrarVenta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 530, 170, 100));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 750, 190));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 770, 210));

        jButton_añadir_producto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_añadir_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/investigar.png"))); // NOI18N
        jButton_añadir_producto.setText("Buscar Medicamento");
        jButton_añadir_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_añadir_productoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_añadir_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 170, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Subtotal:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Descuento:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Iva:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Total a pagar:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Efectivo:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Cambio:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txt_subtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_subtotal.setEnabled(false);
        jPanel2.add(txt_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 120, -1));

        txt_descuento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_descuento.setEnabled(false);
        jPanel2.add(txt_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 120, -1));

        txt_iva.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_iva.setEnabled(false);
        jPanel2.add(txt_iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 120, -1));

        txt_total_pagar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_total_pagar.setEnabled(false);
        jPanel2.add(txt_total_pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 120, -1));

        txt_efectivo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(txt_efectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 120, -1));

        txt_cambio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_cambio.setEnabled(false);
        jPanel2.add(txt_cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 120, -1));

        jButton_calcular_cambio.setBackground(new java.awt.Color(51, 255, 255));
        jButton_calcular_cambio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_calcular_cambio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cambio-de-divisas.png"))); // NOI18N
        jButton_calcular_cambio.setText("Calcular Cambio");
        jButton_calcular_cambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_calcular_cambioActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_calcular_cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 150, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 450, 210));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 880, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton_busca_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_busca_clienteActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jButton_busca_clienteActionPerformed

    private void jButton_añadir_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_añadir_productoActionPerformed


    }//GEN-LAST:event_jButton_añadir_productoActionPerformed

    private void jButton_calcular_cambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_calcular_cambioActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jButton_calcular_cambioActionPerformed


    private void jButton_AgregarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AgregarMedicamentoActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jButton_AgregarMedicamentoActionPerformed

    private void jTable_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_productosMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTable_productosMouseClicked

    private void jButton_RegistrarVenta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarVenta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_RegistrarVenta1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AgregarMedicamento;
    private javax.swing.JButton jButton_RegistrarVenta1;
    private javax.swing.JButton jButton_añadir_producto;
    private javax.swing.JButton jButton_busca_cliente;
    private javax.swing.JButton jButton_calcular_cambio;
    private javax.swing.JComboBox<String> jComboBox_cliente;
    private javax.swing.JComboBox<String> jComboBox_producto;
    private javax.swing.JComboBox<String> jComboBox_producto1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JTextField txt_cambio;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_cantidad1;
    private javax.swing.JTextField txt_cliente_buscar;
    private javax.swing.JTextField txt_descuento;
    private javax.swing.JTextField txt_efectivo;
    private javax.swing.JTextField txt_iva;
    private javax.swing.JTextField txt_subtotal;
    public static javax.swing.JTextField txt_total_pagar;
    // End of variables declaration//GEN-END:variables


    //metodo para restar la cantidad (stock) de los productos vendidos

}