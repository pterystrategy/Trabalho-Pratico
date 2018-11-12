/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.modelcombo;

import br.com.prodrigues.trabalhopratico.model.Livro;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author prorodrigues
 */
public final class LivrosComboModel  extends AbstractListModel<Livro> implements ComboBoxModel<Livro>{
    
    
    private final List<Livro> listLivros;
    private Livro selectedLivro;
    private final static int FIRSTINDEX = 0;

    public LivrosComboModel(List<Livro> listLivros) {
        this();
        this.listLivros.addAll(listLivros);
        if (this.getSize() > 0) {
            setSelectedItem(this.listLivros.get(LivrosComboModel.FIRSTINDEX));
        }
    }

    public LivrosComboModel() {
        this.listLivros = new ArrayList<>();
    }
    

    @Override
    public int getSize() {
        return this.listLivros.size();  
        }

    @Override
    public Livro getElementAt(int index) {
        return this.listLivros.get(index);
    }

    @Override
    public void setSelectedItem(Object o) {
        this.selectedLivro = (Livro) o;
    }

    @Override
    public Object getSelectedItem() {
        return this.selectedLivro;    
    }
    
    
     public void addLivro(Livro livro) {
        this.listLivros.add(livro);
        fireIntervalAdded(this, this.getSize() - 1, this.getSize() - 1);
        setSelectedItem(this.listLivros.get(this.getSize() - 1));
    }
     
    public void addListLivro(List<Livro> livros) {
        int primeiraLinha = getSize();
        listLivros.addAll(livros);
        fireIntervalAdded(this, primeiraLinha, primeiraLinha  + livros.size());
        setSelectedItem(this.listLivros.get(getSize() - 1));
    }
     
    public boolean removeLivro() {
        boolean remove;
        remove = listLivros.remove((Livro) getSelectedItem());
        fireIntervalRemoved(this, LivrosComboModel.FIRSTINDEX, getSize() - 1);
        setSelectedItem(listLivros.get(LivrosComboModel.FIRSTINDEX));
        return remove;
    }
     
    public void clear() {
        this.listLivros.clear();
        fireContentsChanged(this, LivrosComboModel.FIRSTINDEX, getSize() - 1);
    }   
}