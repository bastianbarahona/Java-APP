<%-- 
    Document   : vistaHome
    Created on : 16-06-2019, 20:05:23
    Author     : Universidad de Chile
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--        SCRIPT PARA BOOTSTRAP-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

        <script src="<c:url value="/resources/js/CatalogoVentas2.js"/>" type="text/javascript"></script>   
        <link href="<c:url value="/resources/css/home.css"/>" rel="stylesheet" type="text/css"/>       
        <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
        <title>Home</title>
    </head>
    <body>
        <!--BARRA DE NAVEGACIO -->
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="index.htm">Ferme Construyendo tus proyectos</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="index.htm">Home</a></li>
                        <li><a href="listaProducCatalogo.htm">Catálogo</a></li>
                        <li><a href="crearCli.htm">Regístrate</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="login.htm"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="jumbotron jumbotron-billboard">
            <div class="img"></div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <h2>Ferreteria Ferme </h2>
                        <p>
                            Construyendo Tus Proyectos
                        </p>
                        <a href="crearCli.htm" class="btn btn-success btn-lg"><i class='far fa-address-card'></i> Regístrate</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="thumbnail">

                        <img src="<c:url value="/resources/img/home1.jpg"/>"style="width: 230px; height: 220px" alt=""/>
                        <div class="caption">
                            <p>    <i class='far fa-hand-point-right'style='color:blue'></i></p>
                        </div>

                    </div>
                </div>
                <div class="col-md-4">
                    <div class="thumbnail">

                        <img src="<c:url value="/resources/img/home2.jpg"/>"style="width: 230px;height: 220px" alt=""/>
                        <div class="caption">
                            <p> <i class='far fa-hand-point-right'style='color:blue'></i> </p>
                        </div>

                    </div>
                </div>
                <div class="col-md-4">
                    <div class="thumbnail">

                        <img src="<c:url value="/resources/img/home3.jpg"/>"style="width: 230px;height: 220px" alt=""/>
                        <div class="caption">
                            <p>   <i class='far fa-hand-point-right'style='color:blue'></i> </p>
                        </div>

                    </div>
                </div>
            </div>      
        </div>

        <footer class="container-fluid text-center"style=" background-color: #eee; height: 100px;">

            <p>Baumarkt</p>
            <p>Para mas Información <a href="fermeferreteria@gmail.com">fermeferreteria@gmail.com</a>.</p>
        </footer>

    </body>
</html>
