package org.eventos;

import java.time.ZoneId;

import io.quarkus.scheduler.Scheduled;
import io.quarkus.scheduler.ScheduledExecution;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TaskAtualizacaoStatusEventos {
    
    @Scheduled(cron="{cron.expr}") // 17:44 todos os dias
    void cronJob(ScheduledExecution execution) {

        // TODO: chamar a UseCase de "AtualizacaoStatusEventosUseCase"
        System.out.println("[TaskAtualizacaoStatusEventos] inicio ");
        System.out.println(execution.getScheduledFireTime().atZone(ZoneId.systemDefault()));
        System.out.println("[TaskAtualizacaoStatusEventos] fim ");
    }



}
