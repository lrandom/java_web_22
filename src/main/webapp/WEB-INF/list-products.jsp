<%@ page import="domains.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
<div class="md:mx-10 mx-2">
    <h1 class="font-bold text-center text-lg">List of products</h1>
    <div class="grid grid-cols-3 gap-10">
        <%
            ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("listProduct");
            for (Product product : products) {
        %>
        <div class="shadow md:col-span-1 col-span-10 bg-white p-2 rounded space-y-5">
            <h3 class="text-lg font-bold"><%= product.getName() %>
            </h3>
            <img class="w-full max-h-64 object-cover" src="<%= product.getImage() %>" alt="<%= product.getName() %>">
            <p class="text-base font-bold text-red-500"><%= product.getPrice() %>
            </p>
        </div>
        <%
            }
        %>
    </div>
</div>

</body>
</html>