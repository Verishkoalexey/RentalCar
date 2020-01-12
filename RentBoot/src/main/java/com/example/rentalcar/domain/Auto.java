package com.example.rentalcar.domain;


import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "auto", catalog = "rentalcar")
@EqualsAndHashCode(of = "id")
@Getter @Setter
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class Auto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "number_auto")
	private String numberAuto;
	private String mark;
	private String model;
	private String engine;
	private String volume;
	
	@ManyToOne
	@JoinColumn(name = "transmission_id")
	private Transmission transmission;
	
	@ManyToOne
	@JoinColumn(name = "bodytype_id")
	private BodyType bodyType;
	
	@ManyToOne
	@JoinColumn(name = "drivetype_id")
	private DriveType driveType;

	private String image;
	
	@Basic(fetch = FetchType.LAZY)
	@OneToMany(mappedBy = "auto")
	private List<Contract> auto;
	
	public Auto() {
		// TODO Auto-generated constructor stub
	}

	public Auto(int id, String image) {
		super();
		this.id = id;
		this.image = image;
	}

	@Override
	public String toString() {
		return "Auto [mark=" + mark + ", model=" + model + "]";
	}

	public Auto(int id, String mark, String model, String engine, String volume, Transmission transmission,
			BodyType bodyType, DriveType driveType, String image) {
		super();
		this.id = id;
		this.mark = mark;
		this.model = model;
		this.engine = engine;
		this.volume = volume;
		this.transmission = transmission;
		this.bodyType = bodyType;
		this.driveType = driveType;
		this.image = image;
	}




	
//	public Auto(int id, String numberAuto, String mark, String model, String engine, String volume,
//			Transmission transmission, BodyType bodyType, DriveType driveType) {
//		super();
//		this.id = id;
//		this.numberAuto = numberAuto;
//		this.mark = mark;
//		this.model = model;
//		this.engine = engine;
//		this.volume = volume;
//		this.transmission = transmission;
//		this.bodyType = bodyType;
//		this.driveType = driveType;
//	}

}
