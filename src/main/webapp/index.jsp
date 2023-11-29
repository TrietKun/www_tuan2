<%@ page import="com.example.tuan.services.EmployeeService" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>home</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 20px;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            margin-bottom: 10px;
        }

        button {
            margin-left: 10px;
        }

        #customerForm {
            margin-top: 20px;
        }
    </style>
    <script src="script.js"></script>
</head>
<body>
<div id="cart">
    <h2><a href="ShoppingCart.html">Giỏ hàng</a></h2>
    <ul id="cart-items">
    </ul>
</div>

<h1>Chủ đề bán sản phẩm</h1>

<h2>Danh sách sản phẩm</h2>
<ul>
    <li>Sản phẩm 1: Giá $100 <button onclick="buyProduct('Sản phẩm 1')">Mua</button></li>
    <li>Sản phẩm 2: Giá $75 <button onclick="buyProduct('Sản phẩm 2')">Mua</button></li>
    <li>Sản phẩm 3: Giá $50 <button onclick="buyProduct('Sản phẩm 3')">Mua</button></li>
</ul>

<h2>Tạo tài khoản khách hàng</h2>
<form id="customerForm">
    <label for="customerName">Tên khách hàng:</label>
    <input type="text" id="customerName" name="customerName" required><br><br>

    <label for="customerEmail">Email khách hàng:</label>
    <input type="email" id="customerEmail" name="customerEmail" required><br><br>

    <input type="submit" value="Thêm mới khách hàng">
</form>
</body>
</html>
