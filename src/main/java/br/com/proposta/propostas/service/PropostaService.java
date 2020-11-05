package br.com.proposta.propostas.service;

import br.com.proposta.propostas.cartao.CartaoConsulta;
import br.com.proposta.propostas.cartao.ValidaCartao;
import br.com.proposta.propostas.entity.Proposta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import javax.transaction.Transactional;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Service
public class PropostaService {

    @Autowired
    private CartaoConsulta cartaoController;

    @Autowired
    private ValidaCartao validaCartao;

    @Autowired
    private CartaoConsulta cartaoConsulta;

    @Autowired
    private ExecutorTransacao executorTransacao;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AnalisePropostaResponse analisePropostaResponse;

    @Autowired
    private AnalisePropostaRequest analisePropostaRequest;

    private final Logger log = LoggerFactory.getLogger(PropostaService.class);

    private String url = "http://localhost:9999/api/solicitacao";

    @Deprecated
    public PropostaService() {
    }

    public PropostaService(ExecutorTransacao executorTransacao, RestTemplate restTemplate) {
        this.executorTransacao = executorTransacao;
        this.restTemplate = restTemplate;
    }

    @Transactional
    public Proposta criarProposta(@NotBlank String cpfCpnj, @NotBlank @Email String email, @NotBlank String nome,
                          @NotBlank String endereco,@NotNull @Positive BigDecimal salario) {

        StatusAvaliacaoProposta statusAvaliacaoProposta = null;

        Proposta novaProposta = new Proposta(cpfCpnj, email,nome, endereco,salario,statusAvaliacaoProposta.PENDENTE);

        Object propostaPersistida = executorTransacao.criaProposta(novaProposta);

        analisePropostaRequest = novaProposta.toAnalisePropostaRequest();

        log.info("Chamando URL: {} {} {}", url, analisePropostaRequest.getDocumento(), analisePropostaRequest.getNome(), analisePropostaRequest.getIdProposta());

        try {
            analisePropostaResponse = restTemplate.postForObject(url, analisePropostaRequest, AnalisePropostaResponse.class);
            log.info("Proposta : {}, {}, {}", analisePropostaResponse.getResultadoSolicitacao(), novaProposta.getId(),novaProposta.getCpfCnpj());

        }catch (Exception e){

            log.info("Proposta COM RESTRIÇÃO: {} {} {}", analisePropostaRequest.getDocumento(), analisePropostaRequest.getIdProposta(), analisePropostaRequest.getNome());
            novaProposta.setStatusAvaliacaoProposta(StatusAvaliacaoProposta.NAO_ELEGIVEL);
            executorTransacao.atualizaStatus(novaProposta);
            return novaProposta;
        }

        novaProposta.setStatusAvaliacaoProposta(StatusAvaliacaoProposta.ELEGIVEL);
        executorTransacao.atualizaStatus(novaProposta);

        log.info("Consulta cartão: {}", novaProposta.getId());

        validaCartao.solicita();
        return (novaProposta);
    }

}
