package bean;

public class GetMaxRequest extends Request {
    private int category_id;

    public GetMaxRequest() {
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
