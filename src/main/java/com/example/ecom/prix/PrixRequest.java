package com.example.ecom.prix;

public class PrixRequest {

	private Double valeur;
	private Long idProduit;
	
	public Double getValeur() {
		return valeur;
	}
	
	public void setValeur(Double valeur) {
		this.valeur = valeur;
	}
	
	public Long getIdProduit() {
		return idProduit;
	}
	
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	
	public PrixRequest(Double valeur, Long idProduit) {
		this.valeur = valeur;
		this.idProduit = idProduit;
	}
	
	public PrixRequest() {
	}
	
	
}
