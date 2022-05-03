package br.com.fiap.brq.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import javax.persistence.Id;

@Entity
@SequenceGenerator(name = "certificate", sequenceName = "SQ_CERTIFICATE", allocationSize = 1)
public class Certificate {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "certificate")
	private int id;
	
	@NotBlank(message = "Campo Obrigatório")
	private String name;
	
	@NotBlank(message = "Campo Obrigatório")
	private String school;
			
}
