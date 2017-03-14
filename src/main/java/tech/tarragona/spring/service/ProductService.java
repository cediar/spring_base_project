package tech.tarragona.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import tech.tarragona.spring.model.Product;
import tech.tarragona.spring.repository.ProductRepository;

@Service
public class ProductService {
	
	public double importe;
	public static final ArrayList<Product> cart = new ArrayList<Product>();

	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	@Transactional
	public ArrayList<Product> addToCart(Integer id){
		Product product = productRepository.findById(id);
		cart.add(product);
		System.out.println(cart.toString());
		return cart;
	}
	
	@Transactional
	public double getImporte(ArrayList<Product> cart){
		for (Product product : cart){
			importe += product.getPrice();
		}
		return importe;
	}
	
	@Transactional
	public Product getById(Integer id){
		return productRepository.findById(id);
	}
	
	@Transactional
	public void addProduct(Product product){
		productRepository.save(product);
	}
	
	@Transactional
	public void deleteById(Integer id){
		Product product = productRepository.findById(id);
		productRepository.delete(product);
	}
	
	@Transactional
	public boolean productAlreadyExists(Product product, BindingResult result) {
		if (productRepository.findByName(product.getName())==null){
			return false;
			
		}else{
			result.rejectValue("name", "productAlreadyExists");
			return true;
		}
	}
	
}
