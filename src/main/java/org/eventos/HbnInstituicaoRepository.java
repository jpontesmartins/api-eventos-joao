package org.eventos;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class HbnInstituicaoRepository implements InstituicaoRepository {
    
    @Inject
    EntityManager entityManager;
    
    @Transactional
    @Override
    public List<Instituicao> findAll() {
        List<Instituicao> instituicoes = entityManager.createNamedQuery("Instituicao.findAll", Instituicao.class)
            .getResultList();
        return instituicoes;
    }
    
}