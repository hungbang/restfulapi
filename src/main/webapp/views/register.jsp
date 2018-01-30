<%--
  Created by IntelliJ IDEA.
  User: Anh
  Date: 1/23/2018
  Time: 9:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/rest/register" method='POST'>
    <table>
        <tr>
            <td>User:</td>
            <td><input type='text' name='userName' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='passWord' /></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
        </tr>
    </table>
</form>
</body>
</html>
