package com.mycompany.farmaciasaludproyecto.view.menu;

import com.mycompany.farmaciasaludproyecto.model.dao.Conexion;
import com.mycompany.farmaciasaludproyecto.model.dao.VentaDAO;
import com.mycompany.farmaciasaludproyecto.model.entity.Venta;
import java.awt.Dimension;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ediso
 */
public class InterGestionarVentas extends javax.swing.JInternalFrame {

    private DefaultTableModel dtm;
    private String[] cabeceras = {"ID Venta", "ID Cliente", "ID Vendedor", "ID Descuento", "Total", "Fecha Venta", "Vigente"};
    private VentaDAO ventaDao;
    private LinkedList<Venta> listaVentas;

    public void mostrarVentasEnJTable() {
        // Inicializar el modelo de la tabla con las cabeceras definidas
        dtm = new DefaultTableModel(null, cabeceras);

        // Llenar la lista de ventas
        ventaDao = new VentaDAO();
        listaVentas = ventaDao.obtenerVentas(); // Este método debería retornar la lista de ventas desde la base de datos

        // Recorrer la lista de ventas y agregar cada una al modelo de la tabla
        for (Venta venta : listaVentas) {
            // Aquí asumo que tienes un método en la clase Venta que convierte la venta en un arreglo de objetos
            dtm.addRow(venta.convertir());
        }

        // Establecer el modelo de la tabla
        jTable_ventas.setModel(dtm);

    }

    private void buscarVentaPorID(int idVenta) {
        // Limpiar la tabla antes de mostrar resultados
        dtm = new DefaultTableModel(null, cabeceras);
        jTable_ventas.setModel(dtm);

        // Buscar en la lista de ventas
        boolean encontrado = false; // Para manejar casos en los que no se encuentre nada
        for (Venta venta : listaVentas) {
            if (venta.getId_venta() == idVenta) { // Asumiendo que tienes un getter para `idVenta`
                // Agregar la venta encontrada a la tabla
                dtm.addRow(venta.convertir());
                encontrado = true;
                break;
            }
        }

        // Mostrar mensaje si no se encuentra ninguna venta
        if (!encontrado) {
            JOptionPane.showMessageDialog(this, "No se encontró ninguna venta con el ID: " + idVenta,
                    "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void jTable_ventasMouseClicked(java.awt.event.MouseEvent evt) {
        int row = jTable_ventas.getSelectedRow();  // Obtener la fila seleccionada

        // Verificar si la fila tiene valores válidos
        if (row != -1) {
            // Obtener los valores de la fila con comprobación de null
            Object idVentaObj = jTable_ventas.getValueAt(row, 0);
            Object idClienteObj = jTable_ventas.getValueAt(row, 1);
            Object idVendedorObj = jTable_ventas.getValueAt(row, 2);
            Object idDescuentoObj = jTable_ventas.getValueAt(row, 3);
            Object totalObj = jTable_ventas.getValueAt(row, 4);
            Object fechaVentaObj = jTable_ventas.getValueAt(row, 5);
            Object vigenteObj = jTable_ventas.getValueAt(row, 6);

            // Comprobar si los valores no son null antes de usarlos
            int idVenta = idVentaObj != null ? (int) idVentaObj : 0;  // Asignar un valor predeterminado en caso de null
            int idCliente = idClienteObj != null ? (int) idClienteObj : 0;
            int idVendedor = idVendedorObj != null ? (int) idVendedorObj : 0;
            int idDescuento = idDescuentoObj != null ? (int) idDescuentoObj : 0;

            double total = 0;
            if (totalObj != null) {
                BigDecimal totalBigDecimal = (BigDecimal) totalObj;
                total = totalBigDecimal.doubleValue();  // Convertir a double si no es null
            }

            String fechaVenta = fechaVentaObj != null ? fechaVentaObj.toString() : "";  // Convertir a String si no es null

            // Verificar si el estado es true o false y asignar "Activo" o "Inactivo"
            String estado = (vigenteObj != null && vigenteObj instanceof Boolean && (Boolean) vigenteObj)
                    ? "Activo"
                    : "Inactivo";

            // Asignar los valores a los JTextField y JComboBox
            txt_total_pagar.setText(String.valueOf(total));
            txt_cliente.setText(String.valueOf(idCliente));  // Si deseas mostrar el ID del cliente
            txt_fecha1.setText(fechaVenta);
            jComboBox_estado.setSelectedItem(estado);  // Establecer el estado en el ComboBox
        }

    }

    public InterGestionarVentas() {
        initComponents();
        this.setSize(new Dimension(900, 500));
        this.setTitle("Gestionar Ventas");
        mostrarVentasEnJTable();
        jTable_ventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ventasMouseClicked(evt);
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ventas = new javax.swing.JTable();
        jButton_buscar1 = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton_actualizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_total_pagar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_cliente = new javax.swing.JTextField();
        jComboBox_estado = new javax.swing.JComboBox<>();
        txt_fecha1 = new javax.swing.JTextField();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos-humanos.png"))); // NOI18N
        jLabel1.setText("Administrar Ventas");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_ventas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_ventas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 710, 210));

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

        txt_buscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });
        jPanel1.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 170, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 730, 270));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_actualizar.setBackground(new java.awt.Color(51, 204, 0));
        jButton_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rotacion.png"))); // NOI18N
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 130, 270));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventas.png"))); // NOI18N
        jLabel2.setText("Total Pagar:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, -1));

        txt_total_pagar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_total_pagar.setEnabled(false);
        jPanel3.add(txt_total_pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fecha-de-caducidad.png"))); // NOI18N
        jLabel3.setText("Fecha:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 120, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tarifa.png"))); // NOI18N
        jLabel4.setText("Cliente:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actual.png"))); // NOI18N
        jLabel5.setText("Estado:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 90, -1));

        txt_cliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_cliente.setEnabled(false);
        jPanel3.add(txt_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 170, -1));

        jComboBox_estado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jPanel3.add(jComboBox_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 170, 30));

        txt_fecha1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_fecha1.setEnabled(false);
        txt_fecha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fecha1ActionPerformed(evt);
            }
        });
        jPanel3.add(txt_fecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 170, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 870, 100));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cual-es-la-organizacion-de-los-servicios-de-salud-en-el-Peru2.jpg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //ComboBoxCliente
    private void actualizarEstadoVenta(int idVenta, int estado) {
        try {
            // Conexión a la base de datos
            Connection conn = Conexion.conectar();  // Suponiendo que tienes este método para obtener la conexión
            String query = "UPDATE venta SET vigente = ? WHERE id_venta = ?";

            // Preparar la consulta
            PreparedStatement ps = conn.prepareStatement(query);

            // Establecer los parámetros
            ps.setInt(1, estado);  // Pasamos 1 para "Activo" y 0 para "Inactivo"
            ps.setInt(2, idVenta);  // ID de la venta a actualizar

            // Ejecutar la consulta
            int filasAfectadas = ps.executeUpdate();

            // Imprimir para depuración
            System.out.println("Filas afectadas: " + filasAfectadas);

            // Verificar si la actualización fue exitosa
            if (filasAfectadas > 0) {
                // Recargar la tabla con los datos actualizados
                mostrarVentasEnJTable();  // Método para recargar la tabla, si es necesario
            } else {
                // Si no se actualizó ninguna fila, mostrar un mensaje
                JOptionPane.showMessageDialog(this, "No se pudo actualizar el estado de la venta.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            // Mostrar el error si ocurre
            JOptionPane.showMessageDialog(this, "Error al actualizar el estado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        int row = jTable_ventas.getSelectedRow();

        // Verificar si hay una fila seleccionada
        if (row != -1) {
            // Obtener el ID de la venta seleccionada
            Object idVentaObj = jTable_ventas.getValueAt(row, 0);
            int idVenta = idVentaObj != null ? (int) idVentaObj : 0;

            // Obtener el estado seleccionado del JComboBox
            String estadoSeleccionado = (String) jComboBox_estado.getSelectedItem();

            // Convertir el estado a 1 (Activo) o 0 (Inactivo)
            int estado = estadoSeleccionado.equals("Activo") ? 1 : 0;

            // Imprimir para depuración
            System.out.println("ID Venta: " + idVenta);
            System.out.println("Estado seleccionado: " + estado);

            // Actualizar el estado de la venta en la base de datos
            actualizarEstadoVenta(idVenta, estado);

            // Mostrar un mensaje de éxito
            JOptionPane.showMessageDialog(this, "Estado de la venta actualizado con éxito.");
        } else {
            // Si no hay fila seleccionada, mostrar un mensaje de error
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una venta para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void txt_fecha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fecha1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fecha1ActionPerformed

    private void jButton_buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscar1ActionPerformed

        String textoID = txt_buscar.getText().trim();

        if (!textoID.isEmpty()) {
            try {
                // Intentar convertir el texto a un número
                int idVenta = Integer.parseInt(textoID);
                buscarVentaPorID(idVenta);
            } catch (NumberFormatException e) {
                // Mostrar un error si el ID no es un número válido
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID de venta válido.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Mostrar todas las ventas si no se ingresó un ID
            mostrarVentasEnJTable();
        }
    }//GEN-LAST:event_jButton_buscar1ActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_buscar1;
    private javax.swing.JComboBox<String> jComboBox_estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_ventas;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_cliente;
    private javax.swing.JTextField txt_fecha1;
    private javax.swing.JTextField txt_total_pagar;
    // End of variables declaration//GEN-END:variables

}
