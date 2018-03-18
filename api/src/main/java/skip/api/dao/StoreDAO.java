package skip.api.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import skip.api.models.Store;

public class StoreDAO {

		public List<Store> getStores() {
			List<Store> storeList = new ArrayList<Store>();

			try {

				Connect connect = new Connect();  
				Connection con = connect.getConnection();

				Statement stmt = null;
				String query = "select * from product";

				stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {				
					Store store = new Store();
					store.setId(rs.getInt("id"));
					store.setName(rs.getString("name"));
					store.setAddress(rs.getString("address"));
					store.setCousineId(rs.getInt("cousineId"));
					storeList.add(store);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return storeList;
		}	

		public List<Store> getStoresByText(String text) {
			List<Store> storeList = new ArrayList<Store>();   	
			
			try {

				Connect connect = new Connect();  
				Connection con = connect.getConnection();
				
				Statement stmt = null;	
				String query = "select * from product where name like '%"+ text +"%'";
				System.out.println(query);
				stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {				
					Store store = new Store();
					store.setId(rs.getInt("id"));
					store.setName(rs.getString("name"));
					store.setAddress(rs.getString("address"));
					store.setCousineId(rs.getInt("cousineId"));
					storeList.add(store);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return storeList;
		}

		public Store getStoreById(Integer id) {
		
			Store store = null;
			
			try {

				Connect connect = new Connect();  
				Connection con = connect.getConnection();
							
				Statement stmt = null;	
				String query = "select * from product where id = " + id ;
				stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {				
					store = new Store();
					store.setId(rs.getInt("id"));
					store.setName(rs.getString("name"));
					store.setAddress(rs.getString("address"));
					store.setCousineId(rs.getInt("cousineId"));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return store;
		}
}
