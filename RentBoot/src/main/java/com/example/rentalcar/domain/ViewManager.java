package com.example.rentalcar.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "view_manager", catalog = "rentalcar")
@EqualsAndHashCode(of = "id")
@Getter @Setter
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class ViewManager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "contract_id")
	private Contract contract;
	private String startRent;
	private String finishRent;
	@ManyToOne
	@JoinColumn(name = "status_rent")
	private Status statusRent;
	
	public ViewManager() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "ViewManager [id=" + id + ", contract=" + contract + ", startRent=" + startRent + ", finishRent="
				+ finishRent + ", statusRent=" + statusRent + "]";
	}
	public ViewManager(int id, Contract contract, String startRent, String finishRent,
			Status statusRent) {
		super();
		this.id = id;
		this.contract = contract;
		this.startRent = startRent;
		this.finishRent = finishRent;
		this.statusRent = statusRent;
	}
	
	
}
