/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.modeltable;

import br.com.prodrigues.trabalhopratico.model.Autor;
import br.com.prodrigues.trabalhopratico.model.Editora;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author prorodrigues
 */
public class EditoraTableModel extends AbstractTableModel{
    
    
    List<Editora> lista = new ArrayList<>();
    protected List<Editora> listaoriginal;
    
    protected String[] columnNames;
    protected Class[] classes;

    public EditoraTableModel(List<Editora> listanova) {
        lista = listanova;
        columnNames = new String[]{"ID","Nome"};
        classes = new Class[]{Long.class,String.class};
    }
    
    public void setLista(List<Editora> lista){
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
        Editora get = lista.get(rowIndex);
        switch (columnIndex){
            case 0:
                return get.getId();
            case 1:
                return get.getNamepublisher();
            default:
                 return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }   
}
