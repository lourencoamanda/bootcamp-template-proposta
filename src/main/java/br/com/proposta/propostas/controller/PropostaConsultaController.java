package br.com.proposta.propostas.controller;

import br.com.proposta.propostas.entity.Proposta;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.net.URI;

@RestController
public class PropostaConsultaController {

    @PersistenceContext
    private EntityManager manager;

    private final Logger log = LoggerFactory.getLogger(PropostaController.class);

    @GetMapping(path="/proposta/{id}")
    public ResponseEntity<?> consultaProposta(@PathVariable("id") Long id, UriComponentsBuilder uriComponentsBuilder){

        log.info("Consulta Proposta: {}", id);

        Proposta buscaProposta = manager.find(Proposta.class, id);

        if (buscaProposta == null){
            log.info("Propoposta não encontrada nas bases de dados: ID: {}", id);
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Id Proposta não encontrado nas bases de dados");
        }

        URI urlConsultaProposta = uriComponentsBuilder.path("/proposta/{id}").build(buscaProposta.getId());
        log.info("URL Api: {}", urlConsultaProposta);

        log.info("Consulta Efetuada com sucesso!");
        log.info("Dados da Proposta: ID:{}, CPF/CNPJ: {}, Status Proposta: {}, Nome: {}", buscaProposta.getId(), buscaProposta.getCpfCnpj(), buscaProposta.getStatusAvaliacaoProposta(), buscaProposta.getNome());
        return ResponseEntity.created(urlConsultaProposta).body(buscaProposta);
    }

}
