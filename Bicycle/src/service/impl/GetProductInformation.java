package service.impl;

import dao.DAOFactory;
import dao.NBDao;
import dao.exception.DAOException;
import service.exception.ServiceException;
import service.GetProductInformationService;

public class GetProductInformation implements GetProductInformationService{

    @Override
    public int getCountOfProducts(int category_id) throws ServiceException {	
	DAOFactory factory = DAOFactory.getInstance();
	NBDao dao = factory.getNBDao();
	int count;	
        
	try {
    	    count=dao.getCountOfProducts(category_id);
            return count;
	} 
        catch (DAOException e) {
	    throw new ServiceException(e);
	}
    }

    @Override
    public float getMinPrice(int category_id) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
	NBDao dao = factory.getNBDao();
	float min;	
        
	try {
    	    min=dao.getMinPrice(category_id);
            return min;
	} 
        catch (DAOException e) {
	    throw new ServiceException(e);
	}
    }

    @Override
    public float getMaxPrice(int category_id) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
	NBDao dao = factory.getNBDao();
	float max;	
        
	try {
    	    max=dao.getMaxPrice(category_id);
            return max;
	} 
        catch (DAOException e) {
	    throw new ServiceException(e);
	}
    }
    
}
