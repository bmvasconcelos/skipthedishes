package skip.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import skip.api.models.Cousine;
import skip.api.models.Store;

public class CousineDAO {

	public List<Cousine> getCousines() {
		List<Cousine> cousineList = new ArrayList<Cousine>();

		try {

			Connect connect = new Connect();  
			Connection con = connect.getConnection();

			Statement stmt = null;
			String query = "select * from cousine";

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {				
				Cousine cousine = new Cousine();
				cousine.setId(rs.getInt("id"));
				cousine.setName(rs.getString("name"));
				cousineList.add(cousine);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cousineList;
	}	

	public List<Cousine> getCousineByText(String text) {
		List<Cousine> cousineList = new ArrayList<Cousine>();   	
		
		try {

			Connect connect = new Connect();  
			Connection con = connect.getConnection();
			
			Statement stmt = null;	
			String query = "select * from cousine where name like '%"+ text +"%'";
			System.out.println(query);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {				
				Cousine cousine = new Cousine();
				cousine.setId(rs.getInt("id"));
				cousine.setName(rs.getString("name"));
				cousineList.add(cousine);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cousineList;
	}

	public List<Store> getStoresByCousineId(Integer cousineId) {
		List<Store> storeList = new ArrayList<Store>();   	
		try {

			Connect connect = new Connect();  
			Connection con = connect.getConnection();
						
			Statement stmt = null;	
			String query = "select * from store where cousineId = " + cousineId ;
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
}
