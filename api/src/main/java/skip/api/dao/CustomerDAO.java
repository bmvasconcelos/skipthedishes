package skip.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import skip.api.models.Customer;

public class CustomerDAO {
	
	public void authCustomer() {
		
	}
	
	public void saveCustomer(Customer customer) {

		try {

			Connect connect = new Connect();  
			Connection con = connect.getConnection();

			PreparedStatement preparedStatement = con.prepareStatement("insert into customer (id, name, creation, address, email, password) values(?,?,?,?,?,?)");
			preparedStatement.setInt(1, customer.getId());
			preparedStatement.setString(2, customer.getName());
			preparedStatement.setString(3, customer.getCreation());
			preparedStatement.setString(4, customer.getAddress());
			preparedStatement.setString(5, customer.getEmail());
			preparedStatement.setString(6, customer.getPassword());
			preparedStatement.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}
}
