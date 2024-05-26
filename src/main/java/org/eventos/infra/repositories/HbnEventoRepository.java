package org.eventos.infra.repositories;

import java.util.Date;
import java.util.List;

import org.eventos.data.interfaces.EventoRepository;
import org.eventos.infra.entities.Evento;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class HbnEventoRepository implements EventoRepository {
    
    @Inject
    EntityManager entityManager;
    
    @Transactional
    @Override
    public List<Evento> findAll() {
        List<Evento> eventos = entityManager.createNamedQuery("Evento.findAll", Evento.class)
            .getResultList();
        return eventos;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Evento> findBetweenDataInicialAndDataFinal() {
        System.out.println("Eventos com o dia de hoje dentro do período vigente");
        String query = " SELECT e FROM Evento e WHERE :hoje BETWEEN e.dataInicial AND e.dataFinal ";
        List<Evento> eventos = entityManager.createQuery(query).setParameter("hoje", new Date()).getResultList();
        return eventos;
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<Evento> findOutsideRangeDataInicialAndDataFinal() {
        String query = " SELECT e FROM Evento e WHERE :hoje NOT BETWEEN e.dataInicial AND e.dataFinal ";
        List<Evento> eventos = entityManager.createQuery(query).setParameter("hoje", new Date()).getResultList();
        return eventos;
    }

    @Transactional
    @Override
    public void update(Evento evento) {
        this.entityManager.merge(evento);
    }
    
}
