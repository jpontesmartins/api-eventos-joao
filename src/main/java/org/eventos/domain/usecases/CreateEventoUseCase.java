package org.eventos.domain.usecases;

import org.eventos.domain.models.EventoModel;


public interface CreateEventoUseCase {

        EventoModel execute(EventoModel evento);
    
}
