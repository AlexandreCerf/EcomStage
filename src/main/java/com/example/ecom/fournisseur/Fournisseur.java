package com.example.ecom.fournisseur;

import jakarta.persistence.*;

@Entity
public class Fournisseur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Fournisseur(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Fournisseur() {
	}
	
}
