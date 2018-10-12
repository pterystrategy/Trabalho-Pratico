package br.com.prodrigues.trabalhopratico.view;

public interface IView {
    public void showMessage(String msg);
    public void showErrorMessage(String msg);
    
    public int askForInt(String question);
    public double askForDouble(String question);
    public String askForString(String question);
    public long askForLong(String question);
}
