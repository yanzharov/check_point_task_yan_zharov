package command.impl;

import bean.FindProductsRequest;
import bean.Request;
import bean.Response;
import bean.entity.Product;
import command.Command;
import java.util.List;
import org.apache.log4j.Logger;
import service.FindProductService;
import service.exception.ServiceException;
import service.factory.ServiceFactory;

public class FindProducts implements Command{
    private final static Logger LOGGER = Logger.getLogger(FindProducts.class);
    
    @Override
    public Response execute(Request request) {
        FindProductsRequest findProductsRequest = null;
        if(request instanceof FindProductsRequest){
	    findProductsRequest = (FindProductsRequest)request;
	}
		
        int category_id;
        List<Product> list;
		
        category_id=findProductsRequest.getCategory_id();
	
	ServiceFactory factory = ServiceFactory.getInstance();
	FindProductService findService = factory.getFindProductService();
		
	Response response= new Response();
	try {
   	    list=findService.getProductsByCategory(category_id);
            response.setProducts(list);
	    response.setErrorStatus(false);
	    response.setSimpleMessage("Product was found");
	    System.out.println("1");
	} 
        catch (ServiceException e) {
            LOGGER.error("Exception in FindProducts class");
	    response.setErrorStatus(true);
	    response.setErrorMessage("Product wasn't found");
	    System.out.println("2");
	}
		
	return response;
    }
    
}
