package com.example.ecom.rayon;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.annotation.Nonnull;

@RestController
@RequestMapping
public class RayonController {
	private final RayonService rayonService;
		
	public RayonController(RayonService rayonService) {
		this.rayonService = rayonService;
	}
	@GetMapping("/rayons")
	public List<Rayon>getAll(){
		return this.rayonService.getAll();
	}
	@GetMapping("/rayons/{id}")
	public Rayon getRayon(@Nonnull @PathVariable Long id) {
		return this.rayonService.getById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	@PutMapping("/rayons/{id}")
	public Rayon update(@Nonnull @PathVariable Long id,@RequestBody @Nonnull RayonRequest rayonRequest) {
		try {
			return this.rayonService.update(rayonRequest, id);
		}
		catch(NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/rayons")
	public Rayon create(@RequestBody @Nonnull RayonRequest rayonRequest) {
		return this.rayonService.create(rayonRequest);
	}
	@DeleteMapping("/rayons/{id}")
	public ResponseEntity<Rayon> delete(@Nonnull @PathVariable Long id){
		try {
			this.rayonService.delete(id);
			return ResponseEntity.noContent().build();
		}
		catch(EmptyResultDataAccessException e0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}
