<%-- 
    Document   : vistaAdmin
    Created on : 13-06-2019, 21:37:54
    Author     : Bastian Barahona
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ferreteria Ferme</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
        <script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
        
        <link href="<c:url value="/resources/css/morris.css"/>" rel="stylesheet" type="text/css"/>
        <script src="<c:url value="/resources/js/morris.min.js"/>" charset="utf-8"></script>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>   


        <script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/modules/data.js"></script>
        <script src="https://code.highcharts.com/modules/drilldown.js"></script>

        <script src="<c:url value="/resources/js/linea.js"/>" charset="utf-8"></script>
        <script src="<c:url value="/resources/js/charts.js"/>" charset="utf-8"></script>
        <script src="<c:url value="/resources/js/ProductosAdmin2.js"/>" type="text/javascript"></script> 
        <script src="<c:url value="/resources/js/Cliente.js"/>" type="text/javascript"></script> 
        <script src="<c:url value="/resources/js/morris.min.js"/>" charset="utf-8"></script>
    </head>
    <body>
        <!--BARRA DE NAVEGACIO -->
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar "></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="index.htm">BAUMARKT</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="">Informes</a></li>

                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="login.htm"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <br>
        <div class="container">
            
            <h2> Bienvenido Administrador</h2>
            <br>
            <!-- Nav pills -->
            <ul class="nav nav-pills" role="tablist">
                <li class="nav-item active">
                    <a class="nav-link active" data-toggle="pill" href="#home">Productos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="pill" href="#menu1">Clientes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="pill" href="#menu2">Reporte y Estadistica</a>
                </li>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
                <div id="home" class="container tab-pane active"><br>
                    <h3>Lista de Productos</h3>
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
                                    <c:forEach items="${lstProducto}" var="c" varStatus="indice">
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
                                    <input type="hidden" id="indice" value="${lstProducto.size()}"/>

                                    <!--  <input type="button" onclick="ingresaFecha()" value="Ingreso" />-->

                                </table>                 
                            </div>
                            <div class="col-sm-1">
                            </div>
                        </div>
                    </div>
                </div>
                <div id="menu1" class="container tab-pane fade"><br>
                    <h3>Clientes Registrados</h3>
                    
                    <div class="container">

                        <div class="row">
                            <div class="col-sm-1"></div>

                            <div class="col-sm-10">
                                <h3 align="center">Clientes</h3>
                                
                                <table class="table table-hover">
                                    <tr>
                      
                                        <th>Rut</th>
                                        <th>Nombre</th>
                                        <th>Apellido</th>
                                        <th>Telefono</th>
                                        <th>Tipo Cliente</th>
                                        <th>Razon Social</th>
                                        <th>Dirección</th>
                                        <th>Email</th>
                                        <th>User Name</th>
                                     
                                    </tr>
                                    <c:forEach items="${lstCliente}" var="c" varStatus="indiceC">
                                    <tr>
                             
                                        <td>${c.rutCli}</td>
                                        <td>${c.nomCli}</td>
                                        <td>${c.apellCli}</td>
                                        <td>${c.fonoCli}</td>
                                        <td id="type_${indiceC.index}">${c.tipoCli}</td>
                                        <td>${c.razonSocial}</td>
                                        <td>${c.direcCli}</td>
                                        <td>${c.emailCli}</td>
                                        <td>${c.userCli}</td> 

                                    </tr>
                                    </c:forEach>
                                    <input type="hidden" id="indiceC" value="${lstCliente.size()}"/>
                                </table>
                                     <br>    
                            </div>
                            <div class="col-sm-1">
                            </div>
                        </div>
                    </div>
                </div>    
                <div id="menu2" class="container tab-pane fade"><br>
                    <div class="container">
                    <h3>Graficos</h3>
                    <hr>
                    
                    <div class="row">
                        
                        <div class="col-md-6">
                         <div id="containerChart" style="min-width: 310px; height: 400px; margin: 0 auto"></div>   
                        </div>   
                        <script src="<c:url value="/resources/js/charts.js"/>" charset="utf-8"></script>
                    </div>
                    

                </div>
  
            </div>
        </div>
                    <br>                   
    </body>
</html>
