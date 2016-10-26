package command.impl;

import bean.Request;
import bean.Response;
import bean.GetMaxRequest;
import command.Command;
import org.apache.log4j.Logger;
import service.exception.ServiceException;
import service.factory.ServiceFactory;
import service.GetProductInformationService;

public class GetMax implements Command{
    private final static Logger LOGGER = Logger.getLogger(GetMax.class);
    
    @Override
    public Response execute(Request request) {
        GetMaxRequest maxRequest = null;
        if(request instanceof GetMaxRequest){
	    maxRequest = (GetMaxRequest)request;
	}
		
	int category_id;
        float max;
		
	category_id = maxRequest.getCategory_id();
	
	ServiceFactory factory = ServiceFactory.getInstance();
	GetProductInformationService informationService = factory.getProductInformationService();
		
	Response response= new Response();
	try {
   	    max=informationService.getMaxPrice(category_id);
            response.setMax(max);
	    response.setErrorStatus(false);
	    response.setSimpleMessage("Max found");
	    System.out.println("1");
	} 
        catch (ServiceException e) {
            LOGGER.error("Exception in GetMax class");
	    response.setErrorStatus(true);
	    response.setErrorMessage("Max wasn't found");
	    System.out.println("2");
	}
		
	return response;
    }
    
}
