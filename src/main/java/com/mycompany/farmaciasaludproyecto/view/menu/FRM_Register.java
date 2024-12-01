package com.mycompany.farmaciasaludproyecto.view.menu;

import com.mycompany.farmaciasaludproyecto.model.dao.UsuarioDAO;
import com.mycompany.farmaciasaludproyecto.model.dao.VendedorDao;
import com.mycompany.farmaciasaludproyecto.model.entity.Usuario;
import com.mycompany.farmaciasaludproyecto.view.image.redirectImage;
import java.awt.Dimension;
import javax.swing.JOptionPane;

/**
 *
 * @author cesar
 */
public class FRM_Register extends javax.swing.JFrame {

    redirectImage image1 = new redirectImage();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    VendedorDao vendedorDao = new VendedorDao();

    /**
     * Creates new form JLoginFrame
     */
    public void limpiar() {

        txtNombre.setText("");
        txtApellidos.setText("");
        txtCorreo.setText("");
        txtPassword.setText("");
        txtPasswordVali.setText("");
        txtNombre.requestFocus();

    }

    public FRM_Register() {

        initComponents();
        this.setSize(new Dimension(1230, 700));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JPLogo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtApellidos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        txtPasswordVali = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jSeparator8 = new javax.swing.JSeparator();
        BotonRegistrarse = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        B_ValidarUVendedor_existente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JPLogo.setBackground(new java.awt.Color(255, 255, 255));
        JPLogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farmacia2.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        JPLogo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-210, 10, 810, 700));

        jPanel1.add(JPLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 600, 720));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2135.jpg"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 290, 170));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Apellidos");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 90, 30));

        jSeparator2.setForeground(new java.awt.Color(34, 194, 186));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 150, 30));

        txtApellidos.setBackground(new java.awt.Color(153, 153, 153));
        txtApellidos.setForeground(new java.awt.Color(0, 0, 0));
        txtApellidos.setBorder(null);
        jPanel2.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 150, 30));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nombre");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 90, 30));

        txtNombre.setBackground(new java.awt.Color(153, 153, 153));
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.setBorder(null);
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 150, 30));

        jSeparator3.setForeground(new java.awt.Color(34, 194, 186));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 150, 30));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Telefono");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, 80, 30));

        txtTelefono.setBackground(new java.awt.Color(153, 153, 153));
        txtTelefono.setForeground(new java.awt.Color(0, 0, 0));
        txtTelefono.setBorder(null);
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 150, 30));

        jSeparator4.setForeground(new java.awt.Color(34, 194, 186));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 430, 150, 30));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Validar ");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 470, 70, 30));

        txtCorreo.setBackground(new java.awt.Color(153, 153, 153));
        txtCorreo.setForeground(new java.awt.Color(0, 0, 0));
        txtCorreo.setBorder(null);
        jPanel2.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 190, 30));

        jSeparator5.setForeground(new java.awt.Color(34, 194, 186));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 150, 30));

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Dni");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 90, 30));

        txtDni.setBackground(new java.awt.Color(153, 153, 153));
        txtDni.setForeground(new java.awt.Color(0, 0, 0));
        txtDni.setBorder(null);
        jPanel2.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 150, 30));

        jSeparator6.setForeground(new java.awt.Color(34, 194, 186));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 150, 30));

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Correo");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 90, 30));

        jSeparator7.setForeground(new java.awt.Color(34, 194, 186));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 190, 30));

        txtPasswordVali.setBackground(new java.awt.Color(153, 153, 153));
        txtPasswordVali.setForeground(new java.awt.Color(0, 0, 0));
        txtPasswordVali.setBorder(null);
        jPanel2.add(txtPasswordVali, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, 150, 30));

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Password");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 90, 30));

        txtPassword.setBackground(new java.awt.Color(153, 153, 153));
        txtPassword.setForeground(new java.awt.Color(0, 0, 0));
        txtPassword.setBorder(null);
        jPanel2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 150, 30));

        jSeparator8.setForeground(new java.awt.Color(34, 194, 186));
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 150, 30));

        BotonRegistrarse.setBackground(new java.awt.Color(34, 194, 186));
        BotonRegistrarse.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BotonRegistrarse.setForeground(new java.awt.Color(0, 0, 0));
        BotonRegistrarse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/verificar.png"))); // NOI18N
        BotonRegistrarse.setText("REGISTRARSE");
        BotonRegistrarse.setToolTipText("");
        BotonRegistrarse.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(34, 194, 186)));
        BotonRegistrarse.setContentAreaFilled(false);
        BotonRegistrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegistrarseActionPerformed(evt);
            }
        });
        jPanel2.add(BotonRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 550, 390, 70));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signo-de-exclamacion (1).png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signo-de-exclamacion (1).png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signo-de-exclamacion (1).png"))); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signo-de-exclamacion (1).png"))); // NOI18N
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signo-de-exclamacion (1).png"))); // NOI18N
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signo-de-exclamacion (1).png"))); // NOI18N
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signo-de-exclamacion (1).png"))); // NOI18N
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, -1, -1));

        jLabel18.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(60, 63, 65));
        jLabel18.setText("Iniciar sesion");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, 40));

        B_ValidarUVendedor_existente.setBackground(new java.awt.Color(51, 255, 102));
        B_ValidarUVendedor_existente.setForeground(new java.awt.Color(0, 0, 0));
        B_ValidarUVendedor_existente.setText("Validar");
        B_ValidarUVendedor_existente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_ValidarUVendedor_existenteActionPerformed(evt);
            }
        });
        jPanel2.add(B_ValidarUVendedor_existente, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 90, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 630, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BotonRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegistrarseActionPerformed
        // TODO add your handling code here:
        if (txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtDni.getText().isEmpty()
                || txtCorreo.getText().isEmpty() || (txtPassword.getPassword().length == 0) || (txtPasswordVali.getPassword().length == 0)) {
            JOptionPane.showMessageDialog(null, "No deben estar incompleto los datos");
            return;
        }

        char[] pass = txtPassword.getPassword();
        char[] pass1 = txtPasswordVali.getPassword();

        if (!String.valueOf(pass).equals(String.valueOf(pass1))) {
            JOptionPane.showMessageDialog(null, "Las claves no coinciden");
            limpiar();
            return;
        }

        String dni = txtDni.getText();

        if (!usuarioDAO.dniExiste(dni)) {
            JOptionPane.showMessageDialog(null, "No existe el DNI del usuario. Verificacion incorrecta");
            return;
        }
        
         int idVendedor = vendedorDao.obtenerIdPorDni(dni);

        // Creación del usuario
        Usuario usuario = new Usuario();
        usuario.setNombres(txtNombre.getText());
        usuario.setApellidos(txtApellidos.getText());
        usuario.setDni(dni);
        usuario.setTelefono(txtTelefono.getText());
        usuario.setCorreo(txtCorreo.getText());
        usuario.setClave(String.valueOf(pass));
        usuario.setEstado(1);
        usuario.setRol("vendedor"); 
        usuario.setId_vendedor(idVendedor); 

        // Registro del usuario en la base de datos
        if (usuarioDAO.agregarUsuario(usuario)) {
            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
            limpiar();
            FRM_Login login = new FRM_Login();
            login.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar el usuario");
        }
    }//GEN-LAST:event_BotonRegistrarseActionPerformed

    private void B_ValidarUVendedor_existenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_ValidarUVendedor_existenteActionPerformed
        // TODO add your handling code here:
        if (txtDni.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No deben estar vacias las casillas");
            return;
        }
        if (!vendedorDao.dniExiste(txtDni.getText())) {
            JOptionPane.showMessageDialog(null, "No existe el DNI del usuario. Verificacion incorrecta");
            limpiar();
            return;
        }
        JOptionPane.showMessageDialog(null, "Dni existente.Verificacion correcta");

    }//GEN-LAST:event_B_ValidarUVendedor_existenteActionPerformed

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
        FRM_Login login = new FRM_Login();
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel18MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FRM_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRM_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRM_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRM_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRM_Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_ValidarUVendedor_existente;
    private javax.swing.JButton BotonRegistrarse;
    private javax.swing.JPanel JPLogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordVali;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
