package bean;

public class GetMinRequest extends Request {
    private int category_id;

    public GetMinRequest() {
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
