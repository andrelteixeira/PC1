/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.mdlCategoria;
import modelo.mdlGenerico;

/**
 *
 * @author andre
 */
public class daoCategoria extends daoGenerico{

    @Override
    public void iniciaPersistencia() {
        tabela = "categoria";
        campos = new String[]{"nome", "admin"};
        chave = "codigo";
    }

    @Override
    public void mapearParametros(PreparedStatement ST, mdlGenerico obj) {
        try {
            ST.setString(1, ((mdlCategoria)obj).getDescricao());
            ST.setBoolean(2, ((mdlCategoria)obj).isAdmin());
        } catch (SQLException ex) {
            Logger.getLogger(daoCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void desmapearParametros(ResultSet rs, mdlGenerico obj) {
        try {
            ((mdlCategoria)obj).setCodigo(rs.getInt("codigo"));
            ((mdlCategoria)obj).setDescricao(rs.getString("nome"));
            ((mdlCategoria)obj).setAdmin(rs.getBoolean("admin"));
        } catch (SQLException ex) {
            Logger.getLogger(daoCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
