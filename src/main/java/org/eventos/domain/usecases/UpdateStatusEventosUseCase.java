package org.eventos.domain.usecases;

import java.time.ZonedDateTime;
import java.util.List;

import org.eventos.infra.entities.Evento;

public interface UpdateStatusEventosUseCase {

    List<Evento> execute(ZonedDateTime horarioExecucao);
    
}
