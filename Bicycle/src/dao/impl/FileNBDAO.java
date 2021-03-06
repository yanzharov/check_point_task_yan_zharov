package dao.impl;

import bean.entity.Product;
import dao.NBDao;
import dao.exception.DAOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FileNBDAO implements NBDao {
    String QUERY;
    Connection con=null;

    public FileNBDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/bicycle","root","root");
        }
        catch(ClassNotFoundException e){
            
        }
        catch(SQLException e){
            
        }
    }
    
    @Override
    public void addProduct(int id, String name, String description, float price, int category_id) throws DAOException {
        try{
            QUERY="INSERT INTO `products`(`id`,`name`,`description`,`price`,`category_id`) VALUES(?,?,?,?,?)";
            PreparedStatement st=con.prepareStatement(QUERY);
            st.setInt(1, id);
            st.setString(2,name);
            st.setString(3, description);
            st.setFloat(4, price);
            st.setInt(5, category_id);
            st.executeUpdate();
        }
        catch(SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public List<Product> getProductsByCategory(int category_id) throws DAOException {
        try{
            List<Product> list=new ArrayList<Product>();
            Product product=null;
            QUERY="SELECT `id`,`name`,`description`,`price`,`category_id` FROM `products`"
                  + " WHERE `category_id`=?";
            PreparedStatement st=con.prepareStatement(QUERY);
            st.setInt(1, category_id);
            ResultSet set=st.executeQuery();
            while(set.next()){
                product=new Product();
                product.setId(set.getInt(1));
                product.setName(set.getString(2));
                product.setDescription(set.getString(3));
                product.setPrice(set.getFloat(4));
                product.setCategory_id(set.getInt(5));
                list.add(product);
            }
            return list;
        }
        catch(SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public void editProduct(int id, String newName, String newDescription, float newPrice, int newCategory_id) throws DAOException {
        try{
            QUERY="UPDATE `products` SET `name`=?,`description`=?,`price`=?,`category_id`=? WHERE `id`=?";
            PreparedStatement st=con.prepareStatement(QUERY);
            st.setString(1,newName);
            st.setString(2,newDescription);
            st.setFloat(3, newPrice);
            st.setInt(4, newCategory_id);
            st.setInt(5,id);
            st.executeUpdate();
        }
        catch(SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public void deleteProduct(int id) throws DAOException {
        try{
            QUERY="DELETE FROM `products` WHERE `id`=?";
            PreparedStatement st=con.prepareStatement(QUERY);
            st.setInt(1,id);
            st.executeUpdate();
        }
        catch(SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public int getCountOfProducts(int category_id) throws DAOException {
        try{
            QUERY="SELECT COUNT(`id`) FROM products WHERE `category_id`=?";
            PreparedStatement st=con.prepareStatement(QUERY);
            st.setInt(1,category_id);
            ResultSet set=st.executeQuery();
            set.next();
            return set.getInt(1);
        }
        catch(SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public float getMinPrice(int category_id) throws DAOException {
        try{
            QUERY="SELECT MIN(`price`) FROM products WHERE `category_id`=?";
            PreparedStatement st=con.prepareStatement(QUERY);
            st.setInt(1,category_id);
            ResultSet set=st.executeQuery();
            set.next();
            return set.getFloat(1);
        }
        catch(SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public float getMaxPrice(int category_id) throws DAOException {
        try{
            QUERY="SELECT MAX(`price`) FROM products WHERE `category_id`=?";
            PreparedStatement st=con.prepareStatement(QUERY);
            st.setInt(1,category_id);
            ResultSet set=st.executeQuery();
            set.next();
            return set.getFloat(1);
        }
        catch(SQLException e){
            throw new DAOException(e);
        }
    }
   
    @Override
    public void finalize() throws DAOException{
        try{
            if(con!=null){
                con.close();
            }
        }
        catch(SQLException e){
            throw new DAOException(e);
        }
    }

}
