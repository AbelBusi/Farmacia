package com.mycompany.farmaciasaludproyecto.view.menu;

import com.mycompany.farmaciasaludproyecto.model.dao.MedicamentoDAO;
import com.mycompany.farmaciasaludproyecto.model.entity.Medicamento;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author ediso
 */
public class InterListaMedicamentos extends javax.swing.JInternalFrame {

     String[] Cabeceras = {"#", "Nombre", "Descripción", "Precio", "Stock", "Fecha Vencimiento", "ID Tipo"};
    DefaultTableModel modeloTabla;
    LinkedList<Medicamento> listaTiposMedicamentos;
    MedicamentoDAO medicamentoDAO;
   
    public InterListaMedicamentos() throws SQLException {
        initComponents();
        this.setSize(new Dimension(788, 542));
        medicamentoDAO = new MedicamentoDAO();
        try {
            listaTiposMedicamentos = medicamentoDAO.obtenerMedicamentos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al obtener los medicamentos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            listaTiposMedicamentos = new LinkedList<>();
        }
        modeloTabla = new DefaultTableModel(null, Cabeceras);
        jTable_ListaVMedicamentos.setModel(modeloTabla);
        actualizarTabla();
    }
     private void actualizarTabla() {
        modeloTabla.setRowCount(0);
        int n = 0;
        for (Medicamento medicamento : listaTiposMedicamentos) {
            n++;
            modeloTabla.addRow(medicamento.convertirObj(n));
        }
    }

public int buscarPorNombre(String nombreBuscado) {
    int inicio = 0, fin = listaTiposMedicamentos.size() - 1;

        // Ordenamos por nombre antes de realizar la búsqueda binaria
        listaTiposMedicamentos.sort(Comparator.comparing(Medicamento::getNombre));

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Medicamento medicamento = listaTiposMedicamentos.get(medio);
            String nombre = medicamento.getNombre().toLowerCase();

            if (nombre.startsWith(nombreBuscado.toLowerCase())) {
                return medio; // Encontró el medicamento
            }

            if (nombreBuscado.toLowerCase().compareTo(nombre) < 0) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
        }

        return -1; // No se encontró el medicamento
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ListaVMedicamentos = new javax.swing.JTable();
        txt_buscar = new javax.swing.JTextField();
        jButton_ordenarAZ = new javax.swing.JButton();
        jButton_buscar = new javax.swing.JButton();
        jButton_FechaDESC = new javax.swing.JButton();
        jButton_FechaASC = new javax.swing.JButton();
        jButton_ordenarZA = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicamento (2).png"))); // NOI18N
        jLabel1.setText("Lista de Medicamentos");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 270, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_ListaVMedicamentos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_ListaVMedicamentos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 880, 300));

        txt_buscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });
        jPanel1.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 170, 30));

        jButton_ordenarAZ.setBackground(new java.awt.Color(204, 255, 153));
        jButton_ordenarAZ.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_ordenarAZ.setText("Nombre asc");
        jButton_ordenarAZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ordenarAZActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_ordenarAZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 100, -1));

        jButton_buscar.setBackground(new java.awt.Color(51, 204, 0));
        jButton_buscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/investigar.png"))); // NOI18N
        jButton_buscar.setText("Buscar");
        jButton_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscarActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 120, 30));

        jButton_FechaDESC.setBackground(new java.awt.Color(204, 255, 153));
        jButton_FechaDESC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_FechaDESC.setText("Fecha Desc");
        jButton_FechaDESC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_FechaDESCActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_FechaDESC, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, 130, -1));

        jButton_FechaASC.setBackground(new java.awt.Color(204, 255, 153));
        jButton_FechaASC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_FechaASC.setText("Fecha Asc");
        jButton_FechaASC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_FechaASCActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_FechaASC, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 120, -1));

        jButton_ordenarZA.setBackground(new java.awt.Color(204, 255, 153));
        jButton_ordenarZA.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_ordenarZA.setText("Nombre desc");
        jButton_ordenarZA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ordenarZAActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_ordenarZA, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 110, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Orden");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 90, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 910, 450));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images (4) (1).jpeg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 510));

        pack();
    }// </editor-fold>                        

    private void jButton_ordenarAZActionPerformed(java.awt.event.ActionEvent evt) {                                                  
       listaTiposMedicamentos.sort(Comparator.comparing(Medicamento::getNombre));
        actualizarTabla();

    }                                                 

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {                                           
 // No se necesita lógica aquí, solo manejaremos el botón de buscar.
    }                                          

    private void jButton_buscarActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
        // TODO add your handling code here:
        String nombreBuscado = txt_buscar.getText().trim();

        if (nombreBuscado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un nombre para buscar.");
            return;
        }

        int indice = buscarPorNombre(nombreBuscado);

        if (indice != -1) {
            Medicamento medicamentoEncontrado = listaTiposMedicamentos.get(indice);
            modeloTabla.setRowCount(0);
            modeloTabla.addRow(medicamentoEncontrado.convertirObj(1));
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró el medicamento con ese nombre.");
        }
    }                                              

    private void jButton_FechaDESCActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        listaTiposMedicamentos.sort(Comparator.comparing(Medicamento::getFechaVencimiento).reversed());
        actualizarTabla();

    }                                                 

    private void jButton_FechaASCActionPerformed(java.awt.event.ActionEvent evt) {                                                 

      listaTiposMedicamentos.sort(Comparator.comparing(Medicamento::getFechaVencimiento));
        actualizarTabla();
    }                                                

    private void jButton_ordenarZAActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        listaTiposMedicamentos.sort(Comparator.comparing(Medicamento::getNombre).reversed());
        actualizarTabla();
    }                                                 


    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton_FechaASC;
    private javax.swing.JButton jButton_FechaDESC;
    private javax.swing.JButton jButton_buscar;
    private javax.swing.JButton jButton_ordenarAZ;
    private javax.swing.JButton jButton_ordenarZA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_ListaVMedicamentos;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration                   

}

