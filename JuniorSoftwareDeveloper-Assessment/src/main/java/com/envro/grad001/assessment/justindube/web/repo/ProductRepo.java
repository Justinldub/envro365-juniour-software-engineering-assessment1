package com.envro.grad001.assessment.justindube.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.envro.grad001.assessment.justindube.web.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{

	
}
