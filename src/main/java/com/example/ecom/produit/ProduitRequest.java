package com.example.ecom.produit;

public class ProduitRequest {
	private String libelle;
	
	private Long idType;
	private Long idFournisseur;
	private Long idRayon;
	
	public String getLibelle() {
		return libelle;
	}
	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public Long getIdType() {
		return idType;
	}
	
	public void setIdType(Long idType) {
		this.idType = idType;
	}
	
	public Long getIdFournisseur() {
		return idFournisseur;
	}
	
	public void setIdFournisseur(Long idFournisseur) {
		this.idFournisseur = idFournisseur;
	}
	
	public Long getIdRayon() {
		return idRayon;
	}
	
	public void setIdRayon(Long idRayon) {
		this.idRayon = idRayon;
	}
	
	public ProduitRequest(String libelle, Long idType, Long idFournisseur, Long idRayon) {
		this.libelle = libelle;
		this.idType = idType;
		this.idFournisseur = idFournisseur;
		this.idRayon = idRayon;
	}
	
	public ProduitRequest() {
	}
}
