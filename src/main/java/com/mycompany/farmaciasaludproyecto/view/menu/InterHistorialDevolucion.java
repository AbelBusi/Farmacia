package com.mycompany.farmaciasaludproyecto.view.menu;

import com.mycompany.farmaciasaludproyecto.model.dao.DevolucionDAO;
import com.mycompany.farmaciasaludproyecto.model.dao.VendedorDao;
import com.mycompany.farmaciasaludproyecto.model.entity.Devolucion;
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
public class InterHistorialDevolucion extends javax.swing.JInternalFrame {

    private DefaultTableModel dtm;
    private String[] cabeceras = {"ID Devolución", "ID Venta", "Motivo", "Fecha Reclamo", "Vigente"};
    private DevolucionDAO devolucionDao;
    private LinkedList<Devolucion> listaDevoluciones;

    public void mostrarDevolucionesEnJTable() {
        // Inicializar el modelo de la tabla con las cabeceras definidas
        dtm = new DefaultTableModel(null, cabeceras);

        // Llenar la lista de devoluciones
        devolucionDao = new DevolucionDAO();
        listaDevoluciones = devolucionDao.obtenerDevoluciones(); // Obtener las devoluciones desde la base de datos

        // Recorrer la lista de devoluciones y agregar cada una al modelo de la tabla
        for (Devolucion devolucion : listaDevoluciones) {
            // Aquí convertimos la devolución en un arreglo de objetos
            dtm.addRow(devolucion.convertir());
        }

        // Establecer el modelo de la tabla
        jTable_ListaVendedores.setModel(dtm);
    }

    public Devolucion buscarDevolucionPorId(int idDevolucion, LinkedList<Devolucion> listaDevoluciones) {
        int left = 0;
        int right = listaDevoluciones.size() - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            Devolucion midDevolucion = listaDevoluciones.get(middle);

            if (midDevolucion.getId_devolucion() == idDevolucion) {
                return midDevolucion; // Si se encuentra la devolución
            } else if (midDevolucion.getId_devolucion() < idDevolucion) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return null; // No encontrado
    }

    public InterHistorialDevolucion() {
        initComponents();
        this.setSize(new Dimension(943, 533));
        mostrarDevolucionesEnJTable();
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
        jButton_ordenarAZ4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/operador.png"))); // NOI18N
        jLabel1.setText("Historial de devolciones");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 270, 40));

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
        jButton_ordenarAZ.setText("Venta asc");
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

        jButton_ordenarAZ4.setBackground(new java.awt.Color(204, 255, 153));
        jButton_ordenarAZ4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_ordenarAZ4.setText("Venta desc");
        jButton_ordenarAZ4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ordenarAZ4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_ordenarAZ4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 110, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Orden");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 90, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 910, 450));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images (4) (1).jpeg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ordenarAZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ordenarAZActionPerformed
        listaDevoluciones.sort((d1, d2) -> Integer.compare(d1.getId_venta(), d2.getId_venta()));
        mostrarDevolucionesEnJTable();

    }//GEN-LAST:event_jButton_ordenarAZActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed

    }//GEN-LAST:event_txt_buscarActionPerformed

    private void jButton_buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscar1ActionPerformed
        String query = txt_buscar.getText().toLowerCase().trim(); // Obtener el texto de la búsqueda y convertirlo a minúsculas

        // Ordenar la lista de devoluciones (por ejemplo, por ID de la devolución)
        listaDevoluciones.sort((d1, d2) -> Integer.compare(d1.getId_devolucion(), d2.getId_devolucion()));

        // Realizar la búsqueda binaria
        Devolucion resultado = buscarDevolucionPorId(Integer.parseInt(query), listaDevoluciones);

        DefaultTableModel searchResultModel = new DefaultTableModel(null, cabeceras);

        if (resultado != null) {
            // Si se encontró la devolución, agregarla al modelo de la tabla
            searchResultModel.addRow(resultado.convertir());
        } else {
            // Si no se encontró, puedes mostrar un mensaje o dejar la tabla vacía
            JOptionPane.showMessageDialog(this, "Devolución no encontrada", "Error de búsqueda", JOptionPane.ERROR_MESSAGE);
        }

        // Actualizar el modelo de la tabla
        jTable_ListaVendedores.setModel(searchResultModel);
    }//GEN-LAST:event_jButton_buscar1ActionPerformed

    private void jButton_ordenarAZ4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ordenarAZ4ActionPerformed

        listaDevoluciones.sort((d1, d2) -> Integer.compare(d2.getId_venta(), d1.getId_venta()));
        mostrarDevolucionesEnJTable();        // TODO add your handling code here:

    }//GEN-LAST:event_jButton_ordenarAZ4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_buscar1;
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
