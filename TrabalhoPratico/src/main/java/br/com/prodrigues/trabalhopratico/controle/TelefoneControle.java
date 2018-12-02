/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.controle;

import br.com.prodrigues.trabalhopratico.dao.TelefoneDao;
import br.com.prodrigues.trabalhopratico.model.Telefone;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pedro
 */
public class TelefoneControle {
    
    
    private final TelefoneDao dao;
    
    public TelefoneControle() {
        this.dao = new TelefoneDao();
    }
    
    public List<Telefone> add(List<Telefone> telefones){
        List<Telefone> l = new ArrayList<>();
        telefones.forEach((telefone) -> {
            l.add(dao.create(telefone));
        });
        return l;
    }
    
    public void rm(List<Telefone> telefones){
        telefones.forEach((telefone) -> {
            dao.create(telefone);
        });
    }
    
}
