package br.com.proposta.propostas.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class ValidaCpfCnpj implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PropostaRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return ;
        }

        PropostaRequest request = (PropostaRequest) target;
        if(!request.validaCpfCpnj()) {
            errors.rejectValue("cpfCnpj",null, "CPF/ CNPJ Inválido");
        }
    }
}
