package br.com.prodrigues.trabalhopratico.dao.array;

import br.com.prodrigues.trabalhopratico.dao.IDAO;
import br.com.prodrigues.trabalhopratico.model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoArray implements IDAO<Cliente> {

    private final List<Cliente> banco;

    public ClienteDaoArray() {
        banco = new ArrayList<>();
//        banco.add(new Cliente(1L, "Alessio", "111.111.111-02", "aleso@email.com", "999"));
//        banco.add(new Cliente(2L, "Balbino", "222.222.222-02", "balbo@email.com", "888"));
//        banco.add(new Cliente(3L, "Carla"  , "333.333.333-02", "carla@email.com", "777"));
    }

    @Override
    public Cliente create(Cliente t) {
        banco.add(t);
        return t;
    }

    @Override
    public boolean delete(Cliente t) {
        return banco.remove(t);
    }

    @Override
    public Cliente update(Cliente t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> find(Cliente t) {
        //int indice = banco.indexOf(t);
        //return banco.get(indice);

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> findAll() {
        return banco;
    }

    @Override
    public Cliente findById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
