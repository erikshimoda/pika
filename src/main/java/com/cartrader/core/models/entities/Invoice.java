package com.cartrader.core.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INVOICE")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 40, nullable = false)
	private String invoice;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK1_DESTINATION")
	private Destination destination;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}
}
