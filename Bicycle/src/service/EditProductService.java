package service;

import service.exception.ServiceException;

public interface EditProductService {
    
    void addProduct(int id, String name, String description, float price, int category_id) throws ServiceException;
    void editProduct(int id, String newName, String newDescription, float newPrice, int newCategory_id) throws ServiceException;
    void deleteProduct(int id) throws ServiceException;
        
}
