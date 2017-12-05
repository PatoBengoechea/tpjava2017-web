<%@page import="entities.Persona"%>
<%@page import="controlers.CtrlABMCPersona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<% 
Persona per2 = (Persona)session.getAttribute("user");
if(per2.isEncargado() || per2.isAdmin()){%>
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
<% 
 }
 else{%>
 <nav class="navbar navbar-expand-sm bg-dark navbar-dark" style="height: 50px">
  <ul class="navbar-nav">
 	<li class="nav-item active">
 	<form class="form-signin" name="signin" action="aMenuUser" method="post">
      <button class="btn btn-link" type="submit" style="width: 150px; height: 60px; font-size: 20px; padding-top: 0.5cm  ">Menu</button>
    </form>
    </li>
    <li class="nav-item active">
      <form class="form-signin" name="signin" action="editarPer" method="post">
      <button class="btn btn-link" type="submit" style="width: 200px; margin-bottom: 30px; height: 60px ;font-size: 20px; padding-top: 0.5cm ">Editar Mis Datos</button>
      </form>
    </li>
    <li class="nav-item active">
     <form class="form-signin" name="signin" action="aABMReservar" method="post">
     <button class="btn btn-link" type="submit" style="width: 150px; margin-bottom: 30px; height: 60px ; font-size: 20px; padding-top: 0.5cm  "> Reservar</button>
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
<% }%> 
<% CtrlABMCPersona ctrlPer = new CtrlABMCPersona();
	Persona per = new Persona();
	Persona perso = new Persona();
	
	int id = (Integer)request.getAttribute("idPer2");
	per.setIdPersona(id);
	perso = ctrlPer.buscarPersonaID(per);
	Persona per3 = (Persona)session.getAttribute("user");%>
	<form name="signin" action="realizaModiPersona" method="post">
	<label>ID:</label><input type="text" name="idtxt" disabled="disabled" value=<%=perso.getIdPersona() %>>
	<input type="hidden" name="idh" value=<%=perso.getIdPersona() %>>
	<div><label>Nombre</label><input type="text" name="nombretxt" value=<%= perso.getNombre() %>></div>
	<div><label>Apellido</label><input type="text" name="apellidotxt" value=<%= perso.getApellido()%>></div>
	<div><label>DNI</label><input type="text" name="dnitxt" value=<%= perso.getDni()%>></div>
	<% if(per3.isAdmin()){%>
	<% if(perso.isHabilitado()){ %>
	<div><label>Habilitado</label><input type="checkbox" name="habchecbox" checked="checked" ></div>
	<% }if(!(perso.isHabilitado())){%>
	<div><label>Habilitado</label><input type="checkbox" name="habchecbox" ></div>
	<% }%>
	<% }else{%>
	<% if(perso.isHabilitado()){ %>
	<div><label>Habilitado</label><input type="checkbox" name="habchecbox" checked="checked" disabled="disabled" ></div>
	<% }if(!(perso.isHabilitado())){%>
	<div><label>Habilitado</label><input type="checkbox" name="habchecbox" disabled="disabled"></div>
	<% }}%>
	<div><label>Usuario</label><input type="text" name="usuariotxt" value=<%= perso.getUsuario()%>></div>
	<div><label>Password</label><input type="text" name="passwordtxt" value=<%= perso.getPassword() %>></div>
	Tipo Usuario:<select name="tipouser" >
	<% if(perso.isAdmin()){ %>
	<option  value="1" >User</option>
	<option  value="2" selected="selected">Admin</option>
	<option  value="3" >Encargado</option>
	<% }%>
	<% if(perso.isEncargado()){ %>
	<option  value="1" >User</option>
	<option  value="2" >Admin</option>
	<option  value="3" selected="selected">Encargado</option>
	<% }%>
	<% if(!(perso.isAdmin() || perso.isEncargado())){ %>
	<option  value="1" selected="selected">User</option>
	<option  value="2" >Admin</option>
	<option  value="3" >Encargado</option>
	<% }%>
	</select>
	<div>
	<button class="btn btn-lg btn-primary btn-block" type="submit">CONFIRMAR</button> 
	</div>
  </form>
</body>
</html>