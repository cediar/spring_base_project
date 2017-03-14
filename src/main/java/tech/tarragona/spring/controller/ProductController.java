package tech.tarragona.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import tech.tarragona.spring.model.Product;
import tech.tarragona.spring.service.ProductService;

@Controller
@RequestMapping(value={"/products", "/"})
public class ProductController {
	
	public ArrayList<Product> cart = new ArrayList<Product>();
	public final static String PRODUCTS_VIEW = "products";
	public final static String CART_VIEW = "cart";
	public static final String REDIRECT_PRODUCTS = "redirect:/" + PRODUCTS_VIEW;
	public static final String REDIRECT_CART = "redirect:/" + CART_VIEW;
	
	@Autowired
	ProductService productService;
	
	@GetMapping
	public String getAllProducts(Model model){
		model.addAttribute("products",productService.getAllProducts());
		return PRODUCTS_VIEW;
	}
	
	@GetMapping("/{id}/addToCart")
	public String addToCart(@PathVariable Integer id, Model model){
		cart = productService.addToCart(id);
		System.out.println("Product added to cart");
		System.out.println(cart.toString());
		model.addAttribute("cart", cart);
		return REDIRECT_CART;
	}
	
	
	@GetMapping("/{id}/delete")
	public String deleteProduct(@PathVariable Integer id){
		productService.deleteById(id);
		System.out.println("Producto eliminado");
		return REDIRECT_PRODUCTS;
	}
	
}
