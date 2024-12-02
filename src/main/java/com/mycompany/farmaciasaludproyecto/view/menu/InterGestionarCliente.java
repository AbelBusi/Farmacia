package com.mycompany.farmaciasaludproyecto.view.menu;
import com.mycompany.farmaciasaludproyecto.model.dao.ClienteDAO;
import com.mycompany.farmaciasaludproyecto.model.entity.Cliente;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;/**
 *
 * @author ediso
 */
public class InterGestionarCliente extends javax.swing.JInternalFrame {
 String[] Cabeceras = {"#", "Nombre", "Apellidos", "DNI", "Dirección", "Teléfono"};
    DefaultTableModel modeloTabla;
    List<Cliente> listaClientes;
    ClienteDAO clienteDAO;
    
    public InterGestionarCliente(){
     initComponents();
        this.setSize(new Dimension(943, 533));
        clienteDAO = new ClienteDAO();
        listaClientes = new ArrayList<>();
        modeloTabla = new DefaultTableModel(null, Cabeceras);
        jTable_productos.setModel(modeloTabla);
        actualizarTabla();
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
        jButton_ordenarZA = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton_eliminar = new javax.swing.JButton();
        jButton_actualizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_dni = new javax.swing.JTextField();
        txt_Telefeno = new javax.swing.JTextField();
        txt_apellidos = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/operador.png"))); // NOI18N
        jLabel1.setText("Clientes");
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

        jButton_buscar.setBackground(new java.awt.Color(51, 204, 0));
        jButton_buscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/investigar.png"))); // NOI18N
        jButton_buscar.setText("Buscar");
        jButton_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscarActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 120, 30));

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
        jPanel3.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Apellidos:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Direccion:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 90, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Telefono:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 90, -1));

        txt_dni.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_dni.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(txt_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 170, -1));

        txt_Telefeno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_Telefeno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(txt_Telefeno, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 170, -1));

        txt_apellidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_apellidos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(txt_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 43, 170, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Dni:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 90, -1));

        txt_direccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_direccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 170, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 910, 100));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/download (4).jpeg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 510));

        pack();
    }// </editor-fold>                        

    private void jButton_ordenarAZActionPerformed(java.awt.event.ActionEvent evt) {                                                  
    listaClientes.sort(Comparator.comparing(Cliente::getNombres));
    actualizarTabla();


    }                                                 

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {                                                 
    int selectedRow = jTable_productos.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un cliente para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        try {
            Cliente cliente = listaClientes.get(selectedRow);
            clienteDAO.eliminarCliente(cliente.getId_cliente());
            listaClientes.remove(selectedRow);
            actualizarTabla();
            JOptionPane.showMessageDialog(this, "Cliente eliminado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }                                                

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        int selectedRow = jTable_productos.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un cliente para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        Cliente cliente = listaClientes.get(selectedRow);
        cliente.setNombres(txt_nombre.getText().trim());
        cliente.setApellidos(txt_apellidos.getText().trim());
        cliente.setDni(txt_dni.getText().trim());
        cliente.setDireccion(txt_direccion.getText().trim());
        cliente.setTelefono(txt_Telefeno.getText().trim());
        
        try {
            clienteDAO.actualizarCliente(cliente);
            actualizarTabla();
            JOptionPane.showMessageDialog(this, "Cliente actualizado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }                                                  

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        buscarCliente();
        
    }                                          

    private void jButton_buscarActionPerformed(java.awt.event.ActionEvent evt) {                                               
       buscarCliente();
    }
    private void buscarCliente() {
    String nombreBuscado = txt_buscar.getText().trim().toLowerCase();
    modeloTabla.setRowCount(0);

    boolean encontrado = false;
    for (Cliente cliente : listaClientes) {
        if (cliente.getNombres().toLowerCase().contains(nombreBuscado) || cliente.getApellidos().toLowerCase().contains(nombreBuscado)) {
            modeloTabla.addRow(cliente.convertir());
            encontrado = true;
        }
    }

    if (!encontrado) {
        JOptionPane.showMessageDialog(this, "Cliente no encontrado.", "Información", JOptionPane.WARNING_MESSAGE);
    }
       
    }                                              

    private void jButton_ordenarZAActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        listaClientes.sort((c1, c2) -> c2.getNombres().compareTo(c1.getNombres()));
    actualizarTabla();
    }                                                 
    private void actualizarTabla() {
    modeloTabla.setRowCount(0);
    for (Cliente cliente : listaClientes) {
        modeloTabla.addRow(cliente.convertir());
    }}

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_buscar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JButton jButton_ordenarAZ;
    private javax.swing.JButton jButton_ordenarZA;
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
    private javax.swing.JTextField txt_Telefeno;
    private javax.swing.JTextField txt_apellidos;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_dni;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration                   

}
