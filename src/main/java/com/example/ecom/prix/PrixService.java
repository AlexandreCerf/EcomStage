package com.example.ecom.prix;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ecom.ObjectParamNotFoundException;
import com.example.ecom.produit.Produit;
import com.example.ecom.produit.ProduitService;

@Service
public class PrixService {
	private final PrixRepository prixRepository;
	private final ProduitService produitService;
	
	public PrixService(PrixRepository prixRepository, ProduitService produitService) {
		this.prixRepository = prixRepository;
		this.produitService = produitService;
	}
	
	public Prix create(PrixRequest prixRequest) throws ObjectParamNotFoundException {
		Prix prix = new Prix();
		return copyRequestIntoObject(prixRequest, prix);
	}

	private Prix copyRequestIntoObject(PrixRequest prixRequest, Prix prix) throws ObjectParamNotFoundException {
		prix.setValeur(prixRequest.getValeur());
		Produit produit = produitService.getById(prixRequest.getIdProduit()).orElseThrow(()->new ObjectParamNotFoundException("Le produit n'existe pas !"));
		prix.setProduit(produit);
		return prixRepository.save(prix);
	}
	
	public Prix update(PrixRequest prixRequest, Long idPrix) throws ObjectParamNotFoundException, NoSuchElementException {
		Prix prix = prixRepository.findById(idPrix).orElseThrow();
		return copyRequestIntoObject(prixRequest, prix);
	}
	
	public void delete(Long idPrix) {
		prixRepository.deleteById(idPrix);
	}
	
	public Optional<Prix> getById(Long idPrix){
		return prixRepository.findById(idPrix);
	}
	
	public List<Prix> getAll(){
		return prixRepository.findAll();
	}
}
