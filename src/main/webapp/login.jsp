
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <!--
    <form action="<%="http://" + request.getRemoteHost() + ":" + request.getServerPort() + request.getContextPath() %>/login?" method="post">
    -->
    <form action="<%= request.getContextPath() %>/login" method="post">
    <label for="user">Username:</label>
        <input type="text" id="user" name="user">
        <br><br>
        <label for="password">Password:</label>
        <input type="text" id="password" name="password">
        <br><br>
        <input type="submit" value="login">
        <span class="error">${error}</span>
    </form>
</body>
</html>
