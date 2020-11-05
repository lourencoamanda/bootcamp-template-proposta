package br.com.proposta.propostas.cartao;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class Carteiras {

    private String id;
    private String email;
    private LocalDateTime associadaEm;
    private String emissor;

    public Carteiras(){
    }

    public Carteiras(String id, String email, LocalDateTime associadaEm, String emissor) {
        this.id = id;
        this.email = email;
        this.associadaEm = associadaEm;
        this.emissor = emissor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getAssociadaEm() {
        return associadaEm;
    }

    public void setAssociadaEm(LocalDateTime associadaEm) {
        this.associadaEm = associadaEm;
    }

    public String getEmissor() {
        return emissor;
    }

    public void setEmissor(String emissor) {
        this.emissor = emissor;
    }
}
