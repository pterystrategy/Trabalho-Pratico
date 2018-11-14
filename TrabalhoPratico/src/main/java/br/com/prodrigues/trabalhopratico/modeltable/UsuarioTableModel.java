/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.modeltable;

import br.com.prodrigues.trabalhopratico.model.Usuario;
import java.util.List;

/**
 *
 * @author prorodrigues
 */
public class UsuarioTableModel extends UtilTableModel<Usuario> {

    public UsuarioTableModel(List<Usuario> l) {
        super(l);
        this.columnNames = new String[]{"ID", "Login"};
        this.classes = new Class[]{Long.class, String.class};
    }

    public void setLista(List<Usuario> lista) {
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return usuario.getId();
            case 1:
                return usuario.getLogin();
            default:
                return null;
        }

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {

            case 0:
                return "Id";
            case 1:
                return "Nome";
            default:
                return "default:";
        }
    }

    @Override
    public void filter(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
