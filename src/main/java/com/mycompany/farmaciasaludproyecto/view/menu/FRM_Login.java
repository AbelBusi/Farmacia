package com.mycompany.farmaciasaludproyecto.view.menu;

import com.mycompany.farmaciasaludproyecto.model.dao.UsuarioDAO;
import com.mycompany.farmaciasaludproyecto.model.entity.Usuario;
import com.mycompany.farmaciasaludproyecto.view.image.redirectImage;
import java.awt.Dimension;
import javax.swing.JOptionPane;

/**
 *
 * @author cesar
 */
public class FRM_Login extends javax.swing.JFrame {

    redirectImage image1 = new redirectImage();
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    /**
     * Creates new form JLoginFrame
     */
    public FRM_Login() {

        initComponents();
        this.setSize(new Dimension(1200, 700));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JPLogo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtPassword = new javax.swing.JPasswordField();
        logoLogin = new javax.swing.JLabel();
        logoLogin2 = new javax.swing.JLabel();
        logoLogin3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

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
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 290, 250));

        txtCorreo.setBackground(new java.awt.Color(153, 153, 153));
        txtCorreo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(0, 0, 0));
        txtCorreo.setBorder(null);
        jPanel2.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 330, 40));

        jButton1.setBackground(new java.awt.Color(34, 194, 186));
        jButton1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/importar.png"))); // NOI18N
        jButton1.setText("INGRESAR");
        jButton1.setToolTipText("");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(34, 194, 186)));
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 560, 330, 70));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("CONTRASEÑA");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 130, 40));

        jSeparator1.setForeground(new java.awt.Color(34, 194, 186));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 470, 10));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("INICIAR SESION");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 130, 50));

        jSeparator2.setForeground(new java.awt.Color(34, 194, 186));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 470, 30));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("CORREO");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 90, 40));

        jSeparator3.setForeground(new java.awt.Color(34, 194, 186));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 470, 30));

        txtPassword.setBackground(new java.awt.Color(153, 153, 153));
        txtPassword.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(0, 0, 0));
        txtPassword.setBorder(null);
        jPanel2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 330, 40));

        logoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cerrar-con-llave.png"))); // NOI18N
        jPanel2.add(logoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 450, 60, 70));

        logoLogin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farmaciaHome.png"))); // NOI18N
        jPanel2.add(logoLogin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 60, 70));

        logoLogin3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/direccion-de-correo-electronico (1).png"))); // NOI18N
        jPanel2.add(logoLogin3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 60, 70));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(60, 63, 65));
        jLabel6.setText("¿No tienes cuenta ?");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 510, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 600, 700));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String correo = txtCorreo.getText();
        char[] passArray = txtPassword.getPassword();
        String clave = String.valueOf(passArray);

        if (correo.isEmpty() || clave.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
            return;
        }

        Usuario usuario = usuarioDAO.loguear(correo, clave);

        if (usuario != null) {
            JOptionPane.showMessageDialog(null, "Bienvenido " + usuario.getNombres() + " " + usuario.getApellidos());

            String rol = usuario.getRol();
            if (rol != null) {
                JOptionPane.showMessageDialog(null, "Tu rol es: " + rol);
                if (rol.equals("administrador")) {
                    FRM_MENU_ADMINISTRADOR adminiFrm_menu_administrador = new FRM_MENU_ADMINISTRADOR();
                    adminiFrm_menu_administrador.setVisible(true);
                    this.setVisible(false);
                } else if (rol.equals("vendedor")) {
                    FRM_MENU_EMPLEADO ingresarMenu = new FRM_MENU_EMPLEADO();
                    ingresarMenu.setVisible(true);
                    this.setVisible(false);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Correo o contraseña incorrectos");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        FRM_Register frmRegistrarse = new FRM_Register();
        frmRegistrarse.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel6MouseClicked

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
            java.util.logging.Logger.getLogger(FRM_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRM_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRM_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRM_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRM_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPLogo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel logoLogin;
    private javax.swing.JLabel logoLogin2;
    private javax.swing.JLabel logoLogin3;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
