package org.eventos.data.interfaces;

import java.util.List;

import org.eventos.infra.entities.Instituicao;

public interface InstituicaoRepository {

    public List<Instituicao> findAll();

    
}
