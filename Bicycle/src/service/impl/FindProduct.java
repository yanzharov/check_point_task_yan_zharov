package service.impl;

import bean.entity.Product;
import dao.DAOFactory;
import dao.NBDao;
import dao.exception.DAOException;
import java.util.List;
import service.FindProductService;
import service.exception.ServiceException;

public class FindProduct implements FindProductService{

    @Override
    public List<Product> getProductsByCategory(int category_id) throws ServiceException {
	    // а сервисы что, разучились входные параметры проверять?
	DAOFactory factory = DAOFactory.getInstance();
	NBDao dao = factory.getNBDao();
        List list;
		
	try {
    	    list=dao.getProductsByCategory(category_id);
            return list;
	} 
        catch (DAOException e) {
	    throw new ServiceException(e);
	}
    }
    
}
