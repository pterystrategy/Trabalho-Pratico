/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.model.antigo;

import br.com.prodrigues.trabalhopratico.model.Emprestimo;
import br.com.prodrigues.trabalhopratico.model.Livro;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author prorodrigues
 */
@Entity
@Table(name = "TB_EXEMPLAR")
public class Exemplar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDEXEMPLAR", nullable = false)
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FKLIVRO")
    private Livro livro;
    
//    @Column(name = "QTD", length = 3, nullable = false)
//    private int quantidade;
//    
//    @ManyToMany(cascade = {
//        CascadeType.PERSIST,CascadeType.PERSIST,
//        CascadeType.REMOVE})
//    @JoinTable(name = "TB_EXEMPLAR_EMPRESTIMO",
//        joinColumns = @JoinColumn(name = "FKEXEMPLAR"),
//        inverseJoinColumns = @JoinColumn(name = "FKEMPRESTIMO")
//    )
//    private List<Emprestimo> emprestimos;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exemplar)) {
            return false;
        }
        Exemplar other = (Exemplar) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "br.com.prodrigues.trabalhopratico.model.Exemplar[ id=" + id + " ]";
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

//    public int getQuantidade() {
//        return quantidade;
//    }
//
//    public void setQuantidade(int quantidade) {
//        this.quantidade = quantidade;
//    }
//
//    public List<Emprestimo> getEmprestimos() {
//        return emprestimos;
//    }
//
//    public void setEmprestimos(List<Emprestimo> emprestimos) {
//        this.emprestimos = emprestimos;
//    }
    
}
