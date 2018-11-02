/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.modeltable.antigo;

import br.com.prodrigues.trabalhopratico.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author prorodrigues
 */
public class UsuarioTableModel extends AbstractTableModel {

    List<Usuario> lista = new ArrayList<>();

    public UsuarioTableModel(List<Usuario> listanova) {
        lista = listanova;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;

    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return usuario.getName();
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
}
