package br.com.proposta.propostas.cartao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartaoConsulta {

    private final Logger log = LoggerFactory.getLogger(CartaoConsulta.class);

    @Autowired
    private CartaoClient cartaoService;

    public CartaoResponse getCartao(String id) {
            log.info("Consulta cartão(cartao consulta): {} {}", getCartao(id), cartaoService);
            return cartaoService.getCartao(id);

    }

}
