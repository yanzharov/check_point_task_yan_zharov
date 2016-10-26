package command.impl;

import bean.DeleteProductRequest;
import bean.Request;
import bean.Response;
import command.Command;
import org.apache.log4j.Logger;
import service.EditProductService;
import service.exception.ServiceException;
import service.factory.ServiceFactory;

public class DeleteProduct implements Command{
    private final static Logger LOGGER = Logger.getLogger(DeleteProduct.class);
    
    @Override
    public Response execute(Request request) {
        DeleteProductRequest deleteProductRequest = null;
        if(request instanceof DeleteProductRequest){
	    deleteProductRequest = (DeleteProductRequest)request;
	}
		
	int id;
		
	id = deleteProductRequest.getId();
	
	ServiceFactory factory = ServiceFactory.getInstance();
	EditProductService editService = factory.getEditProductService();
		
	Response response= new Response();
	try {
   	    editService.deleteProduct(id);
	    response.setErrorStatus(false);
	    response.setSimpleMessage("Product was deleted");
	    System.out.println("1");
	} 
        catch (ServiceException e) {
            LOGGER.error("Exception in DeleteProduct class");
	    response.setErrorStatus(true);
	    response.setErrorMessage("Product wasn't deleted");
	    System.out.println("2");
	}
		
	return response;
    }
    
}
