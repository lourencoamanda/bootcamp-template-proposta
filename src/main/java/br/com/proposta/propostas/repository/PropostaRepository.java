package br.com.proposta.propostas.repository;

import br.com.proposta.propostas.entity.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {
    Optional<Proposta> findByCpfCnpj(String CpfCnpj);

}
