package com.fstg.gestion.exams.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Filiere implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private String libelle;
	
	@OneToMany(mappedBy="filiere")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Module> modules;
	
	

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
