package com.mycompany.farmaciasaludproyecto.view.menu;
import com.mycompany.farmaciasaludproyecto.model.entity.Medicamento;
import java.awt.Dimension;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ediso
 */
public class InterMedicamento1Bubg extends javax.swing.JInternalFrame {  
     private List<Medicamento> listaMedicamentos;
    private int contadorIdMedicamento = 1;
    private DefaultTableModel modeloTabla;
    public InterMedicamento1Bubg() {
        initComponents();
        this.setSize(new Dimension(1250, 613));
        this.setTitle("Nuevo Medicamento");
        listaMedicamentos = new ArrayList<>();
        modeloTabla = (DefaultTableModel) jTable1.getModel();
        modeloTabla.setColumnIdentifiers(new String[]{"ID", "Nombre", "Descripcion", "Precio", "Stock", "Fecha Vencimiento", "Tipo"});
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton_EliminarMedicamento = new javax.swing.JButton();
        jButton_GenerarCompra = new javax.swing.JButton();
        txt_proveedor_buscar = new javax.swing.JTextField();
        jButton_busca_provedores = new javax.swing.JButton();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        txt_nombre = new javax.swing.JTextField();
        txt_precio = new javax.swing.JTextField();
        txt_stock = new javax.swing.JTextField();
        jComboBox_categoria = new javax.swing.JComboBox<>();
        jButton_Guardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdescripcion = new javax.swing.JTextArea();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nuevo Medicamento");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre:");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 90, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Descripcion:");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 90, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Precio:");
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 90, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Tipo medicamento:");
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 140, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Fecha Vencimiento:");
        jLabel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 140, 40));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Stock:");
        jLabel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel8.setOpaque(true);
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 90, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 540, 370));

        jButton_EliminarMedicamento.setBackground(new java.awt.Color(0, 204, 204));
        jButton_EliminarMedicamento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_EliminarMedicamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        jButton_EliminarMedicamento.setText("Eliminar medicamento");
        jButton_EliminarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EliminarMedicamentoActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_EliminarMedicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 200, 60));

        jButton_GenerarCompra.setBackground(new java.awt.Color(0, 204, 204));
        jButton_GenerarCompra.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_GenerarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventas.png"))); // NOI18N
        jButton_GenerarCompra.setText("Generar compra");
        jButton_GenerarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GenerarCompraActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_GenerarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 200, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 560, 510));

        txt_proveedor_buscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_proveedor_buscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_proveedor_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_proveedor_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(txt_proveedor_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 483, 200, 30));

        jButton_busca_provedores.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_busca_provedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/audiencia.png"))); // NOI18N
        jButton_busca_provedores.setText("Buscar proveedor");
        jButton_busca_provedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_busca_provedoresActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_busca_provedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 160, -1));
        getContentPane().add(jCalendar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 450, 140));

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 170, -1));

        txt_precio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_precio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_precioActionPerformed(evt);
            }
        });
        getContentPane().add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 170, -1));

        txt_stock.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_stock.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_stockActionPerformed(evt);
            }
        });
        getContentPane().add(txt_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 170, -1));

        jComboBox_categoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione tipo:", "Item 2", "Item 3", "Item 4" }));
        jComboBox_categoria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jComboBox_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_categoriaActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 170, -1));

        jButton_Guardar.setBackground(new java.awt.Color(0, 204, 204));
        jButton_Guardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicamento (1).png"))); // NOI18N
        jButton_Guardar.setText("Agregar");
        jButton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, 200, 90));

        txtdescripcion.setColumns(20);
        txtdescripcion.setRows(5);
        txtdescripcion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(txtdescripcion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 390, -1));

        jLabel_wallpaper.setBackground(new java.awt.Color(39, 174, 96));
        jLabel_wallpaper.setForeground(new java.awt.Color(39, 174, 96));
        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondoFarmacia.jpg"))); // NOI18N
        jLabel_wallpaper.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 590));

        pack();
    }// </editor-fold>                        

    private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {                                                
    String nombre = txt_nombre.getText().trim();
    String descripcion = txtdescripcion.getText().trim();
    String tipo = jComboBox_categoria.getSelectedItem().toString();
    BigDecimal precio;
    int stock;

    if (nombre.isEmpty() || descripcion.isEmpty() || tipo.equals("Seleccione tipo:")) {
        JOptionPane.showMessageDialog(this, "Por favor complete todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        precio = new BigDecimal(txt_precio.getText().trim());
        stock = Integer.parseInt(txt_stock.getText().trim());
        if (precio.compareTo(BigDecimal.ZERO) <= 0 || stock < 0) {
            throw new NumberFormatException();
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Ingrese valores válidos para el precio y el stock.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Date fechaVencimiento = new Date(jCalendar1.getDate().getTime());
     Medicamento nuevoMedicamento = new Medicamento(contadorIdMedicamento, nombre, descripcion, precio, stock, fechaVencimiento, jComboBox_categoria.getSelectedIndex());
     listaMedicamentos.add(nuevoMedicamento);
     contadorIdMedicamento++;
     modeloTabla.addRow(nuevoMedicamento.convertir());
     JOptionPane.showMessageDialog(this, "Medicamento agregado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
    txt_nombre.setText("");
    txtdescripcion.setText("");
    txt_precio.setText("");
    txt_stock.setText("");
    jComboBox_categoria.setSelectedIndex(0);
    jCalendar1.setDate(null);
    }                                               

    private void jButton_busca_provedoresActionPerformed(java.awt.event.ActionEvent evt) {                                                         
       String proveedor = txt_proveedor_buscar.getText().trim();
    if (proveedor.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor ingrese el nombre del proveedor a buscar.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    // Aquí se debería implementar la lógica de búsqueda del proveedor
    JOptionPane.showMessageDialog(this, "Proveedor '" + proveedor + "' encontrado.", "Información", JOptionPane.INFORMATION_MESSAGE);

    }                                                        

    private void jButton_EliminarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {                                                            
         int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un medicamento para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            modeloTabla.removeRow(selectedRow);
            listaMedicamentos.remove(selectedRow);
            JOptionPane.showMessageDialog(this, "Medicamento eliminado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }                                                           

    private void jButton_GenerarCompraActionPerformed(java.awt.event.ActionEvent evt) {                                                      
      int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un medicamento para generar la compra.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    // Aquí se debería implementar la lógica para generar la compra
    JOptionPane.showMessageDialog(this, "Compra generada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }                                                     

    private void txt_proveedor_buscarActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        jButton_busca_provedoresActionPerformed(evt);
    }                                                    

    private void jComboBox_categoriaActionPerformed(java.awt.event.ActionEvent evt) {                                                    
       String tipoSeleccionado = jComboBox_categoria.getSelectedItem().toString();
    if (!tipoSeleccionado.equals("Seleccione tipo:")) {
        JOptionPane.showMessageDialog(this, "Tipo seleccionado: " + tipoSeleccionado, "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    }                                                   

    private void txt_stockActionPerformed(java.awt.event.ActionEvent evt) {                                          
     try {
        int stock = Integer.parseInt(txt_stock.getText().trim());
        if (stock < 0) {
            throw new NumberFormatException();
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Ingrese un valor válido para el stock.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }                                         

    private void txt_precioActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
        BigDecimal precio = new BigDecimal(txt_precio.getText().trim());
        if (precio.compareTo(BigDecimal.ZERO) <= 0) {
            throw new NumberFormatException();
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Ingrese un valor válido para el precio.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }                                          

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if (txt_nombre.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "El campo de nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }                                          


    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton_EliminarMedicamento;
    private javax.swing.JButton jButton_GenerarCompra;
    private javax.swing.JButton jButton_Guardar;
    private javax.swing.JButton jButton_busca_provedores;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JComboBox<String> jComboBox_categoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    private javax.swing.JTextField txt_proveedor_buscar;
    private javax.swing.JTextField txt_stock;
    private javax.swing.JTextArea txtdescripcion;
    // End of variables declaration                   

}
