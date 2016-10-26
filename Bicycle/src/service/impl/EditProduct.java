/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.DAOFactory;
import dao.NBDao;
import dao.exception.DAOException;
import java.util.Date;
import service.EditProductService;
import service.exception.ServiceException;

/**
 *
 * @author Admin
 */
public class EditProduct implements EditProductService{

    @Override
    public void addProduct(int id, String name, String description, float price, int category_id) throws ServiceException {
        if (name == null || "".equals(name)){
	    throw new ServiceException("message");
	}
        if (description == null || "".equals(description)){
	    throw new ServiceException("message");
	}
        if (price<0){
	    throw new ServiceException("message");
	}
		
	DAOFactory factory = DAOFactory.getInstance();
	NBDao dao = factory.getNBDao();
		
	try {
    	    dao.addProduct(id, name, description, price, category_id);
	} 
        catch (DAOException e) {
	    throw new ServiceException(e);
	}
		
    }

    @Override
    public void editProduct(int id, String newName, String newDescription, float newPrice, int newCategory_id) throws ServiceException {
        if (newName == null || "".equals(newName)){
	    throw new ServiceException("message");
	}
        if (newDescription == null || "".equals(newDescription)){
	    throw new ServiceException("message");
	}
	if (newPrice<0){
	    throw new ServiceException("message");
	}	
	DAOFactory factory = DAOFactory.getInstance();
	NBDao dao = factory.getNBDao();
		
	try {
    	    dao.editProduct(id, newName, newDescription, newPrice, newCategory_id);
	} 
        catch (DAOException e) {
	    throw new ServiceException(e);
	}
    }

    @Override
    public void deleteProduct(int id) throws ServiceException {	
	DAOFactory factory = DAOFactory.getInstance();
	NBDao dao = factory.getNBDao();
		
	try {
    	    dao.deleteProduct(id);
	} 
        catch (DAOException e) {
	    throw new ServiceException(e);
	}
    }
    
}
