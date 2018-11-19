package br.com.prodrigues.trabalhopratico.controle;

//import br.com.prodrigues.trabalhopratico.dao.gerarDados.auto.AutoDado;
import br.com.prodrigues.trabalhopratico.view.gui.TelaPrincipal;

public class PrincipalControle {

    private TelaPrincipal tela;
    private final ClienteControle cliControle;
    //private ContaControle contaControle;

    private final UsuarioControle usuarioControle;

    private final AutorControle autorControle;

    private final LivroControle livroControle;

    private final EditoraControle editoraControle;
    
    private final EmprestimoControle emprestimoControle;

    public PrincipalControle() {

        this.autorControle = new AutorControle();
        this.cliControle = new ClienteControle();
        this.usuarioControle = new UsuarioControle();
        this.editoraControle = new EditoraControle();
        this.livroControle = new LivroControle(this.autorControle, this.editoraControle);
        
        this.emprestimoControle = new EmprestimoControle(cliControle, livroControle);
        
    }

    public void iniciaClienteControle() {
        cliControle.showInicialScreen();
    }

    public void iniciar() {
//        AutoDado ad = new AutoDado();
        
        if (usuarioControle.showInicialLogin()) {
//            ad.Autores();
            tela = TelaPrincipal.getInstance(this);
            tela.setVisible(true); 
        }else
            System.exit(0);
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
    
     public void iniciaEmprestimoControle() {
        this.emprestimoControle.showInicialScreen();
    }
}
