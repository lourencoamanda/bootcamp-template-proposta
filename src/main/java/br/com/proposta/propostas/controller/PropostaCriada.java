package br.com.proposta.propostas.controller;

import br.com.proposta.propostas.service.StatusAvaliacaoProposta;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class PropostaCriada {

    @NotBlank
    private Long id;

    @NotBlank
    private String cpfCnpj;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String endereco;

    @NotNull
    @Positive
    private BigDecimal salario;

    private StatusAvaliacaoProposta statusAvaliacaoProposta;


    public PropostaCriada(@NotBlank Long id, @NotBlank String cpfCnpj, @NotBlank @Email String email, @NotBlank String nome, @NotBlank String endereco, @NotNull @Positive BigDecimal salario, StatusAvaliacaoProposta statusAvaliacaoProposta) {
        this.id = id;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
        this.statusAvaliacaoProposta = statusAvaliacaoProposta;
    }

    public Long getId() {
        return id;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public StatusAvaliacaoProposta getStatusAvaliacaoProposta() {
        return statusAvaliacaoProposta;
    }
}
