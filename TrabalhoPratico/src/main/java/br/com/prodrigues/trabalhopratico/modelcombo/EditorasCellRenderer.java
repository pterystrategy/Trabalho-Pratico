/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.modelcombo;

import br.com.prodrigues.trabalhopratico.model.Editora;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author prorodrigues
 */
public class EditorasCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> jlist, Object o, int i, boolean bln, boolean bln1) {
        super.getListCellRendererComponent(jlist, o, i, bln, bln1); //To change body of generated methods, choose Tools | Templates.
        if (o instanceof Editora) {
            Editora e = (Editora) o;
            this.setText(e.getNamepublisher());
        }
        return this;
    }
}
