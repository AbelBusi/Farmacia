package com.mycompany.farmaciasaludproyecto.view.menu;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author ediso
 */
public class InterGestionarTipoMedicamentos extends javax.swing.JInternalFrame {
   String[] Cabeceras = {"#", "Nombre", "Descripción"};
    DefaultTableModel modeloTabla;
    List<Object[]> listaTiposMedicamentos;


    public InterGestionarTipoMedicamentos(){
   initComponents();
        this.setSize(new Dimension(788, 542));
        listaTiposMedicamentos = new ArrayList<>();
        modeloTabla = new DefaultTableModel(null, Cabeceras);
        jTable_productos.setModel(modeloTabla);
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
        jButton_buscar = new javax.swing.JButton();
        jButton_PrecioASC = new javax.swing.JButton();
        jButton_ordenarZA = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton_eliminar = new javax.swing.JButton();
        jButton_actualizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdescripcion = new javax.swing.JTextArea();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicamento (1).png"))); // NOI18N
        jLabel1.setText("Tipo de medicamentos");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 250, 40));

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

        jButton_buscar.setBackground(new java.awt.Color(51, 204, 0));
        jButton_buscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/investigar.png"))); // NOI18N
        jButton_buscar.setText("Buscar");
        jButton_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscarActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 120, 30));

        jButton_PrecioASC.setBackground(new java.awt.Color(204, 255, 153));
        jButton_PrecioASC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_PrecioASC.setText("Precio Asc");
        jButton_PrecioASC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PrecioASCActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_PrecioASC, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 100, -1));

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

        jButton_actualizar.setBackground(new java.awt.Color(51, 204, 0));
        jButton_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medico.png"))); // NOI18N
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 170, 330));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Descripcion:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 90, -1));

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        jPanel3.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 90, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        txtdescripcion.setColumns(20);
        txtdescripcion.setRows(5);
        jScrollPane2.setViewportView(txtdescripcion);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 320, 60));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 550, 120));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Salud-10.jpg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 530));

        pack();
    }// </editor-fold>                        

    private void jButton_ordenarAZActionPerformed(java.awt.event.ActionEvent evt) {                                                  
       listaTiposMedicamentos.sort(Comparator.comparing(o -> o[1].toString()));
        actualizarTabla();

    }                                                 

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        int selectedRow = jTable_productos.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un tipo de medicamento para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            listaTiposMedicamentos.remove(selectedRow);
            actualizarTabla();
            JOptionPane.showMessageDialog(this, "Tipo de medicamento eliminado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }                                                

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {                                                   
      actualizarTabla();
    }                                                  

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {                                           
          jButton_buscarActionPerformed(evt);
    }

    private void actualizarTabla() {
       modeloTabla.setRowCount(0);
        int n = 0;
        for (Object[] tipo : listaTiposMedicamentos) {
            n++;
            tipo[0] = n; // Actualizar el índice
            modeloTabla.addRow(tipo);
        } 
    }                                          

    private void jButton_buscarActionPerformed(java.awt.event.ActionEvent evt) {                                               
       String nombreBuscado = txt_buscar.getText().trim().toLowerCase();
        modeloTabla.setRowCount(0);

        boolean encontrado = false;
        for (Object[] tipo : listaTiposMedicamentos) {
            String nombre = tipo[1].toString().toLowerCase();
            if (nombre.contains(nombreBuscado)) {
                modeloTabla.addRow(tipo);
                encontrado = true;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(this, "Tipo de medicamento no encontrado.", "Información", JOptionPane.WARNING_MESSAGE);
        }
    }                                              

    private void jButton_PrecioASCActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        listaTiposMedicamentos.sort(Comparator.comparing(o -> {
         try {
            // Convertir a Double para la comparación
            return Double.parseDouble(o[2].toString());
        } catch (NumberFormatException e) {
            // En caso de que no sea un valor numérico, tratamos como 0
            return 0.0;
        }
    }));
    actualizarTabla();   
        
    }                                                 

    private void jButton_ordenarZAActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        listaTiposMedicamentos.sort((o1, o2) -> o2[1].toString().compareTo(o1[1].toString()));
        actualizarTabla();
    }                                                 

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          


    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton_PrecioASC;
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_buscar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JButton jButton_ordenarAZ;
    private javax.swing.JButton jButton_ordenarZA;
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
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextArea txtdescripcion;
    // End of variables declaration                   

}

