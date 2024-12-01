package com.mycompany.farmaciasaludproyecto.view.menu;

import com.mycompany.farmaciasaludproyecto.model.dao.VendedorDao;
import com.mycompany.farmaciasaludproyecto.model.entity.Vendedor;
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
public class InterListaVendedor extends javax.swing.JInternalFrame {

    String[] Cabeceras = {"Nombres", "Apellidos", "Telefono", "estado"};
    DefaultTableModel DTM;
    VendedorDao vendedorDao = new VendedorDao();
    LinkedList<Vendedor> LI_vendedor = new LinkedList<>();

    public void MostrarJTable() {
        DTM = new DefaultTableModel(null, Cabeceras);
        int n = 0;

        for (Vendedor V : LI_vendedor) {
            n++;
            DTM.addRow(V.convertir(n));
        }
        jTable_ListaVendedores.setModel(DTM);
    }

    public InterListaVendedor() {
        initComponents();
        this.setSize(new Dimension(943, 533));
        LI_vendedor = vendedorDao.obtenerTodosLosVendedores();
        MostrarJTable();
    }
    
    private int buscarPorNombre(String nombre) {
    // Asegúrate de que la lista esté ordenada por nombres
    Collections.sort(LI_vendedor, Comparator.comparing(Vendedor::getNombres));

    int izquierda = 0;
    int derecha = LI_vendedor.size() - 1;

    while (izquierda <= derecha) {
        int medio = (izquierda + derecha) / 2;
        Vendedor vendedorMedio = LI_vendedor.get(medio);
        int comparacion = vendedorMedio.getNombres().compareToIgnoreCase(nombre);

        if (comparacion == 0) {
            return medio; // Se encontró el nombre
        } else if (comparacion < 0) {
            izquierda = medio + 1; // Buscar en la parte derecha
        } else {
            derecha = medio - 1; // Buscar en la parte izquierda
        }
    }
    return -1; // No encontrado
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ListaVendedores = new javax.swing.JTable();
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
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/operador.png"))); // NOI18N
        jLabel1.setText("Lista de vendedores");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 240, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_ListaVendedores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_ListaVendedores);

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
        jButton_inactivo.setText("Inactivo");
        jButton_inactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_inactivoActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_inactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, 90, -1));

        jButton_activo.setBackground(new java.awt.Color(204, 255, 153));
        jButton_activo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_activo.setText("Activo");
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

        Collections.sort(LI_vendedor, Comparator.comparing(Vendedor::getNombres));

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

    int indice = buscarPorNombre(nombreBuscado);

    if (indice != -1) {
        // Si se encuentra, actualiza la tabla con el vendedor encontrado
        Vendedor vendedorEncontrado = LI_vendedor.get(indice);
        DTM = new DefaultTableModel(null, Cabeceras);
        DTM.addRow(vendedorEncontrado.convertir(1)); // Añade solo el vendedor encontrado
        jTable_ListaVendedores.setModel(DTM);
    } else {
        JOptionPane.showMessageDialog(this, "No se encontró el vendedor con ese nombre.");
    }
    }//GEN-LAST:event_jButton_buscar1ActionPerformed

    private void jButton_inactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_inactivoActionPerformed
    
        Collections.sort(LI_vendedor,
                Comparator.comparing(Vendedor::isVigente).reversed()
                        .thenComparing(Vendedor::getNombres));

        MostrarJTable();
    }//GEN-LAST:event_jButton_inactivoActionPerformed

    private void jButton_activoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_activoActionPerformed
        // TODO add your handling code here:
        Collections.sort(LI_vendedor, Comparator.comparing(Vendedor::isVigente).reversed());

        MostrarJTable();
    }//GEN-LAST:event_jButton_activoActionPerformed

    private void jButton_ordenarAZ4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ordenarAZ4ActionPerformed
        // TODO add your handling code here:
        Collections.sort(LI_vendedor, Comparator.comparing(Vendedor::getNombres).reversed());

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
    public static javax.swing.JTable jTable_ListaVendedores;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables

}
