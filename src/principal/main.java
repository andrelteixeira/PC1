/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import dao.daoCategoria;
import dao.daoDepartamento;
import java.util.ArrayList;
import modelo.*;

/**
 *
 * @author andre
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        mdlCategoria obj = new mdlCategoria(2, "", false);
        daoCategoria dao = new daoCategoria();
        
        //dao.inserir(obj);
        //dao.atualizar(obj);
        
        
        ArrayList<mdlGenerico> lista = dao.recupera(obj);
        
        for (mdlGenerico gen : lista) {
            System.out.println(((mdlCategoria)gen).toString());
        }
        
    }
}
