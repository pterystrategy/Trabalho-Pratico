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
        if (this.getSize() > 0) {
            setSelectedItem(this.listAutores.get(AutoresComboModel.FIRSTINDEX));
        }
    }

    public AutoresComboModel() {
        this.listAutores = new ArrayList<>();
    }
    

    @Override
    public int getSize() {
        return this.listAutores.size();  
        }

    @Override
    public Autor getElementAt(int index) {
        return this.listAutores.get(index);
    }

    @Override
    public void setSelectedItem(Object o) {
        this.selectedAutor = (Autor) o;
    }

    @Override
    public Object getSelectedItem() {
        return this.selectedAutor;    
    }
    
    
     public void addAutor(Autor autor) {
        this.listAutores.add(autor);
        fireIntervalAdded(this, this.getSize() - 1, this.getSize() - 1);
        setSelectedItem(this.listAutores.get(this.getSize() - 1));
    }
     
    public void addListAutor(List<Autor> autores) {
        int primeiraLinha = getSize();
        listAutores.addAll(autores);
        fireIntervalAdded(this, primeiraLinha, primeiraLinha  + autores.size());
        setSelectedItem(this.listAutores.get(getSize() - 1));
    }
     
    public boolean removeAutor() {
        boolean remove;
        remove = listAutores.remove((Autor) getSelectedItem());
        fireIntervalRemoved(this, AutoresComboModel.FIRSTINDEX, getSize() - 1);
        setSelectedItem(listAutores.get(AutoresComboModel.FIRSTINDEX));
        return remove;
    }
     
    public void clear() {
        this.listAutores.clear();
        fireContentsChanged(this, AutoresComboModel.FIRSTINDEX, getSize() - 1);
    }
    
}
