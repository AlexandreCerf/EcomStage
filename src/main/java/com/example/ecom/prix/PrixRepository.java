package com.example.ecom.prix;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecom.produit.Produit;

public interface PrixRepository extends JpaRepository<Prix,Long>{
	public Prix findByProduit(Produit produit);
}
