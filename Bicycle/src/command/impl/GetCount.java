package command.impl;

import bean.Request;
import bean.Response;
import bean.GetCountRequest;
import command.Command;
import static jdk.nashorn.internal.runtime.Debug.id;
import org.apache.log4j.Logger;
import service.exception.ServiceException;
import service.factory.ServiceFactory;
import service.GetProductInformationService;

public class GetCount implements Command{
    private final static Logger LOGGER = Logger.getLogger(GetCount.class);
    
    @Override
    public Response execute(Request request) {
        GetCountRequest getCountRequest = null;
        if(request instanceof GetCountRequest){
	    getCountRequest = (GetCountRequest)request;
	}
		
	int category_id;
        int count;
		
	category_id = getCountRequest.getCategory_id();
	
	ServiceFactory factory = ServiceFactory.getInstance();
	GetProductInformationService informationService = factory.getProductInformationService();
		
	Response response= new Response();
	try {
   	    count=informationService.getCountOfProducts(category_id);
            response.setCount(count);
	    response.setErrorStatus(false);
	    response.setSimpleMessage("Count was found");
	    System.out.println("1");
	} 
        catch (ServiceException e) {
            LOGGER.error("Exception in GetCount class");
	    response.setErrorStatus(true);
	    response.setErrorMessage("Count wasn't found");
	    System.out.println("2");
	}
		
	return response;
    }
    
}
