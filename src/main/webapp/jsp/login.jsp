<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
    <title>Login</title>
</head>
<body>
<h2>Shapes application</h2>
<FORM name="loginForm" action="controller" method="POST">
    <input type="hidden" name="command" value="login" />
    <br/>Login:<br/>
    <input type="text" name="login" value=""/>
    <br/>Password:<br/>
    <input type="password" name="password" value=""/>
    <br/>
    ${errorLoginPassMessage}
    <br/>
<%--    ${wrongAction}--%>
<%--    <br/>--%>
<%--    ${nullPage}--%>
<%--    <br/>--%>
    <input type="submit" value="Log in"/>
</FORM>

</body>
</html>