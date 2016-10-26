package view;

import bean.AddProductRequest;
import bean.DeleteProductRequest;
import bean.EditProductRequest;
import bean.FindProductsRequest;
import bean.Response;
import bean.entity.Product;
import bean.GetCountRequest;
import bean.GetMaxRequest;
import bean.GetMinRequest;
import controller.Controller;
import java.util.List;
import org.apache.log4j.Logger;
import service.exception.ServiceException;

public class Main {
    private final static Logger LOGGER = Logger.getLogger(Main.class);
    
    public static void main(String[] args)throws ServiceException{
        LOGGER.info("Start application");
        Controller controller = new Controller();
        Response response;
	//////////////////////////////////////////////////////////////
	// find products by category
	FindProductsRequest find = new FindProductsRequest();
        List<Product> list;
	find.setCommandName("FIND_PRODUCTS");
	find.setCategory_id(1);


	response = controller.doAction(find);

	if (!response.isErrorStatus()) {
	    System.out.println(response.getSimpleMessage());
	} else {
   	    System.out.println(response.getErrorMessage());
	}
        
        list=response.getProducts();
        if(list!=null){
            for (Product product: list) { 
                System.out.println("ID="+product.getId()+" Name="+product.getName()+" Description="+product.getDescription()
                                   +" Price="+product.getPrice()+" Category_id="+product.getCategory_id() ); 
            }
        }
       //имя первого товара из категории
        //////////////////////////////////////////////////////////////
	// add new product
	AddProductRequest addProd = new AddProductRequest();
	addProd.setCommandName("ADD_NEW_PRODUCT");
	addProd.setId(17);
	addProd.setName("Велорезина для горного велосипеда 22");
        addProd.setDescription("Велопокрышка велосипедная Hongda. Имеет жесткий корд и хороший резиновый состав. Рисунок протектора, сделан специально как для асфальтовых, так и гравейных дорог.");
        addProd.setPrice(12);
        addProd.setCategory_id(4);

	response = controller.doAction(addProd);

	if (!response.isErrorStatus()) {
   	    System.out.println(response.getSimpleMessage());
	} 
        else {
	    System.out.println(response.getErrorMessage());
	}
        //////////////////////////////////////////////////////////////
	// edit product
	EditProductRequest editRequest = new EditProductRequest();
	editRequest.setCommandName("EDIT_PRODUCT");
	editRequest.setId(10);
        editRequest.setNewName("Велорезина для горного велосипеда 22");
        editRequest.setNewDescription("Велопокрышка велосипедная Hongda. Имеет жесткий корд и хороший резиновый состав. Рисунок протектора, сделан специально как для асфальтовых, так и гравейных дорог.");
        editRequest.setNewPrice(12);
        editRequest.setNewCategory_id(4);
	response = controller.doAction(editRequest);

	if (!response.isErrorStatus()) {
	    System.out.println(response.getSimpleMessage());
	} else {
	    System.out.println(response.getErrorMessage());
	}
        //////////////////////////////////////////////////////////////
	// delete product
	DeleteProductRequest deleteRequest = new DeleteProductRequest();
	deleteRequest.setCommandName("DELETE_PRODUCT");
	deleteRequest.setId(17);

	response = controller.doAction(deleteRequest);

	if (!response.isErrorStatus()) {
	    System.out.println(response.getSimpleMessage());
	} else {
	    System.out.println(response.getErrorMessage());
	}
        //////////////////////////////////////////////////////////////
	// get count of products
	GetCountRequest countRequest = new GetCountRequest();
	countRequest.setCommandName("GET_COUNT");
	countRequest.setCategory_id(3);

	response = controller.doAction(countRequest);

	if (!response.isErrorStatus()) {
	    System.out.println(response.getSimpleMessage());
	} else {
	    System.out.println(response.getErrorMessage());
	}
        
        System.out.println(response.getCount());
        //////////////////////////////////////////////////////////////
	// get min of prices
	GetMinRequest minRequest = new GetMinRequest();
	minRequest.setCommandName("GET_MIN");
	minRequest.setCategory_id(3);

	response = controller.doAction(minRequest);

	if (!response.isErrorStatus()) {
	    System.out.println(response.getSimpleMessage());
	} else {
	    System.out.println(response.getErrorMessage());
	}
        
        System.out.println(response.getMin());
        //////////////////////////////////////////////////////////////
	// get max of prices
	GetMaxRequest maxRequest = new GetMaxRequest();
	maxRequest.setCommandName("GET_MAX");
	maxRequest.setCategory_id(3);

	response = controller.doAction(maxRequest);

	if (!response.isErrorStatus()) {
	    System.out.println(response.getSimpleMessage());
	} else {
	    System.out.println(response.getErrorMessage());
	}
        
        System.out.println(response.getMax());
        
        LOGGER.info("Close application");
    }
}
