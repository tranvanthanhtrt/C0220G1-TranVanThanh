<%--
  Created by IntelliJ IDEA.
  User: thanhtv
  Date: 13/05/2020
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete product</title>
</head>
<body>
<h1>Delete Product</h1>
<p>
    <a href="/products"> Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>
            Product information
        </legend>
        <table>
            <tr>
                <td>Id:</td>
                <td><input type="text" name="id" id="id" value="${requestScope["product"].getId()}"></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="name" value="${requestScope["product"].getName()}"></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="price" id="price" value="${requestScope["product"].getPrice()}"></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><input type="text" name="description" id="description" value="${requestScope["product"].getDescription()}"></td>
            </tr>
            <tr>
                <td>Productor:</td>
                <td><input type="text" name="productor" id="productor" value="${requestScope["product"].getProductor()}"></td>
            </tr>
            <tr>
                <td>Are you sure?</td>
                <td><input type="submit" value="Delete product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
