<%@ page import="domains.CartItem" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: lrandom
  Date: 11/9/21
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/Java22-1.0-SNAPSHOT/styles/style.css">
</head>
<body>
<div class="md:mx-10 mx-2">
    <h1 class="font-bold text-center text-lg">Cart</h1>
    <div>
        <table class="w-full table-fixed">
            <thead>
            <tr>
                <td>
                    Tên sp
                </td>

                <td>
                    Giá 1 sp
                </td>

                <td>
                    Số lượng
                </td>

                <td>
                    Tiền hàng
                </td>

                <td>

                </td>
            </tr>

            </thead>

            <tbody>
            <%
                ArrayList<CartItem> cart = (ArrayList<CartItem>) request.getAttribute("cart");
                for (CartItem cartItem : cart) {
            %>
            <tr>
                <td>
                    <%= cartItem.getProduct().getName() %>
                </td>

                <td>
                    <%= cartItem.getProduct().getPrice() %>
                </td>

                <td>
                    <div class="flex items-center justify-center">
                        <div>
                            <a href="?action=updateQuantity&quantity=-1&id=<%=cartItem.getProduct().getId()%>">-</a>
                        </div>
                        <div>
                            <input class="border rounded" value="<%= cartItem.getQuantity() %>">
                        </div>
                        <div><a href="?action=updateQuantity&quantity=1&id=<%=cartItem.getProduct().getId()%>">+</a>
                        </div>
                    </div>
                </td>


                <td>
                    <%= cartItem.getProduct().getPrice() * cartItem.getQuantity() %>
                </td>

                <td>
                    <a href="?action=deleteItem&id=<%=cartItem.getProduct().getId()%>"
                       onclick="return confirm('Bạn có chắc muốn xoá')"
                       class="bg-red-500 p-2 round text-white text-sm">Xoá</a>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>

        <div>
            <a href="?action=clearAll">Xoá giỏ hàng</a>
        </div>
    </div>
</div>

</body>
</html>
