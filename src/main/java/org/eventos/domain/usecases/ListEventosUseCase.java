package org.eventos.domain.usecases;

import java.util.List;

import org.eventos.infra.entities.Evento;

public interface ListEventosUseCase {

    public List<Evento> execute();

}
