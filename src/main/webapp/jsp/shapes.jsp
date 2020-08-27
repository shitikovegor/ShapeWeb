<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
    <title>Shapes - ${file.getName()}</title>
</head>
<body>
<h2>Shapes from file ${file.getName()}</h2>
<FORM action="controller" method="POST">
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Point A</th>
            <th>Point B</th>
            <th>Point C</th>
            <th>Point D</th>
            <th>Perimeter</th>
            <th>Square</th>
            <th>Is convex</th>
            <th>Type</th>
        </tr>
        <c:forEach items="${quadrangles}" var="entry">
            <tr>
                <td><c:out value="${entry.key.getShapeId()}" /></td>
                <td><c:out value="${entry.key.getTop(0)}" /></td>
                <td><c:out value="${entry.key.getTop(1)}" /></td>
                <td><c:out value="${entry.key.getTop(2)}" /></td>
                <td><c:out value="${entry.key.getTop(3)}" /></td>
                <td><c:out value="${entry.value.getPerimeter()}" /></td>
                <td><c:out value="${entry.value.getSquare()}" /></td>
                <td><c:out value="${entry.value.isConvex()}" /></td>
                <td><c:out value="${entry.value.getType()}" /></td>
            </tr>
        </c:forEach>
    </table>
</FORM>
<hr/>
<input type=button value="Back" onCLick="history.back()">
</body>
</html>