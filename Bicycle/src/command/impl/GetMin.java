package command.impl;

import bean.Request;
import bean.Response;
import bean.GetMinRequest;
import command.Command;
import org.apache.log4j.Logger;
import service.exception.ServiceException;
import service.factory.ServiceFactory;
import service.GetProductInformationService;

public class GetMin implements Command{
    private final static Logger LOGGER = Logger.getLogger(GetMin.class);
    
    @Override
    public Response execute(Request request) {
        GetMinRequest minRequest = null;
        if(request instanceof GetMinRequest){
	    minRequest = (GetMinRequest)request;
	}
		
	int category_id;
        float min;
		
	category_id = minRequest.getCategory_id();
	
	ServiceFactory factory = ServiceFactory.getInstance();
	GetProductInformationService informationService = factory.getProductInformationService();
		
	Response response= new Response();
	try {
   	    min=informationService.getMinPrice(category_id);
            response.setMin(min);
	    response.setErrorStatus(false);
	    response.setSimpleMessage("Min found");
	    System.out.println("1");
	} 
        catch (ServiceException e) {
            LOGGER.error("Exception in GetMin class");
	    response.setErrorStatus(true);
	    response.setErrorMessage("Min wasn't found");
	    System.out.println("2");
	}
		
	return response;
    }
    
}
