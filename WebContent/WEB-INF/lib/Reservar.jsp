<%@page import="entities.Elemento"%>
<%@page import="controlers.CtrlABMCElemento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlers.CtrlABMCTipoElemento"%>
<%@page import="entities.TipoElemento"%>
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
  <div class="form-group">
    <label for="id-reserva">ID</label>
    <input type="id-reserva" class="form-control" id="id-reserva" readonly="true" style="width:50px;height:30px">
  </div>
  <div class="form-group">
    <label for="fecha-inic">Fecha de Inicio</label>
    <input type="fecha-inic" class="form-control" id="Fecha de Inicio" style="width:100px;
    height:30px" >
  </div>
  <div class="form-group">
    <label for="fecha-fin">Fecha de Fin de Rerserva</label>
    <input type="fecha-fin" class="form-control" id="Fecha de Fin de Reserva" style="width:100px;height:35px" >
  </div>
	<div>
	<%	
		String idSeleccionado = String.valueOf(request.getAttribute("idSel"));
		ArrayList<TipoElemento> listatipos = new ArrayList<TipoElemento>();
		CtrlABMCTipoElemento controladorTE = new CtrlABMCTipoElemento();
		if(idSeleccionado.equals("0"))
		{	
	    listatipos = controladorTE.getAll();   
	 %>
	<select name="tipoElemento" >
	<%for(TipoElemento tipo : listatipos){ %>
  		<option  value="<%= tipo.getIdTipo()%>" ><%= tipo.getDescTipo() %></option> 
	<%}} %>	
	</select>	
	</div>
	<div>
	<button class="btn btn-lg btn-primary btn-block" type="submit">CONFIRMAR</button> 
	</div>
	<div>
	<%	
		if(!(idSeleccionado).equals("0")){
		CtrlABMCElemento controladorE = new CtrlABMCElemento();
		ArrayList<Elemento> listaelemento = new ArrayList<Elemento>();
		TipoElemento tipo = new TipoElemento();
		tipo.setIdTipo(Integer.parseInt(idSeleccionado));
	    listaelemento = controladorE.getByTipo(tipo);    
	 %>
	<p>Elemento:
	<select name="elemento">
	<%for(Elemento el : listaelemento){ %>
  		<option  value="<%= el.getIdElemento()%>" ><%= el.getDescripcion() %></option>
  		<%}} %> 
	</select>	
	</div>
</form>
</body>
</html>