package skip.api.controllers;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import skip.api.dao.CousineDAO;
import skip.api.models.Cousine;
import skip.api.models.Store;

public class CousineController {
	
    public List<Cousine> getCousines() {
    	CousineDAO cousineDAO = new CousineDAO();
		return cousineDAO.getCousines();
    }	

    public List<Cousine> getCousineByText(String text) {
    	CousineDAO cousineDAO = new CousineDAO();
		return cousineDAO.getCousineByText(text);
    }

    public List<Store> getStoresByCousineId(Integer cousineId) {
    	CousineDAO cousineDAO = new CousineDAO();
		return cousineDAO.getStoresByCousineId(cousineId);
    }	
	
}
