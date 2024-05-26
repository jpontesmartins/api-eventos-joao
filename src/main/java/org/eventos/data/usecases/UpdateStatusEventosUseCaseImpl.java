package org.eventos.data.usecases;

import java.time.ZonedDateTime;
import java.util.List;

import org.eventos.data.interfaces.EventoRepository;
import org.eventos.domain.usecases.UpdateStatusEventosUseCase;
import org.eventos.infra.entities.Evento;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UpdateStatusEventosUseCaseImpl implements UpdateStatusEventosUseCase {

    @Inject
    EventoRepository repository;

    @Override
    public void execute(ZonedDateTime horarioExecucao) {
        List<Evento> eventosAtivar = this.repository.findBetweenDataInicialAndDataFinal();
        for (Evento evento : eventosAtivar) {
            evento.setAtivo(true);
            this.repository.update(evento);
        }

        List<Evento> eventosInativar = this.repository.findOutsideRangeDataInicialAndDataFinal();
        for (Evento evento : eventosInativar) {
            evento.setAtivo(false);
            this.repository.update(evento);
        }
        System.out.println("[UpdateStatusEventosUseCase] " + horarioExecucao);
    }    
    
}
