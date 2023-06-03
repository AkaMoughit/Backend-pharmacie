package com.example.pharmacieapi.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Pharmacie")
@Table(name = "Pharmacie")
@Data
@AllArgsConstructor
public class Pharmacie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String adresse;
	private String telephone;
	private Double lat;
	private Double log;
	private int etat;

	@ManyToOne
	@JoinColumn(name = "zone_id",columnDefinition = "integer default 1")
	private Zone zone;

	@OneToMany(mappedBy = "pharmacie")
	@JsonIgnore
	private List<PharmacieDeGarde> gardes ;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
	
	public void addPharmacieDeGarde(PharmacieDeGarde garde){
		this.gardes.add(garde);
		garde.setPharmacie(this);
	}

	public Pharmacie() {
		this.gardes=new ArrayList<>();

	}

	public void setUser(User user2) {
		// TODO Auto-generated method stub
		this.user = user2;
	}

	public void setEtat(int i) {
		// TODO Auto-generated method stub
		this.etat = i;
	}

	public void setZone(Zone zone2) {
		// TODO Auto-generated method stub
		this.zone = zone2;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getNom() {
		// TODO Auto-generated method stub
		return nom;
	}

	public void setNom(String nom2) {
		// TODO Auto-generated method stub
		this.nom = nom2;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLog() {
		return log;
	}

	public void setLog(Double log) {
		this.log = log;
	}

	public List<PharmacieDeGarde> getGardes() {
		return gardes;
	}

	public void setGardes(List<PharmacieDeGarde> gardes) {
		this.gardes = gardes;
	}

	public int getEtat() {
		return etat;
	}

	public Zone getZone() {
		return zone;
	}

	public User getUser() {
		return user;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		// TODO Auto-generated method stub
		return adresse;
	}
}
