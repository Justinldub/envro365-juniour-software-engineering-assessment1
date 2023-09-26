package com.envro.grad001.assessment.justindube.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InvestmentsController {

	@RequestMapping(value = "/index.html")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/add-investor.html")
	public String addInvestor() {
		return "add-investor";
	}
	
	@RequestMapping(value = "/create-product.html")
	public String createProduct() {
		return "create-product";
	}
	
	@RequestMapping(value = "/create-notice.html")
	public String createNotice() {
		return "create-notice";
	}
}
