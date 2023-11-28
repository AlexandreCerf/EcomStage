package com.example.ecom.fournisseur;

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
@RequestMapping("/fournisseurs")
public class FournisseurController {
	private final FournisseurService fournisseurService;
	
	public FournisseurController(FournisseurService fournisseurService) {
		this.fournisseurService = fournisseurService;
	}
	@GetMapping
	public List<Fournisseur> getAll(){
		return this.fournisseurService.getAll();
		}
	@GetMapping("/{id}")
	public Fournisseur getFournisseur(@Nonnull @PathVariable Long id) {
		return this.fournisseurService.getById(id) .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping("{id}")
	public Fournisseur update(@Nonnull @PathVariable Long id,@RequestBody @Nonnull FournisseurRequest fournisseurRequest) {
		try {
			return this.fournisseurService.update(fournisseurRequest, id);
		}
		catch(NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping
	public Fournisseur create(@RequestBody @Nonnull FournisseurRequest fournisseurRequest) {
		return this.fournisseurService.create(fournisseurRequest);
	}
	@DeleteMapping("{id}")
	public ResponseEntity <Fournisseur>delete(@Nonnull @PathVariable Long id){
		try {
			this.fournisseurService.delete(id);
			return ResponseEntity.noContent().build();
		}
		catch(EmptyResultDataAccessException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}
