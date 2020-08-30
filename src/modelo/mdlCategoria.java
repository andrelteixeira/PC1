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
public class mdlCategoria extends mdlGenerico{
    private String descricao;
    private boolean admin;

    public mdlCategoria(int codigo, String descicao, boolean admin) {
        super(codigo);
        this.descricao = descicao;
        this.admin = admin;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descicao) {
        this.descricao = descicao;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String[] listaValores() {
        String valores[] = new String[3];
        valores[0] = Integer.toString(super.getCodigo());
        valores[1] = getDescricao();
        valores[2] = String.valueOf(admin);
        return valores;
    }
    
    public String toString(){
        return "codigo: " + getCodigo() + " | descricao: " + getDescricao() + " | Admin: " + isAdmin();
    }
}
