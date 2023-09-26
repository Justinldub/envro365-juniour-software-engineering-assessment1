package com.envro.grad001.assessment.justindube.web.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/*
 * @Author - Justin Dube
 * 23 September 2013
 */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/*
 * The Address Entity is the address representation of the address table.
 * Its used to store the Investors addresses
 * Investors are allowed to have one or more address
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
@JsonIdentityInfo(generator =ObjectIdGenerators.PropertyGenerator.class,property="id")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String street_number;
	
	@Column(nullable = false)
	private String suburb;
	
	@Column(nullable = false)
	private String town;
	
	@Column(nullable = false,length = 4,updatable = false)
	private String code;
	
	@Column(nullable = false)
	private String country;
	
	@OneToOne(mappedBy = "address")
	private Investor inverstor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet_number() {
		return street_number;
	}

	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Investor getInverstor() {
		return inverstor;
	}

	public void setInverstor(Investor inverstor) {
		this.inverstor = inverstor;
	}
	
	
}
