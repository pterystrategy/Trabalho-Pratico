/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.controle;

import br.com.prodrigues.trabalhopratico.dao.TelefoneDao;
import br.com.prodrigues.trabalhopratico.model.Telefone;
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
    
    public void add(List<Telefone> telefones){
        telefones.forEach((telefone) -> {
            dao.create(telefone);
        });
        
    }
    
    public void rm(List<Telefone> telefones){
        telefones.forEach((telefone) -> {
            dao.create(telefone);
        });
    }
    
}
