<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="login" method="post">
        <h3>Please sign in</h3>
        <input type="text" class="form-control" name="username" placeholder="User name" required autofocus>
        <input type="password" class="form-control" name="password" id="loginPass" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
</body>
</html>
