<%-- 
    Document   : listaClientes
    Created on : 21-05-2019, 13:48:55
    Author     : Universidad de Chile
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3 style="align-content: center">Proveedores</h3>

        <table style="border-collapse: collapse" cellpadding="7px" border="1">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Procedencia</th>
                <th>Telefono</th>
                <th>Email</th>
                <th>Usuario</th>
                <th>Contraseña</th>
            </tr>
            <c:forEach items="${lst}" var="p">
                <tr>
                    <td>${p.idProveedor}</td>
                    <td>${p.nombreProveedor}</td>
                    <td>${p.procedenciaProveedor}</td>
                    <td>${p.fonoProveedor}</td>
                    <td>${p.emailProveedor}</td>
                    <th>${p.usuarioProveedor}</td>
                    <td>${p.contrasenaProveedor}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
