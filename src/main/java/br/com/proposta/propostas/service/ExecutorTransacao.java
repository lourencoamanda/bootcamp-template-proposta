package br.com.proposta.propostas.service;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class ExecutorTransacao {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    public <T> T criaProposta(T novaProposta){
        manager.persist(novaProposta);
        return (novaProposta);
    }

    @Transactional
    public <T> T atualizaStatus(T novaProposta){
       return manager.merge(novaProposta);
    }

    @Transactional
    public <T> T atualizaCartao(T novaProposta){
        return manager.merge(novaProposta);}

    @Transactional
    public <T> T criaCartao(T novoCartao){
        manager.persist(novoCartao);
        return (novoCartao);
    }

}
