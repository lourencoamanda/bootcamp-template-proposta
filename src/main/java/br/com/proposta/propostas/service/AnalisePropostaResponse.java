package br.com.proposta.propostas.service;

import org.springframework.stereotype.Component;

@Component
public class AnalisePropostaResponse {

    private String documento;

    private String nome;

    private PropostaStatus resultadoSolicitacao;

    private Long idProposta;

    @Deprecated
    public AnalisePropostaResponse(){
    }

    public AnalisePropostaResponse(String documento, String nome, PropostaStatus resultadoSolicitacao, Long idProposta) {
        this.documento = documento;
        this.nome = nome;
        this.resultadoSolicitacao = resultadoSolicitacao;
        this.idProposta = idProposta;
    }

    public PropostaStatus getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }

    public void setResultadoSolicitacao(PropostaStatus resultadoSolicitacao) {
        this.resultadoSolicitacao = resultadoSolicitacao;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdProposta() {
        return idProposta;
    }

    public void setIdProposta(Long idProposta) {
        this.idProposta = idProposta;
    }
}
