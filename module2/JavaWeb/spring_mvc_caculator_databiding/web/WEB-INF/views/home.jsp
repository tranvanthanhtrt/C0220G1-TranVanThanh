<%--
  Created by IntelliJ IDEA.
  User: thanhtv
  Date: 16/05/2020
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Caculator</h1>
<form:form action="/caculate" method="post" modelAttribute="Caculators">
    <form:input path="num1"/>
    <form:input path="num2"/>
    <form:button name="submit" value="Addition">Addition</form:button>
    <form:button name="submit" value="Subtraction">Subtraction</form:button>
    <form:button name="submit" value="Multiplication">Multiplication</form:button>
    <form:button name="submit" value="Division">Division</form:button>
</form:form>
<p>
    <c:if test='${requestScope["message"] != null}'>
        ${requestScope["message"]}
    </c:if>
</p>
</body>
</html>
