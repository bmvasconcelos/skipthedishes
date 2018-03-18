package skip.api.controllers;

import java.util.List;
import skip.api.dao.StoreDAO;
import skip.api.models.Store;

public class StoreController {
	  public List<Store> getStores() {
		  StoreDAO storeDAO = new StoreDAO();
		  return storeDAO.getStores();
	    }	

	    public List<Store> getStoresByText(String text) {
	    	StoreDAO storeDAO = new StoreDAO();
			return storeDAO.getStoresByText(text);
	    }

	    public Store getStoreById(Integer id) {
	    	StoreDAO storeDAO = new StoreDAO();
			return storeDAO.getStoreById(id);
	    }
}
