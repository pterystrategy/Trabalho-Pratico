package br.com.prodrigues.trabalhopratico.controle;

import br.com.prodrigues.trabalhopratico.view.gui.TelaPrincipal;

public class PrincipalControle {

    private TelaPrincipal tela;
    private final ClienteControle cliControle;
    //private ContaControle contaControle;

    private final UsuarioControle usuarioControle;

    private final AutorControle autorControle;

    private final LivroControle livroControle;

    private final EditoraControle editoraControle;

    public PrincipalControle() {

        this.autorControle = new AutorControle();
        this.cliControle = new ClienteControle();
        this.usuarioControle = new UsuarioControle();
        this.editoraControle = new EditoraControle();
        this.livroControle = new LivroControle(this.autorControle, this.editoraControle);

    }

    public void iniciaClienteControle() {
        cliControle.showInicialScreen();
    }

    public void iniciar() {
        this.usuarioControle.showInicialLogin();
        tela = TelaPrincipal.getInstance(this);
        tela.setVisible(true);
    }

//    public void iniciaContaControle() {
//        contaControle.showInicialScreen();
//    }
    public void iniciaUsuarioControle() {
        this.usuarioControle.showInicialScreen();
    }

    public void iniciaAutorControle() {
        this.autorControle.showInicialScreen();
    }

    public void iniciaLivroControle() {
        this.livroControle.showInicialScreen();
    }

    public void iniciaEditoraControle() {
        this.editoraControle.showInicialScreen();
    }
}
