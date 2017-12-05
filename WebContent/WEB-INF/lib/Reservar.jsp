
<%@page import="entities.Elemento"%>
<%@page import="controlers.CtrlABMCElemento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlers.CtrlABMCTipoElemento"%>
<%@page import="entities.TipoElemento"%>
<%@page import="entities.Persona"%>
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
<form class="form-signin" name="signin" action="realizaActualizaReserva" method="post">
	<div>
	<%	
		String idSeleccionado = String.valueOf(request.getAttribute("idSel"));
		ArrayList<TipoElemento> listatipos = new ArrayList<TipoElemento>();
		CtrlABMCTipoElemento controladorTE = new CtrlABMCTipoElemento();
		CtrlABMCElemento controladorE = new CtrlABMCElemento();
		ArrayList<Elemento> listaelemento = new ArrayList<Elemento>();
		TipoElemento tipo2 = new TipoElemento();
	    Persona per = (Persona)session.getAttribute("user");
	    if(per.isEncargado() || per.isAdmin()){
	     listatipos = controladorTE.getAll();
	     }
	     else{
	    	 listatipos = controladorTE.getAllTiposUser();
	     }%>
	     <h1 style='margin-left: 8em'>Reservar Elementos</h1>
			<% if(idSeleccionado.equals("0")){
				%>
			<h1 style='margin-left: 9em'>Tipo Elemento</h1>
			<select name="tipoElemento" style='margin-left: 26em'>
			<% 	
					for(TipoElemento tipo : listatipos){ %>				
  					<option  value="<%= tipo.getIdTipo()%>" ><%= tipo.getDescTipo() %></option> 
					<%}	%>
			</select>				
				<%}%>
			<% if(!idSeleccionado.equals("0")){
			listatipos = controladorTE.getAll();   
			for(TipoElemento tipo : listatipos){
				if(idSeleccionado.equals(String.valueOf(tipo.getIdTipo()))){%> 
			<h1 style='margin-left: 6em'>Usted Selecciono El Tipo: <%= tipo.getDescTipo() %></h1>
			<%}}}%>
	</div>
	<div>
		<%	int iband = 0;
			if(!(idSeleccionado).equals("0")){
			int idsel = Integer.parseInt(idSeleccionado);
			tipo2.setIdTipo(idsel);
			tipo2 = controladorTE.getByID(tipo2);
	   		listaelemento = controladorE.getByTipo(tipo2);
	   		%>

				<%if(listaelemento.isEmpty()){
					iband = 1;%>
					<h1 style='margin-left: 2em'>No se pose ningun elemento de este tipo</h1>
				<%}else{ %>
					<h1 style='margin-left: 10em'>Elemento: </h1>
					<input type="hidden" name="selecciono" value=<%= idsel %>>
					<select name="elemento" style='margin-left: 26em'>
					<%for(Elemento el : listaelemento){ %>
  						<option  value="<%= el.getIdElemento()%>"><%= el.getDescripcion() %></option>
  					<%}%>
  					</select>	
					<% }
			}
		else{%>
			<h2>Seleccione algun tipo por favor y aprete confirmar</h2>
		<%}%>
	</select>	
	</div>
	<%if(!(idSeleccionado).equals("0")){%>
	<%if(iband == 0){ %>
	<div>
	<h2>Dias maximos de reserva para el tipo seleccionado: <%= tipo2.getCantdiasMax() %> </h2>
	<input type="hidden" name="diasmax" value=<%= tipo2.getCantdiasMax() %>>
	</div>
	<div>
	<h2>Dias maximos de anticipacion de la reserva para el tipo seleccionado: <%= tipo2.getDiasmaxanti() %></h2>
	<input type="hidden" name="diasanti" value=<%= tipo2.getDiasmaxanti()%>>
	</div>
	<div class="form-group">
    <label for="fecha-inic">Fecha de Inicio</label>
    <input  type="text" class="form-control" name="fechaini" style="width:300px; height:35px" >
  	</div>
  	<div class="form-group">
    <label for="fecha-fin">Fecha de Fin de Rerserva</label>
    <input type="text" class="form-control" name="fechafin" style="width:300px;height:35px" >
  	</div>
	<%}}%>
	<%if(iband == 0){ %>
	<div>
	<button class="btn btn-lg btn-primary btn-block" type="submit" style="width: 800px; margin-bottom: 30px;">CONFIRMAR</button> 
	</div>
	<% }%>
</form>
	<%if(iband == 1 || !(idSeleccionado).equals("0")){ %>
	<form class="form-signin" name="signin" action="aABMReservar" method="post">
	<div>
	<button class="btn btn-warning" type="submit" style="width: 800px; margin-bottom: 30px;">VOLVER</button> 
	</div>
	</form>	
	<%} %>
</body>
</html>