
package dao;


import bean.entity.Product;
import dao.exception.DAOException;
import java.util.List;

public interface NBDao {

	void addProduct(int id,String name, String description,float price,int category_id) throws DAOException;
	List<Product> getProductsByCategory(int category_id) throws DAOException;
        void editProduct(int id,String newName,String newDescription,float newPrice,int newCategory_id) throws DAOException;
        void deleteProduct(int id)throws DAOException;
        int getCountOfProducts(int category_id)throws DAOException;
        float getMinPrice(int category_id)throws DAOException;
        float getMaxPrice(int category_id)throws DAOException;

}
