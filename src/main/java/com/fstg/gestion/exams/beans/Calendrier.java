package com.fstg.gestion.exams.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Calendrier implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String libelle;
	private Integer anneUniversitaire;
	
	@OneToOne
	private Filiere filieres;
	
	@OneToMany
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Exam> exams;


	public Calendrier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Integer getAnneUniversitaire() {
		return anneUniversitaire;
	}
	public void setAnneUniversitaire(Integer anneUniversitaire) {
		this.anneUniversitaire = anneUniversitaire;
	}
	public Filiere getFilieres() {
		return filieres;
	}
	public void setFilieres(Filiere filieres) {
		this.filieres = filieres;
	}
	public List<Exam> getExams() {
		return exams;
	}
	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anneUniversitaire == null) ? 0 : anneUniversitaire.hashCode());
		result = prime * result + ((exams == null) ? 0 : exams.hashCode());
		result = prime * result + ((filieres == null) ? 0 : filieres.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
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
		Calendrier other = (Calendrier) obj;
		if (anneUniversitaire == null) {
			if (other.anneUniversitaire != null)
				return false;
		} else if (!anneUniversitaire.equals(other.anneUniversitaire))
			return false;
		if (exams == null) {
			if (other.exams != null)
				return false;
		} else if (!exams.equals(other.exams))
			return false;
		if (filieres == null) {
			if (other.filieres != null)
				return false;
		} else if (!filieres.equals(other.filieres))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}
	
	
}
