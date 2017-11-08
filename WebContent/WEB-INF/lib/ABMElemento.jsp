
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
        <td><button class="btn btn-lg btn-primary btn-block" type="submit" style="width: 93px; ">Editar</button></td>
        <form class="form-signin" action="eliminarElemento" method="Post">
        	<input type="hidden" name="idElemento" value="<%= elem.getIdElemento() %>">
        <td><button class="btn btn-lg btn-primary btn-block" type="submit" style="width: 87px; ">Eliminar</button></td>
        </form>
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
