/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.visao;

import br.com.infox.conexaobd.ConexaoBD;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author valdo
 */
public class TelaLogin extends javax.swing.JFrame {

    ConexaoBD conex = new ConexaoBD();
    
    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();
        conex.conectar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonLogin = new javax.swing.JButton();
        jTextFieldLogin = new javax.swing.JTextField();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jLabelFundo_Login = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("X System - Login");
        setResizable(false);
        getContentPane().setLayout(null);

        jButtonLogin.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLogin);
        jButtonLogin.setBounds(140, 410, 220, 60);

        jTextFieldLogin.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        jTextFieldLogin.setMinimumSize(new java.awt.Dimension(30, 32));
        getContentPane().add(jTextFieldLogin);
        jTextFieldLogin.setBounds(95, 221, 370, 54);

        jPasswordFieldSenha.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        getContentPane().add(jPasswordFieldSenha);
        jPasswordFieldSenha.setBounds(95, 296, 370, 54);

        jLabelFundo_Login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/imagens/fundo_login.png"))); // NOI18N
        getContentPane().add(jLabelFundo_Login);
        jLabelFundo_Login.setBounds(0, 0, 500, 513);

        setSize(new java.awt.Dimension(504, 541));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        
        try {
            conex.executaSql("select * from usuarios where login_usuario = '"+jTextFieldLogin.getText()+"'");
            conex.resultSet.first();
            
            if(conex.resultSet.getString("login_usuario").equals(jTextFieldLogin.getText()) && 
                    conex.resultSet.getString("senha_usuario").equals(jPasswordFieldSenha.getText())){
                JOptionPane.showMessageDialog(rootPane, "Logando ao sistema");
            }else{
                JOptionPane.showMessageDialog(rootPane, "USUARIO OU SENHA INVALIDOS!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabelFundo_Login;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTextFieldLogin;
    // End of variables declaration//GEN-END:variables
}