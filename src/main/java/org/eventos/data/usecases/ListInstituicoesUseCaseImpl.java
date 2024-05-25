package org.eventos.data.usecases;

import java.util.List;

import org.eventos.data.interfaces.InstituicaoRepository;
import org.eventos.domain.usecases.ListInstituicoesUseCase;
import org.eventos.infra.entities.Instituicao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ListInstituicoesUseCaseImpl implements ListInstituicoesUseCase {

    @Inject
    InstituicaoRepository repository;

    @Override
    public List<Instituicao> execute() {
        return repository.findAll();
    }
    
}
