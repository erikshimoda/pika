package com.cartrader.core.models.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Address {
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;
	
	@ManyToOne
	@JoinColumn(name = "state_id")
	private State state;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@Column(length = 40, nullable = false)
	private String street;
	
	@Column(nullable = false)
	private short number;
	
	@Column(length = 20, nullable = false)
	private String complement;
	
	@Column(length = 9, nullable = true)
	private int cep;
}
