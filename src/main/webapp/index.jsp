<%--
  Created by IntelliJ IDEA.
  User: koros
  Date: 20.06.2015
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TITLE</title>
</head>
<body>
<%--@elvariable id="categories" type="java.util.List<com.morkva.entities.Category>"--%>
<h1>Categories</h1>
<h2>All count = ${all_count}</h2>
<h2>Cat rep = ${cat_rep}</h2>
<h2>Init count = ${initcount}</h2>
<h2>String = ${string}</h2>
<h2>Do Get = ${doget}</h2>
<c:forEach var="num" items="${categories}">
  <h2>${num.id}: ${num.name}</h2>
</c:forEach>
</body>
</html>
