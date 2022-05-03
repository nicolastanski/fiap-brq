package br.com.fiap.brq.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@SequenceGenerator(name = "candidate", sequenceName = "SQ_CANDIDATE", allocationSize = 1)
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidate")
	private int id;
	
	@NotBlank(message = "Campo Obrigatório")
	private String cpf;
	
	@NotBlank(message = "Campo Obrigatório")
	private String name;
	
	@NotBlank(message = "Campo Obrigatório")
	private String email;
	
	@NotBlank(message = "Campo Obrigatório")
	private String phone;
	
	@NotBlank(message = "Campo Obrigatório")
	private String gender;
	
	@NotBlank(message = "Campo Obrigatório")
	private String birth_date;
	
	@ManyToOne
	private Skill skill;
	
	@ManyToOne
	private Certificate certificate;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthDate() {
		return birth_date;
	}

	public void setBirthDate(String birth_date) {
		this.birth_date = birth_date;
	}

	public Skill getSkill() {
		return skill;
	}

	public Certificate getCertificate() {
		return certificate;
	}
		

}