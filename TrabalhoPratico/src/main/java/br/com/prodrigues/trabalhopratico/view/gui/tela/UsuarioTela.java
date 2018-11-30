package br.com.prodrigues.trabalhopratico.view.gui.tela;

import br.com.prodrigues.trabalhopratico.model.Usuario;
import br.com.prodrigues.trabalhopratico.model.validações.LimiteDigitosLetras;
import br.com.prodrigues.trabalhopratico.model.validações.LimiteDigitosLetrasNumeros;
import br.com.prodrigues.trabalhopratico.view.IViewCrud;
import br.com.prodrigues.trabalhopratico.view.gui.ViewGuiSimples;
import java.awt.Frame;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author prorodrigues
 */
public class UsuarioTela extends ViewGuiSimples implements IViewCrud<Usuario> {

    public static UsuarioTela getTela() {
        return tela;
    }

    public static void setTela(UsuarioTela aTela) {
        tela = aTela;
    }

    public static UsuarioTela getInstance(Frame parent, boolean modal) {
        if (tela == null) {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
             * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
             */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(UsuarioTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
            //</editor-fold>
            return new UsuarioTela(parent, modal);
        } else {
            return tela;
        }
    }

    /**
     * Creates new form UsuarioTela
     *
     * @param parent
     * @param modal
     */
    public UsuarioTela(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        edtNome.setDocument(new LimiteDigitosLetras(20));
        edtLogin.setDocument(new LimiteDigitosLetrasNumeros(15));
        edtSenha.setDocument(new LimiteDigitosLetrasNumeros(15));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panRodape = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        panPrincipal = new javax.swing.JPanel();
        labNome = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        labLogin = new javax.swing.JLabel();
        labSenha = new javax.swing.JLabel();
        edtLogin = new javax.swing.JTextField();
        labSenhaConfirmacao = new javax.swing.JLabel();
        edtSenha = new javax.swing.JPasswordField();
        edtSenhaConfirmacao = new javax.swing.JPasswordField();
        labTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuario Tela");

        panRodape.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panRodapeLayout = new javax.swing.GroupLayout(panRodape);
        panRodape.setLayout(panRodapeLayout);
        panRodapeLayout.setHorizontalGroup(
            panRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panRodapeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panRodapeLayout.setVerticalGroup(
            panRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panRodapeLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(panRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnOk))
                .addGap(20, 20, 20))
        );

        panPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labNome.setText("Nome:");

        labLogin.setText("Login*");

        labSenha.setText("Senha*");

        edtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtLoginActionPerformed(evt);
            }
        });

        labSenhaConfirmacao.setText("Confirmação de senha*");

        edtSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edtSenhaMouseClicked(evt);
            }
        });
        edtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtSenhaActionPerformed(evt);
            }
        });

        edtSenhaConfirmacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtSenhaConfirmacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panPrincipalLayout = new javax.swing.GroupLayout(panPrincipal);
        panPrincipal.setLayout(panPrincipalLayout);
        panPrincipalLayout.setHorizontalGroup(
            panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labLogin)
                            .addComponent(labSenha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edtSenha)
                            .addComponent(edtLogin)))
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(labNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtNome))
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addComponent(labSenhaConfirmacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtSenhaConfirmacao, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panPrincipalLayout.setVerticalGroup(
            panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labNome))
                .addGap(10, 10, 10)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labLogin)
                    .addComponent(edtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labSenha)
                    .addComponent(edtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labSenhaConfirmacao)
                    .addComponent(edtSenhaConfirmacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        labTitulo.setFont(new java.awt.Font("Nimbus Mono L", 1, 18)); // NOI18N
        labTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTitulo.setText("Titulo");
        labTitulo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(labTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.setConfirmado(false);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        
        String senha = edtSenha.getText();
        String confSenha = edtSenhaConfirmacao.getText();
        
        if (edtNome.getText().trim().isEmpty() ||
            edtLogin.getText().trim().isEmpty() ||    
            edtSenha.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campo vazio");
        }
        else if (edtNome.getText().length() < 3) {
            this.showErrorMessage("O Nome deve conter no mínimo 3 caracteres!");
        }
        else if (edtLogin.getText().length() < 4) {
            this.showErrorMessage("Login deve conter no mínimo 4 caracteres!");
        }
        else if (edtSenha.getText().length() < 6) {
            this.showErrorMessage("A Senha deve conter no mínimo 6 caracteres!");
        }
        else if (senha.equals(confSenha) == false) {
            this.showMessage("Senha não confere!");
        }
        else {
            this.setConfirmado(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void edtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtLoginActionPerformed

    private void edtSenhaConfirmacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtSenhaConfirmacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtSenhaConfirmacaoActionPerformed

    private void edtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtSenhaActionPerformed

    private void edtSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edtSenhaMouseClicked
        this.mostrarSenha(evt);
    }//GEN-LAST:event_edtSenhaMouseClicked
    private static UsuarioTela tela;
    private boolean confirmado = false;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOk;
    private javax.swing.JTextField edtLogin;
    private javax.swing.JTextField edtNome;
    private javax.swing.JPasswordField edtSenha;
    private javax.swing.JPasswordField edtSenhaConfirmacao;
    private javax.swing.JLabel labLogin;
    private javax.swing.JLabel labNome;
    private javax.swing.JLabel labSenha;
    private javax.swing.JLabel labSenhaConfirmacao;
    private javax.swing.JLabel labTitulo;
    private javax.swing.JPanel panPrincipal;
    private javax.swing.JPanel panRodape;
    // End of variables declaration//GEN-END:variables

    @Override
    public Usuario create(Usuario user) {
        user = null;
        this.limpaTela();
        this.preparaCreate();
        this.setVisible(true);

        if (confirmado) {
            user = this.getScreenObject();
        }
        else{
            showMessage("CANCELADO PELO USUÁRIO!");    
        }
        
        return user;

    }

    @Override
    public void read(Usuario object) {
        this.preparaMostrar(object);
        this.setVisible(true);
    }

    @Override
    public Usuario update(Usuario object) {
        this.limpaTela();
        this.preparaUpdate(object);
        this.setVisible(true);
        if (confirmado) {
            object.setName(edtNome.getText());
            object.setLogin(edtLogin.getText());
            object.setSenha(edtSenha.getText());
        } else if (confirmado == false) {
            showMessage("CANCELADO PELO USUÁRIO!");
        } else if (object == null) {
            showMessage("NÃO ENCONTRADO!");
        } else {
            showMessage("ALTERADO COM SUCESSO!");
        }
        return object;
    }

    @Override
    public boolean delete(Usuario object) {
        preparaDelete(object);

        this.setVisible(true);

       if (confirmado) {
           return true;
         } else if (!confirmado) {
            showMessage("CANCELADO PELO USUÁRIO!");
            return false;
        } else if (object == null) {
            showMessage("NÃO ENCONTRADO!");
            return false;
        }
        return true;
    }

    @Override
    public Usuario getScreenObject() {
        Usuario retorno = new Usuario();
        retorno.setName(edtNome.getText());
        retorno.setLogin(edtLogin.getText());
        retorno.setSenha(edtSenha.getText());
        return retorno;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    @Override
    public void limpaTela() {
        edtNome.setText("");
        edtLogin.setText("");
        edtSenha.setText("");
        edtSenhaConfirmacao.setText("");
    }

    @Override
    public void preparaUpdate(Usuario object) {
        labTitulo.setText("Dados do Usuario");

        edtNome.setText(object.getName());
        edtNome.setEditable(true);
        edtNome.setEnabled(true);

        edtLogin.setText(object.getLogin());
        edtLogin.setEditable(true);
        edtLogin.setEnabled(true);
        
        edtSenha.setText(object.getSenha());
        edtSenha.setEditable(true);
        edtSenha.setEnabled(true);
        
        
        edtSenhaConfirmacao.setText(object.getSenha());
        labSenhaConfirmacao.setVisible(true);
        edtSenhaConfirmacao.setVisible(true);
        edtSenhaConfirmacao.setEditable(true);
        edtSenhaConfirmacao.setEnabled(true);
        btnOk.setText("Update");
        btnOk.setVisible(true);
        btnCancel.setVisible(true);
    }
    
     private void preparaMostrar(Usuario object){
         labTitulo.setText("Dados do Usuario");

        edtNome.setText(object.getName());
        edtNome.setEditable(false);
        edtNome.setEnabled(false);

        edtLogin.setText(object.getLogin());
        edtLogin.setEditable(false);
        edtLogin.setEnabled(false);
        
        edtSenha.setText(object.getSenha());
        edtSenha.setEditable(false);
        edtSenha.setEnabled(false);
        
        edtSenhaConfirmacao.setText(object.getSenha());
        labSenhaConfirmacao.setVisible(false);
        edtSenhaConfirmacao.setVisible(false);
        
        btnOk.setText("Ok");
        btnOk.setVisible(true);
        
        btnCancel.setVisible(false);
        
     } 
     
     private void preparaCreate(){
        labTitulo.setText("Cadastro de Usuario");
        edtNome.setText("");
        edtNome.setEditable(true);
        edtNome.setEnabled(true);

        edtLogin.setText("");
        edtLogin.setEditable(true);
        edtLogin.setEnabled(true);

        edtSenha.setText("");
        edtSenha.setEditable(true);
        edtSenha.setEnabled(true);
        

        edtSenhaConfirmacao.setText("");
        labSenhaConfirmacao.setVisible(true);
        edtSenhaConfirmacao.setVisible(true);
        edtSenhaConfirmacao.setEditable(true);
        edtSenhaConfirmacao.setEnabled(true);
        btnOk.setText("Salvar");
        btnOk.setVisible(true);
        btnCancel.setVisible(true);
     }
     
     private void preparaDelete(Usuario object){
        labTitulo.setText("Dados do Usuario");

        edtNome.setText(object.getName());
        edtNome.setEditable(false);
        edtNome.setEnabled(false);

        edtLogin.setText(object.getLogin());
        edtLogin.setEditable(false);
        edtLogin.setEnabled(false);

        edtSenha.setText(object.getSenha());
        edtSenha.setEditable(false);
        edtSenha.setEnabled(false);

        edtSenhaConfirmacao.setText(object.getSenha());
        labSenhaConfirmacao.setVisible(true);
        edtSenhaConfirmacao.setVisible(true);
        edtSenhaConfirmacao.setEditable(false);
        edtSenhaConfirmacao.setEnabled(false);
        
//        edtNome.setText(object.getName());
//        edtNome.setEditable(false);
//        edtNome.setEnabled(false);
        
        btnOk.setText("Deletar");
        btnOk.setVisible(true);
        btnCancel.setVisible(true);
        
     }

    private void mostrarSenha(java.awt.event.MouseEvent evt) {
        if(evt.getClickCount() == 2){
           edtSenha.setEchoChar((char) 0);
       }else{
           edtSenha.setEchoChar('*');
       }
    }
}
