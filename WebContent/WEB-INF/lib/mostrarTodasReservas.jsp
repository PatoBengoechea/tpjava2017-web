
<%@page import="java.util.Date"%>
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
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<h1>Reservas pendientes</h1>
<div>
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
    CtrlABMCReserva ctrl = new CtrlABMCReserva();
    lista = ctrl.getAll();
    Date today = new Date();
	for (Reserva res : lista){
		if(res.getFechaFin().after(today)) %>
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