<%-- 
    Document   : update
    Created on : Jun 6, 2021, 2:17:29 PM
    Author     : PRREDETOR
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>update Page</title>
    </head>
    <body>
         <c:if test="${sessionScope.LOGIN_USER.roleID =='MU'}">
         <form action="update">
            User ID<input type="text" name="userID" value="${param.userID}"readonly=""/>
            Full Name<input type="text" name="fullName" value="${param.userName}"required="true"/>
            Role ID<input type="text" name="roleid" value="${param.roleID}"required="true"/>
            Email <input type="text" name="email" value="${param.email}"required="true"/>
            Phone<input type="text" name="phone" value="${param.phone}"required="true"/>
            Picture<input type="file" name="picture" value="${param.photo}"required="true"/>
            <input type="hidden" name="search" value="${param.search}"required="true">
            <input type="submit" name="action" value="Confirm"/> 
        </form>          
                <a href="User.jsp">Back to page</a>
            </c:if>
             <c:if test="${sessionScope.LOGIN_USER.roleID =='AD'}">
                 <form action="updateadmin">
            User ID<input type="text" name="userID" value="${param.userID}"readonly=""/>
            Full Name<input type="text" name="fullName" value="${param.userName}"required="true"/>
            Role ID<input type="text" name="roleid" value="${param.roleID}"required="true"/>
            Email <input type="text" name="email" value="${param.email}"required="true"/>
            Phone<input type="text" name="phone" value="${param.phone}"required="true"/>
            Picture<input type="file" name="picture" value="${param.photo}"required="true"/>
            <input type="hidden" name="search" value="${param.search}"required="true">
            <input type="submit" name="action" value="Confirm"/> 
        </form>         
                <a href="Admin.jsp">Back to page</a>
            </c:if>
    </body>
</html>
