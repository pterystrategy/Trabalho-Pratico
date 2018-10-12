/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.modelcombo;

import br.com.prodrigues.trabalhopratico.model.Classificacao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author prorodrigues
 */
public final class ClassificacoesComboModel extends AbstractListModel<Classificacao> implements ComboBoxModel<Classificacao>{
    
        
    private final List<Classificacao> listClassificacoes;
    private Classificacao selectedClassificacao;
    private final static int FIRSTINDEX = 0;

    public ClassificacoesComboModel(List<Classificacao> listClassificacoes) {
        this();
        boolean addAll;
        addAll = this.listClassificacoes.addAll(listClassificacoes);
        if (getSize() > 0) {
            setSelectedItem(this.listClassificacoes.get(FIRSTINDEX));
        }
    }

    public ClassificacoesComboModel() {
        this.listClassificacoes = new 
        ArrayList<>(Arrays.asList(Classificacao.values()));
    }
    

    @Override
    public int getSize() {
        return listClassificacoes.size();  
        }

    @Override
    public Classificacao getElementAt(int index) {
        return listClassificacoes.get(index);
    }
   

    @Override
    public Classificacao getSelectedItem() {
        return selectedClassificacao;    
    }
    
    
     public void addClassificacao( Classificacao classificacao) {
        listClassificacoes.add(classificacao);
        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        setSelectedItem(listClassificacoes.get(getSize() - 1));
    }
     
    public void addListClassificacao(List<Classificacao> classificacacoes) {
        int primeiraLinha = getSize();
        listClassificacoes.addAll(classificacacoes);
        fireIntervalAdded(this, primeiraLinha, primeiraLinha  + classificacacoes.size());
        setSelectedItem(classificacacoes.get(getSize() - 1));
    }
     
    public void removeClassificacao() {
        boolean remove = listClassificacoes.remove(getSelectedItem());
        fireIntervalRemoved(this, FIRSTINDEX, getSize() - 1);
        setSelectedItem(listClassificacoes.get(FIRSTINDEX));
    }
     
    public void clear() {
        listClassificacoes.clear();
        fireContentsChanged(this, FIRSTINDEX, getSize() - 1);
    }

    @Override
    public void setSelectedItem(Object o) {
        selectedClassificacao = (Classificacao) o;
    }
}
