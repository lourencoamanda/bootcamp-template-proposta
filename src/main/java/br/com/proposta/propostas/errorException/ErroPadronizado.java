package br.com.proposta.propostas.errorException;

import java.util.Collection;

public class ErroPadronizado {

    private Collection<String> mensagens;

    @Deprecated
    public ErroPadronizado(){
    }

    public ErroPadronizado(Collection<String> mensagens) {
        this.mensagens = mensagens;
    }

    public Collection<String> getMensagens() {
        return mensagens;
    }

    public void setMensagens(Collection<String> mensagens) {
        this.mensagens = mensagens;
    }
}