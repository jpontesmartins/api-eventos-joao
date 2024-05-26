package org.eventos.data.usecases;

import java.util.ArrayList;
import java.util.List;

import org.eventos.data.interfaces.EventoRepository;
import org.eventos.domain.models.EventoModel;
import org.eventos.domain.usecases.ListEventosUseCase;
import org.eventos.infra.entities.Evento;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ListEventosUseCaseImpl implements ListEventosUseCase {

    @Inject
    EventoRepository eventoRepository;

    @Override
    public List<EventoModel> execute() {
        List<Evento> eventos = eventoRepository.findAll();
        
        List<EventoModel> eventosModel = new ArrayList<EventoModel>();
        for (Evento evento : eventos) {
            eventosModel.add(evento.toModel());
        }
        
        return eventosModel;
    }

}
