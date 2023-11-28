package com.example.ecom.prix;

import com.example.ecom.produit.Produit;
import jakarta.persistence.*;

@Entity
public class Prix {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column(nullable = false, scale = 2)
	private Double valeur;
	
	@ManyToOne
	@JoinColumn
	private Produit produit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValeur() {
		return valeur;
	}

	public void setValeur(Double valeur) {
		this.valeur = valeur;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Prix(Long id, Double valeur, Produit produit) {
		this.id = id;
		this.valeur = valeur;
		this.produit = produit;
	}

	public Prix() {
	}
	
}
