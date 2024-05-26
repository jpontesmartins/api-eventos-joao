package org.eventos.data.interfaces;

import java.util.List;

import org.eventos.infra.entities.Evento;

public interface EventoRepository {

    public List<Evento> findAll();

    public List<Evento> findBetweenDataInicialAndDataFinal();

    public List<Evento> findOutsideRangeDataInicialAndDataFinal();

    public void update(Evento evento);
    
}
