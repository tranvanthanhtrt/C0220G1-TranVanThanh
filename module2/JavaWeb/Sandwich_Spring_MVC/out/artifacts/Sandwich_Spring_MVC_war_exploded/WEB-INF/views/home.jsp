<%--
  Created by IntelliJ IDEA.
  User: thanhtv
  Date: 15/05/2020
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<form action="saving" method="post">
<h1>Sandwich Condiments</h1>
<input type="checkbox" id="condiment1" name="condiment" value="Lettuce">
<label for="condiment1"> Lettuce</label><br>
<input type="checkbox" id="condiment2" name="condiment" value="Tomato">
<label for="condiment2"> Tomato</label><br>
<input type="checkbox" id="condiment3" name="condiment" value="Mustard">
<label for="condiment3"> Mustard</label><br>
<input type="checkbox" id="condiment4" name="condiment" value="Sprouts">
<label for="condiment4"> Sprouts</label><br>
    <input type="submit" value="Saving" >
</form>
</body>
</html>
