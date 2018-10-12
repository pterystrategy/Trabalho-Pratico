package br.com.prodrigues.trabalhopratico.view;

import java.util.List;

public interface IViewSimpleCRUD<T> extends IView{
    
    public T    create();
    public void read(T conta);
    public T    update(T cliSalvar);
    public T    delete(T cliDeletar);

    public void list(T[] listas);
    public void list(List<T> lista);
}
