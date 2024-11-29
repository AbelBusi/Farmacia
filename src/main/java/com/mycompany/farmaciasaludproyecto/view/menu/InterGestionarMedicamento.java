package com.mycompany.farmaciasaludproyecto.view.menu;

import java.awt.Dimension;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ediso
 */
public class InterGestionarMedicamento extends javax.swing.JInternalFrame {



    public InterGestionarMedicamento(){
    initComponents();
    this.setSize(new Dimension(943, 533));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        txt_buscar = new javax.swing.JTextField();
        jButton_ordenarAZ = new javax.swing.JButton();
        jButton_buscar1 = new javax.swing.JButton();
        jButton_PrecioAsc = new javax.swing.JButton();
        jButton_FechaDesc = new javax.swing.JButton();
        jButton_FechaAsc = new javax.swing.JButton();
        jButton_ordenarZA = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton_eliminar = new javax.swing.JButton();
        jButton_actualizar1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();
        jComboBox_categoria = new javax.swing.JComboBox<>();
        txt_descripcion = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicamento (1).png"))); // NOI18N
        jLabel1.setText("Medicamentos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, -1, 40));

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

        jButton_PrecioAsc.setBackground(new java.awt.Color(204, 255, 153));
        jButton_PrecioAsc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_PrecioAsc.setText("Precio Asc");
        jButton_PrecioAsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PrecioAscActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_PrecioAsc, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, 100, -1));

        jButton_FechaDesc.setBackground(new java.awt.Color(204, 255, 153));
        jButton_FechaDesc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_FechaDesc.setText("Fecha Desc");
        jButton_FechaDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_FechaDescActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_FechaDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 90, -1));

        jButton_FechaAsc.setBackground(new java.awt.Color(204, 255, 153));
        jButton_FechaAsc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_FechaAsc.setText("Fecha Asc");
        jButton_FechaAsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_FechaAscActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_FechaAsc, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 100, -1));

        jButton_ordenarZA.setBackground(new java.awt.Color(204, 255, 153));
        jButton_ordenarZA.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_ordenarZA.setText("Z- A");
        jButton_ordenarZA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ordenarZAActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_ordenarZA, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 80, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Orden");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 90, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 730, 330));

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
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Tipo:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 90, -1));

        txt_precio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_precio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_precioActionPerformed(evt);
            }
        });
        jPanel3.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 170, -1));

        jComboBox_categoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione categoria:", "Item 2", "Item 3", "Item 4" }));
        jComboBox_categoria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jComboBox_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_categoriaActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 150, -1));

        txt_descripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_descripcion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_descripcionActionPerformed(evt);
            }
        });
        jPanel3.add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 170, -1));

        txt_cantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_cantidad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cantidadActionPerformed(evt);
            }
        });
        jPanel3.add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 43, 170, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Precio:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 90, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 910, 100));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pastillas.jpeg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 510));

        pack();
    }// </editor-fold>                        

    private void jButton_ordenarAZActionPerformed(java.awt.event.ActionEvent evt) {                                                  
    DefaultTableModel model = (DefaultTableModel) jTable_productos.getModel();
    List<Object[]> rows = new ArrayList<>();

    // Obtener las filas de la tabla
    for (int i = 0; i < model.getRowCount(); i++) {
        Object[] row = new Object[model.getColumnCount()];
        for (int j = 0; j < model.getColumnCount(); j++) {
            row[j] = model.getValueAt(i, j);
        }
        rows.add(row);
    }
    rows.sort(Comparator.comparing(o -> o[1].toString()));
    model.setRowCount(0);
    for (Object[] row : rows) {
        model.addRow(row);
    }


    }                                                 

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {                                                 
    int selectedRow = jTable_productos.getSelectedRow();
    if (selectedRow == -1) {
           JOptionPane.showMessageDialog(this, "Seleccione un medicamento para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        DefaultTableModel model = (DefaultTableModel) jTable_productos.getModel();
        model.removeRow(selectedRow);
        JOptionPane.showMessageDialog(this, "Medicamento eliminado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    }                                                

    private void jButton_actualizar1ActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        int selectedRow = jTable_productos.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un medicamento para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        String nombre = txt_nombre.getText().trim();
        String descripcion = txt_descripcion.getText().trim();
        String categoria = jComboBox_categoria.getSelectedItem().toString();
        int stock;
        BigDecimal precio;

        try {
            stock = Integer.parseInt(txt_cantidad.getText().trim());
            precio = new BigDecimal(txt_precio.getText().trim());
            if (stock < 0 || precio.compareTo(BigDecimal.ZERO) < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese valores válidos para el stock y el precio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTable_productos.getModel();
        model.setValueAt(nombre, selectedRow, 0); 
        model.setValueAt(stock, selectedRow, 1); 
        model.setValueAt(precio, selectedRow, 2); 
        model.setValueAt(descripcion, selectedRow, 3); 
        model.setValueAt(categoria, selectedRow, 4);

        JOptionPane.showMessageDialog(this, "Medicamento actualizado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    }                                                   

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {                                           
     String buscar = txt_buscar.getText().trim().toLowerCase();
    DefaultTableModel model = (DefaultTableModel) jTable_productos.getModel();

    jTable_productos.clearSelection();

    boolean found = false;
    for (int i = 0; i < model.getRowCount(); i++) {
        String nombre = model.getValueAt(i, 0).toString().toLowerCase(); // Suponiendo que la columna 0 es "nombre"
        if (nombre.contains(buscar)) {
            jTable_productos.addRowSelectionInterval(i, i);
            JOptionPane.showMessageDialog(this, "Medicamento encontrado: " + nombre, "Información", JOptionPane.INFORMATION_MESSAGE);
            found = true;
            break;
        }
    }

    if (!found) {
        JOptionPane.showMessageDialog(this, "Medicamento no encontrado.", "Información", JOptionPane.WARNING_MESSAGE);
    }
    }                                          

    private void jButton_buscar1ActionPerformed(java.awt.event.ActionEvent evt) {                                                
        String buscar = txt_buscar.getText().trim().toLowerCase();
        DefaultTableModel model = (DefaultTableModel) jTable_productos.getModel();

        jTable_productos.clearSelection();

        for (int i = 0; i < model.getRowCount(); i++) {
        String nombre = model.getValueAt(i, 1).toString().toLowerCase();
        if (nombre.contains(buscar)) {
            jTable_productos.addRowSelectionInterval(i, i);
            JOptionPane.showMessageDialog(this, "Medicamento encontrado: " + nombre, "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }

    JOptionPane.showMessageDialog(this, "Medicamento no encontrado.", "Información", JOptionPane.WARNING_MESSAGE);
    }                                               

    private void jButton_PrecioAscActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        DefaultTableModel model = (DefaultTableModel) jTable_productos.getModel();
    List<Object[]> rows = new ArrayList<>();
    for (int i = 0; i < model.getRowCount(); i++) {
        Object[] row = new Object[model.getColumnCount()];
        for (int j = 0; j < model.getColumnCount(); j++) {
            row[j] = model.getValueAt(i, j);
        }
        rows.add(row);
    }

    rows.sort((o1, o2) -> {
        try {
            Date fecha1 = Date.valueOf(o1[5].toString()); // Ajustar el índice según la columna de fecha
            Date fecha2 = Date.valueOf(o2[5].toString());
            return fecha1.compareTo(fecha2);
        } catch (IllegalArgumentException e) {
            return 0;
        }
    });
    model.setRowCount(0);
    for (Object[] row : rows) {
        model.addRow(row);
    }
    }                                                 

    private void jButton_FechaDescActionPerformed(java.awt.event.ActionEvent evt) {                                                  
  DefaultTableModel model = (DefaultTableModel) jTable_productos.getModel();
    List<Object[]> rows = new ArrayList<>();
    for (int i = 0; i < model.getRowCount(); i++) {
        Object[] row = new Object[model.getColumnCount()];
        for (int j = 0; j < model.getColumnCount(); j++) {
            row[j] = model.getValueAt(i, j);
        }
        rows.add(row);
    }
      rows.sort((o1, o2) -> Date.valueOf(o2[5].toString()).compareTo(Date.valueOf(o1[5].toString())));
    model.setRowCount(0);
    for (Object[] row : rows) {
        model.addRow(row);
    }
    }                                                 

    private void jButton_FechaAscActionPerformed(java.awt.event.ActionEvent evt) {                                                 
      DefaultTableModel model = (DefaultTableModel) jTable_productos.getModel();
    List<Object[]> rows = new ArrayList<>();

    // Obtener las filas de la tabla
    for (int i = 0; i < model.getRowCount(); i++) {
        Object[] row = new Object[model.getColumnCount()];
        for (int j = 0; j < model.getColumnCount(); j++) {
            row[j] = model.getValueAt(i, j);
        }
        rows.add(row);
    }
    rows.sort(Comparator.comparing(o -> Date.valueOf(o[5].toString())));
    model.setRowCount(0);
    for (Object[] row : rows) {
        model.addRow(row);
    }
    }                                                

    private void jButton_ordenarZAActionPerformed(java.awt.event.ActionEvent evt) {                                                  
       DefaultTableModel model = (DefaultTableModel) jTable_productos.getModel();
    List<Object[]> rows = new ArrayList<>();

    // Obtener las filas de la tabla
    for (int i = 0; i < model.getRowCount(); i++) {
        Object[] row = new Object[model.getColumnCount()];
        for (int j = 0; j < model.getColumnCount(); j++) {
            row[j] = model.getValueAt(i, j);
        }
        rows.add(row);
    }
    rows.sort((o1, o2) -> o2[1].toString().compareTo(o1[1].toString()));
    model.setRowCount(0);
    for (Object[] row : rows) {
        model.addRow(row);
    }
    }                                                 

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String nombre = txt_nombre.getText().trim();
    if (nombre.isEmpty()) {
        JOptionPane.showMessageDialog(this, "El campo de nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        txt_cantidad.requestFocus(); 
    }
    }                                          

    private void txt_cantidadActionPerformed(java.awt.event.ActionEvent evt) {                                             
       try {
        int cantidad = Integer.parseInt(txt_cantidad.getText().trim());
        if (cantidad < 0) {
            JOptionPane.showMessageDialog(this, "La cantidad no puede ser negativa.", "Error", JOptionPane.ERROR_MESSAGE);
            txt_cantidad.requestFocus();
        } else {
            txt_precio.requestFocus();
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Ingrese un número válido para la cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
        txt_cantidad.requestFocus();
    }
    }                                            

    private void txt_precioActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
        BigDecimal precio = new BigDecimal(txt_precio.getText().trim());
        if (precio.compareTo(BigDecimal.ZERO) <= 0) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un valor mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);
            txt_precio.requestFocus();
        } else {
            txt_descripcion.requestFocus(); 
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Ingrese un valor válido para el precio.", "Error", JOptionPane.ERROR_MESSAGE);
        txt_precio.requestFocus();
    }
    }                                          

    private void txt_descripcionActionPerformed(java.awt.event.ActionEvent evt) {                                                
       String descripcion = txt_descripcion.getText().trim();
    if (descripcion.isEmpty()) {
        JOptionPane.showMessageDialog(this, "La descripción no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
        txt_descripcion.requestFocus();
    } else {
        jComboBox_categoria.requestFocus();
    }
    }                                               

    private void jComboBox_categoriaActionPerformed(java.awt.event.ActionEvent evt) {                                                    
       String categoriaSeleccionada = jComboBox_categoria.getSelectedItem().toString();
    if (categoriaSeleccionada.equals("Seleccione tipo:")) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un tipo de medicamento.", "Error", JOptionPane.ERROR_MESSAGE);
        jComboBox_categoria.requestFocus();
    }
    }                                                   


    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton_FechaAsc;
    private javax.swing.JButton jButton_FechaDesc;
    private javax.swing.JButton jButton_PrecioAsc;
    private javax.swing.JButton jButton_actualizar1;
    private javax.swing.JButton jButton_buscar1;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JButton jButton_ordenarAZ;
    private javax.swing.JButton jButton_ordenarZA;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration                   

}
