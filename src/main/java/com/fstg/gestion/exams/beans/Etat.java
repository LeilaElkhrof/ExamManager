package com.fstg.gestion.exams.beans;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
public class Etat implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String libelle;
	private String action;
	@Temporal(TemporalType.DATE)
	private Date dateAction;
	private String type;


	public Etat() {
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
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Date getDateAction() {
		return dateAction;
	}
	public void setDateAction(Date dateAction) {
		this.dateAction = dateAction;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



	
	
}
