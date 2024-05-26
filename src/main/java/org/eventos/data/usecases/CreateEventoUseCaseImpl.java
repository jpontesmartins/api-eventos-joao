package org.eventos.data.usecases;

import org.eventos.data.interfaces.EventoRepository;
import org.eventos.data.interfaces.InstituicaoRepository;
import org.eventos.domain.models.EventoModel;
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
    public EventoModel execute(EventoModel eventoModel) {

        Instituicao instituicao = instituicaoRepository.findById(eventoModel.getInstituicao());

        Evento evento = new Evento();
        evento.setAtivo(false);
        evento.setDataInicial(eventoModel.getDataInicial());
        evento.setDataFinal(eventoModel.getDataFinal());
        evento.setInstituicao(instituicao);
        evento.setNome(eventoModel.getNome());
        
        repository.save(evento);

        EventoModel modelRetorno = evento.toModel();
        return modelRetorno;

    }
    
}
