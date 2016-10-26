package bean.entity;

public class Product {// equals? hashCode? toString? - это же сущность, которую ты в коллекции засовываешь
    // а сущность твой - не полный Bean
    // перечисли правила зоднания bean классов в java
    private int id;
    private String name;
    private String description;
    private float price;
    private int category_id;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
    
    
}
