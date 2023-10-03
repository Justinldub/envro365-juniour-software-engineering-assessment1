package com.envro.grad001.assessment.justindube.web.model;


import java.sql.Date;

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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "withdrawals")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator =ObjectIdGenerators.PropertyGenerator.class,property="id")
public class Withdrawal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String date;
	
	@Column
	private double amount;
	
	@Column
	private double bal;
	
	@ManyToOne()
	@JoinColumn(name = "product_id",nullable = false)
	private Product product;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "banking_details_id")
	private BankingDetails banking_details;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getBal() {
		return bal;
	}

	public void setBal(double bal) {
		this.bal = bal;
	}

	public BankingDetails getBanking_details() {
		return banking_details;
	}

	public void setBanking_details(BankingDetails banking_details) {
		this.banking_details = banking_details;
	}
	
	
}
