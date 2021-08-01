<%-- 
    Document   : Creatediscountcode
    Created on : Jun 29, 2021, 8:50:50 AM
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
        <form action="MainController" method="POST">
            Discount Code <input type="text" name="code" required="true"/><br/>           
            ${requestScope.ERROR.codeERROR}<br/>  
            
            Discount percent <input type="text" name="percent" required="true"/><br/>
            ${requestScope.ERROR.percentERROR}<br/>   
            
            Discount Date <input type="text" name="date" required="true"/><br/>
            ${requestScope.ERROR.dateERROR}<br/>  
            
            <input type="submit" name="action" value="CreateCode"/>

        </form>
    </body>
</html>
