package com.example.ecom.produit;

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
@RequestMapping("/produits")
public class ProduitController {
	private final ProduitService produitService;

	public ProduitController(ProduitService produitService) {
		this.produitService = produitService;
	}
	@GetMapping
	public List<Produit>getAll(){
		return this.produitService.getAll();
	}
	@GetMapping("/{id}")
	public Produit getProduit(@Nonnull @PathVariable Long id) {
		return this.produitService.getById(id) .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	@PutMapping("/{id}")
	public Produit update(@Nonnull @PathVariable Long id,@RequestBody @Nonnull ProduitRequest produitRequest) {
		try {
			return this.produitService.update(produitRequest, id);
		}
		catch(NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		catch(ObjectParamNotFoundException e2) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping
	public Produit create(@RequestBody @Nonnull ProduitRequest produitRequest) {
		try {
			return this.produitService.create(produitRequest);
		}
		catch(ObjectParamNotFoundException e2) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity <Produit> delete(@Nonnull @PathVariable Long id){
		try {
			this.produitService.delete(id);
			return ResponseEntity.noContent().build();
		}
		catch(EmptyResultDataAccessException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}
