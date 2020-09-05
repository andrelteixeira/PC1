/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.daoDepartamento;
import modelo.mdlDepartamento;

/**
 *
 * @author andre
 */
public class ctrlDepartamento extends ctrlGenerico{

    @Override
    public void inicializaControle() {
        dao = new daoDepartamento();
    }
    
}
