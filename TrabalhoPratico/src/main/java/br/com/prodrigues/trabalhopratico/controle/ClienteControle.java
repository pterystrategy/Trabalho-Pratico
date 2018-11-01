package br.com.prodrigues.trabalhopratico.controle;

import br.com.prodrigues.trabalhopratico.dao.ClienteDao;
import br.com.prodrigues.trabalhopratico.model.Cliente;
import br.com.prodrigues.trabalhopratico.modeltable.novo.ClienteTableModel;
import br.com.prodrigues.trabalhopratico.view.gui.grid.ClienteGrid;
import br.com.prodrigues.trabalhopratico.view.gui.tela.ClienteTela;
import br.com.prodrigues.trabalhopratico.view.html.ClienteHtml;
import java.awt.Desktop;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteControle extends AbstractControleSimples<Cliente> {

    protected ClienteGrid grid;
    private final ClienteTela tela;
    private final ClienteTableModel model;

    public ClienteControle() {
        this.dao = new ClienteDao();
        this.model = new ClienteTableModel(this.dao.findAll());

        //Cria CRUD
//        this.grid = ClienteGrid.getInstance(null, true, this);
        this.grid = new ClienteGrid(null, true, this, this.model);

        this.tela = ClienteTela.getInstance(null, true);
        

    }

    @Override
    public Cliente create() {
        Cliente cli = tela.create(null);
        boolean concluido = false;

        do {
            if (tela.isConfirmado() == true) {

                if (!cli.getCpf().isEmpty()) {
                    concluido = true;
                } else {
                    tela.mostrarErro("Falta CPF");
                    tela.setVisible(true);

                    cli = tela.getScreenObject();
                }
            } else {
                return null;
            }

        } while ((concluido == false) && (tela.isConfirmado() == true));
        cli = dao.create(cli);
        model.add(cli);
        return cli;

    }

    @Override
    public void read(Cliente estado) {
        //Cliente e = (Cliente)estado;
        //crud.read(e);
        List<Cliente> clientes = this.dao.findAll();
        String lista = "";
        lista = clientes.stream().map((cliente) -> cliente.getId() + "\n" + cliente.getName() + "\n" + cliente.getCpf()).reduce(lista, String::concat);
        this.tela.showMessage(lista);
    }

    @Override
    public boolean delete(Cliente objeto) {
//        long askForLong = this.tela.askForLong("Informe o ID: ");
        Cliente findById = dao.findById(objeto.getId());
        boolean delete = this.tela.delete(findById);
        if (delete) {
            this.model.remove(findById);
            return this.dao.delete(findById);
           
        }
        return false;
    }

    @Override
    public boolean filter(String column, String valor) {
        return true;
    }

    @Override
    public void showInicialScreen() {
        grid.setVisible(true);
    }

    @Override
    public Cliente update(Cliente objeto) {
        this.read(null);
        long id = tela.askForLong("Digite o código do cliente a editar");

        Cliente findById = dao.findById(id);
        tela.preparaUpdate(findById);
        Cliente update = tela.update(findById);
        return dao.update(update);
    }

    @Override
    public void print() {
        List<Cliente> lista = dao.findAll();

        String relatorioHtml = ClienteHtml.gerarRelatorio(lista, "Meu Relatório");

        //Salvar em Disco
        FileWriter arquivo;
        try {
            arquivo = new FileWriter("/home/alessiojr/file.html");
            arquivo.append(relatorioHtml);
            arquivo.close();
        } catch (IOException ex) {
            Logger.getLogger(ClienteControle.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI("file:///home/alessiojr/file.html"));
            } catch (IOException | URISyntaxException ex) {
                Logger.getLogger(ClienteControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Abrir em Browser
        //Converter em HTML

    }
}
