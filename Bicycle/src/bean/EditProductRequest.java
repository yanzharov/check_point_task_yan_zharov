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
public class EditProductRequest extends Request {
    private int id;
    private String newName;
    private String newDescription;
    private float newPrice;
    private int newCategory_id;

    public EditProductRequest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public void setNewDescription(String newDescription) {
        this.newDescription = newDescription;
    }

    public float getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(float newPrice) {
        this.newPrice = newPrice;
    }

    public int getNewCategory_id() {
        return newCategory_id;
    }

    public void setNewCategory_id(int newCategory_id) {
        this.newCategory_id = newCategory_id;
    }

    
}
