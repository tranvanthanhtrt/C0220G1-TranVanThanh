<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: thanhtv
  Date: 12/05/2020
  Time: 11:11
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
            <h1>Product Discount Calculator</h1><br>
        <div id="data">
            <label> Product Description:</label>
            <span><%=request.getParameter("productDescription")%></span>
            <br>
            <label>List Price:</label>
            <span>$<%=request.getParameter("listPrice")%></span>
            <br>
            <label>Discount percent:</label>
            <span><%=request.getParameter("discountPercent")%></span>(%)
            <br>
            <label>Discount Amount:</label>
            <span>$<c:out value="${discountAmount}"></c:out></span>
            <br>
            <label>Discount Price:</label>
            <span>$<c:out value="${discountPrice}"></c:out></span>
            <br>

        </div>

</div>
</body>
</html>
