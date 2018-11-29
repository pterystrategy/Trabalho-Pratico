/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.model.validações;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Frederico
 */
public class LimiteDigitosNumeros extends PlainDocument{
    private int quantidadeMax;
    public LimiteDigitosNumeros(int maxLen){
        super();
        if(maxLen<=0){
            throw new IllegalArgumentException("Especifique a quantidade");
        }
        quantidadeMax = maxLen;
    }
    
    @Override
    public void insertString(int offSet, String str, AttributeSet attr) throws BadLocationException{
        if(str == null || getLength() == quantidadeMax){
            return;
        }
        int totalQuantia = (getLength()+str.length());
        if(totalQuantia <= quantidadeMax){
            super.insertString(offSet, str.replaceAll("[^0-9]"," "), attr);
            return;
        }
        String nova = str.substring(0, getLength()-quantidadeMax);
        super.insertString(offSet, nova, attr);
    }

   
}
