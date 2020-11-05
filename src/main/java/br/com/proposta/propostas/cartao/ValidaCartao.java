package br.com.proposta.propostas.cartao;

import br.com.proposta.propostas.entity.Proposta;
import br.com.proposta.propostas.repository.PropostaRepository;
import br.com.proposta.propostas.service.ExecutorTransacao;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class ValidaCartao {

    private final Logger log = LoggerFactory.getLogger(ValidaCartao.class);

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private ExecutorTransacao executorTransacao;

    @Autowired
    private CartaoClient cartaoClient;

    @Scheduled(fixedDelay = 10000)
    public void solicita(){
            Query query = manager.createNativeQuery("SELECT * FROM Proposta", Proposta.class);
            List<Proposta> listaProposta = query.getResultList();
            listaProposta.forEach(proposta -> {
                try {
                    if(proposta.getCartao() == null) {
                        CartaoResponse cartaoResponse = cartaoClient.getCartao(Long.toString(proposta.getId()));
                        log.info("ID Cartão: {}, ID Proposta: {} ", cartaoResponse.getId(), cartaoResponse.getIdProposta());
                        proposta.setCartao(cartaoResponse.getId());
                        executorTransacao.atualizaCartao(proposta);
                        log.info("Atualiza Proposta {} ", proposta.getCartao());

                    } else{
                    log.info(" Proposta Já Atualizada: ID Proposta: {} ", proposta.getId());}

                }catch (FeignException e){
                    log.error("Não foi possivel vincular cartão a proposta. Id: {}, Erro: {}", proposta.getId(), e.getLocalizedMessage());
                }
            });
    }
}
