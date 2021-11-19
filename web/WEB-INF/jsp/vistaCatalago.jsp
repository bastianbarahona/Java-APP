<%-- 
    Document   : vistaCatalago
    Created on : 10-06-2019, 21:13:03
    Author     : Universidad de Chile
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Ferreteria Ferme</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--        SCRIPT PARA LAS ALERTAS-->
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <!--        SCRIPT PARA BOOTSTRAP-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

        <script src="<c:url value="/resources/js/CatalogoVentas4.js"/>" type="text/javascript"></script>   
        <link href="<c:url value="/resources/css/vistaCatalogo.css"/>" rel="stylesheet" type="text/css"/>          
    </head>
    <body>
        <!--Hidden para identificar el tipo de cliente -->
        <input  id="tipoCliente" name="tipoCli"  type="hidden" value="${tipo.tipoCli}">
        <!--BARRA DE NAVEGACIO -->
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="#">Ferme Construyendo tus proyectos</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li ><a href="index.htm">Home</a></li>
                        <li class="active"><a href="listaProducCatalogo.htm">Catálogo</a></li>
                        <li><a href="crearCli.htm">Regístrate</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="login.htm"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <!--CARRUSEL-->
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img src="<c:url value="/resources/img/banner4.jpg"/>"style="height: 400px" alt=""/> 
                    <div class="carousel-caption">
                    </div>      
                </div>

                <div class="item">
                    <img src="<c:url value="/resources/img/banner1.jpg"/>" style="height: 400px" alt=""/> 
                    <div class="carousel-caption">
                    </div>      
                </div>

                <div class="item">
                    <img src="<c:url value="/resources/img/banner3.jpg"/>" style="height: 400px" alt=""/> 
                    <div class="carousel-caption">
                    </div>      
                </div>
            </div>

            <!-- Left and right controls -->
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <br>

        <!--LISTA PRODUCTOS -->
        <div class="container text-center">
            <h3>Productos</h3> 
            <a href="#" data-toggle="modal" data-target="#myModal"> <img src="https://img.icons8.com/nolan/48/000000/shopping-cart.png"></a>
            <br>
            <br>  
            <!--CARD PRODUCT -->
            <div class="row">
                <c:forEach items="${lst}" var="c" varStatus="indice">
                    <div class="col-md-4">
                        <figure class="card card-product">
                            <div class="img-wrap">  <img src="<c:url value='/resources/img/producto${indice.index}.jpg'/>"style="width: 280px" alt=""/> </div>
                            <figcaption class="info-wrap">
                                <h4 class="title" id="nom_${indice.index}">${c.nombreProd}</h4>
                                <p class="desc">${c.descProd}</p>
                                <div class="rating-wrap">
                                    <div class="label-rating">Stock: ${c.stock}</div>
                                </div> <!-- rating-wrap.// -->
                            </figcaption>
                            <div class="bottom-wrap">
                                <input  id="productoId_${indice.index}" type="hidden" value="${c.idProducto}">
                                <input  id="precio${indice.index}" type="hidden" value="${c.precioVenta}">
                                <a onclick="onClickAñadir(${indice.index})" class="btn btn-sm btn-primary float-right">Añadir al Carro</a>	

                                <div class="price-wrap h5">
                                    <span class="price-new" id="precio_${indice.index}">$ ${c.precioVenta}</span> 
                                    <!--                                <del class="price-old">$1980</del>-->
                                </div> <!-- price-wrap.// -->
                            </div> <!-- bottom-wrap.// -->
                        </figure>
                    </div> <!-- col // -->

                </c:forEach>

            </div>  

        </div>   


        <!--  MODAL PARA EL CARRO DE COMPRA  -->
        <div class="container">
            <div class="modal fade" id="myModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Detalle De Tu Compra</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <!-- Modal body -->
                        <div class="modal-body">
                            <table id="tablaDetalle">
                                <tr>
                                    <th>Producto</th>
                                    <th>Precio $</th>
                                    <th>Cantidad</th>
                                    <th>Acción</th>
                                </tr>                            
                            </table>
                        </div>


                        <!-- Modal footer   data-dismiss="modal"   -->                        
                        <div class="modal-footer">
                            <button class="btn btn-danger float-right disabled">Comprar</button>

                        </div>
                        </form>

                    </div>
                </div>
            </div>

        </div>


        <!--   FOOTER-->   
        <div class="row">             
            <div class="col-lg-12">
                <footer class="text-center">
                    <p>Baumarkt</p>
                    <p>Para mas Información <a href="fermeferreteria@gmail.com">fermeferreteria@gmail.com</a>.</p>
                </footer>
            </div>
        </div>
    </body>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even){background-color: aliceblue}

        th {
            background-color: #999;
            color: white;
        }
        footer {
            background-color: #eee;
            padding: 25px;


        }

    </style>
</html>
