package t1708m.fashion.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShopingCart {

    private HashMap<Long, HelloOrderDetail> items;
    private double totalPrice;

    public ShopingCart() {
        this.items = new HashMap<>();
    }

    public List<HelloOrderDetail> getItems() {
        if (items == null) {
            items = new HashMap<>();
        }
        return new ArrayList<>(items.values());
    }

    public void setItems(HashMap<Long, HelloOrderDetail> items) {
        this.items = items;
    }

    public void removeProduct(long productId) {
        if (items == null) {
            return;
        }
        if (items.containsKey(productId)) {
            items.remove(productId);
        }
    }

    public void addProduct(Product product, int quantity) {
        if (items == null) {
            items = new HashMap<>();
        }
        HelloOrderDetail item = new HelloOrderDetail(product, quantity);
        if (items.containsKey(product.getId())) {
            HelloOrderDetail existItem = items.get(product.getId());
            item.addQuantity(existItem.getQuantity());
        }
        items.put(product.getId(), item);
    }

    public double getTotalPrice() {
        this.totalPrice = 0;
        for (HelloOrderDetail item :
                items.values()) {
            this.totalPrice += item.getUnitPrice() * item.getQuantity();

        }
        return this.totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
