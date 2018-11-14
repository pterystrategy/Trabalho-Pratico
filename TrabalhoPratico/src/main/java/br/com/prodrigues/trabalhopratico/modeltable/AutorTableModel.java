/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.modeltable;

import br.com.prodrigues.trabalhopratico.model.Autor;
import java.util.Date;
import java.util.List;

/**
 *
 * @author prorodrigues
 */
public class AutorTableModel extends UtilTableModel<Autor> {

    public AutorTableModel(List<Autor> listanova) {
        super(listanova);
        columnNames = new String[]{"ID", "Nome", "Data"};
        classes = new Class[]{Long.class, String.class, Date.class};
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Autor autor;
        autor = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return autor.getId();
            case 1:
                return autor.getName();
            case 2:
                return autor.getNascimento();
            default:
                return null;
        }
    }

    @Override
    public void filter(String filtro) {
        lista.clear();
        for (Autor autor : listaOriginal) {
            if (autor.getName().contains(filtro)) {
                lista.add(autor);
            }
        }
    }
}
