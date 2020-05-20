<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search List</title>
</head>
<body>
<h1>Search</h1>
<p>
    <a href="/products?action=''">Back to list Product</a>
</p>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Price</td>
        <td>Description</td>
        <td>Productor</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["searchList"]}' var="product">
            <tr>
                <td>${product.getId()}</td>
                <td><a href="/products?action=view&id=${product.getId()}">${product.getName()}</a></td>
                    <%--            <td>${product.getPrice()}</td>--%>
                <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${product.getPrice()}" /></td>
                <td>${product.getDescription()}</td>
                <td>${product.getProductor()}</td>
                <td><a href="/products?action=edit&id=${product.getId()}">edit</a></td>
                <td><a href="/products?action=delete&id=${product.getId()}">delete</a></td>
            </tr>
           </c:forEach>
</table>
</body>
</html>