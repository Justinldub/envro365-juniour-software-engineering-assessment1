package com.envro.grad001.assessment.justindube.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.envro.grad001.assessment.justindube.web.model.BankBranches;
import com.envro.grad001.assessment.justindube.web.model.Gender;
import com.envro.grad001.assessment.justindube.web.model.Investor;
import com.envro.grad001.assessment.justindube.web.model.Product;
import com.envro.grad001.assessment.justindube.web.model.ProductNames;
import com.envro.grad001.assessment.justindube.web.model.ProductType;
import com.envro.grad001.assessment.justindube.web.model.Withdrawal;
import com.envro.grad001.assessment.justindube.web.repo.ProductRepo;
import com.envro.grad001.assessment.justindube.web.service.InvestmentService;

@RestController
public class InvestmentControllerRest {

	private static final String BASE_URL = "/api";
	@Autowired InvestmentService is;
	@Autowired ProductRepo pr;
	
	@PostMapping(BASE_URL+"/save-investor")
	public ResponseEntity<Investor> saveInvestor(@RequestBody Investor investor){
		return new ResponseEntity<>(is.addInverstor(investor),HttpStatus.OK);
	}
	
	@GetMapping(BASE_URL+"/get-investors")
	public ResponseEntity<List<Investor>> getAllInvestors(){
		return new ResponseEntity<>(is.getAllInvestors(),HttpStatus.OK);
	}
	
	
	@GetMapping(BASE_URL+"/get-genders")
	public ResponseEntity<Gender[]> getGenders(){
		return new ResponseEntity<>(Gender.values(),HttpStatus.OK);
	}
	
	@GetMapping(BASE_URL+"/get-product-types")
	public ResponseEntity<ProductType[]> getAllProductTypes(){
		return new ResponseEntity<>(ProductType.values(),HttpStatus.OK);
	}
	
	@GetMapping(BASE_URL+"/get-product-names")
	public ResponseEntity<ProductNames[]> getProductNames(){
		return new ResponseEntity<>(ProductNames.values(),HttpStatus.OK);
	}
	
	@GetMapping(BASE_URL+"/get-investor-by-id/{id}")
	public ResponseEntity<Investor> getInvestorByID(@PathVariable int id){
		return new ResponseEntity<>(is.findByID(id),HttpStatus.OK);
	}
	
	@GetMapping(BASE_URL+"/get-investor-by-identity-number/{id}")
	public ResponseEntity<Investor> getInvestorByIdentityNumber(@PathVariable String id){
		return new ResponseEntity<>(is.getInvestorByIdentityNumber(id),HttpStatus.OK);
	}
	
	@PostMapping(BASE_URL+"/create-product/{id}")
	public ResponseEntity<Product> createProduct(@RequestBody Product product,@PathVariable String id){
		return new ResponseEntity<>(is.createProduct(is.getInvestorByIdentityNumber(id), product),HttpStatus.OK);
	}
	
	@GetMapping(BASE_URL+"/get-bank-branches")
	public ResponseEntity<BankBranches[]> getAllBranches(){
		return new ResponseEntity<>(BankBranches.values(),HttpStatus.OK);
	}
	
	
	@PostMapping(BASE_URL+"/create-notice/{id}/{amount}")
	public ResponseEntity<String> createWithdrawalNotice(@RequestBody Withdrawal withdrawal, @PathVariable int id, @PathVariable double amount){
		
		Product product = pr.getReferenceById(id);
		double currentBal = product.getBal();
		double nintyPess = currentBal*0.9;
		switch(product.getProduct_type()) {
		
		case SAVINGS:
			
			if(amount > nintyPess) {
				return new ResponseEntity<>("Can not withdraw more than 90% of the current balance",HttpStatus.NOT_ACCEPTABLE);
			}
			else if(amount > currentBal) {
				
				return new ResponseEntity<>("Not enough funds to process the request, you may request" +currentBal*0.8,HttpStatus.NOT_ACCEPTABLE);
			}
			else 
			{
				is.createWithdrawalnotice(withdrawal, product);
				return new ResponseEntity<>("Your request amount was successful",HttpStatus.OK);
			}
			
		case RETIREMENT:
			Investor investor = product.getInvestor();
			
			if(amount > nintyPess) {
				return new ResponseEntity<>("Can not withdraw more than 90% of the current balance",HttpStatus.NOT_ACCEPTABLE);
			}
			else if(amount > currentBal) {
				
				return new ResponseEntity<>("Not enough funds to process the request, you may request" +currentBal*0.8,HttpStatus.NOT_ACCEPTABLE);
			}
			else 
			{
				is.createWithdrawalnotice(withdrawal, product);
				return new ResponseEntity<>("Your request amount was successful",HttpStatus.OK);
			}
			
			
			
		}
		
		return null;
	}
}
