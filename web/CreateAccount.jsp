<%-- 
    Document   : CreateAccount
    Created on : Jun 3, 2021, 5:14:04 PM
    Author     : PRREDETOR
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create new account</h1>
        <form action="createuser" method="POST">
            User ID <input type="text" name="userID" required="true"/><br/>
            ${requestScope.ERROR.userIDERROR}<br/>  
            
            full Name <input type="text" name="fullName" required="true"/><br/>
            ${requestScope.ERROR.fullnamERROR}<br/>
            
            Phone Number <input type="text" name="phone" required="true"/><br/>
            ${requestScope.ERROR.phoneERROR}<br/>
            
            Role ID <input type="text" name="roleID" required="true"/><br/>
            ${requestScope.ERROR.RoleIDERROR}<br/>
            
            Email <input type="text" name="email" required="true"/><br/>
            ${requestScope.ERROR.emailERROR}<br/>
            
            Photo<input type="file" name="photo" /><br/>
             ${requestScope.ERROR.photoERROR}<br/>
             
            Password <input type="password" name="password" required="true"/><br/>
            Confirm  <input type="password" name="confirm" required="true"/><br/>
            ${requestScope.ERROR.confirmERROR}<br/>
            <input type="submit" name="action" value="Create"/>
            <input type="reset" value="Reset"/>
        </form>
            <a href="Login.jsp">Login</a>
    </body>
</html>
