<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Login</title></head>
<body>
  <h2>Login</h2>
  <form action="login" method="post">
    Usuario: <input type="text" name="username" required><br>
    Contraseña: <input type="password" name="password" required><br>
    <input type="submit" value="Entrar">
  </form>
  <p style="color:red;"><%= request.getAttribute("errorMessage") == null ? "" : request.getAttribute("errorMessage") %></p>
</body>
</html>