/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.modeltable.antigo;

import br.com.prodrigues.trabalhopratico.model.Emprestimo;
import br.com.prodrigues.trabalhopratico.modeltable.UtilTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author prorodrigues
 */
public class EmprestimoTableModel extends UtilTableModel<Emprestimo> {

  

    public EmprestimoTableModel(List<Emprestimo> listanova) {
        columnNames = new String[]{"ID", "Cliente", "Multa"};
        classes = new Class[]{Long.class, String.class, String.class, Date.class};
        lista = (ArrayList<Emprestimo>) listanova;
    }

    public void setLista(List<Emprestimo> lista) {
        this.lista = (ArrayList<Emprestimo>) lista;

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
                return get.getDataEmprestimo();
            default:
                return null;
        }

    }

    @Override
    public void filter(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
