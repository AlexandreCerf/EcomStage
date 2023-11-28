package com.example.ecom.prix;

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

import com.example.ecom.ObjectParamNotFoundException;


import jakarta.annotation.Nonnull;


@RestController
@RequestMapping("/prix")
public class PrixController {
	private final PrixService prixService;

	public PrixController(PrixService prixService) {
		this.prixService = prixService;
	}
	@GetMapping
	public List<Prix>getAll(){
		return this.prixService.getAll();
	}
	@GetMapping("/{id}")
	public Prix getPrix(@Nonnull @PathVariable Long id) {
		return this.prixService.getById(id) .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	@PutMapping("/{id}")
	public Prix update(@Nonnull @PathVariable Long id,@RequestBody @Nonnull PrixRequest prixRequest) {
		try {
			return this.prixService.update(prixRequest, id);
		}
		catch(NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		catch(ObjectParamNotFoundException e2) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping
	public Prix create(@RequestBody @Nonnull PrixRequest prixRequest) {
		try {
			return this.prixService.create(prixRequest);
		}
		catch(ObjectParamNotFoundException e2) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity <Prix> delete(@Nonnull @PathVariable Long id){
		try {
			this.prixService.delete(id);
			return ResponseEntity.noContent().build();
		}
		catch(EmptyResultDataAccessException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}
