/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.modeltable;

import br.com.prodrigues.trabalhopratico.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author aluno
 */
public class ClienteTableModel extends AbstractTableModel {
    List<Cliente> lista = new ArrayList<>();
    
    public ClienteTableModel(List<Cliente> listanova){
       lista = listanova;
    }
    
    
    
    public void setLista(List<Cliente> lista){
        this.lista = lista;
    
    }
    
//    public ClienteTableModel(){
//        lista.add(new Cliente(1L, "alessio"));
//        
//        lista.add(new Cliente(1L, "alessio1"));
//        lista.add(new Cliente(2L, "alessio2"));
//        lista.add(new Cliente(3L, "alessio3"));
//    }

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
        Cliente c = lista.get(rowIndex);
        switch (columnIndex){
            case 0:
                return c.getId();
            case 1:
                return c.getName();
            default:
                 return null;
        }   
       
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
        
            case 0:
                return "Id";
            case 1:
                return "Nome";
            default:
                return "default:";
        }
    } 
}
