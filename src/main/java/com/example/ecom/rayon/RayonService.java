package com.example.ecom.rayon;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
public class RayonService {
	private final RayonRepository rayonRepository;
	
	public RayonService(RayonRepository rayonRepository) {
		this.rayonRepository = rayonRepository;
	}
	
	public Rayon create(RayonRequest rayonRequest) {
		Rayon rayon = new Rayon();
		return copyRequestIntoObject(rayonRequest, rayon);
	}

	private Rayon copyRequestIntoObject(RayonRequest rayonRequest, Rayon rayon) {
		rayon.setName(rayonRequest.getName());
		return rayonRepository.save(rayon);
	}
	
	public Rayon update(RayonRequest rayonRequest,Long idRayon) throws NoSuchElementException{
		Rayon rayon = rayonRepository.findById(idRayon).orElseThrow();
		return copyRequestIntoObject(rayonRequest, rayon);
	}
	
	public void delete(Long idRayon) {
		rayonRepository.deleteById(idRayon);
	}
	
	public Optional<Rayon> getById(Long idRayon){
		return rayonRepository.findById(idRayon);
	}
	
	public List<Rayon> getAll(){
		return rayonRepository.findAll();
	}
}
