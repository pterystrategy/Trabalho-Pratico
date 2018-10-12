package br.com.prodrigues.trabalhopratico.view;

import java.util.Scanner;

public class ViewCliSimples implements IView{
    protected final Scanner entrada; 

    public ViewCliSimples() {
        entrada = new Scanner(System.in);
    }

    public Scanner getScanner() {
        return entrada;
    }
 
    @Override
    public void showMessage(String msg){
        System.out.println(msg);
    }
    
    @Override
    public int askForInt(String question) {
        showMessage(question);
        int inteiro = entrada.nextInt();
        return inteiro;
                
    }
    
    @Override
    public double askForDouble(String question) {
        showMessage(question);
        double d = entrada.nextDouble();
        return d;
                
    }

    @Override
    public String askForString(String question) {
        showMessage(question);
        String resposta = entrada.next();
        return resposta;
                
    }

    @Override
    public void showErrorMessage(String msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long askForLong(String question) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
