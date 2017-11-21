
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
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
	    Tipo Elemento
		<select name="tipoElemento" >
			<% if(idSeleccionado.equals("0"))
				{	
					for(TipoElemento tipo : listatipos){ %>				
  					<option  value="<%= tipo.getIdTipo()%>" ><%= tipo.getDescTipo() %></option> 
					<%}			
				}
			else{
			listatipos = controladorTE.getAll();   %>
			<%for(TipoElemento tipo : listatipos){
				if(idSeleccionado.equals(String.valueOf(tipo.getIdTipo()))){%>
					<option  value="<%= tipo.getIdTipo()%>" ><%= tipo.getDescTipo() %></option>
				<%}
				else{%>	
	  				<option  value="<%= tipo.getIdTipo()%>" selected="selected" ><%= tipo.getDescTipo() %></option> 
				<%}
			}%>	
		</select>	
		<%}%>
	</div>
	<div>
		<%	
		if(!(idSeleccionado).equals("0")){
				tipo2.setIdTipo(1);
	   			 listaelemento = controladorE.getByTipo(tipo2);%>
		<label>Elemento:</label>
		<input type="hidden" name="selecciono" value="1">
		<select name="elemento">
		<%for(Elemento el : listaelemento){ %>
  			<option  value="<%= el.getIdElemento()%>"><%= el.getDescripcion() %></option>
  		<%}
		}
		else{%>
		<label>Seleccione algun tipo por favor y aprete confirmar</label>
		<%}%>
	</select>	
	</div>
	<%if(!(idSeleccionado).equals("0")){%>
	<div class="form-group">
    <label for="fecha-inic">Fecha de Inicio</label>
    <input  type="text" class="form-control" name="fechaini" style="width:300px; height:35px" >
  	</div>
  	<div class="form-group">
    <label for="fecha-fin">Fecha de Fin de Rerserva</label>
    <input type="text" class="form-control" name="fechafin" style="width:300px;height:35px" >
  	</div>
	<%} %>
	<div>
	<button class="btn btn-lg btn-primary btn-block" type="submit">CONFIRMAR</button> 
	</div>
</form>
</body>
</html>