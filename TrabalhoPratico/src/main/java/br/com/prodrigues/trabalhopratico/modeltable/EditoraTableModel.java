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
       lista.clear();
        for (Editora editora: listaOriginal) {
            if (editora.getNamepublisher().contains(filtro)) {
                lista.add(editora);
            }
            
        }
    }
}
