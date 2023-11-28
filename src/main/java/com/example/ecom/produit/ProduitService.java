package com.example.ecom.produit;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ecom.ObjectParamNotFoundException;
import com.example.ecom.fournisseur.Fournisseur;
import com.example.ecom.fournisseur.FournisseurService;
import com.example.ecom.rayon.Rayon;
import com.example.ecom.rayon.RayonService;
import com.example.ecom.type.Type;
import com.example.ecom.type.TypeService;



@Service
public class ProduitService {
	private final ProduitRepository produitRepository;
	private final TypeService typeService;
	private final FournisseurService fournisseurService;
	private final RayonService rayonService;

	public ProduitService(ProduitRepository produitRepository, TypeService typeService,
			FournisseurService fournisseurService, RayonService rayonServices) {
		this.produitRepository = produitRepository;
		this.typeService = typeService;
		this.fournisseurService = fournisseurService;
		this.rayonService = rayonServices;
	}


	public Produit create(ProduitRequest produitRequest)  throws NoSuchElementException, ObjectParamNotFoundException{
		Produit produit = new Produit();
		return copyRequestIntoObject(produitRequest, produit);
	}


	private Produit copyRequestIntoObject(ProduitRequest produitRequest, Produit produit)
			throws ObjectParamNotFoundException {
		produit.setLibelle(produitRequest.getLibelle());
		Type type = typeService.getById(produitRequest.getIdType()).orElseThrow(()->new ObjectParamNotFoundException("Le type spécifié n'existe pas !"));
		produit.setType(type);
		Fournisseur fournisseur = fournisseurService.getById(produitRequest.getIdFournisseur()).orElseThrow(()->new ObjectParamNotFoundException("Le fournisseur n'existe pas !"));
		produit.setFournisseur(fournisseur);
		Rayon rayon = rayonService.getById(produitRequest.getIdRayon()).orElseThrow(()->new ObjectParamNotFoundException("Le rayon spécifié n'existe pas !"));
		produit.setRayon(rayon);
		return produitRepository.save(produit);
	}
	
	public Produit update(ProduitRequest produitRequest, Long idProduit) throws NoSuchElementException, ObjectParamNotFoundException {
		Produit produit = produitRepository.findById(idProduit).orElseThrow();
		return copyRequestIntoObject(produitRequest, produit);
	}
	
	public void delete(Long idProduit) {
		produitRepository.deleteById(idProduit);
	}
	
	public Optional<Produit> getById(Long idProduit){
		return produitRepository.findById(idProduit);
	}
	
	public List<Produit> getAll(){
		return produitRepository.findAll();
	}
}
