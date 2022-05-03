package br.com.fiap.brq.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import javax.persistence.Id;

@Entity
@SequenceGenerator(name = "skill", sequenceName = "SQ_SKILL", allocationSize = 1)
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skill")
	private int id;
	
	@NotBlank(message = "Campo Obrigatório")
	private String name;
	
	@NotBlank(message = "Campo Obrigatório")
	private String description;
			
}
