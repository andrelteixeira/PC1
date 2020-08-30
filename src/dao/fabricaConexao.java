/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andre
 */
public class fabricaConexao {
    private static final String STR_DRIVER = "org.gjt.mm.mysql.Driver";  // definição de qual banco será utilizado
    private static final String DATABASE = "pc1_2020-02"; // Nome do banco de dados         
    private static final String IP = "localhost";  // ip de conexao
    private static final String STR_CON = "jdbc:mysql://" + IP + ":3306/" + DATABASE; // string de conexao com o banco de dados
    private static final String USER = "root"; // Nome do usuário
    private static final String PASSWORD = ""; // senha
    private static Connection objConexao = null;
    
    public fabricaConexao() throws SQLException {
        try{
            Class.forName(STR_DRIVER);
            objConexao = (Connection) DriverManager.getConnection(STR_CON, USER, PASSWORD);
        }catch (ClassNotFoundException | SQLException e) {   
            String errorMsg = "Driver nao encontrado: " + e.getMessage();    
            System.err.println("ERRO NA CONSTRUÇÃO DA CONEXÃO: " + errorMsg);
        }   
    }
    
    public static Connection getConexaoPADRAO() throws SQLException {
        if (objConexao == null) {            
            fabricaConexao objConexao = new fabricaConexao();                        
        }        
        return objConexao; 
    }
    
    public static Connection getConexaoCUSTOMIZADA(){
        Connection cnx = null;
        try {
            Class.forName(STR_DRIVER);
            cnx = (Connection) DriverManager.getConnection(STR_CON, USER, PASSWORD);
            
            cnx.setAutoCommit(false);
            cnx.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("ERRO AO GERAR NOVA CONEXAO " + ex.getMessage());
        }
        return cnx;
    }
}