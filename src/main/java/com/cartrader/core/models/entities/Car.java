package com.cartrader.core.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CAR")
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String color;
	private String chassis;
	private String mileage;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK1_AUTOMAKER")
	private CarAutomaker carAutomaker;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK2_MODEL")
	private CarModel carModel;
	
	public int getId() {
		return id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getChassis() {
		return chassis;
	}

	public void setChassis(String chassis) {
		this.chassis = chassis;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public CarAutomaker getAutomaker() {
		return carAutomaker;
	}

	public void setAutomaker(CarAutomaker carAutomaker) {
		this.carAutomaker = carAutomaker;
	}

	public void setId(int id) {
		this.id = id;
	}
}
