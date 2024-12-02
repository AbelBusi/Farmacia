package com.mycompany.farmaciasaludproyecto.view.menu;

import com.mycompany.farmaciasaludproyecto.model.dao.ClienteDAO;
import com.mycompany.farmaciasaludproyecto.model.dao.Conexion;
import com.mycompany.farmaciasaludproyecto.model.dao.DescuentoDAO;
import com.mycompany.farmaciasaludproyecto.model.dao.DetalleVentaDAO;
import com.mycompany.farmaciasaludproyecto.model.dao.MedicamentoDAO;
import com.mycompany.farmaciasaludproyecto.model.dao.VendedorDao;
import com.mycompany.farmaciasaludproyecto.model.dao.VentaDAO;
import com.mycompany.farmaciasaludproyecto.model.entity.Cliente;
import com.mycompany.farmaciasaludproyecto.model.entity.Descuento;
import com.mycompany.farmaciasaludproyecto.model.entity.DetalleVenta;
import com.mycompany.farmaciasaludproyecto.model.entity.Medicamento;
import com.mycompany.farmaciasaludproyecto.model.entity.Vendedor;
import com.mycompany.farmaciasaludproyecto.model.entity.Venta;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class InterRegistrarVenta extends javax.swing.JInternalFrame {

    private static List<Venta> listaVentas = new ArrayList<>();
    private static int contadorIdVenta = 1;
    private DefaultTableModel modeloTabla;
    VentaDAO ventaDAO = new VentaDAO();

    private int idCliente;
    private int idDescuento;
    private int idVendedor;

    public InterRegistrarVenta() {
        initComponents();
        this.setSize(new Dimension(924, 749));
        this.setTitle("Facturacion");
        cargarClientesEnComboBox();
        cargarMedicamentosEnComboBox();
        cargarDescuentosEnComboBox();
        llenarComboBoxVendedores();
        // Configuración del modelo de la tabla
        String[] columnas = {"ID", "Nombre", "Descripción", "Precio", "Cantidad", "Fecha de Vencimiento"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        jTable_productos.setModel(modelo);
        jComboBox_descuento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descuentoSeleccionado = (String) jComboBox_descuento.getSelectedItem();
                buscarDescuento(descuentoSeleccionado);
            }
        });

        jButton_calcularSubTotal1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double total = calcularSubTotal();
                txt_subTotal.setText(String.valueOf(total));
            }
        });

        jButton_calcularTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double total = calcularTotal();
                txtTotal.setText(String.valueOf(total));  // Mostrar el total con descuento aplicado
            }
        });

        jButton_calcularCambio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el monto ingresado por el cliente
                String montoTexto = txt_efectivo.getText();
                double montoCliente = 0;
                try {
                    montoCliente = Double.parseDouble(montoTexto);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un monto válido.");
                    return;
                }

                // Calcular el total (deberías usar el método que ya tienes para calcular el total)
                double total = calcularTotal();

                // Validación: Si el monto del cliente es menor que el total
                if (montoCliente < total) {
                    JOptionPane.showMessageDialog(null, "El monto ingresado es insuficiente.");
                } else {
                    // Calcular el cambio
                    double vuelto = montoCliente - total;

                    // Mostrar el vuelto en el JTextField
                    txt_cambio.setText(String.format("%.2f", vuelto));
                }
            }
        });

    }

    public double calcularTotal() {
        double total = 0;

        DefaultTableModel modelo = (DefaultTableModel) jTable_productos.getModel();

        // Recorrer las filas de la tabla
        for (int i = 0; i < modelo.getRowCount(); i++) {
            // Obtener el precio de la columna 0 y convertirlo a double
            Object precioObj = modelo.getValueAt(i, 3);
            double precio = 0;
            if (precioObj instanceof Number) {
                precio = ((Number) precioObj).doubleValue();
            } else if (precioObj instanceof String) {
                try {
                    precio = Double.parseDouble((String) precioObj);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();  // Manejar el caso donde el String no sea un número válido
                }
            }

            // Obtener la cantidad de la columna 1 y convertirlo a double
            Object cantidadObj = modelo.getValueAt(i, 4);
            double cantidad = 0;
            if (cantidadObj instanceof Number) {
                cantidad = ((Number) cantidadObj).doubleValue();
            } else if (cantidadObj instanceof String) {
                try {
                    cantidad = Double.parseDouble((String) cantidadObj);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();  // Manejar el caso donde el String no sea un número válido
                }
            }

            // Multiplicar y sumar
            total += precio * cantidad;
        }

        // Obtener el descuento desde el combo
        String descuentoSeleccionado = (String) jComboBox_descuento.getSelectedItem();
        double descuento = 0;
        try {
            Descuento descuentoObj = descuentoDao.obtenerDescuentoPorNombre(descuentoSeleccionado);
            if (descuentoObj != null) {
                descuento = descuentoObj.getTotal();  // Descuento como porcentaje
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        // Aplicar el descuento al total
        total = total - (total * (descuento / 100));  // Descuento aplicado como porcentaje

        return total;
    }

    public double calcularSubTotal() {
        double total = 0;

        DefaultTableModel modelo = (DefaultTableModel) jTable_productos.getModel();

        // Recorrer las filas de la tabla
        for (int i = 0; i < modelo.getRowCount(); i++) {
            // Obtener el precio de la columna 0 y convertirlo a double
            Object precioObj = modelo.getValueAt(i, 3);
            double precio = 0;
            if (precioObj instanceof Number) {
                precio = ((Number) precioObj).doubleValue();
            } else if (precioObj instanceof String) {
                try {
                    precio = Double.parseDouble((String) precioObj);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();  // Manejar el caso donde el String no sea un número válido
                }
            }

            // Obtener la cantidad de la columna 1 y convertirlo a double
            Object cantidadObj = modelo.getValueAt(i, 4);
            double cantidad = 0;
            if (cantidadObj instanceof Number) {
                cantidad = ((Number) cantidadObj).doubleValue();
            } else if (cantidadObj instanceof String) {
                try {
                    cantidad = Double.parseDouble((String) cantidadObj);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();  // Manejar el caso donde el String no sea un número válido
                }
            }

            // Multiplicar y sumar
            total += precio * cantidad;
        }

        return total;
    }

// Método para buscar un descuento en la base de datos y mostrar el total en el JTextField
    private void buscarDescuento(String nombre) {
        try {
            Descuento descuento = descuentoDao.obtenerDescuentoPorNombre(nombre);
            if (descuento != null) {
                txt_descuento.setText(String.valueOf(descuento.getTotal()));
            } else {
                txt_descuento.setText("Descuento no encontrado");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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
        jLabel3 = new javax.swing.JLabel();
        jComboBox_medicamento = new javax.swing.JComboBox<>();
        jButton_AgregarMedicamento = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_subTotal = new javax.swing.JTextField();
        txt_descuento = new javax.swing.JTextField();
        txt_efectivo = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jButton_calcularTotal = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txt_cambio = new javax.swing.JTextField();
        jButton_calcularSubTotal1 = new javax.swing.JButton();
        jButton_calcularCambio = new javax.swing.JButton();
        jButton_RegistrarVenta = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox_cliente = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox_descuento = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jCombo_vendedor = new javax.swing.JComboBox<>();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventas.png"))); // NOI18N
        jLabel1.setText("VENTA");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 130, -1));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("MEDICAMENTO:");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 120, -1));

        jComboBox_medicamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_medicamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione medicamento:" }));
        jComboBox_medicamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jComboBox_medicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 55, 170, 30));

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
        getContentPane().add(jButton_AgregarMedicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 310, 80));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 750, 180));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 770, 220));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Sub total");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Descuento");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Efectivo:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Cambio:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txt_subTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_subTotal.setEnabled(false);
        jPanel2.add(txt_subTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 120, -1));

        txt_descuento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_descuento.setEnabled(false);
        jPanel2.add(txt_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 120, -1));

        txt_efectivo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(txt_efectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 120, -1));

        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTotal.setEnabled(false);
        jPanel2.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 120, -1));

        jButton_calcularTotal.setBackground(new java.awt.Color(51, 255, 255));
        jButton_calcularTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_calcularTotal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cambio-de-divisas.png"))); // NOI18N
        jButton_calcularTotal.setText("Calcular total");
        jButton_calcularTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_calcularTotalActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_calcularTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 200, 50));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Total a pagar:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        txt_cambio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_cambio.setEnabled(false);
        jPanel2.add(txt_cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 120, -1));

        jButton_calcularSubTotal1.setBackground(new java.awt.Color(51, 255, 255));
        jButton_calcularSubTotal1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_calcularSubTotal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cambio-de-divisas.png"))); // NOI18N
        jButton_calcularSubTotal1.setText("Calcular Sub total");
        jButton_calcularSubTotal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_calcularSubTotal1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_calcularSubTotal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 200, 50));

        jButton_calcularCambio.setBackground(new java.awt.Color(51, 255, 255));
        jButton_calcularCambio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_calcularCambio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cambio-de-divisas.png"))); // NOI18N
        jButton_calcularCambio.setText("Cambio");
        jButton_calcularCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_calcularCambioActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_calcularCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 200, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 510, 210));

        jButton_RegistrarVenta.setBackground(new java.awt.Color(51, 255, 255));
        jButton_RegistrarVenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_RegistrarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/verificar (1).png"))); // NOI18N
        jButton_RegistrarVenta.setText("Registrar Venta");
        jButton_RegistrarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_RegistrarVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_RegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarVentaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RegistrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 490, 200, 180));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Cliente:");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 80, 30));

        jComboBox_cliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione cliente:" }));
        jComboBox_cliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jComboBox_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 170, 30));

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Cantidad:");
        jLabel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel11.setOpaque(true);
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 80, 30));

        txt_cantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_cantidad.setForeground(new java.awt.Color(0, 0, 0));
        txt_cantidad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 170, 30));

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Descuento:");
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 100, 30));

        jComboBox_descuento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_descuento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar descuento:" }));
        jComboBox_descuento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jComboBox_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 380, 170, 30));

        jLabel5.setBackground(new java.awt.Color(153, 153, 153));
        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Vendedor:");
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, -1, -1));

        jCombo_vendedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione vendedor:" }));
        getContentPane().add(jCombo_vendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 170, -1));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/download (6).jpeg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton_AgregarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AgregarMedicamentoActionPerformed
        // Obtener el medicamento seleccionado
        String medicamentoSeleccionado = jComboBox_medicamento.getSelectedItem().toString();

        // Validar que se haya seleccionado un medicamento
        if (medicamentoSeleccionado == null || medicamentoSeleccionado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un medicamento.");
            return;
        }

        // Obtener la cantidad ingresada
        int cantidad;
        try {
            cantidad = Integer.parseInt(txt_cantidad.getText().trim());
            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a 0.");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa una cantidad válida.");
            return;
        }

        // Obtener los datos del medicamento desde la base de datos
        Medicamento medicamento = medicamentoDao.obtenerMedicamentoPorNombre(medicamentoSeleccionado);

        if (medicamento == null) {
            JOptionPane.showMessageDialog(this, "No se encontraron datos para el medicamento seleccionado.");
            return;
        }

        // Validar stock disponible
        if (medicamento.getStock() < cantidad) {
            JOptionPane.showMessageDialog(this, "Stock insuficiente para el medicamento seleccionado.");
            return;
        }

        // Buscar si el medicamento ya está en la tabla
        DefaultTableModel modelo = (DefaultTableModel) jTable_productos.getModel();
        boolean medicamentoExistente = false;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            // Compara el nombre del medicamento en la tabla con el medicamento seleccionado
            if (modelo.getValueAt(i, 1).equals(medicamento.getNombre())) {
                // Si ya existe, actualizar la cantidad
                int cantidadExistente = (int) modelo.getValueAt(i, 4); // Columna 4 es la cantidad
                int nuevaCantidad = cantidadExistente + cantidad; // Acumular la cantidad
                modelo.setValueAt(nuevaCantidad, i, 4); // Actualizar la cantidad en la tabla
                medicamentoExistente = true;
                break;
            }
        }

        // Si el medicamento no existe en la tabla, agregarlo como una nueva fila
        if (!medicamentoExistente) {
            Object[] nuevaFila = {
                medicamento.getId_medicamento(), // ID
                medicamento.getNombre(), // Nombre
                medicamento.getDescripcion(), // Descripción
                medicamento.getPrecio(), // Precio
                cantidad, // Cantidad ingresada
                medicamento.getFechaVencimiento() // Fecha de vencimiento
            };
            modelo.addRow(nuevaFila);
        }

        // Limpiar el JComboBox y JTextField
        jComboBox_medicamento.setSelectedIndex(0); // Reinicia el JComboBox
        txt_cantidad.setText(""); // Limpia el JTextField de cantidad

        // Actualizar el subtotal y total
    }//GEN-LAST:event_jButton_AgregarMedicamentoActionPerformed

    private void actualizarTotal() {
        double total = 0.0;

        // Recorrer todas las filas del JTable y sumar los totales
        DefaultTableModel model = (DefaultTableModel) jTable_productos.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            try {
                double precio = (double) model.getValueAt(i, 2); // Columna Precio
                int cantidad = (int) model.getValueAt(i, 3); // Columna Cantidad
                total += precio * cantidad; // Sumar el total de la fila
            } catch (Exception e) {
                System.out.println("Error al obtener los valores de la fila: " + e.getMessage());
            }
        }

        // Mostrar el total en el JTextField
        txt_descuento.setText(String.format("%.2f", total));
    }
    private void jTable_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_productosMouseClicked

        // Obtener la fila seleccionada
        int filaSeleccionada = jTable_productos.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Confirmar la eliminación con un mensaje de advertencia
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este producto?", "Eliminar Producto", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                // Obtener los valores de Precio y Cantidad de la fila seleccionada
                double precio = 0;
                int cantidad = 0;

                try {
                    precio = (double) jTable_productos.getValueAt(filaSeleccionada, 2); // Columna Precio
                    cantidad = (int) jTable_productos.getValueAt(filaSeleccionada, 3); // Columna Cantidad
                } catch (Exception e) {
                    System.out.println("Error al obtener los valores de la fila: " + e.getMessage());
                }

                // Calcular el total de la fila
                double totalFila = precio * cantidad;

                // Eliminar la fila de la tabla
                DefaultTableModel model = (DefaultTableModel) jTable_productos.getModel();
                model.removeRow(filaSeleccionada);

                // Actualizar el total en el JTextField
                actualizarTotal();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para eliminar.");
        }
    }//GEN-LAST:event_jTable_productosMouseClicked

    public static BigDecimal convertir(JTextField textField) {
        try {
            String texto = textField.getText().trim();  // Obtener el texto del JTextField y eliminar espacios
            return new BigDecimal(texto);  // Convertir a BigDecimal
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return BigDecimal.ZERO;  // Retorna BigDecimal.ZERO si no se puede convertir
        }
    }

    private void jButton_RegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarVentaActionPerformed
        if (jComboBox_cliente.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente");
            return; // Salir del método si no se selecciona un cliente
        }

        String vendedors = jCombo_vendedor.getSelectedItem().toString();
        String clientess= jComboBox_cliente.getSelectedItem().toString();
        String descuentoss= jComboBox_descuento.getSelectedItem().toString();

        
        idVendedor = ventaDAO.obtenerIdPorNombre(vendedors);
        idCliente=clienteDao.obtenerIdPorNombre(clientess);
        idDescuento=descuentoDao.obtenerIdPorNombre(descuentoss);

        String total = txtTotal.getText();
        BigDecimal deci = convertir(txtTotal); // Convertir el texto del total a BigDecimal

        // Crear la instancia de Venta con los valores obtenidos
        Venta venta = new Venta(idCliente, 1, idDescuento, deci);

        // Intentar guardar la venta en la base de datos
        if (ventaDAO.guardarVenta(venta)) {
            JOptionPane.showMessageDialog(null, "Venta registrada con éxito");
            txtTotal.setText("");
            txt_cambio.setText("");
            txt_efectivo.setText("");
            txt_subTotal.setText("");
            txt_descuento.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar la venta");
        }


    }//GEN-LAST:event_jButton_RegistrarVentaActionPerformed

    private void jButton_calcularTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_calcularTotalActionPerformed

    }//GEN-LAST:event_jButton_calcularTotalActionPerformed

    private void jButton_calcularSubTotal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_calcularSubTotal1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_calcularSubTotal1ActionPerformed

    private void jButton_calcularCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_calcularCambioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_calcularCambioActionPerformed

    //CLienteComboBox
    ClienteDAO clienteDao = new ClienteDAO();
    LinkedList<String> nombresClientes = new LinkedList<>();

    private void cargarClientesEnComboBox() {
        nombresClientes = clienteDao.obtenerNombresClientes();

        for (String nombre : nombresClientes) {
            jComboBox_cliente.addItem(nombre);
        }
    }

    //MedicamentoComboBox
    MedicamentoDAO medicamentoDao = new MedicamentoDAO();
    LinkedList<String> nombresMedicamentos = new LinkedList<>();

    private void cargarMedicamentosEnComboBox() {
        nombresMedicamentos = medicamentoDao.obtenerNombresMedicamentos();

        for (String nombre : nombresMedicamentos) {
            jComboBox_medicamento.addItem(nombre);
        }
    }

    //DescuentoDaoComboBox
    DescuentoDAO descuentoDao = new DescuentoDAO();
    LinkedList<String> nombresDescuentos = new LinkedList<>();

    private void cargarDescuentosEnComboBox() {
        nombresDescuentos = descuentoDao.obtenerNombresDescuentos();

        for (String nombre : nombresDescuentos) {
            jComboBox_descuento.addItem(nombre);
        }
    }

    VendedorDao vendedorDao = new VendedorDao();

    //vendedor
    public void llenarComboBoxVendedores() {
        LinkedList<String> vendedores = vendedorDao.obtenerNombreVendedor(); // Llama al DAO para obtener la lista

        for (String vendedor : vendedores) {
            jCombo_vendedor.addItem(vendedor); // Agrega cada nombre al combo
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AgregarMedicamento;
    private javax.swing.JButton jButton_RegistrarVenta;
    private javax.swing.JButton jButton_calcularCambio;
    private javax.swing.JButton jButton_calcularSubTotal1;
    private javax.swing.JButton jButton_calcularTotal;
    private javax.swing.JComboBox<String> jComboBox_cliente;
    private javax.swing.JComboBox<String> jComboBox_descuento;
    private javax.swing.JComboBox<String> jComboBox_medicamento;
    private javax.swing.JComboBox<String> jCombo_vendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JTextField txtTotal;
    public static javax.swing.JTextField txt_cambio;
    private javax.swing.JTextField txt_cantidad;
    public static javax.swing.JTextField txt_descuento;
    private javax.swing.JTextField txt_efectivo;
    private javax.swing.JTextField txt_subTotal;
    // End of variables declaration//GEN-END:variables

    //metodo para restar la cantidad (stock) de los productos vendidos
}
