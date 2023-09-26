package com.envro.grad001.assessment.justindube.web.model;
/*
 * @Author - Justin Dube
 */
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonIdentityInfo(generator =ObjectIdGenerators.PropertyGenerator.class,property="id")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inverstors")
/*
 * The Inverstors table is the representation of the inverstors table.
 *  
 */
public class Investor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "date_of_birth")
	private String date_of_birth;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="address_id")
	private Address address;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "investor")
	private Set<Product> products;
	
	@Column(length = 13)
	private String id_number;
	
	@Column()
	private String first_name;
	
	@Column()
	private String surname;
	
	@Column
	private String email;
	
	@Column()
	private String contact_numbers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public String getId_number() {
		return id_number;
	}

	public void setId_number(String id_number) {
		this.id_number = id_number;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact_numbers() {
		return contact_numbers;
	}

	public void setContact_numbers(String contact_numbers) {
		this.contact_numbers = contact_numbers;
	}
	
	
}
