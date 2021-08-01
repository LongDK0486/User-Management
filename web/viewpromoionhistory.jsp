<%-- 
    Document   : viewpromoionhistory
    Created on : Jun 9, 2021, 3:56:00 PM
    Author     : PRREDETOR
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History promotion Page</title>
    </head>
    <body>     
        <c:if test="${requestScope.List_Promotion_History !=null}">
            <c:if test="${not empty requestScope.List_Promotion_History}">
                <c:forEach var="pro" varStatus="counter" items="${requestScope.List_Promotion_History}">                       
                    <form action="promotion">
                        <input type="text" name="date" value="You had been add to promotion list at :${pro.date}" readonly="true" size="80"/><br/>
                        <input type="text" name="dateup" value="You had been update to promotion list at :${pro.dateupdate}" readonly="true"size="80"/><br/>
                        <input type="text" name="datede" value="You had been delete to promotion list at: ${pro.datedelete}" readonly="true"size="80"/><br/>
                        <input type="text" name="date" value="Your rank in promotion list is ${pro.rank}" readonly="true"size="80"/><br/>
                    </form>
                </c:forEach>                                                   
            </c:if>
        </c:if>
        <a href="User.jsp">Back</a>
    </body>
</html>
