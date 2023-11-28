package com.example.ecom.type;

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
@RequestMapping("/types")
public class TypeController {
	private final TypeService typeService;

	public TypeController(TypeService typeService) {
		this.typeService = typeService;
	}
	@GetMapping
	public List<Type> getAll(){
		return this.typeService.getAll();
	}
	@GetMapping("/{id}")
	public Type getType(@Nonnull @PathVariable Long id) {
		return this.typeService.getById(id) .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	@PutMapping("/{id}")
	public Type update(@Nonnull @PathVariable Long id,@RequestBody @Nonnull TypeRequest typeRequest) {
		try {
			return this.typeService.update(typeRequest, id);
		}
		catch(NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping
	public Type create(@RequestBody @Nonnull TypeRequest typeRequest) {
		return this.typeService.create(typeRequest);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity <Type> delete(@Nonnull @PathVariable Long id){
		try {
			this.typeService.delete(id);
			return ResponseEntity.noContent().build();
		}
		catch(EmptyResultDataAccessException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}
