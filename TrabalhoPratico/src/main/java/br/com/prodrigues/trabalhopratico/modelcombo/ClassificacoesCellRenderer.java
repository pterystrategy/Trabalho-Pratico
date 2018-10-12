/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.modelcombo;

import br.com.prodrigues.trabalhopratico.model.Classificacao;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author prorodrigues
 */
public class ClassificacoesCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list,
            Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
         
        if (value instanceof Classificacao) {
            Classificacao classificacao = (Classificacao) value;
            setText(classificacao.name());
        }
        return this;
    }
}
