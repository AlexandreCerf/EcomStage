package com.example.ecom.fournisseur;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
public class FournisseurService {
	private final FournisseurRepository fournisseurRepository;

 
	public FournisseurService(FournisseurRepository fournisseurRepository) {
		this.fournisseurRepository = fournisseurRepository;
	}
	
	public Fournisseur create(FournisseurRequest fournisseurRequest) {
		Fournisseur fournisseur = new Fournisseur();
		return copyRequestIntoObject(fournisseurRequest, fournisseur);
	}

	private Fournisseur copyRequestIntoObject(FournisseurRequest fournisseurRequest, Fournisseur fournisseur) {
		fournisseur.setName(fournisseurRequest.getName());
		return fournisseurRepository.save(fournisseur);
	}
	
	public Fournisseur update(FournisseurRequest fournisseurRequest, Long idFournisseur) throws NoSuchElementException {
		Fournisseur fournisseur = fournisseurRepository.findById(idFournisseur).orElseThrow();
		return copyRequestIntoObject(fournisseurRequest, fournisseur);
	}
	
	public void delete(Long idFournisseur) {
		fournisseurRepository.deleteById(idFournisseur);
	}
	
	public Optional<Fournisseur> getById(Long idFournisseur) {
		return fournisseurRepository.findById(idFournisseur);
	}
	
	public List<Fournisseur> getAll(){
		return fournisseurRepository.findAll();
	}
}
