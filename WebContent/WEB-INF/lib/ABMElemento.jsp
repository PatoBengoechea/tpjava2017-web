
<%@page import="controlers.CtrlABMCElemento"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@ page import= "entities.*" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark" style="height: 50px">
  <ul class="navbar-nav">
 	<li class="nav-item active">
 	<form class="form-signin" name="signin" action="aMenuAdmin" method="post">
      <button class="btn btn-link" type="submit" style="width: 150px; height: 60px; font-size: 20px; padding-top: 0.5cm  ">Menu</button>
    </form>
    </li>
  	<li class="nav-item active">
  	 <form class="form-signin" name="signin" action="aABMTipoElemento" method="post">
     <button class="btn btn-link" type="submit" style="width: 200px; margin-bottom: 30px; height: 60px; font-size: 20px; padding-top: 0.5cm  ">ABM Tipo Elemento</button>
     </form>
    </li>
    <li class="nav-item active">
     <form class="form-signin" name="signin" action="aABMElemento" method="post">
     <button class="btn btn-link" type="submit" style="width: 150px; margin-bottom: 30px; height: 60px; font-size: 20px; padding-top: 0.5cm  ">ABM Elemento</button>
     </form>
    </li>
    <li class="nav-item active">
      <form class="form-signin" name="signin" action="aABMPersona" method="post">
      <button class="btn btn-link" type="submit" style="width: 150px; margin-bottom: 30px; height: 60px ;font-size: 20px; padding-top: 0.5cm ">ABM Persona</button>
      </form>
    </li>
    <li class="nav-item active">
     <form class="form-signin" name="signin" action="aABMReservar" method="post">
     <button class="btn btn-link" type="submit" style="width: 150px; margin-bottom: 30px; height: 60px ; font-size: 20px; padding-top: 0.5cm  "> Reservar</button>
     </form>
    </li>
    <li class="nav-item active">
     <form class="form-signin" name="signin" action="mostrarTodasReservas" method="post">
     <button class="btn btn-link" type="submit" style="width: 200px; margin-bottom: 30px; height: 60px ; font-size: 20px; padding-top: 0.5cm  "> Mostrar Todas Reservas</button>
     </form>
    </li>
    <li class="nav-item active">
     <form class="form-signin" name="signin" action="aLogin" method="post">
     <button class="btn btn-link" type="submit" style="width: 200px; margin-bottom: 30px; height: 60px ; font-size: 20px; padding-top: 0.5cm  "> Cerrar Sesion </button>
     </form>
    </li>
  </ul>
</nav>
<div class="container">
  <h2>ABM ELEMENTOS</h2>
              
  <table class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>UBICACION</th>
        <th>DESCRIPCION</th>
        <th>CAPACIDAD</th>
        <th>TIPO ELEMENTO</th>
        <th>EDITAR</th> 
        <th>ELIMINAR</th>
      </tr>
    </thead>
    <% 
    	CtrlABMCElemento controladorE = new CtrlABMCElemento();
    	ArrayList<Elemento> lista = new ArrayList<Elemento>();
		lista = controladorE.getAll();
		for (Elemento elem : lista){ %> 
    <tbody>
    
      <tr>
        <td><%= elem.getIdElemento() %></td>
        <td><%= elem.getDescripcion() %></td>
		<td><%= elem.getCapacidad() %></td>
        <td><%= elem.getUbicacion() %></td>
        <td><%= elem.getTipo().getDescTipo() %></td>
        <td>
        <form class="form-signin" action="modificarElemento" method="Post">
        	<input type="hidden" name="idElem" value="<%= elem.getIdElemento()%>">
        	<button class="btn btn-lg btn-primary btn-block" type="submit" style="width: 93px; ">Editar</button>
        </form>
        </td>
        <td>
        <form class="form-signin" action="eliminarElemento" method="Post">
        	<input type="hidden" name="idElemento" value="<%= elem.getIdElemento() %>">
        	<button class="btn btn-lg btn-primary btn-block" type="submit" style="width: 87px; ">Eliminar</button>
        </form>
        </td>
      </tr>
    <%} %>  
    
    </tbody>
  </table>
  <div>
  <form class="form-signin" name="signin" action="altaElemento" method="post">
  <button class="btn btn-lg btn-primary btn-block" type="submit" style="width: 235px; ">Agregar</button>
  </form>
  </div>
</div>

</body>
</html>
