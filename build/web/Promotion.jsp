<%-- 
    Document   : Promotion
    Created on : Jun 7, 2021, 6:47:11 PM
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
        <h1>Hello  ${sessionScope.LOGIN_USER.userName}</h1>
       
        <c:if test="${requestScope.List_Promotion !=null}">
            <c:if test="${not empty requestScope.List_Promotion}">
                
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>   
                            <th>ID</th>
                            <th>Name</th>
                            <th>Role</th>
                            <th>Rank</th>
                            <th>Photo</th>
                            <th>Date add</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        
                        <c:forEach var="pro" varStatus="counter" items="${requestScope.List_Promotion}">                       
                        
                            <tr>
                                <td>${counter.count}</td>
                                <td>${pro.userid}</td>                                
                                <td>
                                     <c:forEach var="userid" items="${sessionScope.Userid}">
                                        <c:if test="${(userid.userID)==(pro.userid)}">
                                            ${userid.userName}
                                        </c:if>                                       
                                    </c:forEach>
                                   
                                </td>
                                <td>
                                     <c:forEach var="roleid" items="${sessionScope.RoleID}">
                                        <c:if test="${(roleid.roleID)==(pro.roleid)}">
                                            ${roleid.roleName}
                                        </c:if>                                       
                                    </c:forEach>
                                  
                                </td>
                        <form action="updaterank">
                                <td><input type="text" name="ranks" value="${pro.rank}"/></td> 
                                 <td>
                                     <c:forEach var="userid" items="${sessionScope.Userid}">
                                        <c:if test="${(userid.userID)==(pro.userid)}">
                                            <img src="image/${userid.photoName}" width="200">
                                        </c:if>                                       
                                    </c:forEach>
                                 
                                </td>
                                <td>${pro.date}</td>
                                <td>
                                    <c:url var="delete" value="deletepromotion">
                                        <c:param name="action" value="Delete"></c:param>                                      
                                        <c:param name="Search" value="${param.Search}"></c:param>
                                        <c:param name="userID" value="${pro.userid}"></c:param> 
                                    </c:url>
                                    <a href="${delete}">Delete</a> 
                                </td>                              
                                <td> 
                                    >                                                                           
                                    <input type="hidden" name="UserID" value="${pro.userid}"/>
                                    <input type="hidden" name="rank" value="${param.ranks}"/>
                                    <input type="submit" name="action" value="Update Rank"/>
                                   
                                </td>
                                 </form>
                            </tr>                            
                        
                        </c:forEach>
                       
                </tbody>
            </table>
           
        </c:if>
        </c:if>
    
        <a href="Admin.jsp">Back</a>
    </body>
</html>
