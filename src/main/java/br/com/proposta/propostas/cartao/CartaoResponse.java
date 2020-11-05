package br.com.proposta.propostas.cartao;

import java.math.BigDecimal;

public class CartaoResponse {

    private String id;
    private String emitidoEm;
    private String titular;

    //private List<Bloqueios> bloqueios;
    //private List<Avisos> avisos;
    //private List<Carteiras> carteiras;
    //private List<Parcelas> parcelas;

    private BigDecimal limite;

    //private Renegociacao renegociacao;

    //private Vencimento vencimento;

    private String idProposta;

    @Deprecated
    public CartaoResponse(){
    }

    public CartaoResponse(String id, String emitidoEm, String titular, BigDecimal limite, String idProposta) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.limite = limite;
        this.idProposta = idProposta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmitidoEm() {
        return emitidoEm;
    }

    public void setEmitidoEm(String emitdoEm) {
        this.emitidoEm = emitdoEm;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }


    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }


    public String getIdProposta() {
        return idProposta;
    }

    public void setIdProposta(String idProposta) {
        this.idProposta = idProposta;
    }

    @Override
    public String toString() {
        return "CartaoResponse{" +
                "idCartao='" + id + '\'' +
                ", emitidoEm=" + emitidoEm +
                ", titular='" + titular + '\'' +
                ", idProposta='" + idProposta + '\'' +
                '}';
    }

}
