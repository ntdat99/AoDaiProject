package t1708m.fashion.entity;

public class CartItem {

    private long productId;
    private String productName;
    private String productThumbnail;
    private int quantity;
    private double unitPrice;

    public CartItem(Product product, int quantity) {
        this.quantity = quantity;
        this.unitPrice = product.getPrice();
        this.productId = product.getId();
        this.productName = product.getName();
        this.productThumbnail = product.getPhotoLinks().get(0);
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getTotalPrice() {
        return unitPrice * quantity;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public String getProductThumbnail() {
        return productThumbnail;
    }

    public void setProductThumbnail(String productThumbnail) {
        this.productThumbnail = productThumbnail;
    }
}
