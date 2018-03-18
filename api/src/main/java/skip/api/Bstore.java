package skip.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import skip.api.controllers.CousineController;
import skip.api.controllers.CustomerController;
import skip.api.controllers.OrderController;
import skip.api.controllers.ProductController;
import skip.api.controllers.StoreController;
import skip.api.models.Customer;
import skip.api.models.Order;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/")

public class Bstore {
		
	@GET
	@Path("/Cousine")
    public Response getCousines() {
		CousineController cousineController = new CousineController();
        return Response.status(200).entity( cousineController.getCousines() ).build();
    }
	
	@GET
	@Path("/Cousine/search/{searchText}")
    public Response getCousineByText(@PathParam("searchText") String text) {
		CousineController cousineController = new CousineController();		
        return Response.status(200).entity( cousineController.getCousineByText(text) ).build();
    }
	
	@GET
	@Path("/Cousine/{cousineId}/stores")
    public Response getStoresByCousineId(@PathParam("cousineId") Integer id) {
		CousineController cousineController = new CousineController();		
        return Response.status(200).entity( cousineController.getStoresByCousineId(id) ).build();
    }
	
	@POST
    @Path("/Customer")
    public Response saveCustomer(Customer customer) {		
		CustomerController customerController = new CustomerController();
		customerController.saveCustomer(customer);
		return Response.status(200).build();
    }
	
	@POST
    @Path("/Customer/auth")
    public Response authCustomer() {
		CustomerController customerController = new CustomerController();
		customerController.authCustomer();
        return Response.status(200).build();
    }
		
  	@GET
	@Path("/Order/{orderId}")
    public Response getOrderById(@PathParam("orderId") Integer id) {
		OrderController orderController = new OrderController();
		orderController.getOrderById(id);
        return Response.status(200).build();
    }
  	
 	@POST
	@Path("/Order")
    public Response saveOrder(Order order) {
 		OrderController orderController = new OrderController();
 		orderController.saveOrder(order);
        return Response.status(200).build();
    }
 	
	@POST
	@Path("/Order/customer")
    public Response getCustomersByOrder() {
		OrderController orderController = new OrderController();
		orderController.getCustomersByOrder();
        return Response.status(200).build();
    }

  		
	@GET
	@Path("/Product")
    public Response getProducts() {
		ProductController productController = new ProductController();		
        return Response.status(200).entity(productController.getProducts()).build();
    }

	@GET
	@Path("/Product/search/{searchText}")
    public Response getProdutsByText(@PathParam("searchText") String text) {
		ProductController productController = new ProductController();		
        return Response.status(200).entity(productController.getProdutsByText(text)).build();
    }
	
	@GET
	@Path("/Product/{productId}")
    public Response getProductById(@PathParam("productId") Integer id) {
		ProductController productController = new ProductController();		;
        return Response.status(200).entity(productController.getProductById(id)).build();
    }
	
	@GET
	@Path("/Store")
    public Response getStores() {
		StoreController storeController = new StoreController();		
        return Response.status(200).entity(storeController.getStores()).build();
    }
	
	@GET
	@Path("/Store/search/{searchText}")
    public Response getStoresByText(@PathParam("searchText") String text) {
		StoreController storeController = new StoreController();	
        return Response.status(200).entity(storeController.getStoresByText(text)).build();
    }
	
	@GET
	@Path("/Store/{storeId}")
    public Response getStoreById(@PathParam("storeId") Integer id) {
		StoreController storeController = new StoreController();		
        return Response.status(200).entity(storeController.getStoreById(id)).build();
    }
	
	@GET
	@Path("/Store/{storeId}/products")
    public Response getProductsByStoreId(@PathParam("storeId") Integer storeId) {
		StoreController storeController = new StoreController();	
        return Response.status(200).entity(storeController.getProductsByStoreId(storeId)).build();
    }

}
