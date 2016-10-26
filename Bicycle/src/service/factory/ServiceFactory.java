/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.factory;

import service.EditProductService;
import service.FindProductService;
import service.impl.EditProduct;
import service.impl.FindProduct;
import service.impl.GetProductInformation;
import service.GetProductInformationService;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
	
    private EditProductService editProductService = new EditProduct();
    private FindProductService findProductService = new FindProduct();
    private GetProductInformationService getProductInformationService = new GetProductInformation();
	
    private ServiceFactory(){}
	
    public static ServiceFactory getInstance(){
	return instance;
    }
	
    public EditProductService getEditProductService(){
	return editProductService;
    }
	
    public FindProductService getFindProductService(){
	return findProductService;
    }
    
    public GetProductInformationService getProductInformationService(){
	return getProductInformationService;
    }

}
