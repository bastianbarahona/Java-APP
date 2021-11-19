<%-- 
    Document   : vistaBoleta
    Created on : 18-06-2019, 20:33:37
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <link href="<c:url value="/resources/css/login.css"/>" rel="stylesheet" type="text/css"/>
        <title>Boleta</title>
    </head>
    <body><br>
        <div class="container">
            <a href="index.htm"><button type="button" class="btn btn-primary"><i class="fa fa-home" style="color:white"></i> Volver Al Home</button></a> 
        </div> 
        <div class="row">
            <div class="col"></div>

            <div class="col"style="background-color: #eee; margin-top: 100px"><img src="<c:url value="/resources/img/img1-Login.png"/>"style="width: 150px" alt=""/></div>

            <div class="col" style="background-color: #eee; margin-top: 100px">
                <br>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>&nbsp; Boleta N°  ${venta.idVenta}</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td> ${venta.nomEmpresa}<br>
                                 ${venta.dirEmpresa}<br>
                                Telefono  ${venta.fonoEmpresa}<br>
                            </td>
                     <tr>   </tr>
                      </tr>
                        <tr class="table-success">
                            <td><strong> $ ${venta.total} </strong></td>
                        </tr>
                    </tbody>
                </table> 
            </div>
            <div class="col"></div>
            <div class="col-md-4"></div>
        </div>
    </body>

</html>
