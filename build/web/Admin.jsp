<%-- 
    Document   : Admin
    Created on : May 29, 2021, 3:29:05 PM
    Author     : PRREDETOR
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h1>Hello  ${sessionScope.LOGIN_USER.userName}</h1>
        <form action="logout">
             <input type="submit" name="action" value="Logout"/>
         </form>
         <form action="promotion">
               <input type="submit" name="action" value="View Promotion"/>
               <input type="hidden" name="UserID" value="${sessionScope.LOGIN_USER.userID}" />
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
        <form action="searchrole">
            <c:set var="role" value="${sessionScope.RoleID}"/>
              Category <select name="SearchRole">
                  <option value="0" >ALL</option>
                  <c:forEach var="RoleID" items="${role}">
                      <option value="${RoleID.roleID}" 
                              <c:if test="${param.SearchRole==RoleID.roleID}">
                                  selected=""
                              </c:if>      
                              >
                          ${RoleID.roleName}
                      </option>
                  </c:forEach> 
              </select>     
              <input type="submit" name="action" value="Select"/>
        </form>
         
         <form action="adminsearch">
             <input type="text" name="searchs" value="${param.searchs}"/>
             <input type="submit" name="action" value="Search"/>
         </form>
              <c:if test="${requestScope.List_User_Admin !=null}">
                 <c:if test="${not empty requestScope.List_User_Admin}">
                      <table border="1">
                     <thead>
                         <tr>
                             <th>No</th>                            
                             <th>Name</th>
                             <th>Role</th>
                             <th>Photo</th>
                             <th>Delete</th>
                         </tr>
                     </thead>
                     <tbody>
                     <c:forEach var="user" varStatus="counter" items="${requestScope.List_User_Admin}">                       
                         <form action="adminsearch">
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
                                 <td>  
                                     <c:if test="${user.roleID!='AD'}">
                                         <c:url var="delete" value="delete">
                                             <c:param name="action" value="Delete"></c:param>                                      
                                             <c:param name="Search" value="${param.Search}"></c:param>
                                             <c:param name="userID" value="${user.userID}"></c:param> 
                                         </c:url>
                                         <a href="${delete}">Delete</a>    
                                     </c:if>                               
                                 </td>  
                                 <td>
                                     <c:if test="${user.roleID!='AD'}">
                                         <c:url var="update" value="update.jsp">
                                             <c:param name="action" value="Update"></c:param>                                      
                                             <c:param name="userName" value="${user.userName}"></c:param>
                                             <c:param name="userID" value="${user.userID}"></c:param>
                                             <c:param name="roleID" value="${user.roleID}"></c:param>
                                             <c:param name="email" value="${user.email}"></c:param>
                                             <c:param name="phone" value="${user.phone}"></c:param>
                                             <c:param name="photo" value="${user.photoName}"></c:param>
                                         </c:url>
                                          <a href="${update}">Update info user</a>   
                                     </c:if>
                                 </td>
                                 <td>
                                     <c:if test="${user.roleID!='AD'}">
                                          <c:url var="add" value="InsertPromotion.jsp">
                                              <c:param name="userName" value="${user.userName}"></c:param>
                                             <c:param name="userID" value="${user.userID}"></c:param>
                                             <c:param name="roleID" value="${user.roleID}"></c:param>
                                             <c:param name="email" value="${user.email}"></c:param>
                                             <c:param name="phone" value="${user.phone}"></c:param>
                                             <c:param name="photo" value="${user.photoName}"></c:param>
                                         </c:url>
                                           <a href="${add}">Add to promotion</a>   
                                     </c:if>
                                 </td>
                             </tr>                            
                         </form>
                     </c:forEach>                                                   
                     </tbody>
                 </table>
                 </c:if>
             </c:if>
    </body>
</html>
