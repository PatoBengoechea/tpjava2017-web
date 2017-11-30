
<%@page import="controlers.CtrlABMCTipoElemento"%>
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
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
  
 	<li class="nav-item active">
 	<form class="form-signin" name="signin" action="aMenuAdmin" method="post">
      <button class="btn btn-lg btn-primary btn-block" type="submit" style="width: 150px; margin-bottom: 30px;  ">Menu</button>
    </form>
    </li>
  	<li class="nav-item active">
  	 <form class="form-signin" name="signin" action="aABMTipoElemento" method="post">
     <button class="btn btn-lg btn-primary btn-block" type="submit" style="width: 200px; margin-bottom: 30px;  ">ABM Tipo Elemento</button>
     </form>
    </li>
    <li class="nav-item active">
     <form class="form-signin" name="signin" action="aABMElemento" method="post">
     <button class="btn btn-lg btn-primary btn-block" type="submit" style="width: 150px; margin-bottom: 30px;  ">ABM Elemento</button>
     </form>
    </li>
    <li class="nav-item active">
      <form class="form-signin" name="signin" action="aABMPersona" method="post">
      <button class="btn btn-lg btn-primary btn-block" type="submit" style="width: 150px; margin-bottom: 30px;  ">ABM Persona</button>
      </form>
    </li>
    <li class="nav-item active">
     <form class="form-signin" name="signin" action="aABMReservar" method="post">
     <button class="btn btn-lg btn-primary btn-block" type="submit" style="width: 150px; margin-bottom: 30px;  "> Reservar</button>
     </form>
    </li>
    <li class="nav-item active">
     <form class="form-signin" name="signin" action="mostrarReservas" method="post">
     <button class="btn btn-lg btn-primary btn-block" type="submit" style="width: 200px; margin-bottom: 30px;  "> Mostrar Reservas</button>
     </form>
    </li>
  </ul>
</nav>
<div class="container">
  <h2>ABM TIPO ELEMENTOS</h2>
              
  <table class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>DESCRIPCION</th>
        <th>CANT DIAS MAX</th>
        <th>Tipo Solicitud</th>
        <th>Dias MAX ANTI</th>
        <th>EDITAR</th>
        <th>ELIMINAR</th>
      </tr>
    </thead>
    <% 
    CtrlABMCTipoElemento ctrl = new CtrlABMCTipoElemento();
    ArrayList<TipoElemento> lista = new ArrayList<TipoElemento>();
		lista = ctrl.getAll();
		for (TipoElemento tipo : lista){ %>
    <tbody>
      <tr>
        <td><%= tipo.getIdTipo() %></td>
        <td><%= tipo.getDescTipo() %></td>
        <td><%= tipo.getCantdiasMax() %></td>
        <td><%= tipo.getSoloEnc()%>
        <td><%= tipo.getDiasmaxanti() %>
        <td>
		<form class="form-signin" action ="editarTipo" method="post">
			<input type="hidden" name="idTip" value="<%= tipo.getIdTipo() %>">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Editar</button>
        </form>
        </td>
        <td>
        <form class="form-signin" action="eliminarTipo" method="Post">
        	<input type="hidden" name="idTipo" value="<%= tipo.getIdTipo() %>">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Eliminar</button>
        </form>
        </td>
      </tr>
    <%} %>  
    </tbody>
  </table>
  <div>
  <form class="form-signin" name="signin" action="altaTipo" method="post">
  <button class="btn btn-lg btn-primary btn-block" type="submit" style="width: 235px; ">Agregar</button>
  </form>
  </div>
</div>

</body>
</html>
