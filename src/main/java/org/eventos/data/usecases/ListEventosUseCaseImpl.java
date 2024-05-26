package org.eventos.data.usecases;

import java.util.List;

import org.eventos.domain.usecases.ListEventosUseCase;
import org.eventos.infra.entities.Evento;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class ListEventosUseCaseImpl implements ListEventosUseCase {

    @Inject
    EntityManager entityManager;

    @Override
    public List<Evento> execute() {
        List<Evento> eventos = entityManager.createNamedQuery("Evento.findAll", Evento.class)
                .getResultList();
        return eventos;
    }

}
