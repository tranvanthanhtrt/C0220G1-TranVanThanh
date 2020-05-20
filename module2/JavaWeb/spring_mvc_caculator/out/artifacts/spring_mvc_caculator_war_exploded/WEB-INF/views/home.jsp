<%--
  Created by IntelliJ IDEA.
  User: thanhtv
  Date: 16/05/2020
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Caculator</h1>
<form method="post" action="/caculate">
    <input type="text"  name="number1" value=${requestScope["number1"]}>
    <input type="text" name="number2" value=${requestScope["number2"]}>
    <br>
    <input type="submit" name="submit" id="add" value="Addition">
    <input type="submit" name="submit" id="sub" value="Subtraction">
    <input type="submit" name="submit" id="mul" value="Multiplication">
    <input type="submit" name="submit" id="div" value="Division">
</form>
<p>
    <c:if test='${requestScope["message"] != null}'>
        ${requestScope["message"]}
    </c:if>
</p>
</body>
</html>
