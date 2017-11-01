<%@page import="controlers.CtrlABMCPersona"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@ page import= "entities.*" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>ABM PERSONA</h2>
              
  <table class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>NOMBRE</th>
        <th>APELLIDO</th>
        <th>DNI</th>
        <th>HABILITADO</th>
        <th>USUARIO</th>
        <th>PASSWORD</th>
        <th>EDITAR</th>
        <th>ELIMINAR</th>
      </tr>
    </thead>
    <% 
    ArrayList<Persona> lista = new ArrayList<Persona>();
    CtrlABMCPersona ctrl = new CtrlABMCPersona();
    lista = ctrl.getAll();

		for (Persona tipo : lista){ %>
    <tbody>
      <tr>
        <td><%= tipo.getIdPersonaString() %>
        <td><%= tipo.getNombre() %></td>
        <td><%= tipo.getApellido() %></td>
        <td><%= tipo.getDni() %></td>
        <td><%= tipo.isHabilitado() %></td>
        <td><%= tipo.getUsuario()%>
        <td><%= tipo.getPassword()%>
        <td>
		<form class="form-signin" action ="editarPer" method="post">
			<input type="hidden" name="idPer" value="<%= tipo.getIdPersonaString() %>">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Editar</button>
        </form>
        </td>
        <td>
        <form class="form-signin" action="eliminarPersona" method="Post">
        	<input type="hidden" name="idPersona" value="<%= tipo.getIdPersonaString() %>">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Eliminar</button>
        </form>
        </td>
      </tr>
    <% } %>  
    </tbody>
  </table>
  <div>
  <form class="form-signin" name="signin" action="altaPersona" method="post">
  <button class="btn btn-lg btn-primary btn-block" type="submit" style="width: 235px; ">Agregar</button>
  </form>
  </div>
</div>
</body>
</html>
