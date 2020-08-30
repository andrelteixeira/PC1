/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author andre
 */
public abstract class mdlGenerico {
    private int codigo;

    public mdlGenerico() {
    }

    public mdlGenerico(int codigo) {
        this.codigo = codigo;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public abstract String[] listaValores();
}
