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
public class mdlDepartamento extends mdlGenerico{
    private String descricao;

    public mdlDepartamento() {
    }
    
    public mdlDepartamento(int codigo, String descricao) {
        super(codigo);
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String[] listaValores() {
        String valores[] = new String[2];
        valores[0] = Integer.toString(super.getCodigo());
        valores[1] = getDescricao(); 
        return valores;
    }
    
    public String toString(){
        return "Codigo: " + getCodigo() + " | Departamento: " + getDescricao();
    }
}
