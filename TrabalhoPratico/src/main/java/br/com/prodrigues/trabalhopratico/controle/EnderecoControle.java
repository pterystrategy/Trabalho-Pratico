/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.controle;

import br.com.prodrigues.trabalhopratico.dao.EnderecoDao;
import br.com.prodrigues.trabalhopratico.model.Endereco;

/**
 *
 * @author pedro
 */
public class EnderecoControle {
    
    private final EnderecoDao dao;
    
    public EnderecoControle() {
        this.dao = new EnderecoDao();
    }
    
    public void add(Endereco endereco){
        dao.create(endereco);
    }
    
    public void rm(Endereco endereco){
        dao.delete(endereco);
    }
}
