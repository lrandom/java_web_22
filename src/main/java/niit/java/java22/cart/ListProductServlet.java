package niit.java.java22.cart;

import domains.CartItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import domains.Product;
import jakarta.servlet.http.HttpSession;
import services.CartService;

public class ListProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conn = null;
        //kết nối vào CSDL để lấy ra sản phẩm
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb_22?autoReconnect=true&useSSL=false", "root", "koodinh@");
            String sql = "SELECT * FROM products";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Product> list = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setImage(rs.getString("image"));
                list.add(product);
            }
            req.setAttribute("listProduct", list);
            //chuyển sang trang list-product.jsp


            //thêm sp vào giỏ hàng
            //lấy về id sp muốn thêm vào giỏ hàng

            if (req.getParameter("id") != null) {
                HttpSession session = req.getSession();
                ArrayList<CartItem> cart = new ArrayList<>();
                if (session.getAttribute(ServletCart.KEY_CART) != null) {
                    cart =(ArrayList<CartItem>)session.getAttribute(ServletCart.KEY_CART);
                }

                int productId = Integer.parseInt(req.getParameter("id"));
                CartService cartService = new CartService();
                cartService.setCarts(cart);
                Statement stm = conn.createStatement();
                ResultSet rs2 = stm.executeQuery("SELECT * FROM products where id=" + productId);

                while (rs2.next()) {
                    Product product = new Product();
                    product.setId(rs2.getInt("id"));
                    product.setName(rs2.getString("name"));
                    product.setPrice(rs2.getDouble("price"));
                    product.setImage(rs2.getString("image"));
                    CartItem cartItem = new CartItem();
                    cartItem.setProduct(product);
                    cartItem.setQuantity(1);
                    cartService.addItem(cartItem);
                }

                //đồng bộ vào session
                session.setAttribute(ServletCart.KEY_CART, cartService.getCarts());

            }


            req.getRequestDispatcher("WEB-INF/list-products.jsp").forward(req, resp);


        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
