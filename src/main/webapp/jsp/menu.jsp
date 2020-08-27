<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
    <title>Upload file</title>
</head>
<body>
<h2>Shapes application</h2>
<hr/>
<FORM action="controller" method="POST">
    <input type="hidden" name="command" value="show-files" />
    <INPUT type="submit" value="Show files">
</FORM>
<hr/>
<FORM action="upload" enctype="multipart/form-data" method="POST">
    Upload File: <INPUT type="file" name="content" height="130">
    <INPUT type="submit" value="Upload File">
</FORM>

</body>
</html>