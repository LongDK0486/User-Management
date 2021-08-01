<%-- 
    Document   : User
    Created on : May 31, 2021, 7:41:21 AM
    Author     : PRREDETOR
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manual User Page</title>
    </head>
    <body>
        <h1>Hello ${sessionScope.LOGIN_USER.userName}</h1>
        <form action="logout">
             <input type="submit" name="action" value="Logout"/>
         </form>
        <c:url var="update" value="update.jsp">
            <c:param name="action" value="Update"></c:param>                                      
            <c:param name="userName" value="${sessionScope.LOGIN_USER.userName}"></c:param>
            <c:param name="userID" value="${sessionScope.LOGIN_USER.userID}"></c:param>
            <c:param name="roleID" value="${sessionScope.LOGIN_USER.roleID}"></c:param>
            <c:param name="email" value="${sessionScope.LOGIN_USER.email}"></c:param>
            <c:param name="phone" value="${sessionScope.LOGIN_USER.phone}"></c:param>
            <c:param name="photo" value="${sessionScope.LOGIN_USER.photoName}"></c:param>
        </c:url>
        <a href="${update}">Edit Profile</a> 
        <c:url var="view" value="viewhistory">
              <c:param name="userID" value="${sessionScope.LOGIN_USER.userID}"></c:param>
        </c:url>
         <a href="${view}">View Promotion history</a> 
        <form action="search">
             <input type="text" name="search" value="${param.search}"/>
             <input type="submit" name="action" value="Search"/>
             <input type="hidden" name="roleID" value="${sessionScope.LOGIN_USER.roleID}"/>
         </form>
             <c:if test="${requestScope.List_User !=null}">
                 <c:if test="${not empty requestScope.List_User}">
                      <table border="1">
                     <thead>
                         <tr>
                             <th>No</th>                            
                             <th>Name</th>
                             <th>Role</th>
                             <th>Photo</th>                         
                         </tr>
                     </thead>
                     <tbody>
                     <c:forEach var="user" varStatus="counter" items="${requestScope.List_User}">                       
                         <form action="search">
                             <tr>
                                 <td>${counter.count}</td>                                
                                 <td>${user.userName}</td>
                                 <td>
                                     <c:forEach var="roleid" items="${sessionScope.RoleID}">
                                        <c:if test="${(roleid.roleID)==(user.roleID)}">
                                            ${roleid.roleName}
                                        </c:if>                                       
                                    </c:forEach>
                                 </td>
                                 <td><img src="image/${user.photoName}" width="200"></td>                             
                             </tr>                            
                         </form>
                     </c:forEach>                                                   
                     </tbody>
                 </table>
                 </c:if>
             </c:if>
    </body>
</html>
