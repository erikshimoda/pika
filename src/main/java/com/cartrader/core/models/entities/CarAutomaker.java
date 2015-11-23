package com.cartrader.core.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CAR_AUTOMAKER")
public class CarAutomaker {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 80, nullable = false)
	private String automaker;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAutomaker() {
		return automaker;
	}

	public void setAutomaker(String automaker) {
		this.automaker = automaker;
	}
}
