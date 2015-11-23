package com.cartrader.core.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

	@Column(length = 40, nullable = false)
	private String color;
	
	@Column(length = 40, nullable = false)
	private String chassis;
	
	@Column(length = 6, nullable = false)
	private int mileage;
	
	@Column(length = 4, nullable = false)
	private int year;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK1_AUTOMAKER", referencedColumnName="id")
	private CarAutomaker carAutomaker;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK2_MODEL", referencedColumnName="id")
	private CarModel carModel;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK3_FUEL", referencedColumnName="id")
	private CarFuel carFuel;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK4_GEAR", referencedColumnName="id")
	private CarGear carGear;

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

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
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
