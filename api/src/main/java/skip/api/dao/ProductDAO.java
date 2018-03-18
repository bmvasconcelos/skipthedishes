package skip.api.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import skip.api.models.Product;

public class ProductDAO {
	public List<Product> getProducts() {
		List<Product> productList = new ArrayList<Product>();

		try {

			Connect connect = new Connect();  
			Connection con = connect.getConnection();

			Statement stmt = null;
			String query = "select * from product";

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {				
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setStoreId(rs.getInt("storeId"));
				productList.add(product);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return productList;
	}	

	public List<Product> getProdutsByText(String text) {
		List<Product> productList = new ArrayList<Product>();   	
		
		try {

			Connect connect = new Connect();  
			Connection con = connect.getConnection();
			
			Statement stmt = null;	
			String query = "select * from product where name like '%"+ text +"%'";
			System.out.println(query);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {				
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setStoreId(rs.getInt("storeId"));
				productList.add(product);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return productList;
	}

	public Product getProductById(Integer id) {
	
		Product product = null;
		
		try {

			Connect connect = new Connect();  
			Connection con = connect.getConnection();
						
			Statement stmt = null;	
			String query = "select * from product where id = " + id ;
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {				
				product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setStoreId(rs.getInt("storeId"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;
	}
}
