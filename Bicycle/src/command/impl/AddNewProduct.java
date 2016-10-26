/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.impl;

import bean.AddProductRequest;
import bean.Request;
import bean.Response;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import command.Command;
import org.apache.log4j.Logger;
import service.EditProductService;
import service.exception.ServiceException;
import service.factory.ServiceFactory;

/**
 *
 * @author Admin
 */
public class AddNewProduct implements Command{
    private final static Logger LOGGER = Logger.getLogger(AddNewProduct.class);
    
    @Override
    public Response execute(Request request) {
        AddProductRequest addProductRequest = null;
	if(request instanceof AddProductRequest){
  	    addProductRequest = (AddProductRequest)request;
	}
		
	int id;
        String name;
        String description;
        float price;
        int category_id;
		
        id=addProductRequest.getId();
        name=addProductRequest.getName();
        description=addProductRequest.getDescription();
        price=addProductRequest.getPrice();
        category_id=addProductRequest.getCategory_id();
		
	ServiceFactory factory = ServiceFactory.getInstance();
	EditProductService editService = factory.getEditProductService();
		
	Response response= new Response();
	try {
	    editService.addProduct(id, name, description, price, category_id);
	    response.setErrorStatus(false);
	    response.setSimpleMessage("Product was added");
	} 
        catch (ServiceException e) {
            LOGGER.error("Exception in AddNewProject class");
	    response.setErrorStatus(true);
	    response.setErrorMessage("Product wasn't added");
	}
        
	return response;
    }
    
}
