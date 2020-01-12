package com.example.rentalcar.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "transmission", catalog = "rentalcar")
@Getter @Setter
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class Transmission {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	private String name;
	
	@Basic(fetch = FetchType.LAZY)
	@OneToMany(mappedBy = "transmission")
	private List<Auto> autos;

	@Override
	public String toString() {
		return "Transmission [name=" + name + "]";
	}
	
}
