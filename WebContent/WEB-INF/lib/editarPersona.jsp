<%@page import="entities.Persona"%>
<%@page import="controlers.CtrlABMCPersona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% CtrlABMCPersona ctrlPer = new CtrlABMCPersona();
	Persona per = new Persona();
	Persona perso = new Persona();
	int id = (Integer)request.getAttribute("idPer2");
	per.setIdPersona(id);
	perso = ctrlPer.buscarPersonaID(per);	 %>
	<form name="signin" action="realizaModiPersona" method="post">
	<label>ID:</label><input type="text" name="idtxt" disabled="disabled" value=<%=perso.getIdPersona() %>>
	<input type="hidden" name="idh" value=<%=perso.getIdPersona() %>>
	<div><label>Nombre</label><input type="text" name="nombretxt" value=<%= perso.getNombre() %>></div>
	<div><label>Apellido</label><input type="text" name="apellidotxt" value=<%= perso.getApellido()%>></div>
	<div><label>DNI</label><input type="text" name="dnitxt" value=<%= perso.getDni()%>></div>
	<% if(perso.isHabilitado()){ %>
	<div><label>Habilitado</label><input type="checkbox" name="habchecbox" checked="checked" ></div>
	<% }if(!(perso.isHabilitado())){%>
	<div><label>Habilitado</label><input type="checkbox" name="habchecbox" ></div>
	<% }%>
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