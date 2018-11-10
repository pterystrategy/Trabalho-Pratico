/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.modeltable;

import br.com.prodrigues.trabalhopratico.model.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class ClienteTableModel extends UtilTableModel<Cliente> {

    public ClienteTableModel(List<Cliente> lista) {
        super(lista);
        columnNames = new String[]{"ID", "Nome", "CPF"};
        classes = new Class[]{Long.class, String.class, String.class};
    }

    @Override
    public void filter(String filtro) {
        lista.clear();
        listaOriginal.stream().filter((cliente) -> (cliente.getName().contains(filtro))).forEachOrdered((cliente) -> {
            lista.add(cliente);
        });
    }

    @Override

    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente get = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return get.getId();
            case 1:
                return get.getName();
            case 2:
                return get.getCpf();
            default:
                return null;
        }
    }

}
