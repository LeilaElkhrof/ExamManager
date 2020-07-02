package com.fstg.gestion.exams.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Exam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String reference;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDepart;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateFin;
	
	@OneToOne
	private Module module;
	@OneToOne
	private Professeur prof;
	@ManyToOne
	private Filiere filiere;
	
		
	@OneToMany(mappedBy="exam")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<ExamSalle> examSalles;
	

	@OneToMany(mappedBy="exam")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<ExamEtudiant> examEtudiants;

	public Exam() {
		super();
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateDepart() {
		return dateDepart;
	}


	public Professeur getProf() {
		return prof;
	}

	public void setProf(Professeur prof) {
		this.prof = prof;
	}

	


	public List<ExamEtudiant> getExamEtudiants() {
		return examEtudiants;
	}


	public void setExamEtudiants(List<ExamEtudiant> examEtudiants) {
		this.examEtudiants = examEtudiants;
	}


	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
	public List<ExamSalle> getExamSalles() {
		return examSalles;
	}
	public void setExamSalles(List<ExamSalle> examSalles) {
		this.examSalles = examSalles;
	}
	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exam other = (Exam) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	
	
}