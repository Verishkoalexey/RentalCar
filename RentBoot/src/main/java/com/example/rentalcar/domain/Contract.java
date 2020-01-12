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
@Table(name = "contract", catalog = "rentalcar")
@EqualsAndHashCode(of = "id")
@Getter @Setter
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class Contract {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "contract_number")
	private String contractNumber;
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private User manager;
	@ManyToOne
	@JoinColumn(name = "auto_id")
	private Auto auto;
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
	
	@Basic(fetch = FetchType.LAZY)
	@OneToMany(mappedBy = "contract")
	private List<ViewManager> viewManagerRentContract;
	
	public Contract() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Contract [id=" + id + ", contractNumber=" + contractNumber + ", manager=" + manager + ", auto=" + auto
				+ ", client=" + client + "]";
	}

	public Contract(int id, String contractNumber, User manager, Auto auto, User client) {
		super();
		this.id = id;
		this.contractNumber = contractNumber;
		this.manager = manager;
		this.auto = auto;
		this.client = client;
	}
	
}
