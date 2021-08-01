<%-- 
    Document   : Login
    Created on : May 29, 2021, 9:32:59 AM
    Author     : PRREDETOR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="POST">
            User ID<input type="text" name="userID"/><br/>
            Password<input type="password" name="password"/><br/>
            <input type="submit" name="action" value="Login"/>
        </form>
        <a href="CreateAccount.jsp">Create Account</a>
    </body>
</html>
