<%@page import="controlers.CtrlABMCTipoElemento"%>
<%@page import="entities.TipoElemento"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form class="form-signin" name="signin" action="realizaAltaElemento" method="post">
	<div>
	<p>ID:<input type="text" disabled="disabled" name="idtxt"></p>
	</div>
	<div>
	<p>Ubucacion:<input type="text" name="ubictxt"></p>
	</div>
	<div>
	<p>Descripcion:<input type="text" name="desctxt"></p>
	</div>
	<div>
	<p>Capacidad:<input type="text" name="capactxt"></p>
	</div>
	<div>
	<%
		CtrlABMCTipoElemento controladorTE = new CtrlABMCTipoElemento();
		ArrayList<TipoElemento> listatipos = new ArrayList<TipoElemento>();
	    listatipos = controladorTE.getAll();
	 %>
	<p>Tipo:
	<select name="tipoElemento" >
	<%for(TipoElemento tipo : listatipos){ %>
  		<option  value="<% tipo.getIdTipo();%>" ><%= tipo.getDescTipo() %></option>
  		<%} %> 
	</select>
	</div>
	<div>
	<button class="btn btn-lg btn-primary btn-block" type="submit">CONFIRMAR</button> 
	</div>
  </form>
</body>
</html>