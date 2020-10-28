package br.com.proposta.propostas.service;

import br.com.proposta.propostas.entity.Proposta;
import br.com.proposta.propostas.repository.PropostaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Service
public class PropostaService {

    private final Logger log = LoggerFactory.getLogger(PropostaService.class);

    @Autowired
    private PropostaRepository propostaRepository;

    @Transactional
    public Proposta criar(@NotBlank String cpfCpnj, @NotBlank @Email String email, @NotBlank String nome,
                          @NotBlank String endereco,@NotNull @Positive BigDecimal salario) {

        Proposta novaProposta = new Proposta(cpfCpnj, email,nome, endereco,salario);
        propostaRepository.save(novaProposta);

        log.info("Salvou nova proposta: {}", cpfCpnj);

        return (novaProposta);
    }

}
