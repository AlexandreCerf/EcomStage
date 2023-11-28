package com.example.ecom.rayon;

import jakarta.persistence.*;

@Entity
public class Rayon {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column(nullable = false)
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Rayon(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Rayon() {
	}
}
