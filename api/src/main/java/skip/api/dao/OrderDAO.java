package skip.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import skip.api.models.Cousine;
import skip.api.models.Order;

public class OrderDAO {

	public void saveOrder(Order order) {

		Connect connect = new Connect();  
		Connection con = connect.getConnection();

		PreparedStatement preparedStatement = con.prepareStatement("insert into orders (id, name, creation, address, email, password) values(?,?,?,?,?,?)");
		preparedStatement.setInt(1, order.getId());
		preparedStatement.setString(2, order.getName());
		preparedStatement.setString(3, order.getCreation());
		preparedStatement.setString(4, order.getAddress());
		preparedStatement.setString(5, order.getEmail());
		preparedStatement.setString(6, order.getPassword());
		preparedStatement.execute();

	}	
	
	public List<Order> getOrderById(Integer id) {
		List<Order> orderList = new ArrayList<Order>();   	
		
		try {

			Connect connect = new Connect();  
			Connection con = connect.getConnection();
			
			Statement stmt = null;	
			String query = "select * from order where id="+ id ;
			System.out.println(query);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {		
				
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setDate(rs.getString("orderDate"));
				order.setCustomerId(rs.getInt("customerId"));
				order.setDeliveryAddress(rs.getString("deliveryAddress"));
				order.setContact(rs.getString("contact"));
				order.setStoreId(rs.getInt("storeId"));
				order.setTotal(rs.getInt("total"));
				order.setStatus(rs.getString("status"));
				order.setLastUpdate(rs.getString("lastUpdate"));
				
				orderList.add(order);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderList;
	}	
	
}
