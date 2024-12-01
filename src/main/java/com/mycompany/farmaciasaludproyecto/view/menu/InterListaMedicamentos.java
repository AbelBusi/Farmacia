package com.mycompany.farmaciasaludproyecto.view.menu;

import com.mycompany.farmaciasaludproyecto.model.dao.MedicamentoDAO;
import com.mycompany.farmaciasaludproyecto.model.entity.Medicamento;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ediso
 */
public class InterListaMedicamentos extends javax.swing.JInternalFrame {

    String[] Cabeceras = {"#", "Nombre", "Descripción", "Precio", "Stock", "Fecha Vencimiento", "ID Tipo"};
    DefaultTableModel DTM;
    MedicamentoDAO medicamentoDAO = new MedicamentoDAO();
    LinkedList<Medicamento> LI_medicamento = new LinkedList<>();

    public void MostrarJTable() {
        DTM = new DefaultTableModel(null, Cabeceras);
        int n = 0;

        for (Medicamento M : LI_medicamento) {
            n++;
            DTM.addRow(M.convertirObj(n));
        }
        jTable_ListaVMedicamentos.setModel(DTM);
    }

public int buscarPorNombre(String nombreBuscado) {
    int inicio = 0, fin = LI_medicamento.size() - 1;

    // Ordenamos por nombre antes de realizar la búsqueda binaria
    LI_medicamento.sort(Comparator.comparing(Medicamento::getNombre));

    while (inicio <= fin) {
        int medio = (inicio + fin) / 2;
        Medicamento medicamento = LI_medicamento.get(medio);
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

    public InterListaMedicamentos() throws SQLException {
        initComponents();
        this.setSize(new Dimension(943, 533));
        LI_medicamento = medicamentoDAO.obtenerMedicamentos();
        MostrarJTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ListaVMedicamentos = new javax.swing.JTable();
        txt_buscar = new javax.swing.JTextField();
        jButton_ordenarAZ = new javax.swing.JButton();
        jButton_buscar1 = new javax.swing.JButton();
        jButton_inactivo = new javax.swing.JButton();
        jButton_activo = new javax.swing.JButton();
        jButton_ordenarAZ4 = new javax.swing.JButton();
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

        jButton_buscar1.setBackground(new java.awt.Color(51, 204, 0));
        jButton_buscar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_buscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/investigar.png"))); // NOI18N
        jButton_buscar1.setText("Buscar");
        jButton_buscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscar1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_buscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 120, 30));

        jButton_inactivo.setBackground(new java.awt.Color(204, 255, 153));
        jButton_inactivo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_inactivo.setText("Fecha Desc");
        jButton_inactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_inactivoActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_inactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, 90, -1));

        jButton_activo.setBackground(new java.awt.Color(204, 255, 153));
        jButton_activo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_activo.setText("Fecha Asc");
        jButton_activo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_activoActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_activo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, 120, -1));

        jButton_ordenarAZ4.setBackground(new java.awt.Color(204, 255, 153));
        jButton_ordenarAZ4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_ordenarAZ4.setText("Nombre desc");
        jButton_ordenarAZ4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ordenarAZ4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_ordenarAZ4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 110, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Orden");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 90, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 910, 450));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images (4) (1).jpeg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ordenarAZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ordenarAZActionPerformed
        LI_medicamento.sort(Comparator.comparing(Medicamento::getNombre));
        MostrarJTable();

    }//GEN-LAST:event_jButton_ordenarAZActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed

    }//GEN-LAST:event_txt_buscarActionPerformed

    private void jButton_buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscar1ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        String nombreBuscado = txt_buscar.getText().trim();

        if (nombreBuscado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un nombre para buscar.");
            return;
        }

        // Realizamos la búsqueda binaria por nombre
        int indice = buscarPorNombre(nombreBuscado);

        if (indice != -1) {
            // Si se encuentra, mostramos el medicamento encontrado en la tabla
            Medicamento medicamentoEncontrado = LI_medicamento.get(indice);
            DTM = new DefaultTableModel(null, Cabeceras);
            DTM.addRow(medicamentoEncontrado.convertirObj(1)); // Añade solo el medicamento encontrado
            jTable_ListaVMedicamentos.setModel(DTM);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró el medicamento con ese nombre.");
        }
    }//GEN-LAST:event_jButton_buscar1ActionPerformed

    private void jButton_inactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_inactivoActionPerformed
        LI_medicamento.sort(Comparator.comparing(Medicamento::getFechaVencimiento).reversed());
        MostrarJTable();

    }//GEN-LAST:event_jButton_inactivoActionPerformed

    private void jButton_activoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_activoActionPerformed

        LI_medicamento.sort(Comparator.comparing(Medicamento::getFechaVencimiento));
        MostrarJTable();
    }//GEN-LAST:event_jButton_activoActionPerformed

    private void jButton_ordenarAZ4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ordenarAZ4ActionPerformed

        LI_medicamento.sort(Comparator.comparing(Medicamento::getNombre).reversed());
        MostrarJTable();
    }//GEN-LAST:event_jButton_ordenarAZ4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_activo;
    private javax.swing.JButton jButton_buscar1;
    private javax.swing.JButton jButton_inactivo;
    private javax.swing.JButton jButton_ordenarAZ;
    private javax.swing.JButton jButton_ordenarAZ4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_ListaVMedicamentos;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables

}