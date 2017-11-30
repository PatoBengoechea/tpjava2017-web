
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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
