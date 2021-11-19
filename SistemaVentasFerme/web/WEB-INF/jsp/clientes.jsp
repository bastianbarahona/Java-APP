<%-- 
    Document   : Cliente
    Created on : 17-05-2019, 20:10:40
    Author     : Universidad de Chile
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <a href="crear.html">Agregar</a>
        <table style="border-collapse: collapse" cellpadding="7px" border="1">
            <tr>
                <th>ID</th>
                <th>Rut</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Telefono</th>
                <th>Tipo Cliente</th>
                <th>Razon Social</th>
                <th>Dirección</th>
                <th>Email</th>
                <th>User Name</th>
                <th>Acción</th>
            </tr>
            <c:forEach items="${lst}" var="c">
                <tr>
                    <td>${c.idCliente}</td>
                    <td>${c.rutCli}</td>
                    <td>${c.nomCli}</td>
                    <td>${c.apellCli}</td>
                    <td>${c.fonoCli}</td>
                    <td>${c.tipoCli}</td>
                    <td>${c.razonSocial}</td>
                    <td>${c.direcCli}</td>
                    <td>${c.emailCli}</td>
                    <td>${c.userCli}</td> 
                    <td>
                        <a href="edit.html?id=${c.idCliente}">
                            Edit </a>
                        <a href="remove.html?id=${c.idCliente}" onclick="return confirm('Are you sure?')">Remove</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
