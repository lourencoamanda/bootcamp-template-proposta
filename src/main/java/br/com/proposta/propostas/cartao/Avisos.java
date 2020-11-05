package br.com.proposta.propostas.cartao;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;
import java.util.Date;

@Embeddable
public class Avisos {

    private Date validoAte;
    private String destino;

    public Avisos(){
    }

    public Avisos(Date validoAte, String destino) {
        this.validoAte = validoAte;
        this.destino = destino;
    }

    public Date getValidoAte() {
        return validoAte;
    }

    public void setValidoAte(Date validoAte) {
        this.validoAte = validoAte;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
