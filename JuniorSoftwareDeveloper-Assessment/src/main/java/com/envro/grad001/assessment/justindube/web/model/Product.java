package com.envro.grad001.assessment.justindube.web.model;

import java.util.Date;
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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator =ObjectIdGenerators.PropertyGenerator.class,property="id")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private ProductNames product_name;;
	
	@Column
	private ProductType product_type;
	
	@Column
	private double investment_amount;
	
	@Column(nullable = false, precision = 2)
	private double bal;
	
	@Column(nullable = false, name = "start_date")
	private String start_date;
	
	@ManyToOne()
	@JoinColumn(name = "inverstor_id")
	private Investor investor;
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private List<Withdrawal> withdrawals;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductNames getProduct_name() {
		return product_name;
	}

	public void setProduct_name(ProductNames product_name) {
		this.product_name = product_name;
	}

	public ProductType getProduct_type() {
		return product_type;
	}

	public void setProduct_type(ProductType product_type) {
		this.product_type = product_type;
	}

	public double getInvestment_amount() {
		return investment_amount;
	}

	public void setInvestment_amount(double investment_amount) {
		this.investment_amount = investment_amount;
	}

	public double getBal() {
		return bal;
	}

	public void setBal(double bal) {
		this.bal = bal;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public Investor getInvestor() {
		return investor;
	}

	public void setInvestor(Investor investor) {
		this.investor = investor;
	}

	public List<Withdrawal> getWithdrawals() {
		return withdrawals;
	}

	public void setWithdrawals(List<Withdrawal> withdrawals) {
		this.withdrawals = withdrawals;
	}


	
}
