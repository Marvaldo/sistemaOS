/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.conexaobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author valdo
 */
public class ConexaoBD {
    
    public Statement statement; //responsavel por realizar pesquisas no banco de dados.
    public ResultSet resultSet; //armazenar o resultado da pesquisa (feita pelo o statement).
    private static final String driver = "org.postgresql.Driver"; //identifica o serviço do banco de dados(no caso o padrão do MySql).
    private static final String caminho = "jdbc:postgresql://192.168.1.11/dbinfox"; //ira idezer o caminho para chegar ao banco de dados.
    private static final String usuario = "postgres"; // usuario do banco de dados
    private static final String senha = "senha432"; // senha do banco de dados.
    public Connection conexao; // responsavel por realizar a conexao com o BD.
    
    public void conectar(){ //metodo para conectar ao banco de dados.
        
        try {
            //estabelece uma conexao com banco de dados.
            System.setProperty("jdbc.Drivers", driver);
            conexao = DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null, "CONEXAO EFETUADA COM SUCESSO!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO CONECTAR COM O BD:  *** ModuloConexao *** \n"+ex.getMessage());
            
        }
    }
    public void desconecta(){//metodo para desconectar com o banco de daods.
        try {
            conexao.close();
            //JOptionPane.showMessageDialog(null, "DESCONECTADO COM SUCESSO!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO DESCONECTAR! *** ModuloConexao *** \n"+ex.getMessage());
        }
    }
    public void executaSql(String sql){
        try {
            //ignorar maiuscu/minusc      //percorrer de cima para baixo e baixo para cima.
            statement = conexao.createStatement(resultSet.TYPE_SCROLL_INSENSITIVE, resultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO EXECUTAR O SQL *** ModuloConexao *** "+ex.getMessage());
        }
    }
}
