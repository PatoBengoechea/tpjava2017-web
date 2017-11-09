<%@page import="entities.Elemento"%>
<%@page import="controlers.CtrlABMCElemento"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% CtrlABMCElemento ctrl = new CtrlABMCElemento();
	Elemento el = new Elemento();
	el.setIdElemento(Integer.parseInt(request.getAttribute("idElemento2").toString()));
	el = ctrl.getByID(el); %>
<form name="signin" action="realizaModiElemento" method="post">
	<label>ID:</label><input type="text" name="idtxt" disabled="disabled" value=<%=el.getIdElemento()%>>
	<input type="hidden" name="ide" value=<%=el.getIdElemento()%>>
	<div><label>Ubicacion</label><input type="text" name="ubicaciontxt" value=<%=el.getUbicacion()%>></div>
	<div><label>Descripcion</label><input type="text" name="descripciontxt" value=<%el.getDescripcion()%>></div>
	<div><label>Capacidad</label><input type="text" name="capacidadtxt" value=<%=el.getCapacidad()%>></div>
	<div><label>ID Tipo</label><input type="text" name="idTipo" value=<%=el.getTipo().getIdTipo()%>></div>
	<div>
	<button class="btn btn-lg btn-primary btn-block" type="submit">CONFIRMAR</button> 
	</div>
  </form>
</body>
</html>
</body>
</html>