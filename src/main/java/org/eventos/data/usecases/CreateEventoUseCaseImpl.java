package org.eventos.data.usecases;

import org.eventos.data.interfaces.EventoRepository;
import org.eventos.data.interfaces.InstituicaoRepository;
import org.eventos.domain.dtos.EventoDTO;
import org.eventos.domain.usecases.CreateEventoUseCase;
import org.eventos.infra.entities.Evento;
import org.eventos.infra.entities.Instituicao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CreateEventoUseCaseImpl implements CreateEventoUseCase {

    @Inject
    EventoRepository repository;

    @Inject
    InstituicaoRepository instituicaoRepository;

    @Override
    public Evento execute(EventoDTO eventoDto) {

        Instituicao instituicao = instituicaoRepository.findById(eventoDto.instituicao);

        Evento evento = new Evento();
        evento.setAtivo(false);
        evento.setDataInicial(eventoDto.dataInicial);
        evento.setDataFinal(eventoDto.dataFinal);
        evento.setInstituicao(instituicao);
        evento.setNome(eventoDto.nome);

        repository.save(evento);

        return evento;

    }
    
}
