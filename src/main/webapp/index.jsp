<%@ page import="com.wyn.po.Photo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table width="70%" border="1" cellspacing="0" cellpadding="0">
    <tr>
        <td>id</td>
        <td>名称</td>
        <td>photo</td>
    </tr>
    <c:forEach items="${list}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.photo}</td>

    </c:forEach>
</table>
</body>
</html>
