package com.example.pharmacieapi.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Zone")
@Table(name = "Zone")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Zone {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;

	@OneToMany(mappedBy = "zone",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Pharmacie> pharmacies;

	@ManyToOne
	@JoinColumn(name = "ville_id")
	private Ville ville;

	public void setNom(String nom2) {
		// TODO Auto-generated method stub
		this.nom = nom2;
	}

	public void setVille(Ville v) {
		// TODO Auto-generated method stub
		this.ville = v;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Pharmacie> getPharmacies() {
		return pharmacies;
	}

	public void setPharmacies(List<Pharmacie> pharmacies) {
		this.pharmacies = pharmacies;
	}

	public String getNom() {
		return nom;
	}

	public Ville getVille() {
		return ville;
	}
	
}
