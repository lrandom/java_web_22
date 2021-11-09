package services;

import domains.CartItem;

import java.util.ArrayList;

public class CartService {
    private ArrayList<CartItem> carts = new ArrayList<>();

    public void addItem(CartItem cartItem) {
        int index = findById(cartItem.getProduct().getId());
        if (index > -1) {
            //sp này đã tồn tại trong giỏ hàng
            updateQuantity(cartItem.getProduct().getId(), 1);
        }else {
            carts.add(cartItem);
        }
    }

    public boolean deleteItem(int id) {
        int index = findById(id);
        if (index > -1) {
            carts.remove(index);
            return true;
        }
        return false;
    }

    public int findById(int id) {
        for (int i = 0; i < carts.size(); i++) {
            if (carts.get(i).getProduct().getId() == id) {
                return i;//trả về vị trí của sản phẩm trong carts
            }
        }
        return -1;
    }

    public boolean updateQuantity(int id, int quantity) {
        int index = findById(id);
        if (index > -1) {
            //update số lượng lên
            carts.get(index).setQuantity(carts.get(index).getQuantity() + quantity);
            return true;
        }

        return false;
    }

    public void clearAllItems() {
        carts.clear();
    }

    public ArrayList<CartItem> getCarts() {
        return carts;
    }

    public void setCarts(ArrayList<CartItem> carts) {
        this.carts = carts;
    }
}
