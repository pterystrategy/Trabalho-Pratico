/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.modelcombo;

import br.com.prodrigues.trabalhopratico.model.Autor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author prorodrigues
 */
public final class AutoresComboModel  extends AbstractListModel<Autor> implements ComboBoxModel<Autor>{
    
    
    private final List<Autor> listAutores;
    private Autor selectedAutor;
    private final static int FIRSTINDEX = 0;

    public AutoresComboModel(List<Autor> listAutores) {
        this();
        this.listAutores.addAll(listAutores);
        if (getSize() > 0) {
            setSelectedItem(this.listAutores.get(FIRSTINDEX));
        }
    }

    public AutoresComboModel() {
        this.listAutores = new ArrayList<>();
    }
    

    @Override
    public int getSize() {
        return listAutores.size();  
        }

    @Override
    public Autor getElementAt(int index) {
        return listAutores.get(index);
    }

    @Override
    public void setSelectedItem(Object o) {
        selectedAutor = (Autor) o;
    }

    @Override
    public Object getSelectedItem() {
        return selectedAutor;    
    }
    
    
     public void addAutor(Autor autor) {
        listAutores.add(autor);
        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        setSelectedItem(listAutores.get(getSize() - 1));
    }
     
    public void addListAutor(List<Autor> autores) {
        int primeiraLinha = getSize();
        listAutores.addAll(autores);
        fireIntervalAdded(this, primeiraLinha, primeiraLinha  + autores.size());
        setSelectedItem(listAutores.get(getSize() - 1));
    }
     
    public void removeAutor() {
        boolean remove;
        remove = listAutores.remove((Autor) getSelectedItem());
        fireIntervalRemoved(this, FIRSTINDEX, getSize() - 1);
        setSelectedItem(listAutores.get(FIRSTINDEX));
    }
     
    public void clear() {
        listAutores.clear();
        fireContentsChanged(this, FIRSTINDEX, getSize() - 1);
    }
    
}
