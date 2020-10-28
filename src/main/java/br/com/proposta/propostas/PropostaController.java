package br.com.proposta.propostas;

import br.com.proposta.entity.Proposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
public class PropostaController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private ValidaCpfCnpj validaCpfCnpj;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(validaCpfCnpj);
    }

    @PostMapping(path = "/novaproposta")
    @Transactional
    public ResponseEntity<?> criaProposta(@RequestBody @Valid PropostaRequest propostaRequest, UriComponentsBuilder uriComponentsBuilder){

        Proposta novaProposta= propostaRequest.toModel(manager);
        manager.persist(novaProposta);

        URI urlCriaProposta = uriComponentsBuilder.path("/novaproposta/{id}").build(novaProposta.getId());

        return ResponseEntity.created(urlCriaProposta).body(propostaRequest);
    }

}
