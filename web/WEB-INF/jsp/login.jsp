
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> 

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  

        <link href="<c:url value="/resources/css/login.css"/>" rel="stylesheet" type="text/css"/>

        <title>Iniciar Sesión</title>
    </head>
    <body><br>     
        <div class="container" style="background-color: beige">
            <br/>      
            <br/>   
            <div class="row">
                <div class="col-sm-4">
                <img src="<c:url value="/resources/img/img1-Login.png"/>"style="width: 300px" alt=""/>
                </div>
                <div class="col-sm-4">   
                    <br>
                    <h3 align="center">Iniciar sesión</h3>
                    <hr>
                    <form action="ValidaLogin.htm" method="post">
                        <div class="form-group">
                            <label for="username">Usuario:</label>
                            <input type="text" name="username" class="form-control"value="">
                        </div>
                        <div class="form-group">
                            <label for="pwd">Contraseña</label>
                            <input type="password" class="form-control" name="pwd">
                        </div>               
                        <button type="submit" class="btn btn-primary" >Iniciar Sesión</button> <br>
                    </form> <br>
                      <a href="crearCli.htm">¿No estás registrado? Registrate</a> <br><br><br><br><br>
                    
                </div>
                <div class="col-sm-4">
                    <!--<img src="<c:url value="/resources/img/img2-registroclientes.png"/>"style="width: 300px" alt=""/> -->           
                </div>
            </div>
        </div>

    </body>

</html>
