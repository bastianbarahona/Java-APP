<%-- 
    Document   : vistaProductos
    Created on : 28-05-2019, 23:26:18
    Author     : Universidad de Chile
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        
        
        <script src="<c:url value="/resources/js/ProductosAdmin1.js"/>" type="text/javascript"></script>   
        <title>Productos Administrador</title>
    </head>
    <body>
        <div class="container">
            
            <div class="row">
                <div class="col-sm-1"></div>

                <div class="col-sm-10">
                   <h3 align="center">Productos</h3>
                    <table class="table table-hover">
                        <tr>
                            <th>ID</th>
                            <th>Nombre del Producto</th>
                            <th>Descripción</th>
                            <th>Stock</th>
                            <th>Stock Critico</th>
                            <th style="width: 150px;">Expiración</th>
                            <th>Estado del Producto</th>
                            <th>Codigo del Producto</th>                  
                        </tr>
                        <c:forEach items="${lst}" var="c" varStatus="indice">
                            <tr>                                       
                                <td>${c.idProducto}</td>
                                <td>${c.nombreProd}</td>
                                <td>${c.descProd}</td>
                                <td id="stock_${indice.index}">${c.stock} </td>
                                <td id="critico_${indice.index}"> ${c.stockCritico}</td>
                                <td id="fecha_${indice.index}">${c.fechaVenc}</td>
                                <td>${c.estadoProd}</td>
                                <td>${c.codigoProducto}</td>                   
                            </tr>
                            
                        </c:forEach>
                            <!-- Este Input nos permite saber el largo de la lista -->
                            <input type="hidden" id="indice" value="${lst.size()}"/>
                            
                              <!--  <input type="button" onclick="ingresaFecha()" value="Ingreso" />-->
                    
                             
                    </table>                 
                </div>
                <div class="col-sm-1">
                </div>
            </div>
        </div>
    </body>
</html>
