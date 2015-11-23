package com.cartrader.core.models.entities;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "VESSEL")
public class Vessel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 40, nullable = false)
	private String name;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK1_DESTINATION")
	private Destination destination;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar eta;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar etd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getEta() {
		return eta;
	}

	public void setEta(Calendar eta) {
		this.eta = eta;
	}

	public Calendar getEtd() {
		return etd;
	}

	public void setEtd(Calendar etd) {
		this.etd = etd;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}
}
