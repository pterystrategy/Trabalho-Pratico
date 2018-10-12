package br.com.prodrigues.trabalhopratico.modelcombo;

import br.com.prodrigues.trabalhopratico.model.Cliente;
import java.awt.Component;
 
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
 
 
public class ClientesCellRenderer extends DefaultListCellRenderer {
 
    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list,
            Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
         
        if (value instanceof Cliente) {
            Cliente cliente = (Cliente) value;
            setText(cliente.getName());
        }
        return this;
    }
}