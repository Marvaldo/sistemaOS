/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.dao;

import br.com.infox.beans.UsuarioBeans;
import br.com.infox.conexaobd.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author valdo
 */
public class UsuarioDAO {

    ConexaoBD conex = new ConexaoBD();
    UsuarioBeans beansUsuario = new UsuarioBeans();

    public void salvar(UsuarioBeans mod) {
        conex.conectar();
        try {
            PreparedStatement pst = conex.conexao.prepareStatement("insert into usuarios (nome_usuario, login_usuario, "
                    + "senha_usuario, tel_usuario, perfil_usuario) values (?,?,?,?,?)");

            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getLogin());
            pst.setString(3, mod.getSenha());
            pst.setString(4, mod.getTelefone());
            pst.setString(5, mod.getPerfil());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "DADOS INSERIDOS COM SUCESSO!");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "ERRO AO INSERIR OS DADOS! *** usuario DAO *** "+ex.getMessage());
        }

        conex.desconecta();
    }
}
