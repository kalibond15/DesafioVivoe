package br.com.vivo.desafio.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vivo.desafio.api.Model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    Candidate findByEmail(String email);

}
