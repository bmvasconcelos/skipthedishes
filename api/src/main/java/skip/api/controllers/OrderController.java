package skip.api.controllers;

import java.util.List;

import skip.api.dao.CousineDAO;
import skip.api.dao.OrderDAO;
import skip.api.models.Cousine;
import skip.api.models.Order;
import skip.api.models.Store;

public class OrderController {
    public List<Order> getOrderById(Integer id) {
    	OrderDAO orderDAO = new OrderDAO();
		return orderDAO.getOrderById(id);
    }	

    public void saveOrder(Order order) {
    	OrderDAO orderDAO = new OrderDAO();
		orderDAO.saveOrder(order);
    }

    public List<Store> getCustomersByOrder(Integer cousineId) {
    	OrderDAO orderDAO = new OrderDAO();
		return orderDAO.getCustomersByOrder(cousineId);
    }	
}
