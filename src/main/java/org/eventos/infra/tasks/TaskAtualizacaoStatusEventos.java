package org.eventos.infra.tasks;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.eventos.domain.usecases.UpdateStatusEventosUseCase;

import io.quarkus.scheduler.Scheduled;
import io.quarkus.scheduler.ScheduledExecution;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TaskAtualizacaoStatusEventos {

    @Inject
    UpdateStatusEventosUseCase updateStatusEventosUseCase;
    
    @Scheduled(cron="{cron.expr}")
    void cronJob(ScheduledExecution execution) {
        ZonedDateTime horario = execution.getScheduledFireTime().atZone(ZoneId.systemDefault());
        execute(horario);
    }

    public void execute(ZonedDateTime horario) {
        updateStatusEventosUseCase.execute(horario);
    }


}
