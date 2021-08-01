<%-- 
    Document   : InsertPromotion
    Created on : Jun 7, 2021, 4:56:07 PM
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
       
         <form action="addpromotion">
            User ID<input type="text" name="userID" value="${param.userID}"readonly=""/>
            Full Name<input type="text" name="fullName" value="${param.userName}"readonly=""/>
            Role ID<input type="text" name="roleid" value="${param.roleID}"readonly=""/>
            Email <input type="text" name="email" value="${param.email}"readonly=""/>
            Phone<input type="text" name="phone" value="${param.phone}"readonly=""/>
            <input type="hidden" name="search" value="${param.search}"required="true">
            <input type="submit" name="action" value="confirm"/> 
        </form>         
    </body>
</html>
