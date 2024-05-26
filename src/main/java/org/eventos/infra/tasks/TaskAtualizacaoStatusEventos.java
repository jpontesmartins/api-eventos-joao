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
    
    @Scheduled(cron="{cron.expr}") // 17:44 todos os dias
    void cronJob(ScheduledExecution execution) {
        ZonedDateTime horario = execution.getScheduledFireTime().atZone(ZoneId.systemDefault());
        execute(horario);
    }

    public void execute(ZonedDateTime horario) {

        updateStatusEventosUseCase.execute(horario);
        // // TODO: chamar a UseCase de "AtualizacaoStatusEventosUseCase"
        // System.out.println("[TaskAtualizacaoStatusEventos] inicio ");
        // System.out.println(horario);
        // System.out.println("::: 1. Listar os eventos");
        // System.out.println("::: 2. Para cada evento ");
        // System.out.println("::: 3.1. Se a DATA DE HOJE está entre a data de INICIAL e FINAL do evento");
        // System.out.println("::: 3.1.    Setar para ATIVO");
        // System.out.println("::: 3.1. Senão ");
        // System.out.println("::: 3.1.    Setar INATIVO ");
        // System.out.println("[TaskAtualizacaoStatusEventos] fim ");
    }



}
