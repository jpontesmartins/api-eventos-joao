package org.eventos.domain.usecases;

import java.time.ZonedDateTime;

public interface UpdateStatusEventosUseCase {

    void execute(ZonedDateTime horarioExecucao);
    
}
