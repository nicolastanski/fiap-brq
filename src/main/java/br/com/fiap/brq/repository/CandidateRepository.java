package br.com.fiap.brq.repository;

import java.util.List;
import org.springframework.stereotype.Repository;

import br.com.fiap.brq.model.Candidate;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
		List<Candidate> findByName(String name);
		List<Candidate> findByEmail(String email);
		List<Candidate> findByCpf(String cpf);
		List<Candidate> findBySkill(String skill);
		List<Candidate> findByCertificate(String certificate);
}
