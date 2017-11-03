<%@page import="entities.TipoElemento"%>
<%@page import="controlers.CtrlABMCTipoElemento"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% CtrlABMCTipoElemento ctrlPer = new CtrlABMCTipoElemento();
	TipoElemento tip = new TipoElemento();
	TipoElemento tipo = new TipoElemento();
	int id = (Integer)request.getAttribute("idTip2");
	tip.setIdTipo(id);
	tipo = ctrlPer.buscarTipoElemento(tip);	 %>
<form class="form-signin" name="signin" action="realizaModiTipo" method="post">
	<div>
	<p>ID:</p><input type="text" name="idtxt" disabled="disabled" value= <%=tipo.getIdTipo() %> >
	<input type="hidden" name="idhi" value=<%=tipo.getIdTipo() %>>
	</div>
	<div>
	<p>Descripcion:</p><input type="text" name="desctxt" value= <%=tipo.getDescTipo() %>>
	</div>
	<div>
	<p>Cantidad Dias Max</p><input type="text" name="canttxt" value= <%=tipo.getCantdiasMax() %>>
	</div>
	<div>
	<button class="btn btn-lg btn-primary btn-block" type="submit">CONFIRMAR</button> 
	</div>
  </form>
</body>
</html>