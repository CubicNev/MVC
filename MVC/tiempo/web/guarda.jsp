<%-- 
    Document   : guarda
    Created on : 9/02/2018, 01:36:54 PM
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

String nombre = request.getParameter("nombre");
String paterno = request.getParameter("paterno");
String materno = request.getParameter("materno");
String correo = request.getParameter("correo");
String pswd = request.getParameter("contra");


controlador.cPersona per = new controlador.cPersona(0);

if(per.guardaPersona(nombre, paterno, materno, correo, pswd)){
    
    out.println(per.MSJ());
    
}
else{
    out.println(per.MSJ());
}





%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
