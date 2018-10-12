/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.modeltable;

import br.com.prodrigues.trabalhopratico.model.Autor;
import br.com.prodrigues.trabalhopratico.model.Livro;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author prorodrigues
 */
public class LivroTableModel extends AbstractTableModel{
    
    List<Livro> lista = new ArrayList<>();
    
    
    protected List<Livro> listaoriginal;
    
    protected String[] columnNames;
    protected Class[] classes;

    
    public LivroTableModel(List<Livro> listanova){
       columnNames = new String[]{"ID","Nome","Autor"};
       classes = new Class[]{Long.class,String.class,Autor.class};
       lista = listanova;
    }
    
    
    
    public void setLista(List<Livro> lista){
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
        Livro livro = lista.get(rowIndex);
        switch (columnIndex){
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
    public String getColumnName(int column) {
       return columnNames[column];
    }
}
