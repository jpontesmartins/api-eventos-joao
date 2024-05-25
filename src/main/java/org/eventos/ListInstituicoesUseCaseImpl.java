package org.eventos;

import java.util.List;

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
