/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.impl;

import bean.EditProductRequest;
import bean.Request;
import bean.Response;
import command.Command;
import org.apache.log4j.Logger;
import service.EditProductService;
import service.exception.ServiceException;
import service.factory.ServiceFactory;

public class EditProduct implements Command{
    private final static Logger LOGGER = Logger.getLogger(EditProduct.class);
    
    @Override
    public Response execute(Request request) {
        EditProductRequest editProductRequest = null;
        if(request instanceof EditProductRequest){
	    editProductRequest = (EditProductRequest)request;
	}
		
	int id;
        String newName;
        String newDescription;
        float newPrice;
        int newCategory_id;
		
	id = editProductRequest.getId();
        newName=editProductRequest.getNewName();
        newDescription=editProductRequest.getNewDescription();
        newPrice=editProductRequest.getNewPrice();
        newCategory_id=editProductRequest.getNewCategory_id();
	
	ServiceFactory factory = ServiceFactory.getInstance();
	EditProductService editService = factory.getEditProductService();
		
	Response response= new Response();
	try {
   	    editService.editProduct(id, newName, newDescription, newPrice, newCategory_id);
	    response.setErrorStatus(false);
	    response.setSimpleMessage("Product was edited");
	    System.out.println("1");
	} 
        catch (ServiceException e) {
            LOGGER.error("Exception in EditProduct class");
	    response.setErrorStatus(true);
	    response.setErrorMessage("Product wasn't edited");
	    System.out.println("2");
	}
		
	return response;
    }
    
}
