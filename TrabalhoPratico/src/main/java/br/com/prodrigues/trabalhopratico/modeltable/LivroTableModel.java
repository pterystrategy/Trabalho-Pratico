/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.modeltable;

import br.com.prodrigues.trabalhopratico.model.Livro;
import java.util.List;

/**
 *
 * @author prorodrigues
 */
public class LivroTableModel extends UtilTableModel<Livro> {

    public LivroTableModel(List<Livro> l) {
        super(l);
        columnNames = new String[]{"ID", "Nome", "Autor"};
        classes = new Class[]{Long.class, String.class, String.class};
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Livro livro = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return livro.getId();
            case 1:
                return livro.getTitulo();
            case 2:
                return livro.getAutor().getName();
            default:
                return null;
        }

    }

    @Override
    public void filter(String filtro) {
        lista.clear();
        for (Livro livro : listaOriginal) {
            if (livro.getTitulo().contains(filtro)) {
                lista.add(livro);
            }

            else if(livro.getAutor().getName().contains(filtro)){
                lista.add(livro);
            }
            
        }
    }
}
