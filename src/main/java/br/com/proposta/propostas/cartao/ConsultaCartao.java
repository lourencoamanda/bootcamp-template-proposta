package br.com.proposta.propostas.cartao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaCartao {

    //@Autowired
    //private CartaoConsulta cartaoConsulta;

    @Autowired
    private CartaoClient cartaoService;

    private final Logger log = LoggerFactory.getLogger(ConsultaCartao.class);

    //public void ConsultaCartao(@PathVariable String idProposta){
      //  log.info("Consulta cartão: {}", idProposta);
        //cartaoConsulta.getCartao(idProposta);
    }




