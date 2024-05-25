package org.eventos.infra.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e ORDER BY e.id")
public class Evento {
    @Id
    @SequenceGenerator(name = "eventoSequence", sequenceName = "evento_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue
    private Integer id;
    private String nome;
    private Date dataInicial;
    private Date dataFinal;
    private boolean ativo;

    @ManyToOne(targetEntity = Instituicao.class)
    @JoinColumn(name = "instituicao_id")
    public Instituicao instituicao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

}
