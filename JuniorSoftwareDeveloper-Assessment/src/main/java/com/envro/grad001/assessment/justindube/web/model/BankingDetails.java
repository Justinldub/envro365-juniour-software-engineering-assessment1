package com.envro.grad001.assessment.justindube.web.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bank")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator =ObjectIdGenerators.PropertyGenerator.class,property="id")
public class BankingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String holder;
	
	@Column(name = "account_number")
	private String account_number;
	
	@Column
	private BankBranches branch;
	
	
	@OneToOne(mappedBy = "banking_details")
	private Withdrawal withdrawal;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getHolder() {
		return holder;
	}


	public void setHolder(String holder) {
		this.holder = holder;
	}


	public String getAccount_number() {
		return account_number;
	}


	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}


	public BankBranches getBranch() {
		return branch;
	}


	public void setBranch(BankBranches branch) {
		this.branch = branch;
	}


	public Withdrawal getWithdrawal() {
		return withdrawal;
	}


	public void setWithdrawal(Withdrawal withdrawal) {
		this.withdrawal = withdrawal;
	}
	
	
	
}
