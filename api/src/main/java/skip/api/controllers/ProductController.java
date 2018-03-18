package skip.api.controllers;

import java.util.List;
import skip.api.dao.ProductDAO;
import skip.api.models.Product;

public class ProductController {
	  public List<Product> getProducts() {
		  ProductDAO productDAO = new ProductDAO();
			return productDAO.getProducts();
	    }	

	    public List<Product> getProdutsByText(String text) {
	    	ProductDAO productDAO = new ProductDAO();
			return productDAO.getProdutsByText(text);
	    }

	    public Product getProductById(Integer id) {
	    	ProductDAO productDAO = new ProductDAO();
			return productDAO.getProductById(id);
	    }	
}
