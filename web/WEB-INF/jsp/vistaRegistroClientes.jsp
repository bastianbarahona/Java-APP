<%-- 
    Document   : vistaRegistroClientes
    Created on : 22-05-2019, 23:14:49
    Author     : Universidad de Chile
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> 

        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <link href="<c:url value="/resources/css/registroClientes.css"/>" rel="stylesheet" type="text/css"/>  

        <title>Vista Registro Clientes</title>
    </head>
    <body>  <br>
                <div class="container"> <br>
            <a href="index.htm"><button type="button" class="btn btn-warning"><i class="fa fa-home" style="color:white"></i> Volver Al Home</button></a> 
          <br>
                </div> 
    
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <form action="crearCliente.htm" method="post" class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin">
                        <h2 class="w3-center">Registrate Con Nosotros</h2>

                        <div class="w3-row w3-section">
                            <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
                            <div class="w3-rest">
                                <input class="w3-input w3-border" name="rutCliente" type="text" placeholder="Rut" required>
                            </div>
                        </div>
                        <div class="w3-row w3-section">
                            <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
                            <div class="w3-rest">
                                <input class="w3-input w3-border" name="nombreCliente" type="text" placeholder="Nombre" required>
                            </div>
                        </div>

                        <div class="w3-row w3-section">
                            <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
                            <div class="w3-rest">
                                <input class="w3-input w3-border" name="Apellido" type="text" placeholder="Apellido" required>
                            </div>
                        </div>

                        <div class="w3-row w3-section">
                            <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-phone"></i></div>
                            <div class="w3-rest">
                                <input class="w3-input w3-border" name="fonoCliente" type="text" placeholder="Celular"required>
                            </div>
                        </div>

                        <div class="w3-row w3-section">
                            <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
                            <div class="w3-rest">
                                <select class="w3-select w3-border"  name="TipoCliente" required>
                                    <option value="" disabled selected> Tipo Cliente</option>                 
                                    <option value="Empresa">Empresa</option>
                                    <option value="Persona">Persona Natural</option>                                 
                                </select>
                            </div>
                        </div>

                   <div class="w3-row w3-section">
                            <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-pencil"></i></div>
                            <div class="w3-rest">
                                <input class="w3-input w3-border" name="RazonSocial" type="text" placeholder="Razon Social"required>
                            </div>
                        </div>  

                        <div class="w3-row w3-section">
                            <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-pencil"></i></div>
                            <div class="w3-rest">
                                <input class="w3-input w3-border" name="Direccion" type="text" placeholder="Direccion"required>
                            </div>
                        </div>

                        <div class="w3-row w3-section">
                            <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-envelope-o"></i></div>
                            <div class="w3-rest">
                                <input class="w3-input w3-border" name="email" type="email" placeholder="Email"required>
                            </div>
                        </div>

                        <div class="w3-row w3-section">
                            <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-pencil"></i></div>
                            <div class="w3-rest">
                                <input class="w3-input w3-border" name="user" type="text" placeholder="Usuario"required>
                            </div>
                        </div>
                        <div class="w3-row w3-section">
                            <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-pencil"></i></div>
                            <div class="w3-rest">
                                <input class="w3-input w3-border" name="pas" type="password" placeholder="Password"required>
                            </div>
                        </div>
                        <button class="w3-button w3-block w3-section w3-blue w3-ripple w3-padding">Enviar</button>
                    </form>
                </div>
                <div class="col-sm-5">
                    <br>
                    <img src="<c:url value="/resources/img/img1-registroclientes.png"/>"style="width: 400px" alt=""/>
                </div>
            </div>
        </div>

    </body>
</html>
