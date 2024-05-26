package org.eventos.domain.usecases;

import org.eventos.domain.dtos.EventoDTO;
import org.eventos.infra.entities.Evento;


public interface CreateEventoUseCase {

        Evento execute(EventoDTO eventoDto);
    
}
