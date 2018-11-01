/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.modeltable.antigo;

import br.com.prodrigues.trabalhopratico.model.Autor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author prorodrigues
 */
public class AutorTableModel extends AbstractTableModel {

    List<Autor> lista = new ArrayList<>();
    protected List<Autor> listaoriginal;

    protected String[] columnNames;
    protected Class[] classes;

    public AutorTableModel(List<Autor> listanova) {
        lista = listanova;
        columnNames = new String[]{"ID", "Nome", "Data"};
        classes = new Class[]{Long.class, String.class, Date.class};
    }

    public void setLista(List<Autor> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Autor autor = lista.get(rowIndex);
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
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
