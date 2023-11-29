<%@ page import="com.example.tuan.models.Product" %>
<%@ page import="com.example.tuan.services.ProductService" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<%
    ProductService productService = new ProductService();
    List<Product> productList = productService.getAllProducts();
%>
<table>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>DESCRIPTION</th>
        <th>UNIT</th>
        <th>MANUFACTURER</th>
        <th>STATUS</th>
    </tr>
    <%
        for (Product product : productList) {
    %>
    <tr>
        <td><%=product.getProductId()%></td>
        <td><%=product.getName()%></td>
        <td><%=product.getDesciption()%></td>
        <td><%=product.getUnit()%></td>
        <td><%=product.getManufacturerName()%></td>
    </tr>
    <%}%>
</table>
</body>
</html>
