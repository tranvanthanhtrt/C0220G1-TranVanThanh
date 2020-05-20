<%--
  Created by IntelliJ IDEA.
  User: thanhtv
  Date: 15/05/2020
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items='${requestScope["names"]}' var="name">

        <span>${name}</span>
<br>
</c:forEach>
</body>
</html>
