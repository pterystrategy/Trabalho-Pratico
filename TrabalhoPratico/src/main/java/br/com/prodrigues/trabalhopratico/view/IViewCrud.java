package br.com.prodrigues.trabalhopratico.view;

public interface IViewCrud<T>{

    public  T create(T object);
    public  void read(T object);
    public  T update(T object);    
    public boolean delete(T object);

    public  T getScreenObject();
    
    public void limpaTela();
    
    public void preparaUpdate(T object);
}

