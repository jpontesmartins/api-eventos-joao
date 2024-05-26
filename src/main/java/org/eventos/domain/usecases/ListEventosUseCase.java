package org.eventos.domain.usecases;

import java.util.List;

import org.eventos.domain.models.EventoModel;

public interface ListEventosUseCase {

    public List<EventoModel> execute();

}
