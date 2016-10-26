/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import service.exception.ServiceException;

/**
 *
 * @author Admin
 */
public interface GetProductInformationService {
    
    int getCountOfProducts(int category_id) throws ServiceException;
    float getMinPrice(int category_id) throws ServiceException;
    float getMaxPrice(int category_id) throws ServiceException;
    
}
