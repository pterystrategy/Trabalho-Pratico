/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.modelcombo;

import br.com.prodrigues.trabalhopratico.model.Autor;
import br.com.prodrigues.trabalhopratico.model.Editora;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author prorodrigues
 */
public final class EditorasComboModel  extends AbstractListModel<Editora> implements ComboBoxModel<Editora>{
    
    
    private final List<Editora> listEditoras;
    private Editora selectedEditora;
    private final static int FIRSTINDEX = 0;

    public EditorasComboModel(List<Editora> listEditoras) {
        this();
        this.listEditoras.addAll(listEditoras);
        if (getSize() > 0) {
            setSelectedItem(this.listEditoras.get(FIRSTINDEX));
        }
    }

    public EditorasComboModel() {
        this.listEditoras = new ArrayList<>();
    }
    

    @Override
    public int getSize() {
        return listEditoras.size();  
        }

    @Override
    public Editora getElementAt(int index) {
        return listEditoras.get(index);
    }

    @Override
    public void setSelectedItem(Object o) {
        selectedEditora = (Editora) o;
    }

    @Override
    public Object getSelectedItem() {
        return selectedEditora;    
    }
    
    
     public void addAutor(Editora editora) {
        listEditoras.add(editora);
        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        setSelectedItem(listEditoras.get(getSize() - 1));
    }
     
    public void addListEditora(List<Editora> editoras) {
        int primeiraLinha = getSize();
        listEditoras.addAll(editoras);
        fireIntervalAdded(this, primeiraLinha, primeiraLinha  + editoras.size());
        setSelectedItem(listEditoras.get(getSize() - 1));
    }
     
    public void removeAutor() {
        boolean remove;
        remove = listEditoras.remove((Editora) getSelectedItem());
        fireIntervalRemoved(this, FIRSTINDEX, getSize() - 1);
        setSelectedItem(listEditoras.get(FIRSTINDEX));
    }
     
    public void clear() {
        listEditoras.clear();
        fireContentsChanged(this, FIRSTINDEX, getSize() - 1);
    }
    
}
