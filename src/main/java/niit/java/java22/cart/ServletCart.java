package niit.java.java22.cart;

import domains.CartItem;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import services.CartService;

import java.io.IOException;
import java.util.ArrayList;

public class ServletCart extends HttpServlet {
    public static final String KEY_CART = "CART";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();

        ArrayList<CartItem> cart = new ArrayList<CartItem>();
        if (httpSession.getAttribute(KEY_CART) != null) {
            //đã có giỏ hàng
            cart = (ArrayList<CartItem>) httpSession.getAttribute(KEY_CART);
        }


        //Thao tác với các sp trong giỏ hàng
        if (request.getParameter("action") != null) {
            CartService cartService = new CartService();
            cartService.setCarts(cart);
            switch (request.getParameter("action")) {
                case "deleteItem":
                    //xoá sp
                    //lấy về id của sp
                    int id = Integer.parseInt(request.getParameter("id"));
                    cartService.deleteItem(id);
                    break;

                case "updateQuantity":
                    //cập nhật sp
                    id = Integer.parseInt(request.getParameter("id"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    cartService.updateQuantity(id, quantity);
                    break;

                case "clearAll":
                    //Xoá toàn bộ sp
                    cartService.clearAllItems();
                    break;

            }

            httpSession.setAttribute(KEY_CART, cart);
        }
        //END THAO TÁC VỚI CÁC SP TRONG GIỎ HÀNG


        request.setAttribute("cart", cart);
        request.getRequestDispatcher("WEB-INF/cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
