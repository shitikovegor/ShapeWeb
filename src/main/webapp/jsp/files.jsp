<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
    <title>Shapes - files</title>
</head>
<body>
<FORM action="controller" method="POST">
    <input type="hidden" name="command" value="read-file"/>
    <select name="file" size="5">
        <c:forEach items="${fileList}" var="file">
            <option value="${file}">
                <c:out value="${file.getName()}"/>
            </option>
        </c:forEach>
    </select>
    <p><INPUT type="submit" value="Show shapes from file"></p>
</FORM>
${upload_result}
${invalid_type}
<hr/>
<FORM action="upload" enctype="multipart/form-data" method="POST">
    Upload File: <INPUT type="file" name="content" height="130">
    <INPUT type="submit" value="Upload File">
    <br/>
    ${nullPage}
    <br/>
</FORM>
<hr/>
<input type=button value="Back" onCLick="history.back()">
</body>
</html>