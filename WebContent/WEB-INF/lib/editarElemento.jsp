<%@page import="java.util.ArrayList"%>
<%@page import="entities.TipoElemento"%>
<%@page import="controlers.CtrlABMCTipoElemento"%>
<%@page import="entities.Elemento"%>
<%@page import="controlers.CtrlABMCElemento"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% CtrlABMCElemento ctrl = new CtrlABMCElemento();
	Elemento el = new Elemento();
	int id = Integer.parseInt(request.getAttribute("idE2").toString());
	el.setIdElemento(id);
	el = ctrl.getByID(el); %>
<form name="signin" action="realizaModiElemento" method="post">
	<label>ID:</label><input type="text" name="idtxt" disabled="disabled" value=<%=el.getIdElemento()%>>
	<input type="hidden" name="idehi" value=<%=id%>>
	<div><label>Ubicacion</label><input type="text" name="ubicaciontxt" value=<%=el.getUbicacion()%>></div>
	<div><label>Descripcion</label><input type="text" name="descripciontxt" value=<%=el.getDescripcion()%>></div>
	<div><label>Capacidad</label><input type="text" name="capacidadtxt" value=<%=el.getCapacidad()%>></div>
	<div>
	<%
		CtrlABMCTipoElemento controladorTE = new CtrlABMCTipoElemento();
		ArrayList<TipoElemento> listatipos = new ArrayList<TipoElemento>();
	    listatipos = controladorTE.getAll();
	 %>
	<label>Tipo:</label>
	<select name="tipElem">
	<%for(TipoElemento tipo : listatipos){
		if(tipo.getIdTipo() == el.getTipo().getIdTipo()){
		%>
		<option  value="<%= tipo.getIdTipo()%>" selected><%= tipo.getDescTipo() %></option>
		<%}
		else{%>
  		<option  value="<%= tipo.getIdTipo()%>" ><%= tipo.getDescTipo() %></option>
  		<%}} %> 
	</select>
	</div>
	<div>
	<button class="btn btn-lg btn-primary btn-block" type="submit">CONFIRMAR</button> 
	</div>
  </form>
</body>
</html>