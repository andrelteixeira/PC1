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
import modelo.mdlDepartamento;
import modelo.mdlGenerico;

/**
 *
 * @author andre
 */
public class daoDepartamento extends daoGenerico {

    @Override
    public void iniciaPersistencia() {
        tabela = "departamento";
        chave = "codigo";
        String[] listaCampos = new String[1];
        listaCampos[0] = "nome";
        campos = listaCampos;
    }

    @Override
    public void mapearParametros(PreparedStatement ST, mdlGenerico obj) {
        try {
            ST.setString(1, ((mdlDepartamento) obj).getDescricao());
        } catch (SQLException ex) {
            Logger.getLogger(daoDepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void desmapearParametros(ResultSet rs, mdlGenerico obj) {
        try {
            ((mdlDepartamento) obj).setCodigo(rs.getInt("codigo"));
            ((mdlDepartamento) obj).setDescricao(rs.getString("nome"));
        } catch (SQLException ex) {
            Logger.getLogger(daoDepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
