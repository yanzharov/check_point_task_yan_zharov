package service;

import bean.entity.Product;
import java.util.List;
import service.exception.ServiceException;

public interface FindProductService {
    
    List<Product> getProductsByCategory(int category_id) throws ServiceException;
    
}
