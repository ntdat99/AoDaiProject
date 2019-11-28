package t1708m.fashion.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShopingCart {

    private HashMap<Long, CartItem> items = new HashMap<>();
    private double totalPrice;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ShopingCart() {
        this.items = new HashMap<>();
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items.values());
    }

    public void setItems(HashMap<Long, CartItem> items) {
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
        if (items.containsKey(product.getId())) {
            CartItem existItem = items.get(product.getId());
            existItem.addQuantity(quantity);
            return;
        }
        CartItem existItem = new CartItem(product, quantity);
        items.put(product.getId(), existItem);
    }

    public void updateProduct(Product product, int quantity) {
        if (items.containsKey(product.getId())) {
            CartItem existItem = items.get(product.getId());
            existItem.setQuantity(quantity);
            items.put(product.getId(), existItem);
        }
        CartItem existItem = new CartItem(product, quantity);
        items.put(product.getId(), existItem);
    }

    public double getTotalPrice() {
        this.totalPrice = 0;
        for (CartItem item :
                items.values()) {
            this.totalPrice += item.getUnitPrice() * item.getQuantity();
        }
        return this.totalPrice;
    }
}
