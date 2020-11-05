package br.com.proposta.propostas.cartao;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class Renegociacao {

    private String id;
    private Integer quantidade;
    private BigDecimal valor;
    private String dataDeCriacao;

    public Renegociacao(){
    }

    public Renegociacao(String id, Integer quantidade, BigDecimal valor, String dataDeCriacao) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
        this.dataDeCriacao = dataDeCriacao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(String dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }
}
