/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.modeltable.antigo;

import br.com.prodrigues.trabalhopratico.model.Emprestimo;
import br.com.prodrigues.trabalhopratico.model.Livro;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author prorodrigues
 */
public class EmprestimoTableModel extends AbstractTableModel {

    List<Emprestimo> lista = new ArrayList<>();

    protected List<Emprestimo> listaoriginal;

    protected String[] columnNames;
    protected Class[] classes;

    public EmprestimoTableModel(List<Emprestimo> listanova) {
        columnNames = new String[]{"ID", "Cliente", "Livro", "Multa"};
        classes = new Class[]{Long.class, String.class, String.class, Double.class};
        lista = listanova;
    }

    public void setLista(List<Emprestimo> lista) {
        this.lista = lista;

    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Emprestimo get = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return get.getId();
            case 1:
                return get.getCliente().getName();
            case 2:
                return get.getLivro().getTitulo();
            case 3:
                return get.getMulta();
            default:
                return null;
        }

    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
