<%-- 
    Document   : vistaFactura
    Created on : 18-06-2019, 20:34:05
    Author     : Universidad de Chile
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        
        <link href="<c:url value="/resources/css/login.css"/>" rel="stylesheet" type="text/css"/>
        <title>Factura</title>
    </head>
    <body><br>
        <div class="container">
            <a href="index.htm"><button type="button" class="btn btn-primary"><i class="fa fa-home" style="color:white"></i> Volver Al Home</button></a> 
        </div> 
        <div class="row">
            <div class="col-md-2">              
            </div>
            <div class="col-md-2"style="background-color: #eee; margin-top: 100px">
                <img src="<c:url value="/resources/img/img1-Login.png"/>"style="width: 150px" alt=""/>
            </div>
            <div class="col-md-6" style="background-color: #eee; margin-top: 100px">

                <table class="table table-borderless">
                    <thead>
                        <tr>
                            <th>Factura N° ${venta.idVenta}</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${venta.nomEmpresa} <br>
                                ${venta.rutEmpresa} <br>
                                ${venta.dirEmpresa} <br>
                                ${venta.fonoEmpresa} <br>
                            </td>
                        </tr>
                </table>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Productos</th>
                            <th>Cantidades</th>
                            <th>Totales</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${venta.detalleVentas}" var="c" varStatus="indice">
                            <tr>
                                <td>${c.producto.nombreProd}</td>
                                <td>${c.cantidad}</td>
                                <td>$ ${c.valorDetalle}</td>
                            </tr>                        
                        </c:forEach>
                        <tr>
                            <td><strong>Neto</strong></td>
                            <td></td>
                            <td>$ ${venta.neto}</td>
                        </tr>
                        <tr>
                            <td><strong>Iva</strong></td>
                            <td></td>
                            <td>$ ${iva}</td>
                        </tr>
                        <tr>
                            <td><strong>Total</strong></td>
                            <td></td>
                            <td style="background-color: lightseagreen">$ ${venta.total}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="col-md-2">

            </div>
        </div>
                        
    </body>
</html>
