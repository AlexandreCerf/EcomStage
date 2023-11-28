package com.example.ecom.type;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class TypeService {
	private final TypeRepository typeRepository;

	
	public TypeService(TypeRepository typeRepository) {
		this.typeRepository = typeRepository;

	}
	
	public Type create(TypeRequest typeRequest) {
		Type type = new Type();
		return copyRequestIntoObject(typeRequest, type);
	}

	private Type copyRequestIntoObject(TypeRequest typeRequest, Type type) {
		type.setName(typeRequest.getName());
		return typeRepository.save(type);
	}
	
	public Type update(TypeRequest typeRequest,Long idType) throws NoSuchElementException{
		Type type = typeRepository.findById(idType).orElseThrow();
		return copyRequestIntoObject(typeRequest, type);
	}
	
	public void delete(Long idType) throws EmptyResultDataAccessException {
		typeRepository.deleteById(idType);
	}
	
	public Optional<Type> getById(Long idType){
		return typeRepository.findById(idType);
	}
	
	public List<Type> getAll(){
		return typeRepository.findAll ();
	}
}
