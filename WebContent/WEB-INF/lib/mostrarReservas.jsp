<%@page import="javax.websocket.Session"%>
<%@page import="entities.Persona"%>
<%@page import="controlers.CtrlABMCReserva"%>
<%@page import="entities.Reserva"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
 	<form class="form-signin" name="signin" action="aMenuUser" method="post">
      <button class="btn btn-link" type="submit" style="width: 150px; height: 60px; font-size: 20px; padding-top: 0.5cm  ">Menu</button>
    </form>
    </li>
    <li class="nav-item active">
      <form class="form-signin" name="signin" action="aABMPersona" method="post">
      <button class="btn btn-link" type="submit" style="width: 150px; margin-bottom: 30px; height: 60px ;font-size: 20px; padding-top: 0.5cm ">ABM Persona</button>
      </form>
    </li>
    <li class="nav-item active">
      <form class="form-signin" name="signin" action="editarPer" method="post">
      <button class="btn btn-link" type="submit" style="width: 150px; margin-bottom: 30px; height: 60px ;font-size: 20px; padding-top: 0.5cm ">Editar Mis Datos</button>
      </form>
    </li>
    <li class="nav-item active">
     <form class="form-signin" name="signin" action="mostrarReservas" method="post">
     <button class="btn btn-link" type="submit" style="width: 200px; margin-bottom: 30px; height: 60px ; font-size: 20px; padding-top: 0.5cm  "> Mostrar Mis Reservas</button>
     </form>
    </li>
        <li class="nav-item active">
     <form class="form-signin" name="signin" action="aLogin" method="post">
     <button class="btn btn-link" type="submit" style="width: 200px; margin-bottom: 30px; height: 60px ; font-size: 20px; padding-top: 0.5cm  "> Cerrar Sesion </button>
     </form>
    </li>
  </ul>
</nav>	
	<table class="table">
    <thead>
      <tr>
        <th>ID Reserva</th>
        <th>NOMBRE</th>
        <th>APELLIDO</th>
        <th>DNI</th>
        <th>UBICACION</th>
        <th>DESCRIPCION Elemento</th>
        <th>CAPACIDAD</th>
        <th>DESCRIPCION Tipo</th>
        <th>FECHA INICIO</th>
        <th>FECHA FIN</th>
      </tr>
    </thead>
    <% 
    ArrayList<Reserva> lista = new ArrayList<Reserva>();
    Persona per = new Persona();
    per.setIdPersona((Integer)session.getAttribute(("idPersona")));
    CtrlABMCReserva ctrl = new CtrlABMCReserva();
    lista = ctrl.getAll(per);
		for (Reserva res : lista){ %>
    <tbody>
      <tr>
        <td><%= res.getIdReserva()%></td>
        <td><%= res.getPersona().getNombre() %></td>
        <td><%= res.getPersona().getApellido() %></td>
        <td><%= res.getPersona().getDni() %></td>
        <td><%= res.getElemento().getUbicacion() %></td>
        <td><%= res.getElemento().getDescripcion()%></td>
        <td><%= res.getElemento().getCapacidad()%></td>
        <td><%= res.getElemento().getTipo().getDescTipo()%></td>
        <td><%= res.getFechaInicio()%></td>
       	<td><%= res.getFechaFin() %></td>
        <td>
        <form class="form-signin" action="eliminarRes" method="Post">
        	<input type="hidden" name="idRes" value="<%=res.getIdReserva() %>">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Eliminar</button>
        </form>
        </td>
      </tr>
    <% } %>  
    </tbody>
  </table>



</div>

</body>
</html>