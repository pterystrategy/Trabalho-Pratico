package br.com.prodrigues.trabalhopratico.view;


public abstract class AbstractCRUDSimples<T> extends ViewCliSimples 
                                             implements IViewSimpleCRUD<T> {
    @Override
    public void list(T[] object){      
        for (int i = 0; i < object.length; i++) {
            if(object[i] != null){
                System.out.println(object[i]);
            }
        }
    }   
    
    @Override
    public void read(T object){
        this.showMessage(object.toString());
    }    
}
