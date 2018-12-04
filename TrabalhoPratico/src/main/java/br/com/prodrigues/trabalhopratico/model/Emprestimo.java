/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author prodrigues
 */
@Entity
@Table(name = "TBEMPRESTIMO")
public class Emprestimo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDEMPRESTIMO", length = 5)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DATAEMPRESTIMO", nullable = true)
    private Date dataEmprestimo;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DATADEVOLUCAO", nullable = true)
    private Date dataDevolucao;
    
    @Column(name = "PENDENCIA", nullable = true)
    private Boolean pendencia;
    
    @Column(name = "DEVOLUCAO", nullable = true)
    private Boolean devolucao;
    
    @Column(name = "OBS", length = 500)
    private String obervacoes;
       
    @ManyToMany(mappedBy = "emprestimos", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Livro> livros;
    
    @Column(name = "OBSDEVOLUCAO", length = 225)
    private String obervacoesDevolucao;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FKRESERVA")
    private Reserva reserva;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FKCLIENTE")
    private Cliente cliente;

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
        if (!(object instanceof Emprestimo)) {
            return false;
        }
        Emprestimo other = (Emprestimo) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.trabalhopratico.prodrigues.app.model.Emprestimo[ id=" + id + " ]";
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Boolean getPendencia() {
        return pendencia;
    }

    public void setPendencia(Boolean pendencia) {
        this.pendencia = pendencia;
    }

    public Boolean getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Boolean devolucao) {
        this.devolucao = devolucao;
    }

    public String getObervacoes() {
        return obervacoes;
    }

    public void setObervacoes(String obervacoes) {
        this.obervacoes = obervacoes;
    }

    public String getObervacoesDevolucao() {
        return obervacoesDevolucao;
    }

    public void setObervacoesDevolucao(String obervacoesDevolucao) {
        this.obervacoesDevolucao = obervacoesDevolucao;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
    
}