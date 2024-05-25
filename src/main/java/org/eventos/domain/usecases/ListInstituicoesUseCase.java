package org.eventos.domain.usecases;

import java.util.List;

import org.eventos.infra.entities.Instituicao;

public interface ListInstituicoesUseCase {

    List<Instituicao> execute();
    
}
