/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.daoGenerico;
import java.util.ArrayList;
import modelo.mdlGenerico;

/**
 *
 * @author andre
 */
public abstract class ctrlGenerico {
    protected daoGenerico dao;

    public ctrlGenerico() {
        inicializaControle();
    }
    
    public abstract void inicializaControle();
    
    public void salvar(mdlGenerico obj){
        if(obj.getCodigo() == 0){
            dao.inserir(obj);
        }
        else{
            dao.atualizar(obj);
        }
    }
    
    public void deletar(mdlGenerico obj){
        dao.deletar(obj);
    }
    
    public void recuperar(mdlGenerico obj){
        ArrayList<mdlGenerico> lista = dao.recupera(obj);
        
        for (mdlGenerico gen : lista) {
            System.out.println(gen.toString());
        }
    }
}
