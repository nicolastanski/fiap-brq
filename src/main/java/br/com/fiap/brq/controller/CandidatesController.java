package br.com.fiap.brq.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.brq.model.Candidate;
import br.com.fiap.brq.repository.CandidateRepository;

@RestController
@RequestMapping("candidates")
public class CandidatesController {

		@Autowired
		private CandidateRepository candidateRepository;
		
		@GetMapping
		public List<Candidate> all(Pageable pageRequest) {
			return candidateRepository.findAll();
		}
		
		@GetMapping("{id}")
		public Candidate find(@PathVariable int id) {
			return candidateRepository.findById(id).get();
		}
		
		@ResponseStatus(code = HttpStatus.CREATED)
		@PostMapping
		public Candidate store(@RequestBody Candidate candidate) {
			return candidateRepository.save(candidate);
		}
		
		@GetMapping("{id}")
		public ResponseEntity<Candidate> show(@PathVariable int id) {
			
			Optional<Candidate> candidate = candidateRepository.findById(id);
	        if(candidate.isPresent()) {
	        	return new ResponseEntity<Candidate>(candidate.get(), HttpStatus.OK);
	        }
	        
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);	     
		}
		
		@PutMapping("{id}")
		public Candidate update(@RequestBody Candidate candidate, @PathVariable int id) {
			candidate.setId(id);
			return candidateRepository.save(candidate);
		}
		
		@DeleteMapping("{id}")
		public ResponseEntity<Object> delete(@PathVariable int id) {
			Optional<Candidate> candidate = candidateRepository.findById(id);
			
	        if(candidate.isPresent()) {
	        	candidateRepository.deleteById(id);
	            return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		
		@GetMapping("search")
		public List<Candidate> search(@RequestParam(required = true) String name, @RequestParam(required = true) String value) {
			
			return name != null ? candidateRepository.findByName(name) : candidateRepository.findByCpf(name);
		}
	
}
