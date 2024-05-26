package org.eventos.domain.models;

import java.util.Date;

import org.eventos.domain.dtos.EventoDTO;

public class EventoModel {
    private Integer id;
    private String nome;
    private Integer instituicao;
    private Date dataInicial;
    private Date dataFinal;
    private boolean ativo;

    public EventoModel() { }

    public EventoModel(EventoDTO eventoDto) {
        this.nome = eventoDto.nome;
        this.instituicao = eventoDto.instituicao;
        this.dataInicial = eventoDto.dataInicial;
        this.dataFinal = eventoDto.dataFinal;
        this.ativo = eventoDto.ativo;
    }

    public EventoDTO toDTO() {
        EventoDTO dto = new EventoDTO();
        dto.ativo = this.ativo;
        dto.dataInicial = this.dataInicial;
        dto.dataFinal = this.dataFinal;
        dto.nome = this.nome;
        dto.instituicao = this.instituicao;
        return dto;
    }

    public boolean validate() {
        if (dataInicial == null || dataFinal == null
                || dataInicial.after(dataFinal)) {
            return false;
        }
        if (instituicao == null || instituicao == 0) {
            return false;
        }
        if (nome == null || nome.isEmpty()) {
            return false;
        }
        return true;
    }

    
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

    public Integer getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Integer instituicao) {
        this.instituicao = instituicao;
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

}