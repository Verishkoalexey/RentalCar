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
@Table(name = "user", catalog = "rentalcar")
@EqualsAndHashCode(of = "id")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String login;
	private String password;
	private String fio;
	private String phone;
	private String address;
	private String passport_id;
	
	@Column(name = "identification_number")
	private String identificationNumber;
	@ManyToOne
	@JoinColumn(name = "role_id")
	private UserRoles userRole;
	
	@Basic(fetch = FetchType.LAZY)
	@OneToMany(mappedBy = "manager")
	private List<Contract> manager;
	@Basic(fetch = FetchType.LAZY)
	@OneToMany(mappedBy = "client")
	private List<Contract> client;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}


	public User(int id, String login, String password, String fio, String phone, String address, String passport_id,
			String identificationNumber, UserRoles userRole) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.fio = fio;
		this.phone = phone;
		this.address = address;
		this.passport_id = passport_id;
		this.identificationNumber = identificationNumber;
		this.userRole = userRole;
	}
	
	


	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", fio=" + fio + ", phone=" + phone
				+ ", address=" + address + ", passport_id=" + passport_id + ", identificationNumber="
				+ identificationNumber + ", userRole=" + userRole + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFio() {
		return fio;
	}


	public void setFio(String fio) {
		this.fio = fio;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPassport_id() {
		return passport_id;
	}


	public void setPassport_id(String passport_id) {
		this.passport_id = passport_id;
	}


	public String getIdentificationNumber() {
		return identificationNumber;
	}


	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}


	public UserRoles getUserRole() {
		return userRole;
	}


	public void setUserRole(UserRoles userRole) {
		this.userRole = userRole;
	}


	public List<Contract> getManager() {
		return manager;
	}


	public void setManager(List<Contract> manager) {
		this.manager = manager;
	}


	public List<Contract> getClient() {
		return client;
	}


	public void setClient(List<Contract> client) {
		this.client = client;
	}
	
	
	
}
