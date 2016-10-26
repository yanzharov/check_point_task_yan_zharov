/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import bean.entity.Product;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Response {
    private boolean errorStatus;
    private String errorMessage;
    private String simpleMessage;
    private List<Product> products;
    private int count;
    private float min;
    private float max;

    public boolean isErrorStatus() {
	return errorStatus;
    }

    public void setErrorStatus(boolean errorStatus) {
	this.errorStatus = errorStatus;
    }

    public String getErrorMessage() {
	return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
    }

    public String getSimpleMessage() {
        return simpleMessage;
    }

    public void setSimpleMessage(String simpleMessage) {
	this.simpleMessage = simpleMessage;
    }

    public List<Product> getProducts() {
	return products;
    }

    public void setProducts(List<Product> products) {
	this.products = products;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }
    
}
