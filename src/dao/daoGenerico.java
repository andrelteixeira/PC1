/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.mdlGenerico;

/**
 *
 * @author andre
 */
public abstract class daoGenerico {
    protected String tabela;
    protected String[] campos;
    protected String chave;
    
    private String sqlInserir;
    private String sqlAtualizar;
    private String sqlDeletar;
    private String sqlConsultar;

    private void montarSql(){
        sqlDeletar = "delete from " + tabela + " where " + chave + " = ?";
        sqlConsultar = "select * from " + tabela + " where " + chave + " = ?";
    
        sqlInserir = "insert into " + tabela + " ( ";
        String sCampo = new String();
        String valores = new String();
        for (String campo : campos) {
            sCampo += campo + ", ";
            valores += "?, ";
        }
        sCampo = sCampo.substring(0, sCampo.length()-2);
        valores = valores.substring(0, valores.length()-2);
        sqlInserir += sCampo + " ) values ( " + valores + " )";
        
        sqlAtualizar = "update " + tabela + " set ";
        sCampo = new String();
        for (String campo : campos) {
            sCampo += campo + " = ?, ";
        }
        sCampo = sCampo.substring(0, sCampo.length()-2);
        sqlAtualizar += sCampo + " where " + chave + " = ?";
    }
    
    public abstract void iniciaPersistencia();
    public abstract void mapearParametros(PreparedStatement ST, mdlGenerico obj);
    public abstract void desmapearParametros(ResultSet rs, mdlGenerico obj);

    public daoGenerico() {
        iniciaPersistencia();
        montarSql();
    }
    
    public void inserir(mdlGenerico obj){
        
        try {
            Connection cnx = fabricaConexao.getConexaoPADRAO();
            PreparedStatement comando = cnx.prepareStatement(sqlInserir);
            mapearParametros(comando, obj);
            comando.executeUpdate();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(daoGenerico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizar(mdlGenerico obj){
        try {
            Connection cnx = fabricaConexao.getConexaoPADRAO();
            PreparedStatement comando = cnx.prepareStatement(sqlAtualizar);
            mapearParametros(comando, obj);
            comando.setInt(campos.length+1, obj.getCodigo());
            comando.executeUpdate();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(daoGenerico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deletar(mdlGenerico obj){
        try {
            Connection cnx = fabricaConexao.getConexaoPADRAO();
            PreparedStatement comando = cnx.prepareStatement(sqlDeletar);
            comando.setInt(1, obj.getCodigo());
            comando.executeUpdate();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(daoGenerico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<mdlGenerico> recupera(mdlGenerico obj) {
        ArrayList<mdlGenerico> lista = new ArrayList<>();
        try {
            Connection cnx = fabricaConexao.getConexaoPADRAO();
            PreparedStatement comando = cnx.prepareStatement(sqlConsultar);
            comando.setInt(1, obj.getCodigo());
            ResultSet retorno = comando.executeQuery();
            while (retorno.next()) {
                desmapearParametros(retorno, obj);
                lista.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoGenerico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
