/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Admin
 */
public class FindProductsRequest extends Request {
    private int category_id;//н-да, Java Code COnvention нам побоку

    public FindProductsRequest() {
    }

    public int getCategory_id() {//еще раз такое имя метода увижу - ...!!!
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
    
}
