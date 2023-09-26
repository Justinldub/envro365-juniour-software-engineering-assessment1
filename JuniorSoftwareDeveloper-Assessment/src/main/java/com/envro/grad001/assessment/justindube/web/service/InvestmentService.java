package com.envro.grad001.assessment.justindube.web.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.envro.grad001.assessment.justindube.web.model.Investor;
import com.envro.grad001.assessment.justindube.web.model.Product;
import com.envro.grad001.assessment.justindube.web.model.Withdrawal;
import com.envro.grad001.assessment.justindube.web.repo.InvestorRepo;
import com.envro.grad001.assessment.justindube.web.repo.ProductRepo;
import com.envro.grad001.assessment.justindube.web.repo.WithdrawalsRepo;

@Service
public class InvestmentService {
	
	@Autowired private InvestorRepo ir;
	@Autowired private ProductRepo pr;
	@Autowired private WithdrawalsRepo wr;
	
	public Investor addInverstor(Investor investor) {
		return ir.save(investor);
	}
	
	public void removeInvestor(int id) {
		ir.deleteById(id);
	}
	
	public Investor findByID(int id) {
		return ir.getReferenceById(id);
	}
	
	public List<Investor> getAllInvestors(){
		return ir.findAll();
	}
	
	public Investor getInvestorByIdentityNumber(String id) {
		List<Investor> investors = ir.findAll();
		Investor investor = null;
		for(Investor i : investors) {
			if(i.getId_number().equals(id)) {
				System.out.println("Investor found :"+ id);
				investor = i;
				break;
			}
			else {
				System.out.println("Nothing found");
			}

		}
		return investor;
	}
	
	public Product createProduct(Investor investor, Product product) {
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		product.setStart_date(format.format(new Date()));
		product.setInvestor(investor);
		product.setBal(product.getInvestment_amount());
		pr.save(product);
		
		Set<Product> products = investor.getProducts();
		products.add(product);
		investor.setProducts(products);
		ir.saveAndFlush(investor);
		
		return product;
	}
	
	public Withdrawal createWithdrawalnotice(Withdrawal withdrawal , Product product) {
		
		
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		withdrawal.setDate(format.format(new Date()));
		withdrawal.setProduct(product);
		wr.save(withdrawal);
		
		List<Withdrawal> withdrawals = product.getWithdrawals();
		withdrawals.add(withdrawal);
		product.setWithdrawals(withdrawals);
		pr.saveAndFlush(product);
		
		return withdrawal;
	}
	
}
