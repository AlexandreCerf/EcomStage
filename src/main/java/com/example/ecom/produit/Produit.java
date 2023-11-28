package com.example.ecom.produit;

import com.example.ecom.fournisseur.Fournisseur;
import com.example.ecom.rayon.Rayon;
import com.example.ecom.type.Type;

import jakarta.persistence.*;

@Entity
public class Produit {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column(nullable = false)
	private String libelle;
	
	@ManyToOne
	@JoinColumn
	private Type type;
	
	@ManyToOne
	@JoinColumn
	private Fournisseur fournisseur;
	
	@ManyToOne
	@JoinColumn
	private Rayon rayon;

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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Rayon getRayon() {
		return rayon;
	}

	public void setRayon(Rayon rayon) {
		this.rayon = rayon;
	}

	public Produit(Long id, String libelle, Type type, Fournisseur fournisseur, Rayon rayon) {
		this.id = id;
		this.libelle = libelle;
		this.type = type;
		this.fournisseur = fournisseur;
		this.rayon = rayon;
	}

	public Produit() {
	}
	
}
