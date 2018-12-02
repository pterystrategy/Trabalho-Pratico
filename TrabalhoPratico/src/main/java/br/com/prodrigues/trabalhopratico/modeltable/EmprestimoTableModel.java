/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.modeltable;

import br.com.prodrigues.trabalhopratico.model.Emprestimo;
import java.util.List;

/**
 *
 * @author prorodrigues
 */
public class EmprestimoTableModel extends UtilTableModel<Emprestimo> {

     public EmprestimoTableModel(List<Emprestimo> listanova) {
        super(listanova);
        this.columnNames = new String[]{"ID", "Cliente"};
        this.classes = new Class[]{Long.class, String.class};
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Emprestimo get = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return get.getId();
            case 1:
                return get.getCliente().getName();

            default:
                return null;
        }

    }

    @Override
    public void filter(String filtro) {
         lista.clear();
        for (Emprestimo emprestimo : listaOriginal) {
            if (emprestimo.getCliente().getName().contains(filtro)) {
                lista.add(emprestimo);
            }
        }
    }
}
