/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.modeltable;

import br.com.prodrigues.trabalhopratico.model.Editora;
import java.util.List;

/**
 *
 * @author prorodrigues
 */
public class EditoraTableModel extends UtilTableModel<Editora> {

    protected List<Editora> listaoriginal;

    public EditoraTableModel(List<Editora> l) {
        super(l);
        this.columnNames = new String[]{"ID", "Nome"};
        this.classes = new Class[]{Long.class, String.class};
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Editora get = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return get.getId();
            case 1:
                return get.getNamepublisher();
            default:
                return null;
        }
    }

    @Override
    public void filter(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
