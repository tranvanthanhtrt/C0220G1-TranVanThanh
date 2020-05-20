<%--
  Created by IntelliJ IDEA.
  User: thanhtv
  Date: 12/05/2020
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>
  <title>Product Discount Calculator</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="content">
<form method="post" action="discount">
  <h1>Product Discount Calculator</h1><br>
  <div id="data">
  <label> Product Description:</label>
  <input type="text" name="productDescription" placeholder="Enter the description: "/><br>
  <label>List Price:</label>
  <input type="text" name="listPrice"/><br>
  <label>Discount percent:</label>
  <input type="text" name="discountPercent">(%)
  <br>
  </div>
  <div id="buttons">
    <label>&nbsp;</label>
  <input type = "submit" id = "submit" value = "Cacualate Discount"/>
  </div>
</form>
</div>
</body>
</html>
