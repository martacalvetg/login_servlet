
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
  <h2>Welcome</h2>
  <p>Welcome, <%= (request.getSession().getAttribute("user")) %>!</p>
</body>
</html>
