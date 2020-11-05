package br.com.proposta.propostas.service;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Component
public class AnalisePropostaRequest {

    @NotBlank
    private  String documento;

    @NotBlank
    private  String nome;

    @NotBlank
    private Long idProposta;

    @Deprecated
    public AnalisePropostaRequest(){
    }

    public AnalisePropostaRequest(@NotBlank String documento, @NotBlank String nome, @NotBlank Long idProposta) {
        this.documento = documento;
        this.nome = nome;
        this.idProposta = idProposta;
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
