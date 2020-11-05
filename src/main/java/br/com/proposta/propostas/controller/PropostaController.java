package br.com.proposta.propostas.controller;

import br.com.proposta.propostas.entity.Proposta;
import br.com.proposta.propostas.repository.PropostaRepository;
import br.com.proposta.propostas.service.ExecutorTransacao;
import br.com.proposta.propostas.service.PropostaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class PropostaController {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private PropostaService propostaService;

    @Autowired
    private ValidaCpfCnpj validaCpfCnpj;

    @Autowired
    private ExecutorTransacao executorTransacao;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(validaCpfCnpj);
    }

    private final Logger log = LoggerFactory.getLogger(PropostaController.class);

    @PostMapping(path = "/novaproposta")
    @Transactional
    public ResponseEntity<?> criaProposta(@RequestBody @Valid PropostaRequest propostaRequest, UriComponentsBuilder uriComponentsBuilder){

        if (propostaRepository.findByCpfCnpj(propostaRequest.getCpfCnpj()).isPresent()) {
            log.info("CPF/CNPJ Já possui proposta: {}", propostaRequest.getCpfCnpj());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("CPF/CNPJ Já possui proposta: "+ propostaRequest.getCpfCnpj());
        }

        Proposta proposta = propostaService.criarProposta(propostaRequest.getCpfCnpj(), propostaRequest.getEmail(), propostaRequest.getNome(), propostaRequest.getEndereco(),
                propostaRequest.getSalario());

        PropostaCriada propostaCriada = new PropostaCriada(proposta.getId(), proposta.getCpfCnpj(), proposta.getEmail(), proposta.getNome(), proposta.getEndereco(), proposta.getSalario(),proposta.getStatusAvaliacaoProposta());

        URI urlCriaProposta = uriComponentsBuilder.path("/novaproposta/{id}").build(proposta.getId());

        return ResponseEntity.created(urlCriaProposta).body(propostaCriada);
    }

    @GetMapping(path = "/listapropostas")
    public List<Proposta> listaPropostas(){
        return propostaRepository.findAll();
    }

}
