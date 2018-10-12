package br.com.prodrigues.trabalhopratico.modelcombo;
 
import br.com.prodrigues.trabalhopratico.model.Cliente;
import java.util.ArrayList;
import java.util.List;
 
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
 
public final class ClientesComboModel extends AbstractListModel<Cliente> implements ComboBoxModel<Cliente> {
 
    private List<Cliente> listCliente;
    private Cliente selectedCliente;
    private final static int FIRSTINDEX = 0;
 
    public ClientesComboModel() {
        this.listCliente = new ArrayList<>();
    }
     
    public ClientesComboModel(List<Cliente> listCliente) {
        this();
        this.listCliente.addAll(listCliente);
        if (getSize() > 0) {
            setSelectedItem(this.listCliente.get(FIRSTINDEX));
        }
    }
     
    @Override
    public Cliente getElementAt(int index) {
        return listCliente.get(index);
    }
 
    @Override
    public int getSize() {
        return listCliente.size();
    }
 
    @Override
    public Object getSelectedItem() {
        return selectedCliente;
    }
 
    @Override
    public void setSelectedItem(Object anItem) {
        selectedCliente = (Cliente) anItem;
    }
     
    public void addCliente(Cliente cliente) {
        listCliente.add(cliente);
        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        setSelectedItem(listCliente.get(getSize() - 1));
    }
     
    public void addListCliente(List<Cliente> clientes) {
        int primeiraLinha = getSize();
        listCliente.addAll(clientes);
        fireIntervalAdded(this, primeiraLinha, primeiraLinha  + clientes.size());
        setSelectedItem(listCliente.get(getSize() - 1));
    }
     
    public void removeCliente() {
        boolean remove;
        remove = listCliente.remove((Cliente) this.getSelectedItem());
        fireIntervalRemoved(this, FIRSTINDEX, getSize() - 1);
        setSelectedItem(listCliente.get(FIRSTINDEX));
    }
     
    public void clear() {
        listCliente.clear();
        fireContentsChanged(this, FIRSTINDEX, getSize() - 1);
    }
}
